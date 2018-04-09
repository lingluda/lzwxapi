package com.maiyue.app.controller;

import com.github.pagehelper.PageInfo;
import com.maiyue.app.bean.HeadImage;
import com.maiyue.app.bean.UserInfo;
import com.maiyue.app.constant.BusinessConstant;
import com.maiyue.app.constant.Constant;
import com.maiyue.app.service.HeadImageService;
import com.maiyue.app.service.UserInfoService;
import com.maiyue.app.utils.ComUtil;
import com.maiyue.app.utils.RedisUtil;
import com.maiyue.app.utils.ReflectUtil;
import com.maiyue.app.utils.ResponseUtil;
import com.maiyue.app.utils.jsonUtil.JSONUtils;

import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * UserInfoController
 * 2018/03/29
 */
@RestController
@EnableAutoConfiguration
@RequestMapping(value="/userinfo/*")
public class UserInfoController extends BaseController {
    
	
	@Resource(name = "userInfoService")
    private UserInfoService userInfoService;

	@Autowired
	private ShareCheck shareCheck;
	
	@Resource(name = "redisUtil")
	private RedisUtil redisUtil;
	
	@Resource(name = "headImageService")
    private HeadImageService headImageService;
	
	
	private Logger logger = Logger.getLogger(UserInfoController.class);
	
    
	/***
     * 分页查询应用平台用户信息
     * @param ids
     * @param userInfo
     * @return
     */
    @RequestMapping(value="getPage",method= RequestMethod.POST)
    public ModelMap getPage(@RequestParam(value ="ids[]",required=false) String[] ids, UserInfo userInfo) {
    	try {
          	 logger.debug("调用应用user分页查询方法！");
          	 Map<String,Object> params = ReflectUtil.beanToMap(userInfo,true);
          	 params.put(BusinessConstant.IN_SELECT_IDS,ids);//in查询
      	     PageInfo<UserInfo> data = userInfoService.getPageData(params);
      	     return ResponseUtil.RetCorrectInfo(JSONUtils.toMapJSONObject(data));
   		} catch (Exception e) {
   			logger.error("调用应用user分页查询方法,异常：" + e.getCause().getMessage(),e);
   			return ResponseUtil.RetErrorInfo(e.getCause().getMessage());
   		}
    }

    
    
    
    /****
     * 按别用户名查询
     * @param id
     * @return
     */
    @RequestMapping(value="findByUName")
    public ModelMap findByUName(@RequestParam(value ="userName",required=false)String userName) {
    	try {
        	if(StringUtils.isBlank(userName)){
        		return ResponseUtil.RetErrorInfo("userName is null!");
        	}
        	if(!shareCheck.isEffective(userName, Constant.APP_USER_INFO)){
    			return ResponseUtil.RetErrorInfo("this object is null or disable!");
    		}
        	logger.debug("调用App评论按ID查询接口,成功：--->/userinfo/findByUName?userName=" + userName);
        	UserInfo userInfo = userInfoService.getByUserName(userName);
        	HeadImage img = headImageService.currentHead(userInfo.getId());
        	if(img != null){
        		userInfo.setHeadAddress(img.getHeadAddress());
        	}
        	List<HeadImage> headImages = headImageService.findByUserId(userInfo.getId());//头像历史
        	userInfo.setImages(headImages);
    		return ResponseUtil.RetCorrectInfo(JSONUtils.toJSONObject(userInfo));
		} catch (Exception e) {
    		logger.error("调用App评论按ID查询接口,异常:--->" + e.getCause().getMessage(),e);
    		return ResponseUtil.RetErrorInfo(e.getCause().getMessage());
		}
    }
    
    
    /***
     * 新增用户头像
     * @param userName
     * @param headAlias
     * @param headAddress
     * @return
     */
    @RequestMapping(value="addHead",method= RequestMethod.POST)
    public ModelMap addHead(@RequestParam(value ="userName",required=false) String userName, 
    	   @RequestParam(value ="headAlias",required=false,defaultValue="未知") String headAlias,
    	   @RequestParam(value ="headAddress",required=false) String headAddress){
    	try {
			if(StringUtils.isBlank(userName) || StringUtils.isBlank(headAddress)){
				return ResponseUtil.RetErrorInfo("userName or headAddress is null");
			}	
			HeadImage img = new HeadImage();
			UserInfo usera = userInfoService.getByUserName(userName);
			if(usera != null){
				logger.debug("进入新增用户头像方法");
				img.setId(ComUtil.randomUUID());
				img.setUserId(usera.getId());
				img.setCreateTime(new Date());
				img.setHeadAlias(headAlias);
				img.setHeadAddress(headAddress);
				img.setHeadDisk((String)redisUtil.get(Constant.WHERE_DISK_PATH));
				img.setState(BusinessConstant.COMMON_STATE_STAY);
				headImageService.insert(img);
			}else{
				return ResponseUtil.RetErrorInfo("userName is invalid!");
			}
    		logger.debug("新增用户头像方法>成功！");
    		return ResponseUtil.RetCorrectInfo("{'id':'"+img.getId()+"','headAddress':'"+img.getHeadAddress()+"'}");
		} catch (Exception e) {
			logger.error("新增用户头像方法>异常：");
			return ResponseUtil.RetErrorInfo("新增用户头像方法>异常:" + e.getCause().getMessage());
		}
    }
    
    
    /***
     * 停用
     * @param id
     * @return
     */
    @RequestMapping(value="deleteHead")
    public ModelMap disableHead(@RequestParam(value ="hid",required=false) String hid) {
        try {
        	if(StringUtils.isBlank(hid)){
            	return ResponseUtil.RetErrorInfo(" hid is null!");
            }
        	HeadImage image = headImageService.selectById(hid);
        	if(image != null){
        		if(image.getState().equals(BusinessConstant.COMMON_STATE_JUST)){
        			return ResponseUtil.RetErrorInfo("Record has been deleted!");
        		}
        		else
        		image.setState(BusinessConstant.COMMON_STATE_JUST);
        	}
        	else
        	return ResponseUtil.RetErrorInfo("hid is invalid");
		} catch (Exception e) {
			logger.error("调用删除用户头像接口,异常：" + e.getCause().getMessage(),e);
			return ResponseUtil.RetErrorInfo(e.getCause().getMessage());
		}
		return null;
    }
    
    
    
    /**
     * 保存新增的数据,POST方法
     * @param request
     * @param response
     * @param userInfo 实体
     */
    @RequestMapping(value="newUser",method= RequestMethod.POST)
    public ModelMap newUser(@RequestParam(value ="userName",required=false) String userName, 
    	   @RequestParam(value ="nickName",required=false) String nickName) {
    	try {
			if(StringUtils.isBlank(userName)){
				return ResponseUtil.RetErrorInfo("userName is null");
			}	
			UserInfo usera = userInfoService.getByUserName(userName);
			if(usera != null){
				return ResponseUtil.RetErrorInfo("userName is already existed!");
			}
			logger.debug("进入新增用户方法");
    		UserInfo user = new UserInfo();
    		user.setId(ComUtil.randomUUID());
    		user.setUserName(userName);
    		if(StringUtils.isBlank(nickName)){
    			user.setNickName(userName);
    		}else{
    			user.setNickName(nickName);
    		}	
    		user.setState(BusinessConstant.COMMON_STATE_STAY);
    		userInfoService.insert(user);
    		logger.debug("进入新增用户方法>成功！");
    		return ResponseUtil.RetCorrectInfo("{'uid':'"+user.getId()+"','userName':'"+userName+"'}");
		} catch (Exception e) {
			logger.error("进入新增用户方法>异常：");
			return ResponseUtil.RetErrorInfo("新增用户方法>异常:" + e.getCause().getMessage());
		}
    }

    /**
     * 保存编辑的数据,POST方法
     * @param request
     * @param response
     * @param userInfo 实体
     */
    @RequestMapping(value="editor",method= RequestMethod.POST)
    public ModelMap editor(@RequestParam(value ="userName",required=false) String userName,@RequestParam(value ="nickName",required=false) String nickName){
        try {
			
        	if(StringUtils.isBlank(userName)){
				return ResponseUtil.RetErrorInfo("userName is null");
			}	
			UserInfo usera = userInfoService.getByUserName(userName);
			if(usera == null){
				return ResponseUtil.RetErrorInfo("userName is not existence!");
			}
			logger.debug("进入编辑用户方法");
			if(StringUtils.isNotBlank(nickName) && !usera.getNickName().equals(nickName)){
				usera.setNickName(nickName);
				userInfoService.update(usera);
			}
			return ResponseUtil.RetCorrectInfo("{'userName':'"+userName+"'}");
		} catch (Exception e) {
			logger.error("编辑用户方法,异常：" + e.getCause().getMessage(), e);
			return ResponseUtil.RetErrorInfo(e.getCause().getMessage());
		}
    }

    
    /***
     * 停用
     * @param id
     * @return
     */
    @RequestMapping(value="disable")
    public ModelMap disable(@RequestParam(value ="userName",required=false) String userName) {
        try {
        	if(StringUtils.isBlank(userName)){
            	return ResponseUtil.RetErrorInfo(" userName is null!");
            }
        	if(shareCheck.isEffective(userName,Constant.APP_USER_INFO)){
        		logger.debug("调用禁用用户接口！");
    			UserInfo userInfo = userInfoService.getByUserName(userName);
    			userInfo.setState(BusinessConstant.COMMON_STATE_JUST);
    			userInfoService.update(userInfo);
    			redisUtil.remove(userName);
    			return ResponseUtil.RetCorrectInfo("{userName:'"+userInfo.getUserName()+"'}");
    		}else{
    			return ResponseUtil.RetErrorInfo("already disable!");
    		}
		} catch (Exception e) {
			logger.error("调用应用评论禁用接口,异常：" + e.getCause().getMessage(),e);
			return ResponseUtil.RetErrorInfo(e.getCause().getMessage());
		}
    }
    
    
    /***
     * 启用
     * @param id
     * @return
     */
    @RequestMapping(value="enable")
    public ModelMap enable(@RequestParam(value ="userName",required=false) String userName) {
        try {
        	if(StringUtils.isBlank(userName)){
            	return ResponseUtil.RetErrorInfo(" userName is null!");
            }
        	if(!shareCheck.isEffective(userName,Constant.APP_USER_INFO)){
        		logger.debug("调用用户启用接口！");
    			UserInfo userInfo = userInfoService.getByUserName(userName);
    			if(userInfo != null){
    				if(userInfo.getState().equals(BusinessConstant.COMMON_STATE_JUST)){
    					userInfo.setState(BusinessConstant.COMMON_STATE_STAY);
    					userInfoService.update(userInfo);
    					redisUtil.remove(userName);
    					return ResponseUtil.RetCorrectInfo("{'userName':'" +userName+ "'}");
    				}
    			}
    			return ResponseUtil.RetErrorInfo("object is null!");
    		}else{
				return ResponseUtil.RetErrorInfo("this Object is enable!");
    		}
		} catch (Exception e) {
			logger.error("调用用户评分启用接口,异常：" + e.getCause().getMessage(),e);
			return ResponseUtil.RetErrorInfo(e.getCause().getMessage());
		}
    }
    
    
    
    
}
package com.maiyue.app.controller;

import com.maiyue.app.bean.AppPicture;
import com.maiyue.app.constant.BusinessConstant;
import com.maiyue.app.constant.Constant;
import com.maiyue.app.service.AppPictureService;
import com.github.pagehelper.PageInfo;
import com.maiyue.app.utils.ComUtil;
import com.maiyue.app.utils.RedisUtil;
import com.maiyue.app.utils.ReflectUtil;
import com.maiyue.app.utils.ResponseUtil;
import com.maiyue.app.utils.jsonUtil.JSONUtils;
import java.util.Map;
import javax.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * AppPictureController
 * 2018/03/29
 */
@RestController
@EnableAutoConfiguration
@RequestMapping(value="/picture/*")
public class AppPictureController extends BaseController {
    
	
	@Resource(name = "appPictureService")
    private AppPictureService appPictureService;
	
	@Resource(name = "shareCheck")
    private ShareCheck shareCheck;
	
	@Resource(name = "redisUtil")
    private RedisUtil redisUtil;
	
	private static Logger logger = Logger.getLogger(AppPictureController.class);
	
	
	/***
	 * 分页查询
	 * @param ids
	 * @param appPicture
	 * @return
	 */
    @RequestMapping(value="getPage",method= RequestMethod.POST)
    public ModelMap getPage(@RequestParam(value ="ids[]",required=false) String[] ids, AppPicture appPicture) {
    	try {
   		 	logger.error("调用App信息图片查询接口:--->/picture/getPage");
   		 	Map<String,Object> params = ReflectUtil.beanToMap(appPicture, true);
   		 	params.put(BusinessConstant.IN_SELECT_IDS,ids);//in查询
   	     	PageInfo<AppPicture> data = appPictureService.getPageData(params);
    		 return ResponseUtil.RetCorrectInfo(JSONUtils.toMapJSONObject(data));
		} catch (Exception e) {
			logger.error("调用App信息分页查询接口,异常:--->" + e.getCause().getMessage(),e);
			return ResponseUtil.RetErrorInfo(e.getCause().getMessage());
		}
    }

    
    /***
     * 新增应用图片信息
     * @param appPicture
     * @param appId
     * @param audit
     * @return
     */
    @RequestMapping(value="newAppPicture",method= RequestMethod.POST)
    public ModelMap newAppPicture(AppPicture appPicture,@RequestParam(value="appId",required=false)String appId, 
    		@RequestParam(value="audit",required=false,defaultValue="1")String audit) {
    	try {
			if(StringUtils.isBlank(appId)){
				return ResponseUtil.RetErrorInfo("appId is null!");
			}
			if(!shareCheck.isEffective(appId, Constant.APP_INFO_ID)){
				return ResponseUtil.RetErrorInfo("appId is invalid!");
			}
			if(StringUtils.isBlank(appPicture.getPictureUuidName())){
    			return ResponseUtil.RetErrorInfo("the file uuidName is null!");
    		}
    		if(StringUtils.isBlank(appPicture.getPictureAdderss())){
    			return ResponseUtil.RetErrorInfo("the file address is null!");
    		}
    		if(StringUtils.isNotBlank(appPicture.getAppInstallId())){
    			if(!shareCheck.isEffective(appPicture.getAppInstallId(), Constant.APP_INSTALL_PACK)){
    				return ResponseUtil.RetErrorInfo(" InstallId is invalid!");
    			}
    		}
    		logger.debug("调用APP图片新增接口！");
    		appPicture.setId(ComUtil.randomUUID());
    		appPicture.setAuditResult(audit);
    		appPicture.setAppInfoId(appId);
    		appPicture.setPictureWhereDisk((String)redisUtil.get(Constant.WHERE_DISK_PATH));
    		appPicture.setPictureState(BusinessConstant.COMMON_STATE_STAY);
    		appPictureService.insert(appPicture);
    		logger.debug("调用APP图片新增接口！>成功！");
    		return ResponseUtil.RetCorrectInfo("{'id':'"+appPicture.getId()+"','appId':'"+appId+"'}");
		} catch (Exception e) {
			logger.error("调用APP图片新增接口,异常："+e.getCause().getMessage(),e);
			return ResponseUtil.RetErrorInfo(e.getCause().getMessage());
		}
    }

    

    /***
     * 编辑app图片信息
     * @param id
     * @param adderss
     * @param alias
     * @param uuidName
     * @param size
     * @return
     */
    @RequestMapping(value="editor",method= RequestMethod.POST)
    public ModelMap editor(@RequestParam(value="id",required=false)String id,
    		@RequestParam(value="adderss",required=false)String adderss,
    		@RequestParam(value="alias",required=false)String alias,
    		@RequestParam(value="uuidName",required=false)String uuidName,
    		@RequestParam(value="size",required=false)String size) {
    	try {
    		if(StringUtils.isBlank(id)){
    			return ResponseUtil.RetErrorInfo("id is null");
    		}
    		if(!shareCheck.isEffective(id,Constant.APP_PICTURE)){
    			return ResponseUtil.RetErrorInfo("id is invalid or disable!");
    		}
    		AppPicture appPicture = appPictureService.selectById(id);
    		boolean flag = false;
    		if(StringUtils.isNotBlank(adderss) && !appPicture.getPictureAdderss().equals(adderss)){
    			appPicture.setPictureAdderss(adderss);
    			flag = true;
    		}
    		if(StringUtils.isNotBlank(alias) && !appPicture.getPictureAlias().equals(alias)){
    			appPicture.setPictureAlias(alias);
    			flag = true;
    		}
    		if(StringUtils.isNotBlank(uuidName) && !appPicture.getPictureUuidName().equals(uuidName)){
    			appPicture.setPictureUuidName(uuidName);
    			flag = true;
    		}
    		if(StringUtils.isNotBlank(size) && !appPicture.getPictureSize().equals(size)){
    			appPicture.setPictureSize(size);
    			flag = true;
    		}
    		if(flag){
    			logger.debug("调用编辑APP图片信息接口");
    			appPictureService.update(appPicture);
    		}
    		return ResponseUtil.RetCorrectInfo("{'id':'"+id+"','appId':'"+appPicture.getAppInfoId()+"'}");
		} catch (Exception e) {
			logger.error("调用编辑APP图片信息接口,异常："+e.getCause().getMessage(), e);
			return ResponseUtil.RetErrorInfo(e.getCause().getMessage());
		}
    }

    
    
    
    /***
     * appPicture审核
     * @param id
     * @param state
     * @return
     */
    @RequestMapping(value="audit")
    public ModelMap audit(@RequestParam(value ="id",required=false) String id,
    		@RequestParam(value ="audit",required=false) String audit){
    	try {
    		logger.debug("调用App图片信息审核方法 !/picture/audit?id=" + id);
    		if(StringUtils.isBlank(id) || StringUtils.isBlank(audit)){
        		return ResponseUtil.RetErrorInfo("id or audit is null!");
    		}
    		if(!BusinessConstant.AUDIT_RESULT_JUST.equals(audit) && !BusinessConstant.AUDIT_RESULT_PASS.equals(audit) &&
    			!BusinessConstant.AUDIT_RESULT_STAY.equals(audit)){
    	         return ResponseUtil.RetErrorInfo("audit numerical types unlawful!");
    	    }
    		if(!shareCheck.isEffective(id,Constant.APP_PICTURE)){
    			return ResponseUtil.RetErrorInfo("this id is invalid or disable!");
    		}
    		AppPicture appPicture = appPictureService.selectById(id);
    		if(appPicture.getAuditResult().equals(audit)){
			  return ResponseUtil.RetErrorInfo("The state has already been audited!");
			}
    		appPicture.setAuditResult(audit);
    		appPictureService.update(appPicture);
			logger.debug("调用App图片信息审核方法 ,操作：成功(success)--->/picture/audit?id=" + id + "");
			return ResponseUtil.RetCorrectInfo("{id:'"+id+"'}");
		} catch (Exception e) {
    		logger.error("调用App图片信息审核方法,异常：(Exception)--->" +  e.getCause().getMessage(),e);
    		return ResponseUtil.RetErrorInfo(e.getCause().getMessage());
		}
    }
    
    
    
    /***
     * 修改状态
     * @param id
     * @param state
     * @return
     */
    @RequestMapping(value="enable")
    public ModelMap enable(@RequestParam(value ="id",required=false) String id){
    	try {
    		logger.debug("调用App图片信息更新状态方法 !/picture/enable?id=" + id);
    		if(StringUtils.isBlank(id)){
        		return ResponseUtil.RetErrorInfo("id or state is null!");
    		}
    		if(!shareCheck.isEffective(id, Constant.APP_PICTURE)){
    			AppPicture appPicture = appPictureService.selectById(id);
    			if(appPicture != null){
    				if(appPicture.getPictureState().equals(BusinessConstant.COMMON_STATE_JUST)){
    					appPicture.setPictureState(BusinessConstant.COMMON_STATE_STAY);
    					appPictureService.update(appPicture);
    					if(redisUtil.get(id) != null){
    	    				redisUtil.remove(id);
    	    			}
    					return ResponseUtil.RetCorrectInfo("{'id':'" +id+ "'}");
    				}
    			}
    			return ResponseUtil.RetErrorInfo("object is null!");
    		}else{
    			return ResponseUtil.RetErrorInfo("this Object is enable!");
    		}
		} catch (Exception e) {
    		logger.error("调用App信息更新状态方法,异常：(Exception)--->" +  e.getCause().getMessage(),e);
    		return ResponseUtil.RetErrorInfo(e.getCause().getMessage());
		}
    }
    
    
    
   
    
    /**
     * 根据ID删除数据,POST方法
     * @param request
     * @param response
     * @param id
     */
    @RequestMapping(value="disable")
    public ModelMap disable(@RequestParam(value ="id",required=false) String id) {
    	try {
    		logger.debug("调用禁用App图片信息接口！");
        	if(StringUtils.isBlank(id)){
        		return ResponseUtil.RetErrorInfo("id is null!");
        	}
        	if(shareCheck.isEffective(id,Constant.APP_PICTURE)){
    			AppPicture appPicture = appPictureService.selectById(id);
    			appPicture.setPictureState(BusinessConstant.COMMON_STATE_JUST);
    			appPictureService.update(appPicture);
    			if(redisUtil.get(id) != null){
    				redisUtil.remove(id);
    			}
    			return ResponseUtil.RetCorrectInfo("{id:'"+appPicture.getId()+"'}");
    		}else{
    			return ResponseUtil.RetErrorInfo("already disable!");
    		}
		} catch (Exception e) {
			logger.error("调用删除禁用信息接口,异常：失败(error)--->：" + e.getCause().getMessage(),e);
    		return ResponseUtil.RetErrorInfo(e.getCause().getMessage());
		}
    }
    
    
    
}
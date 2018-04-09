package com.maiyue.app.controller;

import com.maiyue.app.bean.Admedia;
import com.maiyue.app.constant.BusinessConstant;
import com.maiyue.app.constant.Constant;
import com.maiyue.app.service.AdmediaService;
import com.github.pagehelper.PageInfo;
import com.maiyue.app.utils.ComUtil;
import com.maiyue.app.utils.RedisUtil;
import com.maiyue.app.utils.ReflectUtil;
import com.maiyue.app.utils.ResponseUtil;
import com.maiyue.app.utils.jsonUtil.JSONUtils;

import java.util.Date;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

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
 * AdmediaController
 * 2018/03/29
 */

@RestController
@EnableAutoConfiguration
@RequestMapping(value="/admedia/*")
public class AdmediaController extends BaseController {
    
	
	@Resource(name = "admediaService")
    private AdmediaService admediaService;
	
	@Autowired
	private ShareCheck shareCheck;
	
	@Resource(name = "redisUtil")
	private RedisUtil redisUtil;

	private static Logger logger = Logger.getLogger(AdmediaController.class);

	/***
	 * 分页查询
	 * @param ids
	 * @param admedia
	 * @return
	 */
    @RequestMapping(value="getPage",method= RequestMethod.POST)
    public ModelMap getPage(@RequestParam(value ="ids[]",required=false) String[] ids, Admedia admedia) {
    	try {
          	 logger.debug("调用AD资源分页查询方法！");
          	 Map<String,Object> params = ReflectUtil.beanToMap(admedia,true);
          	 params.put(BusinessConstant.IN_SELECT_IDS,ids);//in查询
      	     PageInfo<Admedia> data = admediaService.getPageData(params);
      	     return ResponseUtil.RetCorrectInfo(JSONUtils.toMapJSONObject(data));
   		} catch (Exception e) {
   			logger.error("调用AD资源分页查询方法,异常：" + e.getCause().getMessage(),e);
   			return ResponseUtil.RetErrorInfo(e.getCause().getMessage());
   		}
    }

    
    
    

    /***
     * 新增
     * @param adId
     * @param audit
     * @param mediaType
     * @param alias
     * @param address
     * @return
     */
    @RequestMapping(value="newAdmeda",method= RequestMethod.POST)
    public ModelMap newAdmeda(@RequestParam(value ="adId",required=false) String adId,
    	  @RequestParam(value ="audit",required=false,defaultValue=BusinessConstant.AUDIT_RESULT_PASS) String audit,
    	  @RequestParam(value ="mediaType",required=false) String mediaType,
    	  @RequestParam(value ="alias",required=false) String alias,
    	  @RequestParam(value ="address",required=false) String address) {
    	try {
    		if(getCurrUser() == null){
				return ResponseUtil.RetErrorInfo(" user object is null,please login first!");
			}else{
				if(StringUtils.isBlank(getCurrUser().getId())){
					return ResponseUtil.RetErrorInfo(" user object is null,please login first!");
				}
			}
    		if(StringUtils.isBlank(adId)){
    			return ResponseUtil.RetErrorInfo(" adId is null!");
    		}
    		if(!shareCheck.isEffective(adId,Constant.AD_INFO)){
    			return ResponseUtil.RetErrorInfo(" adId is invalid!");
    		}
    		if(StringUtils.isBlank(mediaType) || StringUtils.isBlank(address)){
    			return ResponseUtil.RetErrorInfo(" mediaType or address is null!");
    		}
    		Admedia media = new Admedia();
    		media.setId(ComUtil.randomUUID());
    		media.setUserId(getCurrUser().getId());
    		media.setState(BusinessConstant.COMMON_STATE_STAY);
    		media.setCreateTime(new Date());
    		media.setAdId(adId);
    		media.setAuditResult(audit);//免审核
    		media.setMediaDisk(redisUtil.get(Constant.WHERE_DISK_PATH)==null?"未知":redisUtil.get(Constant.WHERE_DISK_PATH).toString());
    		media.setMediaType(mediaType);
    		media.setMediaAddress(address);
    		media.setMediaAlias(StringUtils.isBlank(alias)==true?"未知":alias);
    		admediaService.insert(media);
    		logger.debug("调用AD资源接口：成功。");
    		return ResponseUtil.RetCorrectInfo("{'id':'"+media.getId()+"','adId':'"+media.getAdId()+"'}");
		} catch (Exception e) {
			logger.error("调用AD资源接口,异常：" + e.getCause().getMessage(),e);
			return ResponseUtil.RetErrorInfo(e.getCause().getMessage());
		}
    }

    
    
    /***
     * 编辑
     * @param id
     * @param adId
     * @param mediaType
     * @param alias
     * @param address
     * @return
     */
    @RequestMapping(value="editor",method= RequestMethod.POST)
    public ModelMap editor(@RequestParam(value ="id",required=false) String id,
    	   @RequestParam(value ="adId",required=false) String adId,
      	   @RequestParam(value ="mediaType",required=false) String mediaType,
      	   @RequestParam(value ="alias",required=false) String alias,
      	   @RequestParam(value ="address",required=false) String address) {
    	try {
    		if(StringUtils.isBlank(id) || StringUtils.isBlank(adId)){
            	return ResponseUtil.RetErrorInfo(" id or adId is null!");
            }
        	if(!shareCheck.isEffective(id,Constant.AD_MEDIA)){
    			return ResponseUtil.RetErrorInfo(" id is invalid!");
    		}
        	if(!shareCheck.isEffective(adId,Constant.AD_INFO)){
    			return ResponseUtil.RetErrorInfo(" adinfo is invalid!");
    		}
    		Admedia media = admediaService.selectById(id);
    		boolean flag = false;
        	if(StringUtils.isNotBlank(mediaType)){
        		media.setMediaType(mediaType);
        		flag = true;
        	}
        	if(StringUtils.isNotBlank(alias)){
        		media.setMediaAlias(alias);
        		flag = true;
        	}
        	if(StringUtils.isNotBlank(address)){
        		media.setMediaAddress(address);
        		flag = true;
        	}
        	if(flag){
        		admediaService.update(media);
        	}
        	logger.debug("调用AD资源编辑成功！");
        	return ResponseUtil.RetCorrectInfo("{'id':'"+id+"','adId':'"+adId+"'}");
		} catch (Exception e) {
			logger.error("调用AD资源编辑异常：" + e.getCause().getMessage(), e);
			return ResponseUtil.RetErrorInfo(e.getCause().getMessage());
		}
    }

    
    
    /****
     * 按别类别ID查询
     * @param id
     * @return
     */
    @RequestMapping(value="findById")
    public ModelMap findById(@RequestParam(value ="id",required=false)String id
    		,HttpServletResponse response) {
    	try {
        	if(StringUtils.isBlank(id)){
        		return ResponseUtil.RetErrorInfo("id is null!");
        	}
        	if(!shareCheck.isEffective(id, Constant.APP_REWIEW_ID)){
    			return ResponseUtil.RetErrorInfo("this object is null or disable!");
    		}
        	logger.debug("调用AD资源按ID查询接口,成功>");
        	Admedia amedia = admediaService.selectById(id);
    		return ResponseUtil.RetCorrectInfo(JSONUtils.toJSONObject(amedia));
		} catch (Exception e) {
    		logger.error("调用AD资源按ID查询接口,异常:--->" + e.getCause().getMessage(),e);
    		return ResponseUtil.RetErrorInfo(e.getCause().getMessage());
		}
    }
    
    
    
    
    
    
    
    /***
     * AD资源审核
     * @param id
     * @param state
     * @return
     */
    @RequestMapping(value="audit")
    public ModelMap audit(@RequestParam(value ="id",required=false) String id,
    		@RequestParam(value ="audit",required=false) String audit){
    	try {
    		logger.debug("调用AD资源审核审核方法 !id=" + id);
    		if(StringUtils.isBlank(id) || StringUtils.isBlank(audit)){
        		return ResponseUtil.RetErrorInfo("id or audit is null!");
    		}
    		if(!BusinessConstant.AUDIT_RESULT_JUST.equals(audit) && !BusinessConstant.AUDIT_RESULT_PASS.equals(audit) &&
    			!BusinessConstant.AUDIT_RESULT_STAY.equals(audit)){
    	         return ResponseUtil.RetErrorInfo("audit numerical types unlawful!");
    	    }
    		if(!shareCheck.isEffective(id,Constant.AD_MEDIA)){
    			return ResponseUtil.RetErrorInfo("this id is invalid or disable!");
    		}
    		Admedia admedia = admediaService.selectById(id);
    		if(admedia.getAuditResult().equals(audit)){
			  return ResponseUtil.RetErrorInfo("this state has already audited!");
			}
    		admedia.setAuditResult(audit);
    		admediaService.update(admedia);
			logger.debug("调用AD资源审核方法 ,操作：成功(success)--->id=" + id + "");
			return ResponseUtil.RetCorrectInfo("{id:'"+id+"'}");
		} catch (Exception e) {
    		logger.error("调用AD资源审核方法,异常：(Exception)--->" +  e.getCause().getMessage(),e);
    		return ResponseUtil.RetErrorInfo(e.getCause().getMessage());
		}
    }
    
    
    /***
     * 停用
     * @param id
     * @return
     */
    @RequestMapping(value="disable")
    public ModelMap disable(@RequestParam(value ="id",required=false) String id) {
        try {
        	if(StringUtils.isBlank(id)){
            	return ResponseUtil.RetErrorInfo(" id is null!");
            }
        	if(shareCheck.isEffective(id,Constant.AD_MEDIA)){
        		logger.debug("调用应用评论禁用接口！");
    			Admedia admedia = admediaService.selectById(id);
    			admedia.setState(BusinessConstant.COMMON_STATE_JUST);
    			admediaService.update(admedia);
    			redisUtil.remove(id);
    			return ResponseUtil.RetCorrectInfo("{id:'"+admedia.getId()+"'}");
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
    public ModelMap enable(@RequestParam(value ="id",required=false) String id) {
        try {
        	if(StringUtils.isBlank(id)){
            	return ResponseUtil.RetErrorInfo(" id is null!");
            }
        	if(!shareCheck.isEffective(id,Constant.AD_MEDIA)){
        		logger.debug("调用AD资源分启用用接口！");
    			Admedia admedia = admediaService.selectById(id);
    			if(admedia != null){
    				if(admedia.getState().equals(BusinessConstant.COMMON_STATE_JUST)){
    					admedia.setState(BusinessConstant.COMMON_STATE_STAY);
    					admediaService.update(admedia);
    					redisUtil.remove(id);
    					return ResponseUtil.RetCorrectInfo("{'id':'" +id+ "','adId':'"+admedia.getAdId()+"'}");
    				}
    			}
    			return ResponseUtil.RetErrorInfo("object is null!");
    		}else{
				return ResponseUtil.RetErrorInfo("this Object is enable!");
    		}
		} catch (Exception e) {
			logger.error("调用AD资源起用接口,异常：" + e.getCause().getMessage(),e);
			return ResponseUtil.RetErrorInfo(e.getCause().getMessage());
		}
    }
    
}
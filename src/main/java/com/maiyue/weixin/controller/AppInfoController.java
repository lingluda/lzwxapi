package com.maiyue.app.controller;

import com.github.pagehelper.PageInfo;
import com.maiyue.app.bean.AppInfo;
import com.maiyue.app.constant.BusinessConstant;
import com.maiyue.app.constant.Constant;
import com.maiyue.app.service.AppInfoService;
import com.maiyue.app.utils.ComUtil;
import com.maiyue.app.utils.RedisUtil;
import com.maiyue.app.utils.ReflectUtil;
import com.maiyue.app.utils.ResponseUtil;
import com.maiyue.app.utils.jsonUtil.JSONUtils;

import java.math.BigDecimal;
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
 * AppInfoController
 * 2018/03/29
 */
@RestController
@EnableAutoConfiguration
@RequestMapping(value="/appinfo/*")
public class AppInfoController extends BaseController {
    
	
	@Resource(name = "appInfoService")
    private AppInfoService appInfoService;
	
	@Autowired
	private ShareCheck shareCheck;
	

	@Resource(name = "redisUtil")
	private RedisUtil redisUtil;
	
	private static Logger logger = Logger.getLogger(AppCategoryController.class);
	
	
    /***
     * App信息分页查询
     * @param param
     * @param appInfo
     * @return
     */
    @RequestMapping(value="getPage",method= RequestMethod.POST)
    public ModelMap getPage(AppInfo appInfo,@RequestParam(value="ids[]",required = false) String[] ids){
    	try {
   		 	logger.error("调用App信息分页查询接口:--->/appinfo/getPage");
   		 	Map<String,Object> params = ReflectUtil.beanToMap(appInfo, true);
   		 	params.put(BusinessConstant.IN_SELECT_IDS,ids);//in查询
   	     	PageInfo<AppInfo> data = appInfoService.getPageData(params);
    		 return ResponseUtil.RetCorrectInfo(JSONUtils.toMapJSONObject(data));
		} catch (Exception e) {
			logger.error("调用App信息分页查询接口,异常:--->" + e.getCause().getMessage(),e);
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
    		logger.debug("调用App信息按ID查询接口！");
        	if(StringUtils.isBlank(id)){
        		return ResponseUtil.RetErrorInfo("id is null!");
        	}
        	if(!shareCheck.isEffective(id, Constant.APP_INFO_ID)){
    			return ResponseUtil.RetErrorInfo("this object is null or disable!");
    		}
        	AppInfo appInfo = appInfoService.selectById(id);
    		logger.debug("调用App信息按ID查询接口,成功：--->/appInfo/findById?id=" + id);
    		return ResponseUtil.RetCorrectInfo(JSONUtils.toJSONObject(appInfo));
		} catch (Exception e) {
    		logger.error("调用App信息按ID查询接口,异常:--->" + e.getCause().getMessage(),e);
    		return ResponseUtil.RetErrorInfo(e.getCause().getMessage());
		}
    }
    
    
    /***
     * 新增APP信息接口
     * @param appName
     * @param categoryId
     * @param appType
     * @param details
     * @param version
     * @param auditResult
     * @param state
     * @return
     */
    @RequestMapping(value="newAppInfo",method= RequestMethod.POST)
    public ModelMap newAppInfo(@RequestParam(value="appName",required = false) String appName, 
    		@RequestParam(value="categoryId",required = false) String categoryId,
    		@RequestParam(value="appType",required = false) String appType,
    		@RequestParam(value="details",required = false) String details,
    		@RequestParam(value="version",required = false,defaultValue="v1.0") String version,
    		@RequestParam(value="auditResult",required = false,defaultValue=BusinessConstant.AUDIT_RESULT_STAY) String auditResult,
    		@RequestParam(value="state",required = false,defaultValue=BusinessConstant.COMMON_STATE_STAY) String state){
    	try {
    		logger.debug("调用新增App信息接口！");
        	if(StringUtils.isBlank(appName) || StringUtils.isBlank(categoryId) ||
        	   StringUtils.isBlank(appType) || StringUtils.isBlank(details)){
        		return ResponseUtil.RetErrorInfo("appName or categoryId or appType or details is null!");
        	}
        	if(!shareCheck.isEffective(categoryId, Constant.APP_CATEGORY_ID)){
    			return ResponseUtil.RetErrorInfo("categoryId object is null or disable!");
    		}
        	AppInfo appInfo = new AppInfo();
        	appInfo.setId(ComUtil.randomUUID());//ID
        	appInfo.setAppType(appType);
        	appInfo.setAppCategoryId(categoryId);
        	appInfo.setAppName(appName);
        	appInfo.setAppDetails(details);
        	appInfo.setCurrentVersion(version);
        	appInfo.setCreateTime(new Date());
        	appInfo.setAuditResult(auditResult);
        	appInfo.setBrowseNum(BigDecimal.ZERO);
        	appInfo.setDownloadsNum(BigDecimal.ZERO);
        	appInfo.setInstpackNum(BigDecimal.ZERO);//安装包数量
        	appInfo.setAppState(state);
        	appInfoService.insert(appInfo);
        	logger.debug("调用新增App信息接口,成功:--->result:id=" + appInfo.getId());
    		return ResponseUtil.RetCorrectInfo("{id:'"+appInfo.getId()+"'}");
		} catch (Exception e) {
			logger.error("调用新增App信息接口,异常:--->" + e.getCause().getMessage(),e);
    		return ResponseUtil.RetErrorInfo(e.getCause().getMessage());
		}
    }

    
    /***
     * APP信息编辑器
     * @param id
     * @param appName
     * @param categoryId
     * @param appType
     * @param details
     * @param version
     * @return
     */
    @RequestMapping(value="editor",method= RequestMethod.POST)
    public ModelMap editor(@RequestParam(value="id",required = false) String id,
    		@RequestParam(value="appName",required = false) String appName, 
    		@RequestParam(value="categoryId",required = false) String categoryId,
    		@RequestParam(value="appType",required = false) String appType,
    		@RequestParam(value="details",required = false) String details,
    		@RequestParam(value="version",required = false) String version){
    	try {
    		logger.debug("调用App信息编辑器!");
    		if(StringUtils.isBlank(id)){
        		return ResponseUtil.RetErrorInfo("id or categoryId is null!");
    		}
    		if(!shareCheck.isEffective(id, Constant.APP_INFO_ID)){
    			return ResponseUtil.RetErrorInfo("id is invalid or object disable!");
    		}
    		if(!shareCheck.isEffective(categoryId, Constant.APP_CATEGORY_ID)){
    			return ResponseUtil.RetErrorInfo("categoryId object is null or disable!");
    		}
    		AppInfo appInfo = appInfoService.selectById(id);
    		appInfo.setAppName(appName);
    		appInfo.setAppCategoryId(categoryId);
    		appInfo.setAppDetails(details);
    		appInfo.setAppType(appType);
    		appInfo.setCurrentVersion(version);
    		appInfoService.update(appInfo);
    		logger.debug("调用App信息编辑器,成功：--->result:id=" + id);
    		return ResponseUtil.RetCorrectInfo("{id:'"+id+"'}");
		} catch (Exception e) {
    		logger.error("调用App信息编辑器,异常：--->" +  e.getCause().getMessage(),e);
    		return ResponseUtil.RetErrorInfo(e.getCause().getMessage());
		}
    }

    
    /***
     * AppInfo审核
     * @param id
     * @param state
     * @return
     */
    @RequestMapping(value="audit")
    public ModelMap audit(@RequestParam(value ="id",required=false) String id,
    		@RequestParam(value ="audit",required=false) String audit){
    	try {
    		logger.debug("调用App信息审核方法 !/appinfo/audit?id=" + id);
    		if(StringUtils.isBlank(id) || StringUtils.isBlank(audit)){
        		return ResponseUtil.RetErrorInfo("id or audit is null!");
    		}
    		if(!BusinessConstant.AUDIT_RESULT_JUST.equals(audit) && !BusinessConstant.AUDIT_RESULT_PASS.equals(audit) &&
    			!BusinessConstant.AUDIT_RESULT_STAY.equals(audit)){
    	         return ResponseUtil.RetErrorInfo("audit numerical types unlawful!");
    	    }
    		if(!shareCheck.isEffective(id,Constant.APP_INFO_ID)){
    			return ResponseUtil.RetErrorInfo("this id is invalid or disable!");
    		}
    		AppInfo appInfo = appInfoService.selectById(id);
    		if(appInfo.getAuditResult().equals(audit)){
			  return ResponseUtil.RetErrorInfo("The state has already been audited!");
			}
    		appInfo.setAuditResult(audit);
    		appInfoService.update(appInfo);
			logger.debug("调用App信息审核方法 ,操作：成功(success)--->/appinfo/audit?id=" + id + "");
			return ResponseUtil.RetCorrectInfo("{id:'"+id+"'}");
		} catch (Exception e) {
    		logger.error("调用App信息审核方法,异常：(Exception)--->" +  e.getCause().getMessage(),e);
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
    		logger.debug("调用App信息更新状态方法 !/appinfo/enable?id=" + id);
    		if(StringUtils.isBlank(id)){
        		return ResponseUtil.RetErrorInfo("id or state is null!");
    		}
    		if(!shareCheck.isEffective(id, Constant.APP_INFO_ID)){
    			AppInfo appInfo = appInfoService.selectById(id);
    			if(appInfo != null){
    				if(appInfo.getAppState().equals(BusinessConstant.COMMON_STATE_JUST)){
    					appInfo.setAppState(BusinessConstant.COMMON_STATE_STAY);
    					appInfoService.update(appInfo);
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
    		logger.debug("调用禁用App信息接口！");
        	if(StringUtils.isBlank(id)){
        		return ResponseUtil.RetErrorInfo("id is null!");
        	}
        	if(shareCheck.isEffective(id,Constant.APP_INFO_ID)){
    			AppInfo appInfo = appInfoService.selectById(id);
    			appInfo.setAppState(BusinessConstant.COMMON_STATE_JUST);
    			appInfoService.update(appInfo);
    			if(redisUtil.get(id) != null){
    				redisUtil.remove(id);
    			}
    			return ResponseUtil.RetCorrectInfo("{id:'"+appInfo.getId()+"'}");
    		}else{
    			return ResponseUtil.RetErrorInfo("already disable!");
    		}
		} catch (Exception e) {
			logger.error("调用删除禁用信息接口,异常：失败(error)--->：" + e.getCause().getMessage(),e);
    		return ResponseUtil.RetErrorInfo(e.getCause().getMessage());
		}
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
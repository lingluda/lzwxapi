package com.maiyue.app.controller;

import com.maiyue.app.bean.InstPackage;
import com.maiyue.app.bean.UserInfo;
import com.maiyue.app.constant.BusinessConstant;
import com.maiyue.app.constant.Constant;
import com.maiyue.app.service.InstPackageService;
import com.maiyue.app.service.UserInfoService;
import com.github.pagehelper.PageInfo;
import com.maiyue.app.utils.ComUtil;
import com.maiyue.app.utils.RedisUtil;
import com.maiyue.app.utils.ReflectUtil;
import com.maiyue.app.utils.ResponseUtil;
import com.maiyue.app.utils.jsonUtil.JSONUtils;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * InstPackageController
 * 2018/03/29
 */
@Controller
@EnableAutoConfiguration
@RequestMapping(value="/in-package/*")
public class InstPackageController extends BaseController {
    
	@Resource(name = "instPackageService")
    private InstPackageService instPackageService;
	
	@Resource(name = "userInfoService")
    private UserInfoService userInfoService;
	
	@Resource(name = "shareCheck")
    private ShareCheck shareCheck;

	@Resource(name = "redisUtil")
	private RedisUtil redisUtil;
	
	private static Logger logger = Logger.getLogger(InstPackageController.class);
   
	/***
	 * App安装包分页查询
	 * @param ids
	 * @param instPackage
	 * @return
	 */
    @RequestMapping(value="getPage",method= RequestMethod.POST)
    public ModelMap list(@RequestParam(value ="ids[]",required=false) String[] ids,InstPackage instPackage) {
    	try {
   		 	logger.error("调用App安装包分页查询接口:--->/in-package/getPage");
   		 	Map<String,Object> params = ReflectUtil.beanToMap(instPackage, true);
   		 	params.put(BusinessConstant.IN_SELECT_IDS,ids);//in查询
   	     	PageInfo<InstPackage> data = instPackageService.getPageData(params);
    		return ResponseUtil.RetCorrectInfo(JSONUtils.toMapJSONObject(data));
		} catch (Exception e) {
			logger.error("调用App安装包分页查询接口,异常:--->" + e.getCause().getMessage(),e);
			return ResponseUtil.RetErrorInfo(e.getCause().getMessage());
		}
    }
    
    /****
     * 按别ID查询
     * @param id
     * @return
     */
    @RequestMapping(value="findById")
    public ModelMap findById(@RequestParam(value ="id",required=false)String id){
    	try {
    		logger.debug("调用App安装包信息按ID查询接口！");
        	if(StringUtils.isBlank(id)){
        		return ResponseUtil.RetErrorInfo("id is null!");
        	}
        	if(!shareCheck.isEffective(id, Constant.APP_INSTALL_PACK)){
        		return ResponseUtil.RetErrorInfo("InstPackage Object is null!");
        	}
        	InstPackage ipackage = instPackageService.selectById(id);
    		logger.debug("调用App安装包信息按ID查询接口,成功：--->/in-package/findById?id=" + id);
    		return ResponseUtil.RetCorrectInfo(JSONUtils.toJSONObject(ipackage));
		} catch (Exception e) {
    		logger.error("调用App安装包信息按ID查询接口,异常:--->" + e.getCause().getMessage(),e);
    		return ResponseUtil.RetErrorInfo(e.getCause().getMessage());
		}
    }
    
    
    /****
     * 按别AppID查询
     * @param appId
     * @return
     */
    @RequestMapping(value="findByAppId")
    public ModelMap findByAppId(@RequestParam(value ="appId",required=false)String appId) {
    	try {
    		logger.debug("调用App安装包信息按APP-ID查询接口！");
        	if(StringUtils.isBlank(appId)){
        		return ResponseUtil.RetErrorInfo("appId is null!");
        	}
        	List<InstPackage> ipackages = instPackageService.findByAppId(appId);
        	if(ipackages == null || ipackages.size()==0){
        		return ResponseUtil.RetCorrectInfo("null");
        	}
    		logger.debug("调用App安装包信息按APP-ID查询接口,成功：--->/in-package/findByAppId?id=" + appId);
    		return ResponseUtil.RetCorrectInfo(JSONUtils.toJSONArrayExcludes(ipackages));
		} catch (Exception e) {
    		logger.error("调用App安装包信息按APP-ID查询接口,异常:--->" + e.getCause().getMessage(),e);
    		return ResponseUtil.RetErrorInfo(e.getCause().getMessage());
		}
    }
    
    
    
    /****
     * 按别userId查询
     * @param userId
     * @return
     */
    @RequestMapping(value="findByUserName")
    public ModelMap findByUserId(@RequestParam(value ="userName",required=false)String userName) {
    	try {
    		logger.debug("调用App安装包信息按USER-ID查询接口！");
        	if(StringUtils.isBlank(userName)){
        		return ResponseUtil.RetErrorInfo("userName is null!");
        	}
        	if(!shareCheck.isEffective(userName, Constant.APP_USER_INFO)){
        		return ResponseUtil.RetErrorInfo("user object is null!");
        	}
        	UserInfo user = userInfoService.getByUserName(userName);
        	List<InstPackage> ipackages = instPackageService.findByUserId(user.getId());
        	if(ipackages == null || ipackages.size()==0){
        		return ResponseUtil.RetCorrectInfo("null");
        	}
    		logger.debug("调用App安装包信息按APP-ID查询接口,成功：--->/in-package/findByUserId?id=" + user.getId());
    		return ResponseUtil.RetCorrectInfo(JSONUtils.toJSONArrayExcludes(ipackages));
		} catch (Exception e) {
    		logger.error("调用App安装包信息按APP-ID查询接口,异常:--->" + e.getCause().getMessage(),e);
    		return ResponseUtil.RetErrorInfo(e.getCause().getMessage());
		}
    }
    
    
    
    
    
    
    
    
    
    /***
     * 新增安装包
     * @param address
     * @param appId
     * @param alias
     * @param packageSize
     * @param uuidName
     * @param details
     * @param version
     * @param auditResult
     * @param state
     * @return
     */
    @RequestMapping(value="newInstallPackage",method= RequestMethod.POST)
    public ModelMap newInstallPackage(@RequestParam(value="appId",required = false) String appId,
    		@RequestParam(value="address",required = false) String address, 
    		@RequestParam(value="alias",required = false) String alias,
    		@RequestParam(value="packageSize",required = false) String packageSize,
    		@RequestParam(value="uuidName",required = false) String uuidName,
    		@RequestParam(value="details",required = false,defaultValue="无") String details,
    		@RequestParam(value="version",required = false,defaultValue="v1.0") String version,
    		@RequestParam(value="auditResult",required = false,defaultValue=BusinessConstant.AUDIT_RESULT_STAY) String auditResult,
    		@RequestParam(value="state",required = false,defaultValue=BusinessConstant.COMMON_STATE_STAY) String state) {
    	try {
    		logger.debug("调用新增App安装包信息接口！");
        	if(StringUtils.isBlank(address) || StringUtils.isBlank(alias) ||
        	   StringUtils.isBlank(appId) || StringUtils.isBlank(packageSize) || StringUtils.isBlank(uuidName)){
        		return ResponseUtil.RetErrorInfo("The parameters exist is null!");
        	}
        	if(!shareCheck.isEffective(appId, Constant.APP_INFO_ID)){
        		return ResponseUtil.RetErrorInfo("appInfo object is null or disable!");
        	}
        	InstPackage ipackage = new InstPackage();
        	ipackage.setId(ComUtil.randomUUID());//ID
        	ipackage.setAppInfoId(appId);
        	ipackage.setUserId(getCurrUser().getId());
        	ipackage.setUserName(getCurrUser().getUserName());
        	ipackage.setUploadTime(new Date());
        	ipackage.setAuditResult(auditResult);
        	ipackage.setDetails(details);
        	ipackage.setDownloadsNum(BigDecimal.ZERO);
        	
        	ipackage.setInstallVersion(version);
        	ipackage.setInstallAddress(address);
        	ipackage.setInstallAlias(alias);
        	ipackage.setInstallSize(packageSize);
        	ipackage.setInstallUuidName(uuidName);
        	ipackage.setInstallState(state);
        	ipackage.setInstallWhereDisk(redisUtil.get(Constant.UP_DOWN_LOAD_PATH).toString());
        	
        	instPackageService.insert(ipackage);
        	logger.debug("调用新增App信息接口,成功:--->result:id=" + ipackage.getId());
    		return ResponseUtil.RetCorrectInfo("{id:'"+ipackage.getId()+"','appId':'"+ipackage.getAppInfoId()+"'}");
		} catch (Exception e) {
			logger.error("调用新增App信息接口,异常:--->" + e.getCause().getMessage(),e);
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
    		logger.debug("调用App安装包信息审核方法 !/picture/audit?id=" + id);
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
    		InstPackage package1 = instPackageService.selectById(id);
    		if(package1.getAuditResult().equals(audit)){
			  return ResponseUtil.RetErrorInfo("The state has already been audited!");
			}
    		package1.setAuditResult(audit);
    		instPackageService.update(package1);
			logger.debug("调用App安装包信息审核方法 ,操作：成功(success)--->/picture/audit?id=" + id + "");
			return ResponseUtil.RetCorrectInfo("{id:'"+id+"'}");
		} catch (Exception e) {
    		logger.error("调用App安装包信息审核方法,异常：(Exception)--->" +  e.getCause().getMessage(),e);
    		return ResponseUtil.RetErrorInfo(e.getCause().getMessage());
		}
    }
    
    
    
    
    
    
    
    

    /**
     * 保存编辑的数据,POST方法
     * @param request
     * @param response
     * @param instPackage 实体
     */
    @RequestMapping(value="editor",method= RequestMethod.POST)
    public ModelMap editor(@RequestParam(value="id",required=false)String id,
    	@RequestParam(value="adderss",required=false)String adderss,
    	@RequestParam(value="version",required=false)String version,
		@RequestParam(value="alias",required=false)String alias,
		@RequestParam(value="uuidName",required=false)String uuidName,
		@RequestParam(value="details",required = false) String details,
		@RequestParam(value="size",required=false)String size) {
		try {
			if(StringUtils.isBlank(id)){
				return ResponseUtil.RetErrorInfo("id is null");
			}
			if(!shareCheck.isEffective(id,Constant.APP_INSTALL_PACK)){
				return ResponseUtil.RetErrorInfo("id is invalid or disable!");
			}
			InstPackage package1 = instPackageService.selectById(id);
			boolean flag = false;
			if(StringUtils.isNotBlank(adderss) && !package1.getInstallAddress().equals(adderss)){
				package1.setInstallAddress(adderss);
				flag = true;
			}
			if(StringUtils.isNotBlank(version) && !package1.getInstallVersion().equals(version)){
				package1.setInstallVersion(version);
				flag = true;
			}
			if(StringUtils.isNotBlank(alias) && !package1.getInstallAlias().equals(alias)){
				package1.setInstallAlias(alias);
				flag = true;
			}
			if(StringUtils.isNotBlank(details) && !package1.getDetails().equals(details)){
				package1.setDetails(details);
				flag = true;
			}
			if(StringUtils.isNotBlank(uuidName) && !package1.getInstallUuidName().equals(uuidName)){
				package1.setInstallUuidName(uuidName);
				flag = true;
			}
			if(StringUtils.isNotBlank(size) && !package1.getInstallSize().equals(size)){
				package1.setInstallSize(size);
				flag = true;
			}
			if(flag){
				logger.debug("调用编辑APP安装包信息接口");
				instPackageService.update(package1);
			}
			return ResponseUtil.RetCorrectInfo("{'id':'"+id+"','appId':'"+package1.getAppInfoId()+"'}");
		} catch (Exception e) {
			logger.error("调用编辑APP安装包信息接口,异常："+e.getCause().getMessage(), e);
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
    			InstPackage package1 = instPackageService.selectById(id);
    			if(package1 != null){
    				if(package1.getInstallState().equals(BusinessConstant.COMMON_STATE_JUST)){
    					package1.setInstallState(BusinessConstant.COMMON_STATE_STAY);
    					instPackageService.update(package1);
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
        	if(shareCheck.isEffective(id,Constant.APP_INSTALL_PACK)){
    			InstPackage instPackage = instPackageService.selectById(id);
    			instPackage.setInstallState(BusinessConstant.COMMON_STATE_JUST);
    			instPackageService.update(instPackage);
    			if(redisUtil.get(id) != null){
    				redisUtil.remove(id);
    			}
    			return ResponseUtil.RetCorrectInfo("{id:'"+instPackage.getId()+"'}");
    		}else{
    			return ResponseUtil.RetErrorInfo("already disable!");
    		}
		} catch (Exception e) {
			logger.error("调用删除禁用信息接口,异常：失败(error)--->：" + e.getCause().getMessage(),e);
    		return ResponseUtil.RetErrorInfo(e.getCause().getMessage());
		}
    }
    
    
    
}
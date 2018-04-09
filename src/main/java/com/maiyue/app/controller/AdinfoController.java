package com.maiyue.app.controller;

import com.maiyue.app.bean.Adinfo;
import com.maiyue.app.bean.ModResources;
import com.maiyue.app.constant.BusinessConstant;
import com.maiyue.app.constant.Constant;
import com.maiyue.app.service.AdinfoService;
import com.maiyue.app.service.ModResourcesService;
import com.maiyue.app.utils.ComUtil;
import com.maiyue.app.utils.RedisUtil;
import com.maiyue.app.utils.ReflectUtil;
import com.maiyue.app.utils.ResponseUtil;
import com.maiyue.app.utils.jsonUtil.JSONUtils;
import com.github.pagehelper.PageInfo;

import java.text.SimpleDateFormat;
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
 * AdinfoController
 * 2018/03/29
 */
@RestController
@EnableAutoConfiguration
@RequestMapping(value="/adinfo/*")
public class AdinfoController extends BaseController {
   
	
	@Resource(name = "adinfoService")
    private AdinfoService adinfoService;
	
	@Resource(name = "modResourcesService")
    private ModResourcesService modResourcesService;

	@Autowired
	private ShareCheck shareCheck;
	
	@Resource(name = "redisUtil")
	private RedisUtil redisUtil;
	
	private static Logger logger = Logger.getLogger(AdinfoController.class);
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	
	
	/***
	 * 分页查询
	 * @param ids
	 * @param Adinfo
	 * @return
	 */
    @RequestMapping(value="getPage",method= RequestMethod.POST)
    public ModelMap getPage(@RequestParam(value ="ids[]",required=false) String[] ids, Adinfo Adinfo) {
    	try {
   		 	logger.error("调用广告信息分页查询接口:--->/adinfo/getPage");
   		 	Map<String,Object> params = ReflectUtil.beanToMap(Adinfo, true);
   		 	params.put(BusinessConstant.IN_SELECT_IDS,ids);//in查询
   	     	PageInfo<Adinfo> data = adinfoService.getPageData(params);
    		 return ResponseUtil.RetCorrectInfo(JSONUtils.toMapJSONObject(data));
		} catch (Exception e) {
			logger.error("调用广告信息分页查询接口,异常:--->" + e.getCause().getMessage(),e);
			return ResponseUtil.RetErrorInfo(e.getCause().getMessage());
		}
    }

    
    
    
    
    /***
	 * 模块-广告管联关系分页查询
	 * @param ids
	 * @param Adinfo
	 * @return
	 */
    @RequestMapping(value="getResourcesPage",method= RequestMethod.POST)
    public ModelMap getResourcesPage(@RequestParam(value ="ids[]",required=false) String[] ids, ModResources resources) {
    	try {
   		 	logger.error("调用模块广告资源分页查询接口！");
   		 	Map<String,Object> params = ReflectUtil.beanToMap(resources, true);
   		 	params.put(BusinessConstant.IN_SELECT_IDS,ids);//in查询
   	     	PageInfo<ModResources> data = modResourcesService.getPageData(params);
    		 return ResponseUtil.RetCorrectInfo(JSONUtils.toMapJSONObject(data));
		} catch (Exception e) {
			logger.error("调用模块广告资源分页查询接口,异常:--->" + e.getCause().getMessage(),e);
			return ResponseUtil.RetErrorInfo(e.getCause().getMessage());
		}
    }
    
    
    /***
     * 新增模块-广告管联关系
     * @param adinfo
     * @param startTime
     * @param endTime
     * @return
     */
    @RequestMapping(value="newResources",method= RequestMethod.POST)
    public ModelMap newResources(@RequestParam(value="moduleId",required=false)String moduleId,
    		@RequestParam(value="adId",required=false)String adId) {
    	try {
    		if(getCurrUser() == null){
				return ResponseUtil.RetErrorInfo(" user object is null,please login first!");
			}else{
				if(StringUtils.isBlank(getCurrUser().getId())){
					return ResponseUtil.RetErrorInfo(" user object is null,please login first!");
				}
			}
    		if(StringUtils.isBlank(moduleId) || StringUtils.isBlank(adId)){
    			return ResponseUtil.RetErrorInfo(" moduleId or adId is null!");
    		}
    		if(!shareCheck.isEffective(moduleId, Constant.AD_MODULE)){
    			return ResponseUtil.RetErrorInfo(" moduleId is invalid!");
    		}
    		if(!shareCheck.isEffective(adId, Constant.AD_INFO)){
    			return ResponseUtil.RetErrorInfo(" adId is invalid!");
    		}
    		ModResources resources = new ModResources();
    		resources.setId(ComUtil.randomUUID());
    		resources.setModuleId(moduleId);
    		resources.setAdId(adId);
    		modResourcesService.insert(resources);
    		logger.debug("新增模块-广告管联关系，成功>");
    		return ResponseUtil.RetCorrectInfo("{'id':'"+resources.getId()+"'}");
		} catch (Exception e) {
			logger.error("新增模块-广告管联关系异常:" + e.getCause().getMessage(),e);
			return ResponseUtil.RetErrorInfo(e.getCause().getMessage());
		}
    }

    
    
    
    
    /***
     * 新增模块-广告管联关系
     * @param adinfo
     * @param startTime
     * @param endTime
     * @return
     */
    @RequestMapping(value="deleteResources",method= RequestMethod.POST)
    public ModelMap deleteResources(@RequestParam(value="id",required=false)String id) {
    	try {
    		if(getCurrUser() == null){
				return ResponseUtil.RetErrorInfo(" user object is null,please login first!");
			}else{
				if(StringUtils.isBlank(getCurrUser().getId())){
					return ResponseUtil.RetErrorInfo(" user object is null,please login first!");
				}
			}
    		if(StringUtils.isBlank(id)){
    			return ResponseUtil.RetErrorInfo(" id is null!");
    		}
    		ModResources resources = modResourcesService.selectById(id);
    		if(resources == null){
    			return ResponseUtil.RetErrorInfo(" id is invalid!");
    		}else{
    			modResourcesService.delete(id);
    		}
    		logger.debug("删除模块-广告管联关系，成功>");
    		return ResponseUtil.RetCorrectInfo("{'id':'"+resources.getId()+"'}");
		} catch (Exception e) {
			logger.error("删除模块-广告管联关系异常:" + e.getCause().getMessage(),e);
			return ResponseUtil.RetErrorInfo(e.getCause().getMessage());
		}
    }
    
    
    
    
    
    /***
     * 新增广告
     * @param adinfo
     * @param startTime
     * @param endTime
     * @return
     */
    @RequestMapping(value="newAd",method= RequestMethod.POST)
    public ModelMap newAd(Adinfo adinfo,
    		@RequestParam(value="startTime",required=false)String startTime,
    		@RequestParam(value="endTime",required=false)String endTime) {
       
    	try {
    		if(getCurrUser() == null){
				return ResponseUtil.RetErrorInfo(" user object is null,please login first!");
			}else{
				if(StringUtils.isBlank(getCurrUser().getId())){
					return ResponseUtil.RetErrorInfo(" user object is null,please login first!");
				}
			}
    		if(StringUtils.isBlank(adinfo.getAdHref())){
    			adinfo.setAdHref("#");
    		}
    		if(StringUtils.isBlank(startTime)){
    			adinfo.setAdsStartTime(new Date());
    		}else{
    			try {
    				Date stime = sdf.parse(startTime);
    				adinfo.setAdsStartTime(stime);
				} catch (Exception e) {
					adinfo.setAdsStartTime(new Date());
					logger.error("新增广告,开始时间格式转换异常:" + e.getCause().getMessage(),e);
				}
    		}
    		if(StringUtils.isBlank(endTime)){
    			adinfo.setAdsEndTime(new Date());
    		}else{
    			try {
    				Date etime = sdf.parse(endTime);
    				adinfo.setAdsEndTime(etime);
				} catch (Exception e) {
					adinfo.setAdsStartTime(new Date());
					logger.error("新增广告,结束时间格式转换异常:" + e.getCause().getMessage(),e);
				}
    		}
    		adinfo.setId(ComUtil.randomUUID());
    		adinfo.setUserId(getCurrUser().getId());
    		adinfoService.insert(adinfo);
    		logger.debug("新增广告，成功>");
    		return ResponseUtil.RetCorrectInfo("{'id':'"+adinfo.getId()+"'}");
		} catch (Exception e) {
			logger.error("新增广告异常:" + e.getCause().getMessage(),e);
			return ResponseUtil.RetErrorInfo(e.getCause().getMessage());
		}
    }

    
    

    /***
     * 编辑AD信息
     * @param adinfo
     * @param id
     * @param startTime
     * @param endTime
     * @return
     */
    @RequestMapping(value="editor",method= RequestMethod.POST)
    public ModelMap editor(Adinfo adinfo,@RequestParam(value="id",required=false)String id,
    		@RequestParam(value="startTime",required=false)String startTime,
    		@RequestParam(value="endTime",required=false)String endTime) {
    	
    	try {
    		if(StringUtils.isBlank(id)){
            	return ResponseUtil.RetErrorInfo(" id is null!");
            }
        	if(!shareCheck.isEffective(id,Constant.AD_INFO)){
    			return ResponseUtil.RetErrorInfo(" id is invalid!");
    		}
        	logger.debug("调用AD编辑接口!");
        	Adinfo  adinfo2 = adinfoService.selectById(id);
        	boolean flag = false;
        	if(StringUtils.isNotBlank(startTime)){
    			try {
    				Date stime = sdf.parse(startTime);
    				adinfo2.setAdsStartTime(stime);
				} catch (Exception e) {
					adinfo2.setAdsStartTime(new Date());
					logger.error("编辑广告,开始时间格式转换异常:" + e.getCause().getMessage(),e);
				}
    			flag = true;
    		}
    		if(StringUtils.isNotBlank(endTime)){
    			try {
    				Date etime = sdf.parse(endTime);
    				adinfo2.setAdsEndTime(etime);
				} catch (Exception e) {
					adinfo2.setAdsStartTime(new Date());
					logger.error("编辑广告,结束时间格式转换异常:" + e.getCause().getMessage(),e);
				}
    			flag = true;
    		}
        	if(StringUtils.isNotBlank(adinfo.getAdCategory())){
        		adinfo2.setAdCategory(adinfo.getAdCategory());
        		flag = true;
        	}
        	if(StringUtils.isNotBlank(adinfo.getAdContent())){
        		adinfo2.setAdContent(adinfo.getAdContent());
        		flag = true;
        	}
        	if(StringUtils.isNotBlank(adinfo.getAdHref())){
        		adinfo2.setAdHref(adinfo.getAdHref());
        		flag = true;
        	}
        	if(StringUtils.isNotBlank(adinfo.getAdType())){
        		adinfo2.setAdType(adinfo.getAdType());
        		flag = true;
        	}
        	if(flag){
        		adinfoService.update(adinfo2);
        	}
        	return ResponseUtil.RetCorrectInfo("{id:'"+adinfo2.getId()+"'}");
		} catch (Exception e) {
			logger.error("调用AD编辑接口,异常：" + e.getCause().getMessage(),e);
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
        	if(!shareCheck.isEffective(id, Constant.AD_INFO)){
    			return ResponseUtil.RetErrorInfo("this object is null or disable!");
    		}
        	logger.debug("调用Ad按ID查询接口,成功：--->/adinfo/findById?id=" + id);
        	Adinfo adinfo = adinfoService.selectById(id);
    		return ResponseUtil.RetCorrectInfo(JSONUtils.toJSONObject(adinfo));
		} catch (Exception e) {
    		logger.error("调用Ad评论按ID查询接口,异常:--->" + e.getCause().getMessage(),e);
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
        	if(shareCheck.isEffective(id,Constant.AD_INFO)){
        		logger.debug("调用AD禁用接口！");
    			Adinfo adinfo = adinfoService.selectById(id);
    			adinfo.setState(BusinessConstant.COMMON_STATE_JUST);
    			adinfoService.update(adinfo);
    			redisUtil.remove(id);
    			return ResponseUtil.RetCorrectInfo("{id:'"+adinfo.getId()+"'}");
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
        	if(!shareCheck.isEffective(id,Constant.AD_INFO)){
        		logger.debug("调用AD启用用接口！");
    			Adinfo adinfo = adinfoService.selectById(id);
    			if(adinfo != null){
    				if(adinfo.getState().equals(BusinessConstant.COMMON_STATE_JUST)){
    					adinfo.setState(BusinessConstant.COMMON_STATE_STAY);
    					adinfoService.update(adinfo);
    					redisUtil.remove(id);
    					return ResponseUtil.RetCorrectInfo("{'id':'" +id+ "'}");
    				}
    			}
    			return ResponseUtil.RetErrorInfo("object is null!");
    		}else{
				return ResponseUtil.RetErrorInfo("this Object is enable!");
    		}
		} catch (Exception e) {
			logger.error("调用AD启用接口,异常：" + e.getCause().getMessage(),e);
			return ResponseUtil.RetErrorInfo(e.getCause().getMessage());
		}
    }
    
    
}
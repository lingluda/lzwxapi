package com.maiyue.app.controller;

import com.maiyue.app.bean.Admodule;
import com.maiyue.app.constant.BusinessConstant;
import com.maiyue.app.constant.Constant;
import com.maiyue.app.service.AdmoduleService;
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
 * AdmoduleController
 * 2018/03/29
 */
@RestController
@EnableAutoConfiguration
@RequestMapping(value="/admodule/*")
public class AdmoduleController extends BaseController {
    
	
	@Resource(name = "admoduleService")
    private AdmoduleService admoduleService;
	
	@Autowired
	private ShareCheck shareCheck;
	
	@Resource(name = "redisUtil")
	private RedisUtil redisUtil;
	
	private static Logger logger = Logger.getLogger(AdmoduleController.class);
	

	
	/***
	 * 广告模块分页查询
	 * @param ids
	 * @param Admodule
	 * @return
	 */
    @RequestMapping(value="getPage",method= RequestMethod.POST)
    public ModelMap list(@RequestParam(value ="ids[]",required=false) String[] ids, Admodule Admodule) {
    	try {
   		 	logger.error("调用广告模块分页查询接口:--->/admodule/getPage");
   		 	Map<String,Object> params = ReflectUtil.beanToMap(Admodule, true);
   		 	params.put(BusinessConstant.IN_SELECT_IDS,ids);//in查询
   	     	PageInfo<Admodule> data = admoduleService.getPageData(params);
    		 return ResponseUtil.RetCorrectInfo(JSONUtils.toMapJSONObject(data));
		} catch (Exception e) {
			logger.error("调用广告模块分页查询接口,异常:--->" + e.getCause().getMessage(),e);
			return ResponseUtil.RetErrorInfo(e.getCause().getMessage());
		}
    }

    
    
    

    /**
     * 保存新增的数据,POST方法
     * @param request
     * @param response
     * @param Admodule 实体
     */
    @RequestMapping(value="newAdmodule",method= RequestMethod.POST)
    public ModelMap newAdmodule(@RequestParam(value="moduleName",required=false)String moduleName,
    		@RequestParam(value="position",required=false)String position,
    		@RequestParam(value="address",required=false)String address) {
    	try {
    		if(getCurrUser() == null){
				return ResponseUtil.RetErrorInfo(" user object is null,please login first!");
			}else{
				if(StringUtils.isBlank(getCurrUser().getId())){
					return ResponseUtil.RetErrorInfo(" user object is null,please login first!");
				}
			}
    		if(StringUtils.isBlank(moduleName)){
    			return ResponseUtil.RetErrorInfo("moduleName is null !");
    		}
    		
    		Admodule module = new Admodule();
    		module.setId(ComUtil.randomUUID());
    		module.setUserId(getCurrUser().getId());
    		module.setModuleName(moduleName);
    		module.setModulePosition(position==null?"顶部":position);
    		module.setModuleAddress(address==null?"未知":address);
    		module.setCreateTime(new Date());
    		module.setState(BusinessConstant.COMMON_STATE_STAY);
    		admoduleService.insert(module);
    		logger.debug("新增广告模块，成功>");
    		return ResponseUtil.RetCorrectInfo("{'id':'"+module.getId()+"'}");
		} catch (Exception e) {
			logger.error("新增广告模块异常:" + e.getCause().getMessage(),e);
			return ResponseUtil.RetErrorInfo(e.getCause().getMessage());
		}
    }

    
    

    /**
     * 保存编辑的数据,POST方法
     * @param request
     * @param response
     * @param Admodule 实体
     */
    @RequestMapping(value="editor",method= RequestMethod.POST)
    public ModelMap editor(@RequestParam(value="id",required=false)String id,
    		@RequestParam(value="moduleName",required=false)String moduleName,
    		@RequestParam(value="position",required=false)String position,
    		@RequestParam(value="address",required=false)String address) {
    	try {
    		if(StringUtils.isBlank(id)){
            	return ResponseUtil.RetErrorInfo(" id is null!");
            }
        	if(!shareCheck.isEffective(id,Constant.AD_MODULE)){
    			return ResponseUtil.RetErrorInfo(" id is invalid!");
    		}
    		Admodule module = admoduleService.selectById(id);
    		boolean flag = false;
    		if(StringUtils.isNotBlank(moduleName)){
    			module.setModuleName(moduleName);
    			flag = true;
    		}
    		if(StringUtils.isNotBlank(position)){
    			module.setModulePosition(position);
    			flag = true;
    		}
    		if(StringUtils.isNotBlank(address)){
    			module.setModuleAddress(address);
    			flag = true;
    		}
    		if(flag){
    			admoduleService.update(module);
    		}
    		logger.debug("调用AD模块编辑接口!");
    		return ResponseUtil.RetCorrectInfo("{id:'"+module.getId()+"'}");
		} catch (Exception e) {
			logger.error("调用AD模块编辑接口,异常：" + e.getCause().getMessage(),e);
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
        	if(!shareCheck.isEffective(id, Constant.AD_MODULE)){
    			return ResponseUtil.RetErrorInfo("this object is null or disable!");
    		}
        	logger.debug("调用Ad模块按ID查询接口,成功：--->/admodule/findById?id=" + id);
        	Admodule module = admoduleService.selectById(id);
    		return ResponseUtil.RetCorrectInfo(JSONUtils.toJSONObject(module));
		} catch (Exception e) {
    		logger.error("调用Ad模块评论按ID查询接口,异常:--->" + e.getCause().getMessage(),e);
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
        	if(shareCheck.isEffective(id,Constant.AD_MODULE)){
        		logger.debug("调用AD模块禁用接口！");
    			Admodule admodule = admoduleService.selectById(id);
    			admodule.setState(BusinessConstant.COMMON_STATE_JUST);
    			admoduleService.update(admodule);
    			redisUtil.remove(id);
    			return ResponseUtil.RetCorrectInfo("{id:'"+admodule.getId()+"'}");
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
        	if(!shareCheck.isEffective(id,Constant.AD_MODULE)){
        		logger.debug("调用AD模块启用用接口！");
    			Admodule admodule = admoduleService.selectById(id);
    			if(admodule != null){
    				if(admodule.getState().equals(BusinessConstant.COMMON_STATE_JUST)){
    					admodule.setState(BusinessConstant.COMMON_STATE_STAY);
    					admoduleService.update(admodule);
    					redisUtil.remove(id);
    					return ResponseUtil.RetCorrectInfo("{'id':'" +id+ "'}");
    				}
    			}
    			return ResponseUtil.RetErrorInfo("object is null!");
    		}else{
				return ResponseUtil.RetErrorInfo("this Object is enable!");
    		}
		} catch (Exception e) {
			logger.error("调用AD模块启用接口,异常：" + e.getCause().getMessage(),e);
			return ResponseUtil.RetErrorInfo(e.getCause().getMessage());
		}
    }
    
    
}
package com.maiyue.app.controller;

import com.github.pagehelper.PageInfo;
import com.maiyue.app.bean.AppCategory;
import com.maiyue.app.constant.BusinessConstant;
import com.maiyue.app.service.AppCategoryService;
import com.maiyue.app.utils.ComUtil;
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
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * AppCategoryController
 * 2018/03/29
 */
@RestController
@EnableAutoConfiguration
@RequestMapping(value="/category/*")
public class AppCategoryController extends BaseController {
	
	
	@Resource(name = "appCategoryService")
    private AppCategoryService appCategoryService;

	
	private static Logger logger = Logger.getLogger(AppCategoryController.class);
	
    /***
     * 分页查询
     * @param order
     * @param sort
     * @param pageNum
     * @param pageSize
     * @param appCategory
     * @return
     */
    @RequestMapping(value="getPage",method= RequestMethod.POST)
    public ModelMap getPage(AppCategory appCategory,@RequestParam(value="ids[]",required = false) String[] ids){
    	try {
    		 logger.error("调用App类别分页查询接口:--->/category/getPage");
    		 Map<String,Object> params = ReflectUtil.beanToMap(appCategory, true);
    		 params.put(BusinessConstant.IN_SELECT_IDS,ids);//in查询
    	     PageInfo<AppCategory> data = appCategoryService.getPageData(params);
     		 return ResponseUtil.RetCorrectInfo(JSONUtils.toMapJSONObject(data));
		} catch (Exception e) {
    		logger.error("调用App类别分页查询接口,异常:--->" + e.getCause().getMessage(),e);
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
    		logger.debug("调用App按类别ID查询接口！");
        	if(StringUtils.isBlank(id)){
        		return ResponseUtil.RetErrorInfo("id is null!");
        	}
        	AppCategory category = appCategoryService.selectById(id);
        	if(category == null){
        		return ResponseUtil.RetErrorInfo("Category Object is null!");
        	}
    		logger.debug("调用App按类别ID查询接口,成功：--->/category/findById?id=" + id);
    		return ResponseUtil.RetCorrectInfo(JSONUtils.toJSONObject(category));
		} catch (Exception e) {
    		logger.error("调用App按类别ID查询接口,异常:--->" + e.getCause().getMessage(),e);
    		return ResponseUtil.RetErrorInfo(e.getCause().getMessage());
		}
    }

    /***
     * 新增APP类别
     * @param categoryName
     * @param details
     * @param state
     * @return
     */
    @PostMapping(value="newCategory")
    public ModelMap newCategory(@RequestParam(value="categoryName",required=false)String categoryName,
    		@RequestParam(value="details",required=false)String details,
    		@RequestParam(value="state",required=false,defaultValue="0")String state){
    	try {
    		logger.debug("调用新增App类别接口！");
        	if(StringUtils.isBlank(categoryName) || StringUtils.isBlank(details) ){
        		return ResponseUtil.RetErrorInfo("categoryName or details is null!");
        	}
        	AppCategory category = new AppCategory();
        	category.setId(ComUtil.randomUUID());//ID
        	category.setName(categoryName);
        	category.setDetails(details);
        	category.setCreateTime(new Date());
        	category.setAppNum(BigDecimal.ZERO);
        	category.setPendingNum(BigDecimal.ZERO);
        	category.setReviewNopassNum(BigDecimal.ZERO);
        	category.setReviewPassNum(BigDecimal.ZERO);
        	category.setShelfOffNum(BigDecimal.ZERO);
        	category.setState(state);
        	appCategoryService.insert(category);
        	logger.debug("调用新增App类别接口,成功:--->result:id=" + category.getId());
    		return ResponseUtil.RetCorrectInfo("{id:'"+category.getId()+"'}");
		} catch (Exception e) {
			logger.error("调用新增App类别接口,异常:--->" + e.getCause().getMessage(),e);
    		return ResponseUtil.RetErrorInfo(e.getCause().getMessage());
		}
    }

    /***
     * 类别编辑器
     * @param id
     * @param categoryName
     * @param details
     * @return
     */
    @PostMapping(value="editor")
    public ModelMap editor(@RequestParam(value ="id",required=false) String id,
    		@RequestParam(value ="categoryName",required=false) String categoryName,
    		@RequestParam(value ="details",required=false) String details){
    	try {
    		logger.debug("调用App类别编辑器!");
    		if(StringUtils.isBlank(id)){
        		return ResponseUtil.RetErrorInfo("id is null!");
    		}
    		AppCategory appCategory = appCategoryService.selectById(id);
    		if(appCategory == null){
        		return ResponseUtil.RetErrorInfo("Category Object is null or delete!");
    		}
    		if(BusinessConstant.COMMON_STATE_JUST.equals(appCategory.getState())){
        		return ResponseUtil.RetErrorInfo("Category Object is delete!");
    		}
    		if(StringUtils.isNotBlank(categoryName)){
    			appCategory.setName(categoryName);
    		}
    		if(StringUtils.isNotBlank(details)){
    			appCategory.setDetails(details);
    		}
    		if(StringUtils.isNotBlank(categoryName) || StringUtils.isNotBlank(details)){
    			appCategoryService.update(appCategory);
    		}
    		logger.debug("调用App类别编辑器,成功：--->result:id=" + id);
    		return ResponseUtil.RetCorrectInfo("{id:'"+id+"'}");
		} catch (Exception e) {
    		logger.error("调用App类别编辑器,异常：--->" +  e.getCause().getMessage(),e);
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
    		logger.debug("调用App类别更新状态方法 !/category/enable?id=" + id);
    		if(StringUtils.isBlank(id)){
        		return ResponseUtil.RetErrorInfo("id or state is null!");
    		}
    		AppCategory appCategory = appCategoryService.selectById(id);
    		if(appCategory == null){
        		return ResponseUtil.RetErrorInfo("Category Object is null or delete!");
    		}
    		if(BusinessConstant.COMMON_STATE_JUST.equals(appCategory.getState())){
    			appCategory.setState(BusinessConstant.COMMON_STATE_STAY);
    			appCategoryService.update(appCategory);
    			logger.debug("调用App类别编辑器 ,操作：成功(success)--->/category/enable?id=" + id + "");
    			return ResponseUtil.RetCorrectInfo("{id:'"+id+"'}");
    		}else{
        		return ResponseUtil.RetErrorInfo("Category Object is enable!");
    		}
		} catch (Exception e) {
    		logger.error("调用App类别编辑器,异常：(Exception)--->" +  e.getCause().getMessage(),e);
    		return ResponseUtil.RetErrorInfo(e.getCause().getMessage());
		}
    }
    
    
    /**
     * 根据ID删除数据
     * @param request
     * @param response
     * @param id
     */
    @RequestMapping(value="disable")
    public ModelMap disable(@RequestParam(value ="id",required=false) String id) {
        try {
    		logger.debug("调用禁用App类别接口！");
        	if(StringUtils.isBlank(id)){
        		return ResponseUtil.RetErrorInfo("id is null!");
        	}
        	AppCategory category = appCategoryService.selectById(id);
        	if(category == null){
        		return ResponseUtil.RetErrorInfo("category object is null!");
        	}else{
        		if(BusinessConstant.COMMON_STATE_STAY.equals(category.getState())){
        			if(category.getAppNum().compareTo(BigDecimal.ZERO) == 0 && 
	        		   category.getPendingNum().compareTo(BigDecimal.ZERO) == 0 &&
	        		   category.getReviewNopassNum().compareTo(BigDecimal.ZERO) == 0 &&
	        		   category.getReviewPassNum().compareTo(BigDecimal.ZERO) == 0 &&
	        		   category.getShelfOffNum().compareTo(BigDecimal.ZERO) == 0){
	        		   category.setState(BusinessConstant.COMMON_STATE_JUST);
	        		   appCategoryService.update(category);
	           		   logger.debug("调用禁用App类别接口！操作：成功(success)--->/category/delete?id = " + id);
	           		   return ResponseUtil.RetCorrectInfo("{id:'"+id+"',state:'-1'}");
	        		}else{
	            	   return ResponseUtil.RetErrorInfo("existence of associated data,Ineffective operation!");
	        		}
        		}else{
        			return ResponseUtil.RetErrorInfo("category object is disable!");
        		}
        	}
		} catch (Exception e) {
			logger.error("调用删除App类别接口,异常：失败(error)--->：" + e.getCause().getMessage(),e);
    		return ResponseUtil.RetErrorInfo(e.getCause().getMessage());
		}
    }
    
    
    
    
    
}
package com.maiyue.app.controller;

import com.github.pagehelper.PageInfo;
import com.maiyue.app.bean.AppReview;
import com.maiyue.app.constant.BusinessConstant;
import com.maiyue.app.constant.Constant;
import com.maiyue.app.service.AppReviewService;
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
 * AppReviewController
 * 2018/03/29
 */
@RestController
@EnableAutoConfiguration
@RequestMapping(value="/review/*")
public class AppReviewController extends BaseController {
    
	
	@Resource(name = "appReviewService")
    private AppReviewService appReviewService;
	
	@Autowired
	private ShareCheck shareCheck;
	
	@Resource(name = "redisUtil")
	private RedisUtil redisUtil;
	
	private static Logger logger = Logger.getLogger(AppReviewController.class);
	
    /***
     * 分页查询
     * @param ids
     * @param appReview
     * @return
     */
    @RequestMapping(value="getPage",method= RequestMethod.POST)
    public ModelMap getPage(@RequestParam(value ="ids[]",required=false) String[] ids,AppReview appReview) {
    	try {
       	 logger.debug("调用应用评论分页查询方法！");
       	 Map<String,Object> params = ReflectUtil.beanToMap(appReview,true);
       	 params.put(BusinessConstant.IN_SELECT_IDS,ids);//in查询
   	     PageInfo<AppReview> data = appReviewService.getPageData(params);
   	     return ResponseUtil.RetCorrectInfo(JSONUtils.toMapJSONObject(data));
		} catch (Exception e) {
			logger.error("调用应用评论分页查询方法,异常：" + e.getCause().getMessage(),e);
			return ResponseUtil.RetErrorInfo(e.getCause().getMessage());
		}
    }

    /**
     * 保存新增的数据,POST方法
     * @param request
     * @param response
     * @param appReview 实体
     */
    @RequestMapping(value="newReview",method= RequestMethod.POST)
    public ModelMap newReview(@RequestParam(value ="appId",required=false) String appId,
    	   @RequestParam(value ="content",required=false) String content,
    	   @RequestParam(value ="audit",required=false,defaultValue=BusinessConstant.AUDIT_RESULT_PASS) String audit) {
    	try {
    		if(getCurrUser() == null){
				return ResponseUtil.RetErrorInfo(" user object is null,please login first!");
			}else{
				if(StringUtils.isBlank(getCurrUser().getId())){
					return ResponseUtil.RetErrorInfo(" user object is null,please login first!");
				}
			}
    		if(StringUtils.isBlank(appId) || StringUtils.isBlank(content)){
    			return ResponseUtil.RetErrorInfo(" appId or content is null!");
    		}
    		if(!shareCheck.isEffective(appId,Constant.APP_INFO_ID)){
    			return ResponseUtil.RetErrorInfo(" appId is invalid!");
    		}
    		AppReview appReview = new AppReview();
    		appReview.setId(ComUtil.randomUUID());
    		appReview.setAppInfoId(appId);
    		appReview.setState(BusinessConstant.COMMON_STATE_STAY);
    		appReview.setCreateTime(new Date());
    		appReview.setUserId(getCurrUser().getId());
    		appReview.setReviewContent(content);
    		appReview.setAuditResult(audit);//免审核
    		appReviewService.insert(appReview);
    		logger.debug("调用应用评论接口：成功。");
    		return ResponseUtil.RetCorrectInfo("{'id':'"+appReview.getId()+"','appId':'"+appId+"'}");
		} catch (Exception e) {
			logger.error("调用应用评论接口,异常：" + e.getCause().getMessage(),e);
			return ResponseUtil.RetErrorInfo(e.getCause().getMessage());
		}
    }


    /***
     * 保存编辑的数据,POST方法
     * @param id
     * @param appId
     * @param content
     * @return
     */
    @RequestMapping(value="editor",method= RequestMethod.POST)
    public ModelMap editor(@RequestParam(value="id",required=false)String id,
    		@RequestParam(value="appId",required=false)String appId,
    		@RequestParam(value="content",required=false)String content) {
    	try {
    		if(StringUtils.isBlank(id) || StringUtils.isBlank(appId)){
            	return ResponseUtil.RetErrorInfo(" id or appId is null!");
            }
        	if(!shareCheck.isEffective(id,Constant.APP_REWIEW_ID)){
    			return ResponseUtil.RetErrorInfo(" id is invalid!");
    		}
        	if(!shareCheck.isEffective(appId,Constant.APP_INFO_ID)){
				return ResponseUtil.RetErrorInfo(" appinfo is invalid!");
			}
        	logger.debug("调用应用评论编辑接口!");
        	AppReview  appReview = appReviewService.selectById(id);
        	if(StringUtils.isNotBlank(content) && !appReview.getReviewContent().equals(content)){
        		appReview.setReviewContent(content);
        		appReviewService.update(appReview);
        	}
        	return ResponseUtil.RetCorrectInfo("{id:'"+appReview.getId()+"',appId:'"+appReview.getAppInfoId()+"'}");
		} catch (Exception e) {
			logger.error("调用应用评论编辑接口,异常：" + e.getCause().getMessage(),e);
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
        	logger.debug("调用App评论按ID查询接口,成功：--->/review/findById?id=" + id);
        	AppReview appReview = appReviewService.selectById(id);
    		return ResponseUtil.RetCorrectInfo(JSONUtils.toJSONObject(appReview));
		} catch (Exception e) {
    		logger.error("调用App评论按ID查询接口,异常:--->" + e.getCause().getMessage(),e);
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
    		logger.debug("调用App评论审核方法 !/review/audit?id=" + id);
    		if(StringUtils.isBlank(id) || StringUtils.isBlank(audit)){
        		return ResponseUtil.RetErrorInfo("id or audit is null!");
    		}
    		if(!BusinessConstant.AUDIT_RESULT_JUST.equals(audit) && !BusinessConstant.AUDIT_RESULT_PASS.equals(audit) &&
    			!BusinessConstant.AUDIT_RESULT_STAY.equals(audit)){
    	         return ResponseUtil.RetErrorInfo("audit numerical types unlawful!");
    	    }
    		if(!shareCheck.isEffective(id,Constant.APP_REWIEW_ID)){
    			return ResponseUtil.RetErrorInfo("this id is invalid or disable!");
    		}
    		AppReview appReview = appReviewService.selectById(id);
    		if(appReview.getAuditResult().equals(audit)){
			  return ResponseUtil.RetErrorInfo("The state has already audited!");
			}
    		appReview.setAuditResult(audit);
    		appReviewService.update(appReview);
			logger.debug("调用App评论审核方法 ,操作：成功(success)--->/review/audit?id=" + id + "");
			return ResponseUtil.RetCorrectInfo("{id:'"+id+"'}");
		} catch (Exception e) {
    		logger.error("调用App评论审核方法,异常：(Exception)--->" +  e.getCause().getMessage(),e);
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
        	if(shareCheck.isEffective(id,Constant.APP_REWIEW_ID)){
        		logger.debug("调用应用评论禁用接口！");
    			AppReview appReview = appReviewService.selectById(id);
    			appReview.setState(BusinessConstant.COMMON_STATE_JUST);
    			appReviewService.update(appReview);
    			redisUtil.remove(id);
    			return ResponseUtil.RetCorrectInfo("{id:'"+appReview.getId()+"'}");
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
        	if(!shareCheck.isEffective(id,Constant.APP_REWIEW_ID)){
        		logger.debug("调用应用评分启用用接口！");
    			AppReview appReview = appReviewService.selectById(id);
    			if(appReview != null){
    				if(appReview.getState().equals(BusinessConstant.COMMON_STATE_JUST)){
    					appReview.setState(BusinessConstant.COMMON_STATE_STAY);
    					appReviewService.update(appReview);
    					redisUtil.remove(id);
    					return ResponseUtil.RetCorrectInfo("{'id':'" +id+ "','appId':'"+appReview.getAppInfoId()+"'}");
    				}
    			}
    			return ResponseUtil.RetErrorInfo("object is null!");
    		}else{
				return ResponseUtil.RetErrorInfo("this Object is enable!");
    		}
		} catch (Exception e) {
			logger.error("调用应用评分起用接口,异常：" + e.getCause().getMessage(),e);
			return ResponseUtil.RetErrorInfo(e.getCause().getMessage());
		}
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
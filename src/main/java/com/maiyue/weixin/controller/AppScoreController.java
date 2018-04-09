package com.maiyue.app.controller;

import com.maiyue.app.bean.AppScore;
import com.maiyue.app.constant.BusinessConstant;
import com.maiyue.app.constant.Constant;
import com.maiyue.app.service.AppScoreService;
import com.github.pagehelper.PageInfo;
import com.maiyue.app.utils.ComUtil;
import com.maiyue.app.utils.RedisUtil;
import com.maiyue.app.utils.ReflectUtil;
import com.maiyue.app.utils.ResponseUtil;
import com.maiyue.app.utils.jsonUtil.JSONUtils;
import java.util.Date;
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
 * AppScoreController
 * 2018/03/29
 */
@RestController
@EnableAutoConfiguration
@RequestMapping(value="/score/*")
public class AppScoreController extends BaseController {
    
	
	@Resource(name = "appScoreService")
    private AppScoreService appScoreService;

	@Resource(name = "redisUtil")
    private RedisUtil redisUtil;
	
	@Autowired
	private ShareCheck shareCheck;
	
	private static Logger logger = Logger.getLogger(AppScoreController.class);
	
	
    /***
     * 分页查询
     * @param score
     * @param ids
     * @return
     */
    @RequestMapping(value="getPage",method=RequestMethod.POST)
    public ModelMap getPage(AppScore score,@RequestParam(value ="ids[]",required=false) String[] ids) {
        try {
        	 logger.debug("调用应用评分分页查询方法！");
        	 Map<String,Object> params = ReflectUtil.beanToMap(score,true);
        	 params.put(BusinessConstant.IN_SELECT_IDS,ids);//in查询
    	     PageInfo<AppScore> data = appScoreService.getPageData(params);
    	     return ResponseUtil.RetCorrectInfo(JSONUtils.toMapJSONObject(data));
		} catch (Exception e) {
			logger.error("调用应用评分分页查询方法,异常：" + e.getCause().getMessage(),e);
			return ResponseUtil.RetErrorInfo(e.getCause().getMessage());
		}
    }

    /***
     * 新增应用评分
     * @param appId
     * @param score
     * @param state
     * @return
     */
    @RequestMapping(value="addScore",method= RequestMethod.POST)
    public ModelMap addScore(@RequestParam(value ="appId",required=false) String appId,@RequestParam(value ="score",required=false) String score,
    		@RequestParam(value ="state",required=false,defaultValue="0") String state){
    	try {
    		if(getCurrUser() == null){
				return ResponseUtil.RetErrorInfo(" user object is null,please login first!");
			}else{
				if(StringUtils.isBlank(getCurrUser().getId())){
					return ResponseUtil.RetErrorInfo(" user object is null,please login first!");
				}
			}
			if(StringUtils.isBlank(appId) || StringUtils.isBlank(score)){
				return ResponseUtil.RetErrorInfo(" appId or score is null!");
			}
			if(!shareCheck.isEffective(appId,Constant.APP_INFO_ID)){
				return ResponseUtil.RetErrorInfo(" appId is invalid!");
			}
    		AppScore appScore = new AppScore();
    		appScore.setId(ComUtil.randomUUID());
    		appScore.setUserId(getCurrUser().getId());
    		appScore.setAppInfoId(appId);
    		appScore.setAppScoreInfo(score);
    		appScore.setState(state);
    		appScore.setCreateTime(new Date());
    		appScoreService.insert(appScore);
    		logger.debug("调用新增应用评分成功！");
    		return ResponseUtil.RetCorrectInfo("{id:'"+appScore.getId()+"',appId:'"+appScore.getAppInfoId()+"'}");
		} catch (Exception e) {
			logger.error("调用新增应用评分,异常：" + e.getCause().getMessage(), e);
			return ResponseUtil.RetErrorInfo(e.getCause().getMessage());
		}
    }

    /***
     * 保存编辑的数据,POST方法
     * @param id
     * @param score
     * @return
     */
    @RequestMapping(value="editor",method= RequestMethod.POST)
    public ModelMap editor(@RequestParam(value ="id",required=false) String id,@RequestParam(value ="score",required=false) String score) {
    	try {
    		if(StringUtils.isBlank(id) || StringUtils.isBlank(score)){
            	return ResponseUtil.RetErrorInfo(" id or score is null!");
            }
        	if(!shareCheck.isEffective(id,Constant.APP_SCORE_ID)){
    			return ResponseUtil.RetErrorInfo(" id is invalid!");
    		}
        	logger.debug("调用应用评分编辑接口!");
        	AppScore appScore = appScoreService.selectById(id);
        	if(StringUtils.isNotBlank(appScore.getAppInfoId())){
        		if(!shareCheck.isEffective(appScore.getAppInfoId(),Constant.APP_INFO_ID)){
    				return ResponseUtil.RetErrorInfo(" appinfo is invalid!");
    			}
        	}
        	appScore.setAppScoreInfo(score);
        	appScoreService.update(appScore);
        	return ResponseUtil.RetCorrectInfo("{id:'"+appScore.getId()+"',appId:'"+appScore.getAppInfoId()+"'}");
		} catch (Exception e) {
			logger.error("调用应用评分编辑接口,异常：" + e.getCause().getMessage(),e);
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
        	if(shareCheck.isEffective(id,Constant.APP_SCORE_ID)){
        		logger.debug("调用应用评分禁用接口！");
    			AppScore appScore = appScoreService.selectById(id);
    			appScore.setState(BusinessConstant.COMMON_STATE_JUST);
    			appScoreService.update(appScore);
    			redisUtil.remove(id);
    			return ResponseUtil.RetCorrectInfo("{id:'"+appScore.getId()+"'}");
    		}else{
    			return ResponseUtil.RetErrorInfo("already disable!");
    		}
		} catch (Exception e) {
			logger.error("调用应用评分禁用接口,异常：" + e.getCause().getMessage(),e);
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
        	if(!shareCheck.isEffective(id,Constant.APP_SCORE_ID)){
        		logger.debug("调用应用评分启用用接口！");
    			AppScore appScore = appScoreService.selectById(id);
    			if(appScore != null){
    				if(appScore.getState().equals(BusinessConstant.COMMON_STATE_JUST)){
    					appScore.setState(BusinessConstant.COMMON_STATE_STAY);
    					appScoreService.update(appScore);
    					redisUtil.remove(id);
    					return ResponseUtil.RetCorrectInfo("{'id':'" +id+ "','appId':'"+appScore.getAppInfoId()+"'}");
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
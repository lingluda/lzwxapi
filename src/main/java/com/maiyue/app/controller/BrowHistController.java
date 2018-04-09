package com.maiyue.app.controller;

import com.github.pagehelper.PageInfo;
import com.maiyue.app.bean.BrowHist;
import com.maiyue.app.constant.BusinessConstant;
import com.maiyue.app.constant.Constant;
import com.maiyue.app.service.BrowHistService;
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
 * BrowHistController
 * 2018/03/29
 */
@RestController
@EnableAutoConfiguration
@RequestMapping(value="/browhist/*")
public class BrowHistController extends BaseController {
    
	
	@Resource(name = "browHistService")
    private BrowHistService browHistService;
	
	@Resource(name = "redisUtil")
	private RedisUtil redisUtil;

	@Autowired
	private ShareCheck shareCheck;
	
	
	private static Logger logger = Logger.getLogger(BrowHistController.class);

	
	
	/***
	 * 分页查询
	 * @param ids
	 * @param browHist
	 * @return
	 */
    @RequestMapping(value="getPage",method= RequestMethod.POST)
    public ModelMap getPage(@RequestParam(value ="ids[]",required=false) String[] ids,BrowHist browHist) {
    	try {
       	 logger.debug("调用应用浏览历史分页查询方法！");
       	 Map<String,Object> params = ReflectUtil.beanToMap(browHist,true);
       	 params.put(BusinessConstant.IN_SELECT_IDS,ids);//in查询
   	     PageInfo<BrowHist> data = browHistService.getPageData(params);
   	     return ResponseUtil.RetCorrectInfo(JSONUtils.toMapJSONObject(data));
		} catch (Exception e) {
			logger.error("调用应用浏览历史分页查询方法,异常：" + e.getCause().getMessage(),e);
			return ResponseUtil.RetErrorInfo(e.getCause().getMessage());
		}
    }

    
    /***
     * 保存新增的数据,POST方法
     * @param appId
     * @return
     */
    @RequestMapping(value="newBrowHist",method= RequestMethod.POST)
    public ModelMap newBrowHist(@RequestParam(value ="appId",required=false) String appId) {
        try {
        	if(getCurrUser() == null){
				return ResponseUtil.RetErrorInfo(" user object is null,please login first!");
			}else{
				if(StringUtils.isBlank(getCurrUser().getId())){
					return ResponseUtil.RetErrorInfo(" user object is null,please login first!");
				}
			}
        	if(StringUtils.isBlank(appId)){
            	return ResponseUtil.RetErrorInfo(" appId is null!");
            }
        	if(!shareCheck.isEffective(appId,Constant.APP_INFO_ID)){
    			return ResponseUtil.RetErrorInfo(" appId is invalid!");
    		}
        	logger.debug("调用新增浏览历史>");
        	BrowHist hist = new BrowHist();
        	hist.setId(ComUtil.randomUUID());
        	hist.setAppInfoId(appId);
        	hist.setBrowseTime(new Date());
        	hist.setState(BusinessConstant.COMMON_STATE_STAY);
        	hist.setUserId(getCurrUser().getId());
        	browHistService.insert(hist);
        	return ResponseUtil.RetCorrectInfo("{'id':'"+hist.getId()+"','appId':'"+appId+"'}");
		} catch (Exception e) {
			logger.error("调用新增APP浏览历史错误,异常：" + e.getCause().getMessage(),e);
			return ResponseUtil.RetErrorInfo(e.getCause().getMessage());
		}
    }

    
    /**
     * 根据ID删除数据,POST方法
     * @param request
     * @param response
     * @param id
     */
    @RequestMapping(value="delete",method= RequestMethod.POST)
    public ModelMap delete(@RequestParam(value ="id",required=false) String id) {
    	try {
        	if(StringUtils.isBlank(id)){
            	return ResponseUtil.RetErrorInfo(" id is null!");
            }
        	logger.debug("调用删除浏览历史>");
        	if(shareCheck.isEffective(id,Constant.APP_BROW_HIST)){
        		logger.debug("调用浏览历史禁用接口！");
    			BrowHist hist = browHistService.selectById(id);
    			hist.setState(BusinessConstant.COMMON_STATE_JUST);
    			browHistService.update(hist);
    			redisUtil.remove(id);
    			logger.debug("调用删除浏览历史>成功！");
    			return ResponseUtil.RetCorrectInfo("{id:'"+hist.getId()+"'}");
    		}else{
    			return ResponseUtil.RetErrorInfo("already disable!");
    		}
		} catch (Exception e) {
			logger.error("调用应用历史接口,异常：" + e.getCause().getMessage(),e);
			return ResponseUtil.RetErrorInfo(e.getCause().getMessage());
		}
    }
    
    
    
    
    
    
    
    
    
}
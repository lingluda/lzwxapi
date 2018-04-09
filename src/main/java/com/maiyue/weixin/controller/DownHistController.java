package com.maiyue.app.controller;

import com.github.pagehelper.PageInfo;
import com.maiyue.app.bean.DownHist;
import com.maiyue.app.constant.BusinessConstant;
import com.maiyue.app.constant.Constant;
import com.maiyue.app.service.AppInfoService;
import com.maiyue.app.service.DownHistService;
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
 * DownHistController
 * 2018/04/01
 */
@RestController
@RequestMapping("/downhist/*")
@EnableAutoConfiguration
public class DownHistController extends BaseController {
    
	@Resource(name = "downHistService")
    private DownHistService downHistService;

	@Resource(name = "appInfoService")
    private AppInfoService appInfoService;
	
	@Resource(name = "redisUtil")
	private RedisUtil redisUtil;

	@Autowired
	private ShareCheck shareCheck;
	
	private static Logger logger = Logger.getLogger(DownHistController.class);
	
	
    /***
     * 分页查询
     * @param ids
     * @param downHist
     * @return
     */
    @RequestMapping(value="getPage",method= RequestMethod.GET)
    public ModelMap getPage(@RequestParam(value ="ids[]",required=false) String[] ids,DownHist downHist) {
    	try {
          	 logger.debug("调用应用下载历史分页查询方法！>");
          	 Map<String,Object> params = ReflectUtil.beanToMap(downHist,true);
          	 params.put(BusinessConstant.IN_SELECT_IDS,ids);//in查询
      	     PageInfo<DownHist> data = downHistService.getPageData(params);
      	     return ResponseUtil.RetCorrectInfo(JSONUtils.toMapJSONObject(data));
   		} catch (Exception e) {
   			logger.error("调用应用下载历史分页查询方法,异常：" + e.getCause().getMessage(),e);
   			return ResponseUtil.RetErrorInfo(e.getCause().getMessage());
   		}
    }

   
    
    /***
     * 新增下载历史方法
     * @param appId
     * @param packageId
     * @return
     */
    @RequestMapping(value="newDownhist",method= RequestMethod.POST)
    public ModelMap addDownhist(@RequestParam(value="appId",required=false)String appId,@RequestParam(value="packageId",required=false)String packageId) {
    	try {
    		if(getCurrUser() == null){
				return ResponseUtil.RetErrorInfo(" user object is null,please login first!");
			}else{
				if(StringUtils.isBlank(getCurrUser().getId())){
					return ResponseUtil.RetErrorInfo(" user object is null,please login first!");
				}
			}
    		if(!shareCheck.isEffective(appId,Constant.APP_INFO_ID)){
    			return ResponseUtil.RetErrorInfo(" appId is invalid!");
    		}
    		if(!shareCheck.isEffective(packageId,Constant.APP_INSTALL_PACK)){
    			return ResponseUtil.RetErrorInfo(" packageId is invalid!");
    		}
    		logger.debug("调用新增应用下载历史方法！>");
    		DownHist hist = new DownHist();
        	hist.setId(ComUtil.randomUUID());
        	hist.setAppInfoId(appId);
        	hist.setAppInstalId(packageId);
        	hist.setDownTime(new Date());
        	hist.setState(BusinessConstant.COMMON_STATE_STAY);
        	hist.setUserId(getCurrUser().getId());
        	downHistService.insert(hist);
        	logger.debug("调用新增应用下载历史方法！>成功。");
        	return ResponseUtil.RetCorrectInfo("{'id':'"+hist.getId()+"','appId':'"+appId+"'}");
		} catch (Exception e) {
			logger.error("调用新增应用下载历史方法,异常：" + e.getCause().getMessage(), e);
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
        	logger.debug("调用删除下载历史>");
        	if(shareCheck.isEffective(id,Constant.APP_BROW_HIST)){
        		logger.debug("调用下载历史禁用接口！");
    			DownHist hist = downHistService.selectById(id);
    			hist.setState(BusinessConstant.COMMON_STATE_JUST);
    			downHistService.update(hist);
    			redisUtil.remove(id);
    			logger.debug("调用删除下载历史>成功！");
    			return ResponseUtil.RetCorrectInfo("{id:'"+hist.getId()+"'}");
    		}else{
    			return ResponseUtil.RetErrorInfo("already disable!");
    		}
		} catch (Exception e) {
			logger.error("调用应用下载历史接口,异常：" + e.getCause().getMessage(),e);
			return ResponseUtil.RetErrorInfo(e.getCause().getMessage());
		}
    }
    
    
    
    
    
    
}
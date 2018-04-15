package com.maiyue.weixin.utils;

import org.springframework.ui.ModelMap;
import com.maiyue.weixin.constant.Business;

/***
 * 接口返回标准
 * @author Admin
 */
public class ResponseUtil {

	 /***
	  * 请求数据成功、正确信息返回
	  * @param msg
	  * @return
	  */
	 public static ModelMap RetCorrectInfo(String data){
	    	ModelMap result = new ModelMap();
	    	result.put(Business.RESULT_STATUS,Business.RESULT_STATUS_TRUE);
	    	result.put(Business.RESULT_CODE, Business.RESULT_CODE_TRUE);
	    	result.put(Business.RESULT_DATA, data);
	    	result.put(Business.RESULT_MSG,"Request success!");
			return result;
	 }	
	
	 /***
	  * 校验错误信息返回
	  * @param msg
	  * @return
	  */
	 public static ModelMap RetErrorInfo(String msg){
	    	ModelMap result = new ModelMap();
	    	result.put(Business.RESULT_STATUS,Business.RESULT_STATUS_TRUE);
	    	result.put(Business.RESULT_CODE, Business.RESULT_CODE_FALSE);
	    	result.put(Business.RESULT_DATA,"{}");
	    	result.put(Business.RESULT_MSG,msg);
			return result;
	 }
	 
	 /***
	  * 请求错误信息返回
	  * @param msg
	  * @return
	  */
	 public static ModelMap ReqError(Object msg){
	    	ModelMap result = new ModelMap();
	    	result.put(Business.RESULT_STATUS,Business.RESULT_STATUS_FALSE);
	    	result.put(Business.RESULT_CODE, Business.RESULT_CODE_FALSE);
	    	result.put(Business.RESULT_DATA, null);
	    	result.put(Business.RESULT_MSG,msg);
			return result;
	 }
	 
}

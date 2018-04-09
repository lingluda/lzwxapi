package com.maiyue.app.utils;

import java.util.Map;

import org.springframework.ui.ModelMap;

import com.maiyue.app.constant.BusinessConstant;

public class ResponseUtil {

		
	 /***
	  * 正确信息返回
	  * @param msg
	  * @return
	  */
	 public static ModelMap RetCorrectInfo(String data){
	    	ModelMap result = new ModelMap();
	    	result.put(BusinessConstant.RESULT_STATUS,BusinessConstant.RESULT_STATUS_TRUE);
	    	result.put(BusinessConstant.RESULT_CODE, BusinessConstant.RESULT_CODE_TRUE);
	    	result.put(BusinessConstant.RESULT_DATA, data);
	    	result.put(BusinessConstant.RESULT_MSG,"Request data to be normal!");
			return result;
	 }	
	
	 /***
	  * 错误信息返回
	  * @param msg
	  * @return
	  */
	 public static ModelMap RetErrorInfo(String msg){
	    	ModelMap result = new ModelMap();
	    	result.put(BusinessConstant.RESULT_STATUS,BusinessConstant.RESULT_STATUS_TRUE);
	    	result.put(BusinessConstant.RESULT_CODE, BusinessConstant.RESULT_CODE_FALSE);
	    	result.put(BusinessConstant.RESULT_DATA, null);
	    	result.put(BusinessConstant.RESULT_MSG,msg);
			return result;
	 }
	  
	 
	 /***
	  * 错误信息返回
	  * @param msg
	  * @return
	  */
	 public static Map<String, Object> ReqError(Object msg){
	    	ModelMap result = new ModelMap();
	    	result.put(BusinessConstant.RESULT_STATUS,BusinessConstant.RESULT_STATUS_FALSE);
	    	result.put(BusinessConstant.RESULT_CODE, BusinessConstant.RESULT_CODE_FALSE);
	    	result.put(BusinessConstant.RESULT_DATA, null);
	    	result.put(BusinessConstant.RESULT_MSG,msg);
			return result;
	 }
	 
	 
}

package com.maiyue.app.constant;

import java.util.Map;
import com.maiyue.app.utils.ComUtil;

public class BusinessConstant {

	
	  /***
	   *   0 待审核
	   */
	  public static final String AUDIT_RESULT_STAY = "0";
	  /***
	   * 1 审核通过
	   */
	  public static final String AUDIT_RESULT_PASS = "1";
	  
	  /***
	   * -1 审核不过
	   */
	  public static final String AUDIT_RESULT_JUST = "-1";
	  
	  /***
	   * 正常状态
	   */
	  public static final String COMMON_STATE_STAY = "0";
	  
	  /***
	   * 删除状态
	   */
	  public static final String COMMON_STATE_JUST = "-1";
	  
	  
	  /***
	   * ID in 查询
	   */
	  public static final String IN_SELECT_IDS = "ids";
	  
	  
	  
	  /***
	   * 接口执行状态(默认0)
	   */
	  public static final String RESULT_STATUS = "RetStatus";
	  
	  /***
	   * 返回码(true|false)
	   */
	  public static final String RESULT_CODE = "RetCode";
	  
	  /***
	   *  返回信息
	   */
	  public static final String RESULT_MSG = "RetMsg";
	  
	  /***
	   *  返回数据
	   */
	  public static final String RESULT_DATA = "RetData";
	  
	  
	  /***
	   * 成功
	   */
	  public static final boolean RESULT_CODE_TRUE = true;
	  
	  /***
	   * 失败
	   */
	  public static final boolean RESULT_CODE_FALSE = false;
	  
	  /***
	   * 方法执行码
	   */
	  public static final Integer RESULT_STATUS_TRUE = 0;
	  /***
	   * 方法执行码
	   */
	  public static final Integer RESULT_STATUS_FALSE = -1;
	  
	  
	  
	  /****************************** 排序 *****************************/
	  public static final String ORDER = "order";
	  public static final String SORT = "sort";
	  public static final String PAGENUM = "pageNum";
	  public static final String PAGESIZE = "pageSize";
	  
	  /****
	   * 
	   * 业务默认状态
	   * @param object
	   * @param params
	   * @param field
	   * @return
	   */
		@SuppressWarnings("null")
		public static Map<String, Object> defaultState(@SuppressWarnings("rawtypes") Class object,Map<String, Object> params,String field){
			   params = defaultSort(object,params);
			   if(params != null){
					if(params.get(field) != null){
						String state = (String) params.get(field);
						if(!BusinessConstant.COMMON_STATE_JUST.equals(state.trim()) || !BusinessConstant.COMMON_STATE_STAY.equals(state.trim())){
							params.put(field, BusinessConstant.COMMON_STATE_STAY);
						}
					}else{
						params.put(field, BusinessConstant.COMMON_STATE_STAY);
					}
				}else{
					params.put(field, BusinessConstant.COMMON_STATE_STAY);
			  }
			  return params;
		  }
	  
	  
	   /***
	    * 默认排序
	    * @param object
	    * @param params
	    * @return
	    */
		private static Map<String, Object> defaultSort(@SuppressWarnings("rawtypes") Class object,Map<String, Object> params){
			  if(params != null){
				if(params.get(ORDER) != null){
					String column = ComUtil.getCheckColumn(object, params.get(ORDER).toString().trim());
					params.put(ORDER, column);
				}
				if(params.get(SORT) != null){
					if(!params.get(SORT).toString().trim().toUpperCase().equals("DESC") && !params.get("sort").toString().trim().toUpperCase().equals("DESC")){
						params.put(SORT, "DESC");	
					}
				}
		      }
			  return params;
		 }
	
	  
}

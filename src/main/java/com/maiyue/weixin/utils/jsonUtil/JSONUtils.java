package com.maiyue.weixin.utils.jsonUtil;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.github.pagehelper.PageInfo;
import com.maiyue.weixin.constant.Business;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.CycleDetectionStrategy;
import net.sf.json.util.PropertyFilter;


public class JSONUtils {
	
	private static Logger logger = Logger.getLogger(JSONUtils.class);
	
	private static final String [] excludes = {Business.ORDER,Business.SORT,
				Business.PAGENUM,Business.PAGESIZE};
	
	/**
	 * 把PageBean转化成JSONObject
	 * @param <T>
	 * @param pageBean 要转化的数据
	 * @return JSON字符串
	 */
	@SuppressWarnings("rawtypes")
	public static String toMapJSONObject(PageInfo page){
		Map<String,Object> map = new LinkedHashMap<String,Object>();
		map.put("total",page.getTotal());
		map.put("rows",page.getList());
		return toJSONObject(map,excludes);
	}
	
	
	/**
	 * 
	 * 把PageBean转化成JSONObject
	 * @param pageBean 要转化的数据
	 * @param excludes 要排除的字段
	 * @return JSON字符串
	 */
	@SuppressWarnings("rawtypes")
	public static String toMapJSONObject(PageInfo page,String [] excludes){
		Map<String,Object> map = new LinkedHashMap<String,Object>();
		map.put("total",page.getTotal());
		map.put("rows",page.getList());
		return toJSONObject(map,excludes);
	}
	
	
	/**
	 * 
	 * 把PageBean转化成JSONObject
	 * @param pageBean 要转化的数据
	 * @param includes 要转化的字段
	 * @return JSON字符串
	 */
	@SuppressWarnings("rawtypes")
	public static String toMapJSONObjectIncludes(PageInfo page,String [] includes){
		Map<String,Object> map = new LinkedHashMap<String,Object>();
		map.put("total",page.getTotal());
		map.put("rows",page.getList());
		String [] inc = Arrays.copyOf(includes,includes.length + 2);
		inc[inc.length - 2] = "rows";
		inc[inc.length - 1] = "total";
		return toJSONObjectIncludes(map,inc);
	}
	
	
	
	/**
	 * 把对象转化成JSONObject
	 * @param obj 要转化的对象
	 * @return JSON字符串
	 */
	public static String toJSONObject(Object obj){
		/*
		JsonConfig jsonConfig = createJsonConfig();
		JSONObject jsonObject = JSONObject.fromObject(obj,jsonConfig);
		String jsonJAVA = jsonObject.toString();
		logger.info(jsonJAVA);
		*/
		
		
		//使用第三方工具将map转成json文本
		JsonConfig jsonConfig = createJsonConfig(); 
		//排除某些不用转换的字段
		jsonConfig.setExcludes(excludes);
		JSONObject jsonObject = JSONObject.fromObject(obj,jsonConfig);
		String jsonJAVA = jsonObject.toString();
		logger.info(jsonJAVA);
		
		
		return jsonJAVA;
	}
	
	
	
	
	
	
	
	private static JsonConfig createJsonConfig(){
		//使用第三方工具将map转成json文本
		JsonConfig jsonConfig = new JsonConfig(); 
		//防止自包含
		jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT); 
		//注册Date型的处理器
		jsonConfig.registerJsonValueProcessor(java.sql.Date.class , new JsonDateValueProcessor());
		//注册Date型的处理器
		jsonConfig.registerJsonValueProcessor(java.util.Date.class , new JsonDateValueProcessor());
		return jsonConfig;
	}
	
	
	/**
	 * 创建JsonConfig并设置其要包含的字段
	 * @param includes 要包含的字段
	 * @return 创建好的JsonConfig
	 */
	private static JsonConfig createJsonConfigIncludes(String [] includes){
		//使用第三方工具将map转成json文本
		JsonConfig jsonConfig = createJsonConfig(); 
		//把包含字段中的类名与字段名称分开
		final JSONUtilBean jsonB [] = new JSONUtilBean[includes.length];
		int count = 0;
		for(String inc : includes){
			int idx = inc.lastIndexOf(".");
			jsonB[count] = new JSONUtilBean(idx==-1?"":inc.substring(0, idx), inc.substring(idx + 1));
			//System.out.println(jsonB[count].getClassName() + ":" + jsonB[count].getFieldName());
			count++;
		}
		//设置要包含的字段
		jsonConfig.setJsonPropertyFilter(new PropertyFilter() {
			public boolean apply(Object source, String name, Object value) {
				for(JSONUtilBean json : jsonB){
					//完整类名
					String s = source.toString();
					//如果类名source,字段名name与要包含的字段一致,则不过滤，否则过滤。
					if ( name.equals(json.getFieldName()) && ("".equals(json.getClassName()) 
						 || s.substring(s.lastIndexOf(".")+1,s.lastIndexOf("@")).equals(json.getClassName()))){
						//不过滤
						return false;
					}
				}
				//过滤
				return true;
			}
		});
		return jsonConfig;
	}
	
	
	/**
	 * 把对象转化成JSONObject
	 * @param obj 要转化的对象
	 * @param excludes 要排除的字段
	 * @return JSON字符串
	 */
	public static String toJSONObject(Object obj,String [] excludes){
		//使用第三方工具将map转成json文本
		JsonConfig jsonConfig = createJsonConfig(); 
		//排除某些不用转换的字段
		jsonConfig.setExcludes(excludes);
		
		JSONObject jsonObject = JSONObject.fromObject(obj,jsonConfig);
		String jsonJAVA = jsonObject.toString();
		//logger.info(jsonJAVA);
		return jsonJAVA;
	}
	
	
	/**
	 * 把对象转化成JSONObject
	 * @param obj 要转化的对象
	 * @param includes 要转化的字段 字段由[类名.]字段名 组成，[]内内容可省略 如："TblMovieType.movieTypeId"或"movieTypeId"
	 * @return JSON字符串
	 */
	public static String toJSONObjectIncludes(Object obj,String [] includes){
		JsonConfig jsonConfig = createJsonConfigIncludes(includes);
		JSONObject jsonObject = JSONObject.fromObject(obj,jsonConfig);
		String jsonJAVA = jsonObject.toString();
		logger.info(jsonJAVA);
		return jsonJAVA;
	}
	
	
	/**
	 * 把对象转化成JSONArray
	 * @param obj 要转化的对象
	 * @return JSON数组字符串
	 */
	public static String toJSONArray(Object obj){
		JsonConfig jsonConfig = createJsonConfig(); 				
		JSONArray jsonObject = JSONArray.fromObject(obj,jsonConfig);
		String jsonJAVA = jsonObject.toString();
		//如果里面没有数据时，会生成"[null]"字符串，easyUI不能处理该字符串，会报错。所以此处转化一下
		if("[null]".equals(jsonJAVA)){
			jsonJAVA = "[]";
		}
		//logger.info(jsonJAVA);
		return jsonJAVA;
	}
	
	/**
	 * 把对象转化成JSONArray
	 * @param obj 要转化的对象
	 * @param excludes 要排除的字段
	 * @return JSON数组字符串
	 */
	public static String toJSONArray(Object obj,String [] excludes){
		JsonConfig jsonConfig = createJsonConfig();
		//排除某些不用转换的字段
		jsonConfig.setExcludes(excludes);
		JSONArray jsonObject = JSONArray.fromObject(obj,jsonConfig);
		String jsonJAVA = jsonObject.toString();
		//如果里面没有数据时，会生成"[null]"字符串，在easyUI下不能处理该字符串，会报错。所以此处转化一下
		if("[null]".equals(jsonJAVA)){
			jsonJAVA = "[]";
		}
		logger.info(jsonJAVA);
		return jsonJAVA;
	}
	
	/**
	 * 把对象转化成JSONArray
	 * @param obj 要转化的对象
	 * @param excludes 要排除的字段
	 * @return JSON数组字符串
	 */
	public static String toJSONArrayExcludes(Object obj){
		JsonConfig jsonConfig = createJsonConfig();
		//排除某些不用转换的字段
		jsonConfig.setExcludes(excludes);
		JSONArray jsonObject = JSONArray.fromObject(obj,jsonConfig);
		String jsonJAVA = jsonObject.toString();
		//如果里面没有数据时，会生成"[null]"字符串，在easyUI下不能处理该字符串，会报错。所以此处转化一下
		if("[null]".equals(jsonJAVA)){
			jsonJAVA = "[]";
		}
		logger.info(jsonJAVA);
		return jsonJAVA;
	}
	
	/**
	 * 把对象转化成JSONArray
	 * @param obj 要转化的对象
	 * @param includes 要包含的字段
	 * @return JSON数组字符串
	 */
	public static String toJSONArrayIncludes(Object obj,String [] includes){
		JsonConfig jsonConfig = createJsonConfigIncludes(includes);
		JSONArray jsonObject = JSONArray.fromObject(obj,jsonConfig);
		String jsonJAVA = jsonObject.toString();
		//如果里面没有数据时，会生成"[null]"字符串，在easyUI下不能处理该字符串，会报错。所以此处转化一下
		if("[null]".equals(jsonJAVA)){
			jsonJAVA = "[]";
		}
		logger.info(jsonJAVA);
		return jsonJAVA;
	}
	
	
	
	
	

}

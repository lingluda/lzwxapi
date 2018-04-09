package com.maiyue.weixin.utils.jsonUtil;

/**
 * JSONUtils要使用到的辅助工具类
 */
public class JSONUtilBean {
	
	private String className;				//类名
	private String fieldName;				//字段名
	
	public JSONUtilBean(String className, String fieldName) {
		this.className = className;
		this.fieldName = fieldName;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	
}

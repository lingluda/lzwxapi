package com.maiyue.app.bean;

import java.io.Serializable;

public class ModResources extends BaseSort implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -5895230629296217558L;

	/**
    * Id标识
    * 字段名:ID
    * 类型:VARCHAR
     */
    private String id;

    /**
    * 模块ID
    * 字段名:MODULE_ID
    * 类型:VARCHAR
     */
    private String moduleId;

    /**
    * 广告ID
    * 字段名:AD_ID
    * 类型:VARCHAR
     */
    private String adId;

    /**
     * Id标识
     * @return ID
     */
    public String getId() {
        return id;
    }

    /**
     * Id标识
     * @param id
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 模块ID
     * @return MODULE_ID
     */
    public String getModuleId() {
        return moduleId;
    }

    /**
     * 模块ID
     * @param moduleId
     */
    public void setModuleId(String moduleId) {
        this.moduleId = moduleId == null ? null : moduleId.trim();
    }

    /**
     * 广告ID
     * @return AD_ID
     */
    public String getAdId() {
        return adId;
    }

    /**
     * 广告ID
     * @param adId
     */
    public void setAdId(String adId) {
        this.adId = adId == null ? null : adId.trim();
    }
}
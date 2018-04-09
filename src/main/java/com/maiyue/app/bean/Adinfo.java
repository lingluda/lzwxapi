package com.maiyue.app.bean;

import java.io.Serializable;
import java.util.Date;

public class Adinfo extends BaseSort implements Serializable{
    
	private static final long serialVersionUID = 7585769900793912185L;

	/**
    * ID标识
    * 字段名:ID
    * 类型:VARCHAR
     */
    private String id;

    /**
    * 用户ID
    * 字段名:USER_ID
    * 类型:VARCHAR
     */
    private String userId;

    /**
    * 广告类别
    * 字段名:AD_CATEGORY
    * 类型:VARCHAR
     */
    private String adCategory;

    /**
    * 广告类型
    * 字段名:AD_TYPE
    * 类型:VARCHAR
     */
    private String adType;

    /**
    * 广告链接
    * 字段名:AD_HREF
    * 类型:VARCHAR
     */
    private String adHref;

    /**
    * 广告内容
    * 字段名:AD_CONTENT
    * 类型:VARCHAR
     */
    private String adContent;

    /**
    * 广告投放时间
    * 字段名:ADS_START_TIME
    * 类型:TIMESTAMP
     */
    private Date adsStartTime;

    /**
    * 广告停止时间
    * 字段名:ADS_END_TIME
    * 类型:TIMESTAMP
     */
    private Date adsEndTime;

    /**
    * 创建时间
    * 字段名:CREATE_TIME
    * 类型:TIMESTAMP
     */
    private Date createTime;

    /**
    * 状态  0 正常 -1 停用   
    * 字段名:STATE
    * 类型:VARCHAR
     */
    private String state;

    /**
     * ID标识
     * @return ID
     */
    public String getId() {
        return id;
    }

    /**
     * ID标识
     * @param id
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 用户ID
     * @return USER_ID
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 用户ID
     * @param userId
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * 广告类别
     * @return AD_CATEGORY
     */
    public String getAdCategory() {
        return adCategory;
    }

    /**
     * 广告类别
     * @param adCategory
     */
    public void setAdCategory(String adCategory) {
        this.adCategory = adCategory == null ? null : adCategory.trim();
    }

    /**
     * 广告类型
     * @return AD_TYPE
     */
    public String getAdType() {
        return adType;
    }

    /**
     * 广告类型
     * @param adType
     */
    public void setAdType(String adType) {
        this.adType = adType == null ? null : adType.trim();
    }

    /**
     * 广告链接
     * @return AD_HREF
     */
    public String getAdHref() {
        return adHref;
    }

    /**
     * 广告链接
     * @param adHref
     */
    public void setAdHref(String adHref) {
        this.adHref = adHref == null ? null : adHref.trim();
    }

    /**
     * 广告内容
     * @return AD_CONTENT
     */
    public String getAdContent() {
        return adContent;
    }

    /**
     * 广告内容
     * @param adContent
     */
    public void setAdContent(String adContent) {
        this.adContent = adContent == null ? null : adContent.trim();
    }

    /**
     * 广告投放时间
     * @return ADS_START_TIME
     */
    public Date getAdsStartTime() {
        return adsStartTime;
    }

    /**
     * 广告投放时间
     * @param adsStartTime
     */
    public void setAdsStartTime(Date adsStartTime) {
        this.adsStartTime = adsStartTime;
    }

    /**
     * 广告停止时间
     * @return ADS_END_TIME
     */
    public Date getAdsEndTime() {
        return adsEndTime;
    }

    /**
     * 广告停止时间
     * @param adsEndTime
     */
    public void setAdsEndTime(Date adsEndTime) {
        this.adsEndTime = adsEndTime;
    }

    /**
     * 创建时间
     * @return CREATE_TIME
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 状态  0 正常 -1 停用   
     * @return STATE
     */
    public String getState() {
        return state;
    }

    /**
     * 状态  0 正常 -1 停用   
     * @param state
     */
    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

	
}
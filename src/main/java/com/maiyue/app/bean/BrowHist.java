package com.maiyue.app.bean;

import java.io.Serializable;
import java.util.Date;

public class BrowHist extends BaseSort implements Serializable{
    
	
	private static final long serialVersionUID = 6115154539245833732L;

	/**
    * ID标识
    * 字段名:ID
    * 类型:VARCHAR
     */
    private String id;

    /**
    * APP信息ID
    * 字段名:APP_INFO_ID
    * 类型:VARCHAR
     */
    private String appInfoId;

    /**
    * 用户ID
    * 字段名:USER_ID
    * 类型:VARCHAR
     */
    private String userId;

    /**
    * 浏览时间
    * 字段名:BROWSE_TIME
    * 类型:TIMESTAMP
     */
    private Date browseTime;

    /**
    * 状态  0 正常 -1 删除
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
     * APP信息ID
     * @return APP_INFO_ID
     */
    public String getAppInfoId() {
        return appInfoId;
    }

    /**
     * APP信息ID
     * @param appInfoId
     */
    public void setAppInfoId(String appInfoId) {
        this.appInfoId = appInfoId == null ? null : appInfoId.trim();
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
     * 浏览时间
     * @return BROWSE_TIME
     */
    public Date getBrowseTime() {
        return browseTime;
    }

    /**
     * 浏览时间
     * @param browseTime
     */
    public void setBrowseTime(Date browseTime) {
        this.browseTime = browseTime;
    }

    /**
     * 状态  0 正常 -1 删除
     * @return STATE
     */
    public String getState() {
        return state;
    }

    /**
     * 状态  0 正常 -1 删除
     * @param state
     */
    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }
}
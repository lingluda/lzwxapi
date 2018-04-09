package com.maiyue.app.bean;

import java.io.Serializable;
import java.util.Date;

public class AppScore extends BaseSort implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 2542899382371894932L;

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
    * 用户信息
    * 字段名:USER_ID
    * 类型:VARCHAR
     */
    private String userId;

    /**
    * 得分信息
    * 字段名:APP_SCORE_INFO
    * 类型:VARCHAR
     */
    private String appScoreInfo;

    /**
    * 创建时间
    * 字段名:CREATE_TIME
    * 类型:TIMESTAMP
     */
    private Date createTime;

    /**
    * 状态 0 正常 -1 删除
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
     * 用户信息
     * @return USER_ID
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 用户信息
     * @param userId
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * 得分信息
     * @return APP_SCORE_INFO
     */
    public String getAppScoreInfo() {
        return appScoreInfo;
    }

    /**
     * 得分信息
     * @param appScoreInfo
     */
    public void setAppScoreInfo(String appScoreInfo) {
        this.appScoreInfo = appScoreInfo == null ? null : appScoreInfo.trim();
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
     * 状态 0 正常 -1 删除
     * @return STATE
     */
    public String getState() {
        return state;
    }

    /**
     * 状态 0 正常 -1 删除
     * @param state
     */
    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }
}
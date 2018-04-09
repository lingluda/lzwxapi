package com.maiyue.app.bean;

import java.io.Serializable;
import java.util.Date;

public class DownHist extends BaseSort implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -9025664761730749259L;

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
    * APP安装包ID
    * 字段名:APP_INSTAL_ID
    * 类型:VARCHAR
     */
    private String appInstalId;

    /**
    * 用户ID
    * 字段名:USER_ID
    * 类型:VARCHAR
     */
    private String userId;

    /**
    * 下载时间
    * 字段名:DOWN_TIME
    * 类型:TIMESTAMP
     */
    private Date downTime;

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
     * APP安装包ID
     * @return APP_INSTAL_ID
     */
    public String getAppInstalId() {
        return appInstalId;
    }

    /**
     * APP安装包ID
     * @param appInstalId
     */
    public void setAppInstalId(String appInstalId) {
        this.appInstalId = appInstalId == null ? null : appInstalId.trim();
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
     * 下载时间
     * @return DOWN_TIME
     */
    public Date getDownTime() {
        return downTime;
    }

    /**
     * 下载时间
     * @param downTime
     */
    public void setDownTime(Date downTime) {
        this.downTime = downTime;
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
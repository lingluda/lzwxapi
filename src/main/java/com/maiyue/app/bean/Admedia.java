package com.maiyue.app.bean;

import java.io.Serializable;
import java.util.Date;

public class Admedia extends BaseSort implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 2386451556374298823L;

	/**
    * ID
    * 字段名:ID
    * 类型:VARCHAR
     */
    private String id;

    /**
    * User_id
    * 字段名:USER_ID
    * 类型:VARCHAR
     */
    private String userId;

    /**
    * ad_ID
    * 字段名:AD_ID
    * 类型:VARCHAR
     */
    private String adId;

    /**
    * 资源类型
    * 字段名:MEDIA_TYPE
    * 类型:VARCHAR
     */
    private String mediaType;

    /**
    * 资源别名
    * 字段名:MEDIA_ALIAS
    * 类型:VARCHAR
     */
    private String mediaAlias;

    /**
    * 资源地址
    * 字段名:MEDIA_ADDRESS
    * 类型:VARCHAR
     */
    private String mediaAddress;

    /**
    * 资源所在盘
    * 字段名:MEDIA_DISK
    * 类型:VARCHAR
     */
    private String mediaDisk;

    /**
    * 审核结果  0 待审核  1 审核通过  -1审核不过
    * 字段名:AUDIT_RESULT
    * 类型:VARCHAR
     */
    private String auditResult;

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
     * ID
     * @return ID
     */
    public String getId() {
        return id;
    }

    /**
     * ID
     * @param id
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * User_id
     * @return USER_ID
     */
    public String getUserId() {
        return userId;
    }

    /**
     * User_id
     * @param userId
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * ad_ID
     * @return AD_ID
     */
    public String getAdId() {
        return adId;
    }

    /**
     * ad_ID
     * @param adId
     */
    public void setAdId(String adId) {
        this.adId = adId == null ? null : adId.trim();
    }

    /**
     * 资源类型
     * @return MEDIA_TYPE
     */
    public String getMediaType() {
        return mediaType;
    }

    /**
     * 资源类型
     * @param mediaType
     */
    public void setMediaType(String mediaType) {
        this.mediaType = mediaType == null ? null : mediaType.trim();
    }

    /**
     * 资源别名
     * @return MEDIA_ALIAS
     */
    public String getMediaAlias() {
        return mediaAlias;
    }

    /**
     * 资源别名
     * @param mediaAlias
     */
    public void setMediaAlias(String mediaAlias) {
        this.mediaAlias = mediaAlias == null ? null : mediaAlias.trim();
    }

    /**
     * 资源地址
     * @return MEDIA_ADDRESS
     */
    public String getMediaAddress() {
        return mediaAddress;
    }

    /**
     * 资源地址
     * @param mediaAddress
     */
    public void setMediaAddress(String mediaAddress) {
        this.mediaAddress = mediaAddress == null ? null : mediaAddress.trim();
    }

    /**
     * 资源所在盘
     * @return MEDIA_DISK
     */
    public String getMediaDisk() {
        return mediaDisk;
    }

    /**
     * 资源所在盘
     * @param mediaDisk
     */
    public void setMediaDisk(String mediaDisk) {
        this.mediaDisk = mediaDisk == null ? null : mediaDisk.trim();
    }

    /**
     * 审核结果  0 待审核  1 审核通过  -1审核不过
     * @return AUDIT_RESULT
     */
    public String getAuditResult() {
        return auditResult;
    }

    /**
     * 审核结果  0 待审核  1 审核通过  -1审核不过
     * @param auditResult
     */
    public void setAuditResult(String auditResult) {
        this.auditResult = auditResult == null ? null : auditResult.trim();
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
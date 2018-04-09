package com.maiyue.app.bean;

import java.io.Serializable;
import java.util.Date;

public class AppReview extends BaseSort implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -8598933833554996948L;

	/**
    * ID标识
    * 字段名:ID
    * 类型:VARCHAR
     */
    private String id;

    /**
    * 应用信息ID
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
    * 审核内容
    * 字段名:REVIEW_CONTENT
    * 类型:VARCHAR
     */
    private String reviewContent;

    /**
    * 创建时间
    * 字段名:CREATE_TIME
    * 类型:TIMESTAMP
     */
    private Date createTime;

    /**
    * 审核结果  0 待审核  1 审核通过  -1审核不过
    * 字段名:AUDIT_RESULT
    * 类型:VARCHAR
     */
    private String auditResult;

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
     * 应用信息ID
     * @return APP_INFO_ID
     */
    public String getAppInfoId() {
        return appInfoId;
    }

    /**
     * 应用信息ID
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
     * 审核内容
     * @return REVIEW_CONTENT
     */
    public String getReviewContent() {
        return reviewContent;
    }

    /**
     * 审核内容
     * @param reviewContent
     */
    public void setReviewContent(String reviewContent) {
        this.reviewContent = reviewContent == null ? null : reviewContent.trim();
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
package com.maiyue.business.bean;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

public class WorkResults {
    /**
    * id标识
    * 字段名:ID
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="id",value="id标识",dataType="String")
    private String id;

    /**
    * 工作日志ID
    * 字段名:WORK_LOG_ID
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="workLogId",value="工作日志ID",dataType="String")
    private String workLogId;

    /**
    * 申请人id
    * 字段名:APPLICANT_ID
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="applicantId",value="申请人id",dataType="String")
    private String applicantId;

    /**
    * 成果地址
    * 字段名:RESUT_URL
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="resutUrl",value="成果地址",dataType="String")
    private String resutUrl;

    /**
    * 成果类型
    * 字段名:RESUT_TYPE
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="resutType",value="成果类型",dataType="String")
    private String resutType;

    /**
    * 创建时间
    * 字段名:CREATE_TIME
    * 类型:TIMESTAMP
     */
    @ApiModelProperty(name="createTime",value="创建时间",dataType="Date")
    private Date createTime;

    /**
    * 状态 0 正常 -1 删除 1锁定
    * 字段名:STATE
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="state",value="状态 0 正常 -1 删除 1锁定",dataType="String")
    private String state;

    /**
     * id标识
     * @return ID
     */
    public String getId() {
        return id;
    }

    /**
     * id标识
     * @param id
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 工作日志ID
     * @return WORK_LOG_ID
     */
    public String getWorkLogId() {
        return workLogId;
    }

    /**
     * 工作日志ID
     * @param workLogId
     */
    public void setWorkLogId(String workLogId) {
        this.workLogId = workLogId == null ? null : workLogId.trim();
    }

    /**
     * 申请人id
     * @return APPLICANT_ID
     */
    public String getApplicantId() {
        return applicantId;
    }

    /**
     * 申请人id
     * @param applicantId
     */
    public void setApplicantId(String applicantId) {
        this.applicantId = applicantId == null ? null : applicantId.trim();
    }

    /**
     * 成果地址
     * @return RESUT_URL
     */
    public String getResutUrl() {
        return resutUrl;
    }

    /**
     * 成果地址
     * @param resutUrl
     */
    public void setResutUrl(String resutUrl) {
        this.resutUrl = resutUrl == null ? null : resutUrl.trim();
    }

    /**
     * 成果类型
     * @return RESUT_TYPE
     */
    public String getResutType() {
        return resutType;
    }

    /**
     * 成果类型
     * @param resutType
     */
    public void setResutType(String resutType) {
        this.resutType = resutType == null ? null : resutType.trim();
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
     * 状态 0 正常 -1 删除 1锁定
     * @return STATE
     */
    public String getState() {
        return state;
    }

    /**
     * 状态 0 正常 -1 删除 1锁定
     * @param state
     */
    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }
}
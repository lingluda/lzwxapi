package com.maiyue.weixin.business.bean;


import com.maiyue.weixin.bean.BaseSort;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class DiligentApplication extends BaseSort implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 3422206559833709532L;

	/**
    * id标识
    * 字段名:ID
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="id",value="id标识",dataType="String")
    private String id;

    /**
    * 勤工助学ID
    * 字段名:DILIGENT_ID
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="diligentId",value="勤工助学ID",dataType="String")
    private String diligentId;

    /**
    * 申请人ID
    * 字段名:APPLICANT_ID
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="applicantId",value="申请人ID",dataType="String")
    private String applicantId;

    /**
    * 工作开始时间
    * 字段名:START_TIME
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="startTime",value="工作开始时间",dataType="String")
    private String startTime;

    /**
    * 工作截止时间
    * 字段名:END_TIME
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="endTime",value="工作截止时间",dataType="String")
    private String endTime;

    /**
    * 0 待审核 1 通过 2 不通过 
    * 字段名:AUDIT_STATE
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="auditState",value="0 待审核 1 通过 2 不通过 ",dataType="String")
    private String auditState;

    /**
    * 0 正常 -1 删除 1 锁定
    * 字段名:STATE
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="state",value="0 正常 -1 删除 1 锁定",dataType="String")
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
     * 勤工助学ID
     * @return DILIGENT_ID
     */
    public String getDiligentId() {
        return diligentId;
    }

    /**
     * 勤工助学ID
     * @param diligentId
     */
    public void setDiligentId(String diligentId) {
        this.diligentId = diligentId == null ? null : diligentId.trim();
    }

    /**
     * 申请人ID
     * @return APPLICANT_ID
     */
    public String getApplicantId() {
        return applicantId;
    }

    /**
     * 申请人ID
     * @param applicantId
     */
    public void setApplicantId(String applicantId) {
        this.applicantId = applicantId == null ? null : applicantId.trim();
    }

    /**
     * 工作开始时间
     * @return START_TIME
     */
    public String getStartTime() {
        return startTime;
    }

    /**
     * 工作开始时间
     * @param startTime
     */
    public void setStartTime(String startTime) {
        this.startTime = startTime == null ? null : startTime.trim();
    }

    /**
     * 工作截止时间
     * @return END_TIME
     */
    public String getEndTime() {
        return endTime;
    }

    /**
     * 工作截止时间
     * @param endTime
     */
    public void setEndTime(String endTime) {
        this.endTime = endTime == null ? null : endTime.trim();
    }

    /**
     * 0 待审核 1 通过 2 不通过 
     * @return AUDIT_STATE
     */
    public String getAuditState() {
        return auditState;
    }

    /**
     * 0 待审核 1 通过 2 不通过 
     * @param auditState
     */
    public void setAuditState(String auditState) {
        this.auditState = auditState == null ? null : auditState.trim();
    }

    /**
     * 0 正常 -1 删除 1 锁定
     * @return STATE
     */
    public String getState() {
        return state;
    }

    /**
     * 0 正常 -1 删除 1 锁定
     * @param state
     */
    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }
}
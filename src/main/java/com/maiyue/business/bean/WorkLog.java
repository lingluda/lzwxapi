package com.maiyue.business.bean;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

public class WorkLog {
    /**
    * id标识
    * 字段名:ID
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="id",value="id标识",dataType="String")
    private String id;

    /**
    * 申请人
    * 字段名:APPLICANT_ID
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="applicantId",value="申请人",dataType="String")
    private String applicantId;

    /**
    * 工作岗位
    * 字段名:JOB_POST
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="jobPost",value="工作岗位",dataType="String")
    private String jobPost;

    /**
    * 工作时长
    * 字段名:JOB_TIME
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="jobTime",value="工作时长",dataType="String")
    private String jobTime;

    /**
    * 工作内容
    * 字段名:JOB_CONTENT
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="jobContent",value="工作内容",dataType="String")
    private String jobContent;

    /**
    * 审核级别  1 2 3 最高三级
    * 字段名:AUDIT_LEVLE
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="auditLevle",value="审核级别  1 2 3 最高三级",dataType="String")
    private String auditLevle;

    /**
    * 当前审核级别 默认 1
    * 字段名:CURRENT_LEVEL
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="currentLevel",value="当前审核级别 默认 1",dataType="String")
    private String currentLevel;

    /**
    * 一级审核人
    * 字段名:FIRST_LEVEL
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="firstLevel",value="一级审核人",dataType="String")
    private String firstLevel;

    /**
    * 一级审核状态  0 待审核 1 通过 2 不通过
    * 字段名:FIRST_LEVEL_STATE
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="firstLevelState",value="一级审核状态  0 待审核 1 通过 2 不通过",dataType="String")
    private String firstLevelState;

    /**
    * 一级审核人意见
    * 字段名:FIRST_LEVEL_OPINION
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="firstLevelOpinion",value="一级审核人意见",dataType="String")
    private String firstLevelOpinion;

    /**
    * 二级审核人
    * 字段名:SEC_LEVEL
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="secLevel",value="二级审核人",dataType="String")
    private String secLevel;

    /**
    * 二级审核状态  0 待审核 1 通过 2 不通过
    * 字段名:SEC_LEVEL_STATE
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="secLevelState",value="二级审核状态  0 待审核 1 通过 2 不通过",dataType="String")
    private String secLevelState;

    /**
    * 二级审核人意见
    * 字段名:SEC_LEVEL_OPINION
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="secLevelOpinion",value="二级审核人意见",dataType="String")
    private String secLevelOpinion;

    /**
    * 三级审核人
    * 字段名:THREE_LEVEL
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="threeLevel",value="三级审核人",dataType="String")
    private String threeLevel;

    /**
    * 三级审核状态  0 待审核 1 通过 2 不通过
    * 字段名:THREE_LEVEL_STATE
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="threeLevelState",value="三级审核状态  0 待审核 1 通过 2 不通过",dataType="String")
    private String threeLevelState;

    /**
    * 三级审核人意见
    * 字段名:THREE_LEVEL_OPINION
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="threeLevelOpinion",value="三级审核人意见",dataType="String")
    private String threeLevelOpinion;

    /**
    * 0 待审核  1 一级审核结束 2 二级审核结束
    * 字段名:PROCESS_STATE
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="processState",value="0 待审核  1 一级审核结束 2 二级审核结束",dataType="String")
    private String processState;

    /**
    * 审核结果 1 通过 2 不通过
    * 字段名:AUDIT_RESULT
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="auditResult",value="审核结果 1 通过 2 不通过",dataType="String")
    private String auditResult;

    /**
    * 是否提交审核 0 是 1 不是
    * 字段名:SUBMIT
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="submit",value="是否提交审核 0 是 1 不是",dataType="String")
    private String submit;

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
     * 申请人
     * @return APPLICANT_ID
     */
    public String getApplicantId() {
        return applicantId;
    }

    /**
     * 申请人
     * @param applicantId
     */
    public void setApplicantId(String applicantId) {
        this.applicantId = applicantId == null ? null : applicantId.trim();
    }

    /**
     * 工作岗位
     * @return JOB_POST
     */
    public String getJobPost() {
        return jobPost;
    }

    /**
     * 工作岗位
     * @param jobPost
     */
    public void setJobPost(String jobPost) {
        this.jobPost = jobPost == null ? null : jobPost.trim();
    }

    /**
     * 工作时长
     * @return JOB_TIME
     */
    public String getJobTime() {
        return jobTime;
    }

    /**
     * 工作时长
     * @param jobTime
     */
    public void setJobTime(String jobTime) {
        this.jobTime = jobTime == null ? null : jobTime.trim();
    }

    /**
     * 工作内容
     * @return JOB_CONTENT
     */
    public String getJobContent() {
        return jobContent;
    }

    /**
     * 工作内容
     * @param jobContent
     */
    public void setJobContent(String jobContent) {
        this.jobContent = jobContent == null ? null : jobContent.trim();
    }

    /**
     * 审核级别  1 2 3 最高三级
     * @return AUDIT_LEVLE
     */
    public String getAuditLevle() {
        return auditLevle;
    }

    /**
     * 审核级别  1 2 3 最高三级
     * @param auditLevle
     */
    public void setAuditLevle(String auditLevle) {
        this.auditLevle = auditLevle == null ? null : auditLevle.trim();
    }

    /**
     * 当前审核级别 默认 1
     * @return CURRENT_LEVEL
     */
    public String getCurrentLevel() {
        return currentLevel;
    }

    /**
     * 当前审核级别 默认 1
     * @param currentLevel
     */
    public void setCurrentLevel(String currentLevel) {
        this.currentLevel = currentLevel == null ? null : currentLevel.trim();
    }

    /**
     * 一级审核人
     * @return FIRST_LEVEL
     */
    public String getFirstLevel() {
        return firstLevel;
    }

    /**
     * 一级审核人
     * @param firstLevel
     */
    public void setFirstLevel(String firstLevel) {
        this.firstLevel = firstLevel == null ? null : firstLevel.trim();
    }

    /**
     * 一级审核状态  0 待审核 1 通过 2 不通过
     * @return FIRST_LEVEL_STATE
     */
    public String getFirstLevelState() {
        return firstLevelState;
    }

    /**
     * 一级审核状态  0 待审核 1 通过 2 不通过
     * @param firstLevelState
     */
    public void setFirstLevelState(String firstLevelState) {
        this.firstLevelState = firstLevelState == null ? null : firstLevelState.trim();
    }

    /**
     * 一级审核人意见
     * @return FIRST_LEVEL_OPINION
     */
    public String getFirstLevelOpinion() {
        return firstLevelOpinion;
    }

    /**
     * 一级审核人意见
     * @param firstLevelOpinion
     */
    public void setFirstLevelOpinion(String firstLevelOpinion) {
        this.firstLevelOpinion = firstLevelOpinion == null ? null : firstLevelOpinion.trim();
    }

    /**
     * 二级审核人
     * @return SEC_LEVEL
     */
    public String getSecLevel() {
        return secLevel;
    }

    /**
     * 二级审核人
     * @param secLevel
     */
    public void setSecLevel(String secLevel) {
        this.secLevel = secLevel == null ? null : secLevel.trim();
    }

    /**
     * 二级审核状态  0 待审核 1 通过 2 不通过
     * @return SEC_LEVEL_STATE
     */
    public String getSecLevelState() {
        return secLevelState;
    }

    /**
     * 二级审核状态  0 待审核 1 通过 2 不通过
     * @param secLevelState
     */
    public void setSecLevelState(String secLevelState) {
        this.secLevelState = secLevelState == null ? null : secLevelState.trim();
    }

    /**
     * 二级审核人意见
     * @return SEC_LEVEL_OPINION
     */
    public String getSecLevelOpinion() {
        return secLevelOpinion;
    }

    /**
     * 二级审核人意见
     * @param secLevelOpinion
     */
    public void setSecLevelOpinion(String secLevelOpinion) {
        this.secLevelOpinion = secLevelOpinion == null ? null : secLevelOpinion.trim();
    }

    /**
     * 三级审核人
     * @return THREE_LEVEL
     */
    public String getThreeLevel() {
        return threeLevel;
    }

    /**
     * 三级审核人
     * @param threeLevel
     */
    public void setThreeLevel(String threeLevel) {
        this.threeLevel = threeLevel == null ? null : threeLevel.trim();
    }

    /**
     * 三级审核状态  0 待审核 1 通过 2 不通过
     * @return THREE_LEVEL_STATE
     */
    public String getThreeLevelState() {
        return threeLevelState;
    }

    /**
     * 三级审核状态  0 待审核 1 通过 2 不通过
     * @param threeLevelState
     */
    public void setThreeLevelState(String threeLevelState) {
        this.threeLevelState = threeLevelState == null ? null : threeLevelState.trim();
    }

    /**
     * 三级审核人意见
     * @return THREE_LEVEL_OPINION
     */
    public String getThreeLevelOpinion() {
        return threeLevelOpinion;
    }

    /**
     * 三级审核人意见
     * @param threeLevelOpinion
     */
    public void setThreeLevelOpinion(String threeLevelOpinion) {
        this.threeLevelOpinion = threeLevelOpinion == null ? null : threeLevelOpinion.trim();
    }

    /**
     * 0 待审核  1 一级审核结束 2 二级审核结束
     * @return PROCESS_STATE
     */
    public String getProcessState() {
        return processState;
    }

    /**
     * 0 待审核  1 一级审核结束 2 二级审核结束
     * @param processState
     */
    public void setProcessState(String processState) {
        this.processState = processState == null ? null : processState.trim();
    }

    /**
     * 审核结果 1 通过 2 不通过
     * @return AUDIT_RESULT
     */
    public String getAuditResult() {
        return auditResult;
    }

    /**
     * 审核结果 1 通过 2 不通过
     * @param auditResult
     */
    public void setAuditResult(String auditResult) {
        this.auditResult = auditResult == null ? null : auditResult.trim();
    }

    /**
     * 是否提交审核 0 是 1 不是
     * @return SUBMIT
     */
    public String getSubmit() {
        return submit;
    }

    /**
     * 是否提交审核 0 是 1 不是
     * @param submit
     */
    public void setSubmit(String submit) {
        this.submit = submit == null ? null : submit.trim();
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
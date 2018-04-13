package com.maiyue.weixin.business.bean;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

public class DiligentStudy {
    /**
    * Id标识
    * 字段名:ID
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="id",value="Id标识",dataType="String")
    private String id;

    /**
    * 发布人
    * 字段名:RELEASER_ID
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="releaserId",value="发布人",dataType="String")
    private String releaserId;

    /**
    * 发布单位
    * 字段名:RELEASE_UNIT
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="releaseUnit",value="发布单位",dataType="String")
    private String releaseUnit;

    /**
    * 用人岗位
    * 字段名:EMPLOYMENT
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="employment",value="用人岗位",dataType="String")
    private String employment;

    /**
    * 岗位简介
    * 字段名:INTRODUCE
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="introduce",value="岗位简介",dataType="String")
    private String introduce;

    /**
    * 岗位要求
    * 字段名:REQUIRES
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="requires",value="岗位要求",dataType="String")
    private String requires;

    /**
    * 岗位薪资
    * 字段名:SALARY
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="salary",value="岗位薪资",dataType="String")
    private String salary;

    /**
    * 用人数量
    * 字段名:WITH_NUMBER
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="withNumber",value="用人数量",dataType="String")
    private String withNumber;

    /**
    * 面试地点
    * 字段名:INTERVIEW_PLACE
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="interviewPlace",value="面试地点",dataType="String")
    private String interviewPlace;

    /**
    * 面试时间
    * 字段名:INTERVIEW_TIME
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="interviewTime",value="面试时间",dataType="String")
    private String interviewTime;

    /**
    * 开始时间
    * 字段名:START_TIME
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="startTime",value="开始时间",dataType="String")
    private String startTime;

    /**
    * 结束时间
    * 字段名:END_TIME
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="endTime",value="结束时间",dataType="String")
    private String endTime;

    /**
    * 已报名人数
    * 字段名:SIGNUP_NUM
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="signupNum",value="已报名人数",dataType="String")
    private String signupNum;

    /**
    * 已录用人数
    * 字段名:EMPLOY_NUM
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="employNum",value="已录用人数",dataType="String")
    private String employNum;

    /**
    * 创建时间
    * 字段名:CREATE_TIME
    * 类型:TIMESTAMP
     */
    @ApiModelProperty(name="createTime",value="创建时间",dataType="Date")
    private Date createTime;

    /**
    * 状态
    * 字段名:STATE
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="state",value="状态",dataType="String")
    private String state;

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
     * 发布人
     * @return RELEASER_ID
     */
    public String getReleaserId() {
        return releaserId;
    }

    /**
     * 发布人
     * @param releaserId
     */
    public void setReleaserId(String releaserId) {
        this.releaserId = releaserId == null ? null : releaserId.trim();
    }

    /**
     * 发布单位
     * @return RELEASE_UNIT
     */
    public String getReleaseUnit() {
        return releaseUnit;
    }

    /**
     * 发布单位
     * @param releaseUnit
     */
    public void setReleaseUnit(String releaseUnit) {
        this.releaseUnit = releaseUnit == null ? null : releaseUnit.trim();
    }

    /**
     * 用人岗位
     * @return EMPLOYMENT
     */
    public String getEmployment() {
        return employment;
    }

    /**
     * 用人岗位
     * @param employment
     */
    public void setEmployment(String employment) {
        this.employment = employment == null ? null : employment.trim();
    }

    /**
     * 岗位简介
     * @return INTRODUCE
     */
    public String getIntroduce() {
        return introduce;
    }

    /**
     * 岗位简介
     * @param introduce
     */
    public void setIntroduce(String introduce) {
        this.introduce = introduce == null ? null : introduce.trim();
    }

    /**
     * 岗位要求
     * @return REQUIRES
     */
    public String getRequires() {
        return requires;
    }

    /**
     * 岗位要求
     * @param requires
     */
    public void setRequires(String requires) {
        this.requires = requires == null ? null : requires.trim();
    }

    /**
     * 岗位薪资
     * @return SALARY
     */
    public String getSalary() {
        return salary;
    }

    /**
     * 岗位薪资
     * @param salary
     */
    public void setSalary(String salary) {
        this.salary = salary == null ? null : salary.trim();
    }

    /**
     * 用人数量
     * @return WITH_NUMBER
     */
    public String getWithNumber() {
        return withNumber;
    }

    /**
     * 用人数量
     * @param withNumber
     */
    public void setWithNumber(String withNumber) {
        this.withNumber = withNumber == null ? null : withNumber.trim();
    }

    /**
     * 面试地点
     * @return INTERVIEW_PLACE
     */
    public String getInterviewPlace() {
        return interviewPlace;
    }

    /**
     * 面试地点
     * @param interviewPlace
     */
    public void setInterviewPlace(String interviewPlace) {
        this.interviewPlace = interviewPlace == null ? null : interviewPlace.trim();
    }

    /**
     * 面试时间
     * @return INTERVIEW_TIME
     */
    public String getInterviewTime() {
        return interviewTime;
    }

    /**
     * 面试时间
     * @param interviewTime
     */
    public void setInterviewTime(String interviewTime) {
        this.interviewTime = interviewTime == null ? null : interviewTime.trim();
    }

    /**
     * 开始时间
     * @return START_TIME
     */
    public String getStartTime() {
        return startTime;
    }

    /**
     * 开始时间
     * @param startTime
     */
    public void setStartTime(String startTime) {
        this.startTime = startTime == null ? null : startTime.trim();
    }

    /**
     * 结束时间
     * @return END_TIME
     */
    public String getEndTime() {
        return endTime;
    }

    /**
     * 结束时间
     * @param endTime
     */
    public void setEndTime(String endTime) {
        this.endTime = endTime == null ? null : endTime.trim();
    }

    /**
     * 已报名人数
     * @return SIGNUP_NUM
     */
    public String getSignupNum() {
        return signupNum;
    }

    /**
     * 已报名人数
     * @param signupNum
     */
    public void setSignupNum(String signupNum) {
        this.signupNum = signupNum == null ? null : signupNum.trim();
    }

    /**
     * 已录用人数
     * @return EMPLOY_NUM
     */
    public String getEmployNum() {
        return employNum;
    }

    /**
     * 已录用人数
     * @param employNum
     */
    public void setEmployNum(String employNum) {
        this.employNum = employNum == null ? null : employNum.trim();
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
     * 状态
     * @return STATE
     */
    public String getState() {
        return state;
    }

    /**
     * 状态
     * @param state
     */
    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }
}
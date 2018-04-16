package com.maiyue.weixin.business.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.maiyue.weixin.bean.BaseSort;

import io.swagger.annotations.ApiModelProperty;

public class QualityEvaluation extends BaseSort implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 4962100307210758236L;

	/**
    * ID标识
    * 字段名:ID
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="id",value="ID标识",dataType="String")
    private String id;

    /**
    * 学年
    * 字段名:TERM_YEAR
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="termYear",value="学年",dataType="String")
    private String termYear;

    /**
    * 学期ID
    * 字段名:TERM_ID
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="termId",value="学期ID",dataType="String")
    private String termId;

    /**
    * 学生ID
    * 字段名:STUDENT_ID
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="studentId",value="学生ID",dataType="String")
    private String studentId;

    /**
    * 考评类型 (活动分/诚信分/素养积分)
    * 字段名:CHECK_ID
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="checkId",value="考评类型 (活动分/诚信分/素养积分)",dataType="String")
    private String checkId;

    /**
    * 操作类型 加分 plus /减分 reduce
    * 字段名:OPER_TYPE
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="operType",value="操作类型 加分 plus /减分 reduce",dataType="String")
    private String operType;

    /**
    * 操作分值
    * 字段名:OPER_SCORE
    * 类型:DECIMAL
     */
    @ApiModelProperty(name="operScore",value="操作分值",dataType="BigDecimal")
    private BigDecimal operScore;

    /**
    * 操作原因
    * 字段名:OPER_REASON
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="operReason",value="操作原因",dataType="String")
    private String operReason;

    /**
    * 操作时间
    * 字段名:OPER_TIME
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="operTime",value="操作时间",dataType="String")
    private String operTime;

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
     * 学年
     * @return TERM_YEAR
     */
    public String getTermYear() {
        return termYear;
    }

    /**
     * 学年
     * @param termYear
     */
    public void setTermYear(String termYear) {
        this.termYear = termYear == null ? null : termYear.trim();
    }

    /**
     * 学期ID
     * @return TERM_ID
     */
    public String getTermId() {
        return termId;
    }

    /**
     * 学期ID
     * @param termId
     */
    public void setTermId(String termId) {
        this.termId = termId == null ? null : termId.trim();
    }

    /**
     * 学生ID
     * @return STUDENT_ID
     */
    public String getStudentId() {
        return studentId;
    }

    /**
     * 学生ID
     * @param studentId
     */
    public void setStudentId(String studentId) {
        this.studentId = studentId == null ? null : studentId.trim();
    }

    /**
     * 考评类型 (活动分/诚信分/素养积分)
     * @return CHECK_ID
     */
    public String getCheckId() {
        return checkId;
    }

    /**
     * 考评类型 (活动分/诚信分/素养积分)
     * @param checkId
     */
    public void setCheckId(String checkId) {
        this.checkId = checkId == null ? null : checkId.trim();
    }

    /**
     * 操作类型 加分 plus /减分 reduce
     * @return OPER_TYPE
     */
    public String getOperType() {
        return operType;
    }

    /**
     * 操作类型 加分 plus /减分 reduce
     * @param operType
     */
    public void setOperType(String operType) {
        this.operType = operType == null ? null : operType.trim();
    }

    /**
     * 操作分值
     * @return OPER_SCORE
     */
    public BigDecimal getOperScore() {
        return operScore;
    }

    /**
     * 操作分值
     * @param operScore
     */
    public void setOperScore(BigDecimal operScore) {
        this.operScore = operScore;
    }

    /**
     * 操作原因
     * @return OPER_REASON
     */
    public String getOperReason() {
        return operReason;
    }

    /**
     * 操作原因
     * @param operReason
     */
    public void setOperReason(String operReason) {
        this.operReason = operReason == null ? null : operReason.trim();
    }

    /**
     * 操作时间
     * @return OPER_TIME
     */
    public String getOperTime() {
        return operTime;
    }

    /**
     * 操作时间
     * @param operTime
     */
    public void setOperTime(String operTime) {
        this.operTime = operTime == null ? null : operTime.trim();
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
package com.maiyue.weixin.business.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.maiyue.weixin.bean.BaseSort;

import io.swagger.annotations.ApiModelProperty;

public class Payment extends BaseSort implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 8177036496737284678L;

	/**
    * ID标识
    * 字段名:ID
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="id",value="ID标识",dataType="String")
    private String id;

    /**
    * 最后处理人/经手人ID
    * 字段名:HUMAN_ID
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="humanId",value="最后处理人/经手人ID",dataType="String")
    private String humanId;

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
    * 缴纳账户
    * 字段名:TRANSFER_ACCOUNTS
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="transferAccounts",value="缴纳账户",dataType="String")
    private String transferAccounts;

    /**
    * 收入账户
    * 字段名:INCOME_ACCOUNTS
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="incomeAccounts",value="收入账户",dataType="String")
    private String incomeAccounts;

    /**
    * 缴费方式  0 网上转账 1 现金缴纳 2、物质抵押
    * 字段名:PAY_TYPE
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="payType",value="缴费方式  0 网上转账 1 现金缴纳 2、物质抵押",dataType="String")
    private String payType;

    /**
    * 用途
    * 字段名:PURPOSE
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="purpose",value="用途",dataType="String")
    private String purpose;

    /**
    * 金额
    * 字段名:MONEY
    * 类型:DECIMAL
     */
    @ApiModelProperty(name="money",value="金额",dataType="BigDecimal")
    private BigDecimal money;

    /**
    * 缴费日期
    * 字段名:PAY_DATE
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="payDate",value="缴费日期",dataType="String")
    private String payDate;

    /**
    * 创建时间
    * 字段名:CREATE_TIME
    * 类型:TIMESTAMP
     */
    @ApiModelProperty(name="createTime",value="创建时间",dataType="Date")
    private Date createTime;

    /**
    * 缴费状态   0 缴费成功 1 缴费失败
    * 字段名:PAY_STATE
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="payState",value="缴费状态   0 缴费成功 1 缴费失败",dataType="String")
    private String payState;

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
     * 最后处理人/经手人ID
     * @return HUMAN_ID
     */
    public String getHumanId() {
        return humanId;
    }

    /**
     * 最后处理人/经手人ID
     * @param humanId
     */
    public void setHumanId(String humanId) {
        this.humanId = humanId == null ? null : humanId.trim();
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
     * 缴纳账户
     * @return TRANSFER_ACCOUNTS
     */
    public String getTransferAccounts() {
        return transferAccounts;
    }

    /**
     * 缴纳账户
     * @param transferAccounts
     */
    public void setTransferAccounts(String transferAccounts) {
        this.transferAccounts = transferAccounts == null ? null : transferAccounts.trim();
    }

    /**
     * 收入账户
     * @return INCOME_ACCOUNTS
     */
    public String getIncomeAccounts() {
        return incomeAccounts;
    }

    /**
     * 收入账户
     * @param incomeAccounts
     */
    public void setIncomeAccounts(String incomeAccounts) {
        this.incomeAccounts = incomeAccounts == null ? null : incomeAccounts.trim();
    }

    /**
     * 缴费方式  0 网上转账 1 现金缴纳 2、物质抵押
     * @return PAY_TYPE
     */
    public String getPayType() {
        return payType;
    }

    /**
     * 缴费方式  0 网上转账 1 现金缴纳 2、物质抵押
     * @param payType
     */
    public void setPayType(String payType) {
        this.payType = payType == null ? null : payType.trim();
    }

    /**
     * 用途
     * @return PURPOSE
     */
    public String getPurpose() {
        return purpose;
    }

    /**
     * 用途
     * @param purpose
     */
    public void setPurpose(String purpose) {
        this.purpose = purpose == null ? null : purpose.trim();
    }

    /**
     * 金额
     * @return MONEY
     */
    public BigDecimal getMoney() {
        return money;
    }

    /**
     * 金额
     * @param money
     */
    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    /**
     * 缴费日期
     * @return PAY_DATE
     */
    public String getPayDate() {
        return payDate;
    }

    /**
     * 缴费日期
     * @param payDate
     */
    public void setPayDate(String payDate) {
        this.payDate = payDate == null ? null : payDate.trim();
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
     * 缴费状态   0 缴费成功 1 缴费失败
     * @return PAY_STATE
     */
    public String getPayState() {
        return payState;
    }

    /**
     * 缴费状态   0 缴费成功 1 缴费失败
     * @param payState
     */
    public void setPayState(String payState) {
        this.payState = payState == null ? null : payState.trim();
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
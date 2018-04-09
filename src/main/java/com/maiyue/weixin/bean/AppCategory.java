package com.maiyue.app.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class AppCategory extends BaseSort implements Serializable{
    
	/**
	 * 
	 */
	private static final long serialVersionUID = -7763392043400074061L;

	/**
    * ID标识
    * 字段名:ID
    * 类型:VARCHAR
     */
    private String id;

    /**
    * 类别名称
    * 字段名:NAME
    * 类型:VARCHAR
     */
    private String name;

    /**
    * 类别详情
    * 字段名:DETAILS
    * 类型:VARCHAR
     */
    private String details;

    /**
    * 创建时间
    * 字段名:CREATE_TIME
    * 类型:TIMESTAMP
     */
    private Date createTime;

    /**
    * 应用数量
    * 字段名:APP_NUM
    * 类型:DECIMAL
     */
    private BigDecimal appNum;

    /**
    * 待审核数量
    * 字段名:PENDING_NUM
    * 类型:DECIMAL
     */
    private BigDecimal pendingNum;

    /**
    * 审核通过数
    * 字段名:REVIEW_PASS_NUM
    * 类型:DECIMAL
     */
    private BigDecimal reviewPassNum;

    /**
    * 审核不过数
    * 字段名:REVIEW_NOPASS_NUM
    * 类型:DECIMAL
     */
    private BigDecimal reviewNopassNum;

    /**
    * 下架数量
    * 字段名:SHELF_OFF_NUM
    * 类型:DECIMAL
     */
    private BigDecimal shelfOffNum;

    /**
    * 状态
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
     * 类别名称
     * @return NAME
     */
    public String getName() {
        return name;
    }

    /**
     * 类别名称
     * @param name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 类别详情
     * @return DETAILS
     */
    public String getDetails() {
        return details;
    }

    /**
     * 类别详情
     * @param details
     */
    public void setDetails(String details) {
        this.details = details == null ? null : details.trim();
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
     * 应用数量
     * @return APP_NUM
     */
    public BigDecimal getAppNum() {
        return appNum;
    }

    /**
     * 应用数量
     * @param appNum
     */
    public void setAppNum(BigDecimal appNum) {
        this.appNum = appNum;
    }

    /**
     * 待审核数量
     * @return PENDING_NUM
     */
    public BigDecimal getPendingNum() {
        return pendingNum;
    }

    /**
     * 待审核数量
     * @param pendingNum
     */
    public void setPendingNum(BigDecimal pendingNum) {
        this.pendingNum = pendingNum;
    }

    /**
     * 审核通过数
     * @return REVIEW_PASS_NUM
     */
    public BigDecimal getReviewPassNum() {
        return reviewPassNum;
    }

    /**
     * 审核通过数
     * @param reviewPassNum
     */
    public void setReviewPassNum(BigDecimal reviewPassNum) {
        this.reviewPassNum = reviewPassNum;
    }

    /**
     * 审核不过数
     * @return REVIEW_NOPASS_NUM
     */
    public BigDecimal getReviewNopassNum() {
        return reviewNopassNum;
    }

    /**
     * 审核不过数
     * @param reviewNopassNum
     */
    public void setReviewNopassNum(BigDecimal reviewNopassNum) {
        this.reviewNopassNum = reviewNopassNum;
    }

    /**
     * 下架数量
     * @return SHELF_OFF_NUM
     */
    public BigDecimal getShelfOffNum() {
        return shelfOffNum;
    }

    /**
     * 下架数量
     * @param shelfOffNum
     */
    public void setShelfOffNum(BigDecimal shelfOffNum) {
        this.shelfOffNum = shelfOffNum;
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
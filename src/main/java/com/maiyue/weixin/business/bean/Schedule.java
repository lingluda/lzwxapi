package com.maiyue.weixin.business.bean;

import java.io.Serializable;
import java.util.Date;

import com.maiyue.weixin.bean.BaseSort;

import io.swagger.annotations.ApiModelProperty;

public class Schedule extends BaseSort implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -2643906658009181133L;

	/**
    * id标识
    * 字段名:ID
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="id",value="id标识",dataType="String")
    private String id;

    /**
    * 学年
    * 字段名:TERM_YEAR
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="termYear",value="学年",dataType="String")
    private String termYear;

    /**
    * 学期
    * 字段名:TERM_ID
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="termId",value="学期",dataType="String")
    private String termId;

    /**
    * 班级ID
    * 字段名:CLASS_ID
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="classId",value="班级ID",dataType="String")
    private String classId;

    /**
    * 课程表名称
    * 字段名:SCHEDULE_NAME
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="scheduleName",value="课程表名称",dataType="String")
    private String scheduleName;

    /**
    * 周数
    * 字段名:WEEKS_NUM
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="weeksNum",value="周数",dataType="String")
    private String weeksNum;

    /**
    * 创建时间
    * 字段名:CREATE_TIME
    * 类型:TIMESTAMP
     */
    @ApiModelProperty(name="createTime",value="创建时间",dataType="Date")
    private Date createTime;

    /**
    * 状态 0 正常 -1 删除 1 锁定
    * 字段名:STATR
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="statr",value="状态 0 正常 -1 删除 1 锁定",dataType="String")
    private String statr;

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
     * 学期
     * @return TERM_ID
     */
    public String getTermId() {
        return termId;
    }

    /**
     * 学期
     * @param termId
     */
    public void setTermId(String termId) {
        this.termId = termId == null ? null : termId.trim();
    }

    /**
     * 班级ID
     * @return CLASS_ID
     */
    public String getClassId() {
        return classId;
    }

    /**
     * 班级ID
     * @param classId
     */
    public void setClassId(String classId) {
        this.classId = classId == null ? null : classId.trim();
    }

    /**
     * 课程表名称
     * @return SCHEDULE_NAME
     */
    public String getScheduleName() {
        return scheduleName;
    }

    /**
     * 课程表名称
     * @param scheduleName
     */
    public void setScheduleName(String scheduleName) {
        this.scheduleName = scheduleName == null ? null : scheduleName.trim();
    }

    /**
     * 周数
     * @return WEEKS_NUM
     */
    public String getWeeksNum() {
        return weeksNum;
    }

    /**
     * 周数
     * @param weeksNum
     */
    public void setWeeksNum(String weeksNum) {
        this.weeksNum = weeksNum == null ? null : weeksNum.trim();
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
     * 状态 0 正常 -1 删除 1 锁定
     * @return STATR
     */
    public String getStatr() {
        return statr;
    }

    /**
     * 状态 0 正常 -1 删除 1 锁定
     * @param statr
     */
    public void setStatr(String statr) {
        this.statr = statr == null ? null : statr.trim();
    }
}
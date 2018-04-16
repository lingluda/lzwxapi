package com.maiyue.weixin.base.bean;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

public class Classes {
    /**
    * 班级id
    * 字段名:ID
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="id",value="班级id",dataType="String")
    private String id;

    /**
    * 班级代码
    * 字段名:CLASSES_CODE
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="classesCode",value="班级代码",dataType="String")
    private String classesCode;

    /**
    * 班级名称
    * 字段名:NAME
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="name",value="班级名称",dataType="String")
    private String name;

    /**
    * 班级所属学院
    * 字段名:DEPT_CODE
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="deptCode",value="班级所属学院",dataType="String")
    private String deptCode;

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
    * 年级
    * 字段名:GRADE
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="grade",value="年级",dataType="String")
    private String grade;

    /**
     * 班级id
     * @return ID
     */
    public String getId() {
        return id;
    }

    /**
     * 班级id
     * @param id
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 班级代码
     * @return CLASSES_CODE
     */
    public String getClassesCode() {
        return classesCode;
    }

    /**
     * 班级代码
     * @param classesCode
     */
    public void setClassesCode(String classesCode) {
        this.classesCode = classesCode == null ? null : classesCode.trim();
    }

    /**
     * 班级名称
     * @return NAME
     */
    public String getName() {
        return name;
    }

    /**
     * 班级名称
     * @param name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 班级所属学院
     * @return DEPT_CODE
     */
    public String getDeptCode() {
        return deptCode;
    }

    /**
     * 班级所属学院
     * @param deptCode
     */
    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode == null ? null : deptCode.trim();
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

    /**
     * 年级
     * @return GRADE
     */
    public String getGrade() {
        return grade;
    }

    /**
     * 年级
     * @param grade
     */
    public void setGrade(String grade) {
        this.grade = grade == null ? null : grade.trim();
    }
}
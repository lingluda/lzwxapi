package com.maiyue.weixin.base.bean;

import io.swagger.annotations.ApiModelProperty;

public class Major {
    /**
    * 专业ID
    * 字段名:ID
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="id",value="专业ID",dataType="String")
    private String id;

    /**
    * 专业代码
    * 字段名:MAJOR_CODE
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="majorCode",value="专业代码",dataType="String")
    private String majorCode;

    /**
    * 专业名称
    * 字段名:NAME
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="name",value="专业名称",dataType="String")
    private String name;

    /**
    * 专业所属学院
    * 字段名:DEPT_CODE
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="deptCode",value="专业所属学院",dataType="String")
    private String deptCode;

    /**
    * 创建时间
    * 字段名:CREATE_TIME
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="createTime",value="创建时间",dataType="String")
    private String createTime;

    /**
    * 状态 0 正常 -1 删除 1锁定
    * 字段名:STATE
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="state",value="状态 0 正常 -1 删除 1锁定",dataType="String")
    private String state;

    /**
     * 专业ID
     * @return ID
     */
    public String getId() {
        return id;
    }

    /**
     * 专业ID
     * @param id
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 专业代码
     * @return MAJOR_CODE
     */
    public String getMajorCode() {
        return majorCode;
    }

    /**
     * 专业代码
     * @param majorCode
     */
    public void setMajorCode(String majorCode) {
        this.majorCode = majorCode == null ? null : majorCode.trim();
    }

    /**
     * 专业名称
     * @return NAME
     */
    public String getName() {
        return name;
    }

    /**
     * 专业名称
     * @param name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 专业所属学院
     * @return DEPT_CODE
     */
    public String getDeptCode() {
        return deptCode;
    }

    /**
     * 专业所属学院
     * @param deptCode
     */
    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode == null ? null : deptCode.trim();
    }

    /**
     * 创建时间
     * @return CREATE_TIME
     */
    public String getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     * @param createTime
     */
    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
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
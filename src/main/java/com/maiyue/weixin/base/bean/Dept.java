package com.maiyue.weixin.base.bean;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

public class Dept {
    /**
    * 院系ID
    * 字段名:ID
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="id",value="院系ID",dataType="String")
    private String id;

    /**
    * 院系代码
    * 字段名:DEPT_CODE
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="deptCode",value="院系代码",dataType="String")
    private String deptCode;

    /**
    * 院系名称
    * 字段名:NAME
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="name",value="院系名称",dataType="String")
    private String name;

    /**
    * 类型(0,教育部门;1,行政部门)
    * 字段名:TYPE
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="type",value="类型(0,教育部门;1,行政部门)",dataType="String")
    private String type;

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
     * 院系ID
     * @return ID
     */
    public String getId() {
        return id;
    }

    /**
     * 院系ID
     * @param id
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 院系代码
     * @return DEPT_CODE
     */
    public String getDeptCode() {
        return deptCode;
    }

    /**
     * 院系代码
     * @param deptCode
     */
    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode == null ? null : deptCode.trim();
    }

    /**
     * 院系名称
     * @return NAME
     */
    public String getName() {
        return name;
    }

    /**
     * 院系名称
     * @param name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 类型(0,教育部门;1,行政部门)
     * @return TYPE
     */
    public String getType() {
        return type;
    }

    /**
     * 类型(0,教育部门;1,行政部门)
     * @param type
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
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
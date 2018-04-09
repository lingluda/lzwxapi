package com.maiyue.app.bean;

import java.io.Serializable;
import java.util.Date;

public class Admodule extends BaseSort implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 4095739083005763409L;

	/**
    * id
    * 字段名:ID
    * 类型:VARCHAR
     */
    private String id;

    /**
    * 用户ID
    * 字段名:USER_ID
    * 类型:VARCHAR
     */
    private String userId;

    /**
    * 模块名称
    * 字段名:MODULE_NAME
    * 类型:VARCHAR
     */
    private String moduleName;

    /**
    * 模块位置
    * 字段名:MODULE_POSITION
    * 类型:VARCHAR
     */
    private String modulePosition;

    /**
    * 模块地址
    * 字段名:MODULE_ADDRESS
    * 类型:VARCHAR
     */
    private String moduleAddress;

    /**
    * 创建时间
    * 字段名:CREATE_TIME
    * 类型:TIMESTAMP
     */
    private Date createTime;

    /**
    * 状态  0 正常 -1 停用
    * 字段名:STATE
    * 类型:VARCHAR
     */
    private String state;

    /**
     * id
     * @return ID
     */
    public String getId() {
        return id;
    }

    /**
     * id
     * @param id
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 用户ID
     * @return USER_ID
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 用户ID
     * @param userId
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * 模块名称
     * @return MODULE_NAME
     */
    public String getModuleName() {
        return moduleName;
    }

    /**
     * 模块名称
     * @param moduleName
     */
    public void setModuleName(String moduleName) {
        this.moduleName = moduleName == null ? null : moduleName.trim();
    }

    /**
     * 模块位置
     * @return MODULE_POSITION
     */
    public String getModulePosition() {
        return modulePosition;
    }

    /**
     * 模块位置
     * @param modulePosition
     */
    public void setModulePosition(String modulePosition) {
        this.modulePosition = modulePosition == null ? null : modulePosition.trim();
    }

    /**
     * 模块地址
     * @return MODULE_ADDRESS
     */
    public String getModuleAddress() {
        return moduleAddress;
    }

    /**
     * 模块地址
     * @param moduleAddress
     */
    public void setModuleAddress(String moduleAddress) {
        this.moduleAddress = moduleAddress == null ? null : moduleAddress.trim();
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
     * 状态  0 正常 -1 停用
     * @return STATE
     */
    public String getState() {
        return state;
    }

    /**
     * 状态  0 正常 -1 停用
     * @param state
     */
    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }
}
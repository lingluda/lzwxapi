package com.maiyue.app.bean;

import java.io.Serializable;
import java.util.Date;

public class HeadImage extends BaseSort implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 8590517502324395312L;

	/**
    * ID
    * 字段名:ID
    * 类型:VARCHAR
     */
    private String id;

    /**
    * user_id
    * 字段名:USER_ID
    * 类型:VARCHAR
     */
    private String userId;

    /**
    * 头像别名
    * 字段名:HEAD_ALIAS
    * 类型:VARCHAR
     */
    private String headAlias;

    /**
    * 头像地址
    * 字段名:HEAD_ADDRESS
    * 类型:VARCHAR
     */
    private String headAddress;

    /**
    * 头像所在盘
    * 字段名:HEAD_DISK
    * 类型:VARCHAR
     */
    private String headDisk;

    /**
    * 创建时间
    * 字段名:CREATE_TIME
    * 类型:TIMESTAMP
     */
    private Date createTime;

    /**
    * 状态 0 正常  -1 删除
    * 字段名:STATE
    * 类型:VARCHAR
     */
    private String state;

    /**
     * ID
     * @return ID
     */
    public String getId() {
        return id;
    }

    /**
     * ID
     * @param id
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * user_id
     * @return USER_ID
     */
    public String getUserId() {
        return userId;
    }

    /**
     * user_id
     * @param userId
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * 头像别名
     * @return HEAD_ALIAS
     */
    public String getHeadAlias() {
        return headAlias;
    }

    /**
     * 头像别名
     * @param headAlias
     */
    public void setHeadAlias(String headAlias) {
        this.headAlias = headAlias == null ? null : headAlias.trim();
    }

    /**
     * 头像地址
     * @return HEAD_ADDRESS
     */
    public String getHeadAddress() {
        return headAddress;
    }

    /**
     * 头像地址
     * @param headAddress
     */
    public void setHeadAddress(String headAddress) {
        this.headAddress = headAddress == null ? null : headAddress.trim();
    }

    /**
     * 头像所在盘
     * @return HEAD_DISK
     */
    public String getHeadDisk() {
        return headDisk;
    }

    /**
     * 头像所在盘
     * @param headDisk
     */
    public void setHeadDisk(String headDisk) {
        this.headDisk = headDisk == null ? null : headDisk.trim();
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
     * 状态 0 正常  -1 删除
     * @return STATE
     */
    public String getState() {
        return state;
    }

    /**
     * 状态 0 正常  -1 删除
     * @param state
     */
    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }
}
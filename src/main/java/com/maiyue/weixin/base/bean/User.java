package com.maiyue.weixin.base.bean;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable{

	/**
    * ID标识
    * 字段名:ID
    * 类型:VARCHAR
     */
    private String id;

    /**
    * 用户名
    * 字段名:USERNAME
    * 类型:VARCHAR
     */
    private String username;

    /**
    * 密码
    * 字段名:PASSWORD
    * 类型:VARCHAR
     */
    private String password;

    /**
    * 创建时间
    * 字段名:CREATETIME
    * 类型:TIMESTAMP
     */
    private Date createtime;

    /**
    * 状态 0 正常 -1 停用 1锁定
    * 字段名:STATUS
    * 类型:VARCHAR
     */
    private String status;

    /**
    * 类型 0 管理员 1 领导 2 教师 3 学生 4游客
    * 字段名:TYPE
    * 类型:VARCHAR
     */
    private String type;

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
     * 用户名
     * @return USERNAME
     */
    public String getUsername() {
        return username;
    }

    /**
     * 用户名
     * @param username
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * 密码
     * @return PASSWORD
     */
    public String getPassword() {
        return password;
    }

    /**
     * 密码
     * @param password
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 创建时间
     * @return CREATETIME
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * 创建时间
     * @param createtime
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * 状态 0 正常 -1 停用 1锁定
     * @return STATUS
     */
    public String getStatus() {
        return status;
    }

    /**
     * 状态 0 正常 -1 停用 1锁定
     * @param status
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * 类型 0 管理员 1 领导 2 教师 3 学生 4游客
     * @return TYPE
     */
    public String getType() {
        return type;
    }

    /**
     * 类型 0 管理员 1 领导 2 教师 3 学生 4游客
     * @param type
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    
	/*@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("{id:'").append(id).append("', username:'").append(username).append("', status:'").append(status)
				.append("', type:'").append(type).append("'}");
		return builder.toString();
	}*/
    
    
    
    
    
    
}
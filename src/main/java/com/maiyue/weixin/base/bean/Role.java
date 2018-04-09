package com.maiyue.weixin.base.bean;

import java.util.Date;

public class Role {
    /**
    * ID标识
    * 字段名:ID
    * 类型:VARCHAR
     */
    private String id;

    /**
    * 角色名称标识
    * 字段名:NAME
    * 类型:VARCHAR
     */
    private String name;

    /**
    * 创建时间
    * 字段名:CREATETIME
    * 类型:TIMESTAMP
     */
    private Date createtime;

    /**
    * 状态 0 正常 -1 停用 1 锁定
    * 字段名:STATUS
    * 类型:VARCHAR
     */
    private String status;

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
     * 角色名称标识
     * @return NAME
     */
    public String getName() {
        return name;
    }

    /**
     * 角色名称标识
     * @param name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
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
     * 状态 0 正常 -1 停用 1 锁定
     * @return STATUS
     */
    public String getStatus() {
        return status;
    }

    /**
     * 状态 0 正常 -1 停用 1 锁定
     * @param status
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
}
package com.maiyue.weixin.base.bean;

import java.util.Date;

public class UserRole {
    /**
    * Id标识
    * 字段名:ID
    * 类型:VARCHAR
     */
    private String id;

    /**
    * 角色ID
    * 字段名:RID
    * 类型:VARCHAR
     */
    private String rid;

    /**
    * 用户ID
    * 字段名:USERID
    * 类型:VARCHAR
     */
    private String userid;

    /**
    * 创建时间
    * 字段名:CREATETIME
    * 类型:TIMESTAMP
     */
    private Date createtime;

    /**
     * Id标识
     * @return ID
     */
    public String getId() {
        return id;
    }

    /**
     * Id标识
     * @param id
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 角色ID
     * @return RID
     */
    public String getRid() {
        return rid;
    }

    /**
     * 角色ID
     * @param rid
     */
    public void setRid(String rid) {
        this.rid = rid == null ? null : rid.trim();
    }

    /**
     * 用户ID
     * @return USERID
     */
    public String getUserid() {
        return userid;
    }

    /**
     * 用户ID
     * @param userid
     */
    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
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
}
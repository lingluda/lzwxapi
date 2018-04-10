package com.maiyue.weixin.base.bean;

import java.io.Serializable;
import java.util.Date;

import com.maiyue.weixin.bean.BaseSort;

public class RolePermission extends BaseSort implements Serializable{
   
	private static final long serialVersionUID = -2049097834721493533L;

	/**
    * 角色ID标识
    * 字段名:RID
    * 类型:VARCHAR
     */
    private String rid;

    /**
    * 权限标识
    * 字段名:PID
    * 类型:VARCHAR
     */
    private String pid;

    /**
    * 创建时间
    * 字段名:CREATETIME
    * 类型:TIMESTAMP
     */
    private Date createtime;

    /**
     * 角色ID标识
     * @return RID
     */
    public String getRid() {
        return rid;
    }

    /**
     * 角色ID标识
     * @param rid
     */
    public void setRid(String rid) {
        this.rid = rid == null ? null : rid.trim();
    }

    /**
     * 权限标识
     * @return PID
     */
    public String getPid() {
        return pid;
    }

    /**
     * 权限标识
     * @param pid
     */
    public void setPid(String pid) {
        this.pid = pid == null ? null : pid.trim();
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
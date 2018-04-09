package com.maiyue.app.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * manager_task_info表的实体类
 * @author huang
 * 2018/01/16
 */
public class ManagerTaskInfo extends BaseSort implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -570912267307563644L;

	/**
    * ID
    * 字段名:id
    * 类型:VARCHAR
     */
    private String id;

    /**
    * 任务名称
    * 字段名:task_name
    * 类型:VARCHAR
     */
    private String taskName;

    /**
    * 任务分组
    * 字段名:task_group
    * 类型:VARCHAR
     */
    private String taskGroup;

    /**
    * job类的包路径
    * 字段名:cls_name
    * 类型:VARCHAR
     */
    private String clsName;

    /**
    * cron表达式
    * 字段名:express
    * 类型:VARCHAR
     */
    private String express;

    /**
    * 状态,1启用,0停用
    * 字段名:status
    * 类型:INTEGER
     */
    private Integer status;

    /**
    * 创建时间
    * 字段名:create_time
    * 类型:TIMESTAMP
     */
    private Date createTime;

    /**
    * 备注
    * 字段名:remark
    * 类型:LONGVARCHAR
     */
    private String remark;

    /**
     * ID
     * @return id
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
     * 任务名称
     * @return task_name
     */
    public String getTaskName() {
        return taskName;
    }

    /**
     * 任务名称
     * @param taskName
     */
    public void setTaskName(String taskName) {
        this.taskName = taskName == null ? null : taskName.trim();
    }

    /**
     * 任务分组
     * @return task_group
     */
    public String getTaskGroup() {
        return taskGroup;
    }

    /**
     * 任务分组
     * @param taskGroup
     */
    public void setTaskGroup(String taskGroup) {
        this.taskGroup = taskGroup == null ? null : taskGroup.trim();
    }

    /**
     * job类的包路径
     * @return cls_name
     */
    public String getClsName() {
        return clsName;
    }

    /**
     * job类的包路径
     * @param clsName
     */
    public void setClsName(String clsName) {
        this.clsName = clsName == null ? null : clsName.trim();
    }

    /**
     * cron表达式
     * @return express
     */
    public String getExpress() {
        return express;
    }

    /**
     * cron表达式
     * @param express
     */
    public void setExpress(String express) {
        this.express = express == null ? null : express.trim();
    }

    /**
     * 状态,1启用,0停用
     * @return status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 状态,1启用,0停用
     * @param status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 创建时间
     * @return create_time
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
     * 备注
     * @return remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 备注
     * @param remark
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}
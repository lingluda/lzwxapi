package com.maiyue.weixin.base.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.maiyue.weixin.bean.BaseSort;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="权限实体信息",description="")
public class Permission extends BaseSort implements Serializable{
   
	private static final long serialVersionUID = -7944021604772793227L;

	/**
    * ID标识
    * 字段名:ID
    * 类型:VARCHAR
     */
	@ApiModelProperty(name="id",value="ID唯一标识",required=false,dataType="String")
    private String id;

    /**
    * 权限标识
    * 字段名:PID
    * 类型:VARCHAR
     */
	@ApiModelProperty(name="pid",value="权限标记唯一标识",required=false,dataType="String")
    private String pid;

    /**
    * 权限名称
    * 字段名:PNAME
    * 类型:VARCHAR
     */
	@ApiModelProperty(name="pname",value="权限名称",required=false,dataType="String")
    private String pname;

    /**
    * 创建时间
    * 字段名:CREATETIME
    * 类型:TIMESTAMP
     */
	@ApiModelProperty(name="createtime",value="创建时间",required=false,dataType="Date")
    private Date createtime;

    /**
    * 权限类型
    * 字段名:PTYPE
    * 类型:VARCHAR
     */
	@ApiModelProperty(name="ptype",value="权限类型",required=false,dataType="String")
    private String ptype;

    /**
    * 权限URL
    * 字段名:URL
    * 类型:VARCHAR
     */
	@ApiModelProperty(name="url",value="权限URL",required=false,dataType="String")
    private String url;

    /**
    * 权限排序
    * 字段名:SORT
    * 类型:DECIMAL
     */
	@ApiModelProperty(name="sort",value="权限排序",required=false,dataType="long")
    private BigDecimal sort;

    /**
    * 权限卡片
    * 字段名:CARD
    * 类型:VARCHAR
     */
	@ApiModelProperty(name="card",value="权限卡片",required=false,dataType="String")
    private String card;

    /**
    * 权限卡片地址
    * 字段名:CARD_URL
    * 类型:VARCHAR
     */
	@ApiModelProperty(name="cardUrl",value="权限卡片地址",required=false,dataType="String")
    private String cardUrl;

    /**
    * 上级ID
    * 字段名:PARENT_ID
    * 类型:VARCHAR
     */
	@ApiModelProperty(name="parentId",value="上级ID",required=false,dataType="String")
    private String parentId;

    /**
     * 状态 0 正常 -1 停用 1 锁定
     * 字段名:STATUS
     * 类型:VARCHAR
      */
	 @ApiModelProperty(name="status",value="状态 0 正常 -1 停用 1 锁定",required=false,dataType="String")
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
     * 权限名称
     * @return PNAME
     */
    public String getPname() {
        return pname;
    }

    /**
     * 权限名称
     * @param pname
     */
    public void setPname(String pname) {
        this.pname = pname == null ? null : pname.trim();
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

    /**
     * 权限类型
     * @return PTYPE
     */
    public String getPtype() {
        return ptype;
    }

    /**
     * 权限类型
     * @param ptype
     */
    public void setPtype(String ptype) {
        this.ptype = ptype == null ? null : ptype.trim();
    }

    /**
     * 权限URL
     * @return URL
     */
    public String getUrl() {
        return url;
    }

    /**
     * 权限URL
     * @param url
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * 权限排序
     * @return SORT
     */
    public BigDecimal getSort() {
        return sort;
    }

    /**
     * 权限排序
     * @param sort
     */
    public void setSort(BigDecimal sort) {
        this.sort = sort;
    }

    /**
     * 权限卡片
     * @return CARD
     */
    public String getCard() {
        return card;
    }

    /**
     * 权限卡片
     * @param card
     */
    public void setCard(String card) {
        this.card = card == null ? null : card.trim();
    }

    /**
     * 权限卡片地址
     * @return CARD_URL
     */
    public String getCardUrl() {
        return cardUrl;
    }

    /**
     * 权限卡片地址
     * @param cardUrl
     */
    public void setCardUrl(String cardUrl) {
        this.cardUrl = cardUrl == null ? null : cardUrl.trim();
    }

    /**
     * 上级ID
     * @return PARENT_ID
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * 上级ID
     * @param parentId
     */
    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
    }
}
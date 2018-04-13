package com.maiyue.weixin.business.bean;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

public class ExternalLinks {
    /**
    * ID
    * 字段名:ID
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="id",value="ID",dataType="String")
    private String id;

    /**
    * 链接名称
    * 字段名:LINK_NAME
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="linkName",value="链接名称",dataType="String")
    private String linkName;

    /**
    * 弹窗 / 跳转 Pop-up / jump
    * 字段名:OPEN_MODE
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="openMode",value="弹窗 / 跳转 Pop-up / jump",dataType="String")
    private String openMode;

    /**
    * 链接URL
    * 字段名:LINK_URL
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="linkUrl",value="链接URL",dataType="String")
    private String linkUrl;

    /**
    * 链接图片地址
    * 字段名:LINK_PICTURE
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="linkPicture",value="链接图片地址",dataType="String")
    private String linkPicture;

    /**
    * 公开类型 All / teacher / student / Leader
    * 字段名:OPEN_TYPE
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="openType",value="公开类型 All / teacher / student / Leader",dataType="String")
    private String openType;

    /**
    * 创建时间
    * 字段名:CREATE_TIME
    * 类型:TIMESTAMP
     */
    @ApiModelProperty(name="createTime",value="创建时间",dataType="Date")
    private Date createTime;

    /**
    * 状态 0 正常 -1 删除 1 锁定
    * 字段名:STATE
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="state",value="状态 0 正常 -1 删除 1 锁定",dataType="String")
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
     * 链接名称
     * @return LINK_NAME
     */
    public String getLinkName() {
        return linkName;
    }

    /**
     * 链接名称
     * @param linkName
     */
    public void setLinkName(String linkName) {
        this.linkName = linkName == null ? null : linkName.trim();
    }

    /**
     * 弹窗 / 跳转 Pop-up / jump
     * @return OPEN_MODE
     */
    public String getOpenMode() {
        return openMode;
    }

    /**
     * 弹窗 / 跳转 Pop-up / jump
     * @param openMode
     */
    public void setOpenMode(String openMode) {
        this.openMode = openMode == null ? null : openMode.trim();
    }

    /**
     * 链接URL
     * @return LINK_URL
     */
    public String getLinkUrl() {
        return linkUrl;
    }

    /**
     * 链接URL
     * @param linkUrl
     */
    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl == null ? null : linkUrl.trim();
    }

    /**
     * 链接图片地址
     * @return LINK_PICTURE
     */
    public String getLinkPicture() {
        return linkPicture;
    }

    /**
     * 链接图片地址
     * @param linkPicture
     */
    public void setLinkPicture(String linkPicture) {
        this.linkPicture = linkPicture == null ? null : linkPicture.trim();
    }

    /**
     * 公开类型 All / teacher / student / Leader
     * @return OPEN_TYPE
     */
    public String getOpenType() {
        return openType;
    }

    /**
     * 公开类型 All / teacher / student / Leader
     * @param openType
     */
    public void setOpenType(String openType) {
        this.openType = openType == null ? null : openType.trim();
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
     * 状态 0 正常 -1 删除 1 锁定
     * @return STATE
     */
    public String getState() {
        return state;
    }

    /**
     * 状态 0 正常 -1 删除 1 锁定
     * @param state
     */
    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }
}
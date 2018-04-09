package com.maiyue.app.bean;

import java.io.Serializable;

public class AppPicture extends BaseSort implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 2445991065931934035L;

	/**
    * ID标识
    * 字段名:ID
    * 类型:VARCHAR
     */
    private String id;

    /**
    * 应用ID
    * 字段名:APP_INFO_ID
    * 类型:VARCHAR
     */
    private String appInfoId;

    /**
    * 安装包ID
    * 字段名:APP_INSTALL_ID
    * 类型:VARCHAR
     */
    private String appInstallId;

    /**
    * 图片地址
    * 字段名:PICTURE_ADDERSS
    * 类型:VARCHAR
     */
    private String pictureAdderss;

    /**
    * 图片所在盘
    * 字段名:PICTURE_WHERE_DISK
    * 类型:VARCHAR
     */
    private String pictureWhereDisk;

    /**
    * 图片别名
    * 字段名:PICTURE_ALIAS
    * 类型:VARCHAR
     */
    private String pictureAlias;

    /**
    * 图片UUID名称
    * 字段名:PICTURE_UUID_NAME
    * 类型:VARCHAR
     */
    private String pictureUuidName;

    /**
    * 图片大小 KB
    * 字段名:PICTURE_SIZE
    * 类型:VARCHAR
     */
    private String pictureSize;

    /**
    * 审核结果  0 待审核  1 审核通过  -1审核不过
    * 字段名:AUDIT_RESULT
    * 类型:VARCHAR
     */
    private String auditResult;

    /**
    * 状态 -1 删除 0 正常
    * 字段名:PICTURE_STATE
    * 类型:VARCHAR
     */
    private String pictureState;

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
     * 应用ID
     * @return APP_INFO_ID
     */
    public String getAppInfoId() {
        return appInfoId;
    }

    /**
     * 应用ID
     * @param appInfoId
     */
    public void setAppInfoId(String appInfoId) {
        this.appInfoId = appInfoId == null ? null : appInfoId.trim();
    }

    /**
     * 安装包ID
     * @return APP_INSTALL_ID
     */
    public String getAppInstallId() {
        return appInstallId;
    }

    /**
     * 安装包ID
     * @param appInstallId
     */
    public void setAppInstallId(String appInstallId) {
        this.appInstallId = appInstallId == null ? null : appInstallId.trim();
    }

    /**
     * 图片地址
     * @return PICTURE_ADDERSS
     */
    public String getPictureAdderss() {
        return pictureAdderss;
    }

    /**
     * 图片地址
     * @param pictureAdderss
     */
    public void setPictureAdderss(String pictureAdderss) {
        this.pictureAdderss = pictureAdderss == null ? null : pictureAdderss.trim();
    }

    /**
     * 图片所在盘
     * @return PICTURE_WHERE_DISK
     */
    public String getPictureWhereDisk() {
        return pictureWhereDisk;
    }

    /**
     * 图片所在盘
     * @param pictureWhereDisk
     */
    public void setPictureWhereDisk(String pictureWhereDisk) {
        this.pictureWhereDisk = pictureWhereDisk == null ? null : pictureWhereDisk.trim();
    }

    /**
     * 图片别名
     * @return PICTURE_ALIAS
     */
    public String getPictureAlias() {
        return pictureAlias;
    }

    /**
     * 图片别名
     * @param pictureAlias
     */
    public void setPictureAlias(String pictureAlias) {
        this.pictureAlias = pictureAlias == null ? null : pictureAlias.trim();
    }

    /**
     * 图片UUID名称
     * @return PICTURE_UUID_NAME
     */
    public String getPictureUuidName() {
        return pictureUuidName;
    }

    /**
     * 图片UUID名称
     * @param pictureUuidName
     */
    public void setPictureUuidName(String pictureUuidName) {
        this.pictureUuidName = pictureUuidName == null ? null : pictureUuidName.trim();
    }

    /**
     * 图片大小 KB
     * @return PICTURE_SIZE
     */
    public String getPictureSize() {
        return pictureSize;
    }

    /**
     * 图片大小 KB
     * @param pictureSize
     */
    public void setPictureSize(String pictureSize) {
        this.pictureSize = pictureSize == null ? null : pictureSize.trim();
    }

    /**
     * 审核结果  0 待审核  1 审核通过  -1审核不过
     * @return AUDIT_RESULT
     */
    public String getAuditResult() {
        return auditResult;
    }

    /**
     * 审核结果  0 待审核  1 审核通过  -1审核不过
     * @param auditResult
     */
    public void setAuditResult(String auditResult) {
        this.auditResult = auditResult == null ? null : auditResult.trim();
    }

    /**
     * 状态 -1 删除 0 正常
     * @return PICTURE_STATE
     */
    public String getPictureState() {
        return pictureState;
    }

    /**
     * 状态 -1 删除 0 正常
     * @param pictureState
     */
    public void setPictureState(String pictureState) {
        this.pictureState = pictureState == null ? null : pictureState.trim();
    }
}
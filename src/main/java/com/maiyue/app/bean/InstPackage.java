package com.maiyue.app.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class InstPackage extends BaseSort implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 5780959627544102817L;

	/**
    * ID标识
    * 字段名:ID
    * 类型:VARCHAR
     */
    private String id;

    /**
    * 应用信息表ID
    * 字段名:APP_INFO_ID
    * 类型:VARCHAR
     */
    private String appInfoId;

    /**
    * 上传人ID
    * 字段名:USER_ID
    * 类型:VARCHAR
     */
    private String userId;

    /**
    * 上传人用户名
    * 字段名:USER_NAME
    * 类型:VARCHAR
     */
    private String userName;

    /**
    * 安装包别名
    * 字段名:INSTALL_ALIAS
    * 类型:VARCHAR
     */
    private String installAlias;

    /**
    * 安装包UUID名称
    * 字段名:INSTALL_UUID_NAME
    * 类型:VARCHAR
     */
    private String installUuidName;

    /**
    * 安装包版本
    * 字段名:INSTALL_VERSION
    * 类型:VARCHAR
     */
    private String installVersion;
    
    
    /**
    * 安装包地址
    * 字段名:INSTALL_ADDRESS
    * 类型:VARCHAR
     */
    private String installAddress;

    /**
    * 安装包所在盘
    * 字段名:INSTALL_WHERE_DISK
    * 类型:VARCHAR
     */
    private String installWhereDisk;

    /**
    * 安装包大小 MB
    * 字段名:INSTALL_SIZE
    * 类型:VARCHAR
     */
    private String installSize;

    /**
    * 详情
    * 字段名:DETAILS
    * 类型:VARCHAR
     */
    private String details;

    /**
    * 上传时间
    * 字段名:UPLOAD_TIME
    * 类型:TIMESTAMP
     */
    private Date uploadTime;

    /**
    * 审核结果  0 待审核  1 审核通过  -1审核不过
    * 字段名:AUDIT_RESULT
    * 类型:VARCHAR
     */
    private String auditResult;

    /**
    * 下载次数
    * 字段名:DOWNLOADS_NUM
    * 类型:DECIMAL
     */
    private BigDecimal downloadsNum;

    /**
    * 状态 0 正常 -1 下架
    * 字段名:INSTALL_STATE
    * 类型:VARCHAR
     */
    private String installState;

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
     * 应用信息表ID
     * @return APP_INFO_ID
     */
    public String getAppInfoId() {
        return appInfoId;
    }

    /**
     * 应用信息表ID
     * @param appInfoId
     */
    public void setAppInfoId(String appInfoId) {
        this.appInfoId = appInfoId == null ? null : appInfoId.trim();
    }

    /**
     * 上传人ID
     * @return USER_ID
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 上传人ID
     * @param userId
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * 上传人用户名
     * @return USER_NAME
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 上传人用户名
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * 安装包别名
     * @return INSTALL_ALIAS
     */
    public String getInstallAlias() {
        return installAlias;
    }

    /**
     * 安装包别名
     * @param installAlias
     */
    public void setInstallAlias(String installAlias) {
        this.installAlias = installAlias == null ? null : installAlias.trim();
    }

    /**
     * 安装包UUID名称
     * @return INSTALL_UUID_NAME
     */
    public String getInstallUuidName() {
        return installUuidName;
    }

    /**
     * 安装包UUID名称
     * @param installUuidName
     */
    public void setInstallUuidName(String installUuidName) {
        this.installUuidName = installUuidName == null ? null : installUuidName.trim();
    }

    /**
     * 安装包版本
     * @return INSTALL_VERSION
     */
    public String getInstallVersion() {
        return installVersion;
    }

    /**
     * 安装包版本
     * @param installVersion
     */
    public void setInstallVersion(String installVersion) {
        this.installVersion = installVersion == null ? null : installVersion.trim();
    }

    /**
     * 安装包地址
     * @return INSTALL_ADDRESS
     */
    public String getInstallAddress() {
        return installAddress;
    }

    /**
     * 安装包地址
     * @param installAddress
     */
    public void setInstallAddress(String installAddress) {
        this.installAddress = installAddress == null ? null : installAddress.trim();
    }

    /**
     * 安装包所在盘
     * @return INSTALL_WHERE_DISK
     */
    public String getInstallWhereDisk() {
        return installWhereDisk;
    }

    /**
     * 安装包所在盘
     * @param installWhereDisk
     */
    public void setInstallWhereDisk(String installWhereDisk) {
        this.installWhereDisk = installWhereDisk == null ? null : installWhereDisk.trim();
    }

    /**
     * 安装包大小 MB
     * @return INSTALL_SIZE
     */
    public String getInstallSize() {
        return installSize;
    }

    /**
     * 安装包大小 MB
     * @param installSize
     */
    public void setInstallSize(String installSize) {
        this.installSize = installSize == null ? null : installSize.trim();
    }

    /**
     * 详情
     * @return DETAILS
     */
    public String getDetails() {
        return details;
    }

    /**
     * 详情
     * @param details
     */
    public void setDetails(String details) {
        this.details = details == null ? null : details.trim();
    }

    /**
     * 上传时间
     * @return UPLOAD_TIME
     */
    public Date getUploadTime() {
        return uploadTime;
    }

    /**
     * 上传时间
     * @param uploadTime
     */
    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
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
     * 下载次数
     * @return DOWNLOADS_NUM
     */
    public BigDecimal getDownloadsNum() {
        return downloadsNum;
    }

    /**
     * 下载次数
     * @param downloadsNum
     */
    public void setDownloadsNum(BigDecimal downloadsNum) {
        this.downloadsNum = downloadsNum;
    }

    /**
     * 状态 0 正常 -1 下架
     * @return INSTALL_STATE
     */
    public String getInstallState() {
        return installState;
    }

    /**
     * 状态 0 正常 -1 下架
     * @param installState
     */
    public void setInstallState(String installState) {
        this.installState = installState == null ? null : installState.trim();
    }
}
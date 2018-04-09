package com.maiyue.app.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class AppInfo extends BaseSort implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -3640294509100861472L;

	/**
    * ID标识
    * 字段名:ID
    * 类型:VARCHAR
     */
    private String id;

    /**
    * APP分类
    * 字段名:APP_CATEGORY_ID
    * 类型:VARCHAR
     */
    private String appCategoryId;

    /**
    * 应用类型 IOS/Android
    * 字段名:APP_TYPE
    * 类型:VARCHAR
     */
    private String appType;

    /**
    * APP名称
    * 字段名:APP_NAME
    * 类型:VARCHAR
     */
    private String appName;

    /**
    * 当前版本
    * 字段名:CURRENT_VERSION
    * 类型:VARCHAR
     */
    private String currentVersion;

    /**
    * 应用详情
    * 字段名:APP_DETAILS
    * 类型:VARCHAR
     */
    private String appDetails;

    /**
    * 创建时间
    * 字段名:CREATE_TIME
    * 类型:TIMESTAMP
     */
    private Date createTime;

    /**
    * 状态   0 待审核  1审核通过  -1 审核不过
    * 字段名:AUDIT_RESULT
    * 类型:VARCHAR
     */
    private String auditResult;

    /**
    * 浏览次数
    * 字段名:BROWSE_NUM
    * 类型:DECIMAL
     */
    private BigDecimal browseNum;

    /**
    * 下载次数
    * 字段名:DOWNLOADS_NUM
    * 类型:DECIMAL
     */
    private BigDecimal downloadsNum;

    /**
    * 安装包数量
    * 字段名:INSTPACK_NUMR
    * 类型:DECIMAL
     */
    private BigDecimal instpackNum;

    /**
    * 状态   -1  下架   0 正常  
    * 字段名:APP_STATE
    * 类型:VARCHAR
     */
    private String appState;

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
     * APP分类
     * @return APP_CATEGORY_ID
     */
    public String getAppCategoryId() {
        return appCategoryId;
    }

    /**
     * APP分类
     * @param appCategoryId
     */
    public void setAppCategoryId(String appCategoryId) {
        this.appCategoryId = appCategoryId == null ? null : appCategoryId.trim();
    }

    /**
     * 应用类型 IOS/Android
     * @return APP_TYPE
     */
    public String getAppType() {
        return appType;
    }

    /**
     * 应用类型 IOS/Android
     * @param appType
     */
    public void setAppType(String appType) {
        this.appType = appType == null ? null : appType.trim();
    }

    /**
     * APP名称
     * @return APP_NAME
     */
    public String getAppName() {
        return appName;
    }

    /**
     * APP名称
     * @param appName
     */
    public void setAppName(String appName) {
        this.appName = appName == null ? null : appName.trim();
    }

    /**
     * 当前版本
     * @return CURRENT_VERSION
     */
    public String getCurrentVersion() {
        return currentVersion;
    }

    /**
     * 当前版本
     * @param currentVersion
     */
    public void setCurrentVersion(String currentVersion) {
        this.currentVersion = currentVersion == null ? null : currentVersion.trim();
    }

    /**
     * 应用详情
     * @return APP_DETAILS
     */
    public String getAppDetails() {
        return appDetails;
    }

    /**
     * 应用详情
     * @param appDetails
     */
    public void setAppDetails(String appDetails) {
        this.appDetails = appDetails == null ? null : appDetails.trim();
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
     * 状态   0 待审核  1审核通过  -1 审核不过
     * @return AUDIT_RESULT
     */
    public String getAuditResult() {
        return auditResult;
    }

    /**
     * 状态   0 待审核  1审核通过  -1 审核不过
     * @param auditResult
     */
    public void setAuditResult(String auditResult) {
        this.auditResult = auditResult == null ? null : auditResult.trim();
    }

    /**
     * 浏览次数
     * @return BROWSE_NUM
     */
    public BigDecimal getBrowseNum() {
        return browseNum;
    }

    /**
     * 浏览次数
     * @param browseNum
     */
    public void setBrowseNum(BigDecimal browseNum) {
        this.browseNum = browseNum;
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
     * 安装包数量
     * @return INSTPACK_NUMR
     */
    public BigDecimal getInstpackNum() {
        return instpackNum;
    }

    /**
     * 下载次数
     * @param instpackNumr
     */
    public void setInstpackNum(BigDecimal instpackNum) {
        this.instpackNum = instpackNum;
    }

    /**
     * 状态   -1  下架   0 正常  
     * @return APP_STATE
     */
    public String getAppState() {
        return appState;
    }

    /**
     * 状态   -1  下架   0 正常  
     * @param appState
     */
    public void setAppState(String appState) {
        this.appState = appState == null ? null : appState.trim();
    }
}
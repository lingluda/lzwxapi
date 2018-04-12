package com.maiyue.weixin.base.bean;

import java.io.Serializable;
import java.util.Date;

import com.maiyue.weixin.bean.BaseSort;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel(value="BaseFiles",description="文件表实体")
public class BaseFiles extends BaseSort implements Serializable{
    
	private static final long serialVersionUID = 1293039746303796742L;

	/**
    * ID
    * 字段名:ID
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="id",value="ID",dataType="String")
    private String id;

    /**
    * 生成文件名
    * 字段名:UUID_NAME
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="uuidName",value="生成文件名",dataType="String")
    private String uuidName;

    /**
    * 文件名称
    * 字段名:FILE_NAME
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="fileName",value="文件名称",dataType="String")
    private String fileName;

    /**
    * 文件大小
    * 字段名:FILE_SIZE
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="fileSize",value="文件大小",dataType="String")
    private String fileSize;

    /**
    * 文件类型
    * 字段名:FILE_TYPE
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="fileType",value="文件类型",dataType="String")
    private String fileType;

    /**
    * 下载地址
    * 字段名:DOWNLOAD
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="download",value="下载地址",dataType="String")
    private String download;

    /**
    * 文件地址
    * 字段名:FILE_ADDRESS
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="fileAddress",value="文件地址",dataType="String")
    private String fileAddress;

    /**
    * 所在盘
    * 字段名:DISK
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="disk",value="所在盘",dataType="String")
    private String disk;

    /**
    * 状态 0 正常  -1 删除 1锁定
    * 字段名:STATE
    * 类型:VARCHAR
     */
    @ApiModelProperty(name="state",value="状态 0 正常  -1 删除 1锁定",dataType="String")
    private String state;

    /**
    * null
    * 字段名:CREATE_TIME
    * 类型:TIMESTAMP
     */
    @ApiModelProperty(name="createTime",value="null",dataType="Date")
    private Date createTime;

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
     * 生成文件名
     * @return UUID_NAME
     */
    public String getUuidName() {
        return uuidName;
    }

    /**
     * 生成文件名
     * @param uuidName
     */
    public void setUuidName(String uuidName) {
        this.uuidName = uuidName == null ? null : uuidName.trim();
    }

    /**
     * 文件名称
     * @return FILE_NAME
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * 文件名称
     * @param fileName
     */
    public void setFileName(String fileName) {
        this.fileName = fileName == null ? null : fileName.trim();
    }

    /**
     * 文件大小
     * @return FILE_SIZE
     */
    public String getFileSize() {
        return fileSize;
    }

    /**
     * 文件大小
     * @param fileSize
     */
    public void setFileSize(String fileSize) {
        this.fileSize = fileSize == null ? null : fileSize.trim();
    }

    /**
     * 文件类型
     * @return FILE_TYPE
     */
    public String getFileType() {
        return fileType;
    }

    /**
     * 文件类型
     * @param fileType
     */
    public void setFileType(String fileType) {
        this.fileType = fileType == null ? null : fileType.trim();
    }

    /**
     * 下载地址
     * @return DOWNLOAD
     */
    public String getDownload() {
        return download;
    }

    /**
     * 下载地址
     * @param download
     */
    public void setDownload(String download) {
        this.download = download == null ? null : download.trim();
    }

    /**
     * 文件地址
     * @return FILE_ADDRESS
     */
    public String getFileAddress() {
        return fileAddress;
    }

    /**
     * 文件地址
     * @param fileAddress
     */
    public void setFileAddress(String fileAddress) {
        this.fileAddress = fileAddress == null ? null : fileAddress.trim();
    }

    /**
     * 所在盘
     * @return DISK
     */
    public String getDisk() {
        return disk;
    }

    /**
     * 所在盘
     * @param disk
     */
    public void setDisk(String disk) {
        this.disk = disk == null ? null : disk.trim();
    }

    /**
     * 状态 0 正常  -1 删除 1锁定
     * @return STATE
     */
    public String getState() {
        return state;
    }

    /**
     * 状态 0 正常  -1 删除 1锁定
     * @param state
     */
    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    /**
     * @return CREATE_TIME
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
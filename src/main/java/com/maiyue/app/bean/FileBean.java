package com.maiyue.app.bean;

public class FileBean {
	
	/***
	 * 文件名
	 */
	private String uuidName;
	
	/***
	 * 别名
	 */
	private String aliasName;
	/***
	 * 地址
	 */
	private String address;
	/***
	 * 根地址
	 */
	private String diskPath;
	/***
	 * 大小KB
	 */
	private String fileSize;

	/***
	 * 
	 * @param uuidName
	 * @param aliasName
	 * @param address
	 * @param diskPath
	 * @param fileSize
	 */
	public FileBean(String uuidName,String aliasName,String address,String diskPath,String fileSize){
		this.uuidName = uuidName;
		this.aliasName = aliasName;
		this.address = address;
		this.diskPath = diskPath;
		this.fileSize = fileSize;
	}
	
	
	
	
	
	
	public String getUuidName() {
		return uuidName;
	}

	public void setUuidName(String uuidName) {
		this.uuidName = uuidName;
	}

	public String getAliasName() {
		return aliasName;
	}

	public void setAliasName(String aliasName) {
		this.aliasName = aliasName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDiskPath() {
		return diskPath;
	}

	public void setDiskPath(String diskPath) {
		this.diskPath = diskPath;
	}

	public String getFileSize() {
		return fileSize;
	}

	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}

}

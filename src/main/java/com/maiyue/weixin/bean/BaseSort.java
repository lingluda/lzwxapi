package com.maiyue.weixin.bean;

import io.swagger.annotations.ApiModelProperty;

public class BaseSort {
	
	/***
	 * 显示第1页  (默认)
	 */
	 @ApiModelProperty(name="pageNum",value="第几页",dataType="Integer")
	private Integer pageNum;
	 
	/***
	 * 每页显示 10 条 (默认)
	 */
	 @ApiModelProperty(name="pageSize",value="每页显示",dataType="Integer")
	private Integer pageSize;
	
	/***
	 * 排序字段
	 */
	 @ApiModelProperty(name="order",value="排序字段",dataType="String")
	private String order;
	
	/***
	 * 排序
	 */
	 @ApiModelProperty(name="sorting",value="排序",dataType="String")
	private String sorting;
	
	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}
   
	public String getSorting() {
		return sorting;
	}

	public void setSorting(String sorting) {
		this.sorting = sorting;
	}

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		if(pageNum == 0){
			pageNum = 1;
		}
		this.pageNum = pageNum;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		if(pageSize == 0){
		   pageSize = 10;
		}
		this.pageSize = pageSize;
	}

	
	
	
	
	
	
	

}

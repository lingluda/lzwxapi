package com.maiyue.weixin.bean;



public class BaseSort {
	
	/***
	 * 显示第1页  (默认)
	 */
	private Integer pageNum;
	 
	/***
	 * 每页显示 10 条 (默认)
	 */
	private Integer pageSize;
	
	/***
	 * 排序字段
	 */
	private String order;
	
	/***
	 * 排序
	 */
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

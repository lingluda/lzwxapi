package com.maiyue.weixin.bean;

import java.util.Date;

public class Messages {
	// 标题
	private String title;
	// 通知时间
	private String infoTime;
	// 内容
	private String content;
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getInfoTime() {
		return infoTime;
	}

	public void setInfoTime(String infoTime) {
		this.infoTime = infoTime;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Messages [title=" + title + ", infoTime=" + infoTime + ", content=" + content + "]";
	}

	public Messages(String title, String infoTime, String content) {
		super();
		this.title = title;
		this.infoTime = infoTime;
		this.content = content;
	}

	public Messages() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	

}

package com.maiyue.weixin.base.bean;

public class Schedules {
	// 上课时间段
	private String timePeriod;
	// 科目名称
	private String subject;
	// 教室地点
	private String classroom;

	public String getTimePeriod() {
		return timePeriod;
	}

	public void setTimePeriod(String timePeriod) {
		this.timePeriod = timePeriod;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getClassroom() {
		return classroom;
	}

	public void setClassroom(String classroom) {
		this.classroom = classroom;
	}

	@Override
	public String toString() {
		return "Schedules [timePeriod=" + timePeriod + ", subject=" + subject + ", classroom=" + classroom + "]";
	}

	public Schedules() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Schedules(String timePeriod, String subject, String classroom) {
		super();
		this.timePeriod = timePeriod;
		this.subject = subject;
		this.classroom = classroom;
	}

}

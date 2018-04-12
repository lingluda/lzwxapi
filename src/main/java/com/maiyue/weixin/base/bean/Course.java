package com.maiyue.weixin.base.bean;

public class Course {
	private String courseName;
	private String classPeriod;
	private String classNum;
	private String studentNum;

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getClassPeriod() {
		return classPeriod;
	}

	public void setClassPeriod(String classPeriod) {
		this.classPeriod = classPeriod;
	}

	public String getClassNum() {
		return classNum;
	}

	public void setClassNum(String classNum) {
		this.classNum = classNum;
	}

	public String getStudentNum() {
		return studentNum;
	}

	public void setStudentNum(String studentNum) {
		this.studentNum = studentNum;
	}

	@Override
	public String toString() {
		return "Course [courseName=" + courseName + ", classPeriod=" + classPeriod + ", classNum=" + classNum
				+ ", studentNum=" + studentNum + "]";
	}

	public Course(String courseName, String classPeriod, String classNum, String studentNum) {
		super();
		this.courseName = courseName;
		this.classPeriod = classPeriod;
		this.classNum = classNum;
		this.studentNum = studentNum;
	}

	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}

}

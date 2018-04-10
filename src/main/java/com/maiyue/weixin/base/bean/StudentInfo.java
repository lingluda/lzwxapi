package com.maiyue.weixin.base.bean;

public class StudentInfo {
	private String clas;
	private String ifo;
	private String score;

	public String getClas() {
		return clas;
	}

	public void setClas(String clas) {
		this.clas = clas;
	}

	public String getIfo() {
		return ifo;
	}

	public void setIfo(String ifo) {
		this.ifo = ifo;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public StudentInfo(String clas, String ifo, String score) {
		super();
		this.clas = clas;
		this.ifo = ifo;
		this.score = score;
	}

	public StudentInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "StudentInfo [clas=" + clas + ", ifo=" + ifo + ", score=" + score + "]";
	}

}

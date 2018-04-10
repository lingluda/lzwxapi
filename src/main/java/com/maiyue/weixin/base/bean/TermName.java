package com.maiyue.weixin.base.bean;

public class TermName {
	private String termName;

	@Override
	public String toString() {
		return "TermName [termName=" + termName + "]";
	}

	public String getTermName() {
		return termName;
	}

	public void setTermName(String termName) {
		this.termName = termName;
	}

	public TermName(String termName) {
		super();
		this.termName = termName;
	}

	public TermName() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}

package com.mitocode.jsf.model;

// default package
// Generated Feb 27, 2021, 9:56:04 AM by Hibernate Tools 5.4.27.Final

/**
 * Student generated by hbm2java
 */
public class Student implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private byte stdCode;
	private User user;
	private String stdName;
	private String column3;

	public Student() {
	}

	public Student(User user) {
		this.user = user;
	}

	public Student(User user, String stdName, String column3) {
		this.user = user;
		this.stdName = stdName;
		this.column3 = column3;
	}

	public byte getStdCode() {
		return this.stdCode;
	}

	public void setStdCode(byte stdCode) {
		this.stdCode = stdCode;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getStdName() {
		return this.stdName;
	}

	public void setStdName(String stdName) {
		this.stdName = stdName;
	}

	public String getColumn3() {
		return this.column3;
	}

	public void setColumn3(String column3) {
		this.column3 = column3;
	}

}

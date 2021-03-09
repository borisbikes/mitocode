package com.webproject.entity;

import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "emp_cod")
	private int id;
	
	@Column(name = "emp_names")
	private String names;
	
	@Column(name = "emp_last_names")
	private String lastNames;
	
	
	@Column(name = "emp_sex")
	private String sex;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNames() {
		return names;
	}


	public void setNames(String names) {
		this.names = names;
	}


	public String getLastNames() {
		return lastNames;
	}


	public void setLastNames(String lastNames) {
		this.lastNames = lastNames;
	}


	public String getSex() {
		return sex;
	}


	public void setSex(String sex) {
		this.sex = sex;
	}


	public Employee(int id, String names, String lastNames, String sex) {
		super();
		this.id = id;
		this.names = names;
		this.lastNames = lastNames;
		this.sex = sex;
	}


	public Employee() {
		super();
	}
	
	
	
}

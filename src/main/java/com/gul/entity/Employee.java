package com.gul.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity
@Table
@Proxy(lazy = false)
public class Employee {

	@Id
	private long id;
	private String fname;
	private String lname;
	private String age;
	private String attrb;

	public String getAttrb() {
		return attrb;
	}

	public void setAttrb(String attrb) {
		this.attrb = attrb;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", fname=" + fname + ", lname=" + lname + ", age=" + age + ", attrb="
				+ attrb + "]";
	}

	public Employee() {
		super();
	}

	public Employee(long id, String fname, String lname, String age, String attrb) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.age = age;
		this.attrb = attrb;
	}

}

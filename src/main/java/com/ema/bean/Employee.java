package com.ema.bean;

public class Employee {
	private int empid;
	private String empname;
	private String gender;
	private String dob;
	private String place;
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getEmpname() {
		System.out.println(empname);
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		//System.out.println(getPlace());
		this.place = place;
	}
	public String toString() {
		return "employee [empid = "+empid+",empname = "+empname+",gender = "+gender+",dob = "+dob+",place = "+place+"]";
	}


}

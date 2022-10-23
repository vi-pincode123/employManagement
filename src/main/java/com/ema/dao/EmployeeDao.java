package com.ema.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.ema.bean.Employee;

public class EmployeeDao {
	public static Connection getCon() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","rootpassword");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return con;
		
	}
	

	public static int registerEmployee(Employee employ) {
		int status = 0;
		try {
			String sql = "insert into employdetails(empname,gender,dob,place) values(?,?,?,?)";
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1, employ.getEmpname());
			ps.setString(2, employ.getGender());
			ps.setString(3, employ.getDob());
			ps.setString(4, employ.getPlace());
			
			status = ps.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	public static List<Employee> getAllEmployees(){
		List<Employee> emplist = new ArrayList<>();
		try {
			String sql = "select * from employdetails";
			PreparedStatement ps = getCon().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Employee emp = new Employee();
				emp.setEmpid(rs.getInt(1));
				emp.setEmpname(rs.getString(2));
				emp.setGender(rs.getString(3));
				emp.setDob(rs.getString(4));
				emp.setPlace(rs.getString(5));
				emplist.add(emp);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return emplist;
		
	}


	public static int deleteEmployee(int empid) {
		int status = 0;
		try {
			String slq = "delete from employdetails where empid=?";
			PreparedStatement ps = getCon().prepareStatement(slq);
			ps.setInt(1, empid);
			status = ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return status;
	}


	public static Employee getEmployeeById(int empid) {
		Employee emp = null;
		try {
			String sql = "select * from employdetails where empid=?";
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, empid);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
			emp.setEmpid(rs.getInt(1));
			emp.setEmpname(rs.getString(2));
			emp.setGender(rs.getString(3));
			emp.setDob(rs.getString(4));
			emp.setPlace(rs.getString(5));
			}
			//System.out.println(emp.empname);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return emp;
	}


	public static int updateEmployee(Employee employee) {
		int status = 0;
		try {
			String sql = "update employdetails set empname=?,gender=?,dob=?,place=? where empid=?";
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, employee.getEmpid());
			ps.setString(2, employee.getEmpname());
			ps.setString(3, employee.getGender());
			ps.setString(4, employee.getDob());
			ps.setString(5, employee.getPlace());
			status = ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return status;
	}
	

}


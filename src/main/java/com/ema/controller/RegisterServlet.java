package com.ema.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ema.bean.Employee;
import com.ema.dao.EmployeeDao;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet{
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		String empname = request.getParameter("empname");
		String gender = request.getParameter("gender");
		String dob = request.getParameter("dob");
		String place = request.getParameter("place");
		
		Employee employ  = new Employee();
		employ.setEmpname(empname);
		employ.setGender(gender);
		employ.setDob(dob);
		employ.setPlace(place);
		
		int i = EmployeeDao.registerEmployee(employ);
		
		if(i>0) {
			out.print("<h1 style='font-size:60px;color:green'align='center'>registered successfully</h1>");
		}
		else {
			out.print("<h1 style='font-size: 60px;color:red'align='center'>registered failed!!!</h1>");
		}
	}

}

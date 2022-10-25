package com.ema.controller;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ema.bean.Employee;
import com.ema.dao.EmployeeDao;
@WebServlet("/updates")
public class UpdateServlet extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		 response.setContentType("text/html"); 
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("empname");
		String gender = request.getParameter("gender");
		String dob = request.getParameter("dob");
		String place = request.getParameter("place");
		
		Employee employee = new Employee();
		employee.setEmpid(id);
		employee.setEmpname(name);
		employee.setGender(gender);
		employee.setDob(dob);
		employee.setPlace(place);
		
		int i = EmployeeDao.updateEmployee(employee);
		
		if(i>0) {
			response.sendRedirect("view");
		}else {
			out.print("updation failed");
		}
	}

}

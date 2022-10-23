package com.ema.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ema.bean.Employee;
import com.ema.dao.EmployeeDao;
@WebServlet("/view")
public class ViewServlet extends HttpServlet{
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException {
		List<Employee> Employees = EmployeeDao.getAllEmployees();
		PrintWriter out = response.getWriter();
		out.print("<h1 align='center'>TABLE DATA</h1>");
		out.print("<center><table border='5'><thead style='font-size:50px'><th>ID</th><th>NAME</th><th>GENDER</th><th>DOB</th><th>PLACE</th><th>EDIT</th><th>DELETE</th></thead></center>");
	    out.print("<tbody style='color:orange'>");
	    for(Employee emp : Employees) {
	    	out.print("<tr><td>" +emp.getEmpid()+"</td><td>" +emp.getEmpname()+"</td><td>" +emp.getGender()+"</td><td>" +emp.getDob()+"</td><td>" +emp.getPlace()+"</td><td><a href='edit?ide="+emp.getEmpid()+"'>edit</a></td><td><a href='delete?id="+emp.getEmpid()+"'>delete</a></td></tr>");
	    }
	    out.print("</tbody></table>");
	}

}

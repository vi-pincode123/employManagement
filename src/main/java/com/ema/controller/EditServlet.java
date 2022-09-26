package com.ema.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ema.bean.Employee;
import com.ema.dao.EmployeeDao;
@WebServlet("/edit")
public class EditServlet extends HttpServlet{
	public void service(HttpServletRequest request,HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<style>body{background-color: cyan}</style>");
		int id = Integer.parseInt(request.getParameter("id"));
		
		
		Employee employee = EmployeeDao.getEmployeeById(id);
		//System.out.println(employee);
		out.print("<body>");
		out.print("<h1 align='center'><b>TABLE FORM</b></h1>");
		out.print("<center><form action='update' method='post' style='font-size:40px'><label>ID</label><br><input type='hidden' value=''><br><label>NAME</label><br><input type='text'  value=''><br><label>GENDER</label><br><input type='radio' name='gender'>male<input type='radio' name='gender'>female<br><label>date of birth</label><br><input type='date' value=''><br><label>PLACE</label><br><input type='text' value=''><br><br><button type='submit'>update</button></form></center>");
	    out.print("</body>");	
		
		
	}

}

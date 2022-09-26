package com.ema.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ema.dao.EmployeeDao;
@WebServlet("/delete")
public class DeleteServlet extends HttpServlet{
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException {
		int empid = Integer.parseInt(request.getParameter("id"));
		int i = EmployeeDao.deleteEmployee(empid);
		PrintWriter out = response.getWriter();
		if(i>0) {
			response.sendRedirect("view");
		}
		else {
			out.print("error");
		}
	}

}

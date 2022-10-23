package com.ema.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.metal.MetalBorders.Flush3DBorder;
import java.sql.*;
import com.ema.bean.Employee;
import com.ema.dao.EmployeeDao;
@WebServlet("/edit")

public class EditServlet extends HttpServlet{
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
	public void service(HttpServletRequest request,HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<style>body{background-color: cyan}</style>");
		int id = Integer.parseInt(request.getParameter("ide"));
		
		System.out.println(id);
		String na;
		try {
			String sql = "select * from employdetails where empid=?";
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				
			//emp.setEmpid(rs.getInt(1));
			na = rs.getString(2);
			System.out.println(na);
			//emp.setGender(rs.getString(3));String gn = rs.
			//emp.setDob(rs.getString(4));
			//emp.setPlace(rs.getString(5));
			
			//System.out.println(empid);
			
			}
			//System.out.println(emp.empname);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		Employee employee = EmployeeDao.getEmployeeById(id);
		out.print("<body>");
		out.print("<h1 align='center'><b>TABLE FORM</b></h1>");
		out.print("<center><form action='update' method='post' style='font-size:40px'><label>ID</label><br>"
				+ "<input type='hidden' value='"+employee.getEmpid()+"'><br><label>NAME</label><br><input type='text'  value='"+na+"'><br>"
				+ "<label>GENDER</label><br><input type='radio' name='gender' value='"+employee.getGender()+"'>male<input type='radio' name='gender'>female<br>"
				+ "<label>date of birth</label><br><input type='date' value='"+employee.getDob()+"'><br><label>PLACE</label><br>"
				+ "<input type='text' value='"+employee.getPlace()+"'><br><br><button type='submit'>update</button></form></center>");
	    out.print("</body>");	
		
		
	}

}

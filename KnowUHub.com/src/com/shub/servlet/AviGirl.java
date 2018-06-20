package com.shub.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class AviGirl extends HttpServlet {
	private Connection cn;
	public void init(ServletConfig config)throws ServletException
	{
		super.init(config);
		ServletContext ctx=config.getServletContext();
		String d=ctx.getInitParameter("driver");
		String u=ctx.getInitParameter("url");
		String user=ctx.getInitParameter("user");
		String pwd=ctx.getInitParameter("pwd");
		try
		{
//			Class.forName(d);
//			cn=DriverManager.getConnection(u,user,pwd);
//			
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection cn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		    cn=DriverManager.getConnection("jdbc:mysql://localhost/xyz","root","12345");
		} catch (Exception e1) {
			
			e1.printStackTrace();
		}
		PreparedStatement ps = null;
		HttpSession session=request.getSession(false);
         PrintWriter o=response.getWriter();
		 int rollno=(Integer) session.getAttribute("rollno");
		 String cuteboy=request.getParameter("cuteboy");
		 String smartboy=request.getParameter("smartboy");
		 String mugguboy=request.getParameter("mugguboy");
		 String aboy=request.getParameter("aboy");
		 String bboy=request.getParameter("bboy");
		 try{
			 ps=cn.prepareStatement("insert into avigirl values(?,?,?,?,?,?)");
			 ps.setInt(1, rollno);
			 ps.setString(2, cuteboy);
			 ps.setString(3,smartboy);
			 ps.setString(4, mugguboy);
			 ps.setString(5, aboy);
			 ps.setString(6, bboy);
			int count=ps.executeUpdate();
			if(count==1)
			{
				response.sendRedirect("View.jsp");
			}
			cn.close();
		 }
		 catch(Exception e)
		 {e.printStackTrace();}
	
		
		 
		 
		 
		 
		 
		 
    }

}

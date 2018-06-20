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
public class AviMatch extends HttpServlet {
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

		 int optionA=Integer.parseInt(request.getParameter("nameA"));
		 int optionB=Integer.parseInt(request.getParameter("fname"));
		 int optionC=Integer.parseInt(request.getParameter("fname2"));
         int optionD=Integer.parseInt(request.getParameter("nameD"));
         int optionE=Integer.parseInt(request.getParameter("fname3"));
   
		 try{
			 ps=cn.prepareStatement("insert into avymatch1 values(?,?,?,?,?,?)");
			 ps.setInt(1, rollno);
			 ps.setInt(2,optionA);
			 ps.setInt(3,optionB);
			 ps.setInt(4,optionC);
			 ps.setInt(5,optionD);
			 ps.setInt(6,optionE);
			int count=ps.executeUpdate();
			if(count==1)
			{
				response.sendRedirect("aviMatch2.jsp");
			}
		 }
		 catch(Exception e)
		 {e.printStackTrace();}
		
		
		 
		 
		 
		 
		 
		 
    }

}

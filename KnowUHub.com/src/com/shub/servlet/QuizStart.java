package com.shub.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class QuizStart extends HttpServlet {
	private Connection cn;
	public void init(ServletConfig config)throws ServletException
	{
		super.init(config);
		ServletContext ctx=config.getServletContext();
		
		String d=ctx.getInitParameter("driver");
		String u=ctx.getInitParameter("url");
		String user="knowuquiz";
		String pwd=ctx.getInitParameter("pwd");
		try
		{
//			Class.forName(d);
//			cn=DriverManager.getConnection("jdbc:mysql://localhost/Knowuquiz","root","12345");			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection cn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		    cn=DriverManager.getConnection("jdbc:mysql://localhost/Knowuquiz","root","12345");
		} catch (Exception e1) {
			
			e1.printStackTrace();
		}
		PreparedStatement ps=null;
		HttpSession session=request.getSession(false);
		if(session==null)
			response.sendRedirect("fornt1.html");
		int rollno=(int)session.getAttribute("rollno");

		PrintWriter o=response.getWriter();
		try{
			 ps=cn.prepareStatement("create table q"+rollno+"(Question varchar(500),Answer varchar(500))");
			ps.executeUpdate();
			RequestDispatcher rd=request.getRequestDispatcher("Quiz1.jsp");
			
			rd.include(request, response);
			cn.close();
		}catch(Exception e)
		{e.printStackTrace();}
		
       	}

}

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
public class QuizExam extends HttpServlet {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection cn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		    cn=DriverManager.getConnection("jdbc:mysql://localhost/Knowuquiz","root","12345");
		} catch (Exception e1) {
			
			e1.printStackTrace();
		}
		String webpage=null;
		PreparedStatement ps=null;
		HttpSession session=request.getSession(false);
		int rollno=(int)session.getAttribute("rollno");
		String answer=request.getParameter("answer");
		int question=Integer.parseInt(request.getParameter("question"));
		int pageno=(1+question);
		if (pageno<31){
		webpage="Quiz"+pageno+".jsp";
	
		}
		else{
			 webpage="Quiz"+question+".jsp";
			System.out.println(webpage);
		}
	
	
		try{
			ps=cn.prepareStatement("insert into q"+rollno+" values(?,?)");
			ps.setInt(1, question);
			ps.setString(2,	answer);
			ps.executeUpdate();
			RequestDispatcher rd=request.getRequestDispatcher(""+webpage+"");
			rd.include(request, response);
			cn.close();
		}catch(Exception e)
		{e.printStackTrace();}
		
	
       	}

}

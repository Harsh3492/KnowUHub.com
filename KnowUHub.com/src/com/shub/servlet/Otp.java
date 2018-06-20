package com.shub.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class Otp extends HttpServlet {
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
		PreparedStatement ps2=null;
		ResultSet rs=null;
		PrintWriter out=response.getWriter();
	HttpSession session=request.getSession(false);
	PrintWriter o=response.getWriter();
	int enterotp=Integer.parseInt(request.getParameter("enterotp"));
	int generatedotp=(int)session.getAttribute("generatedotp");
	int rollno=(int)session.getAttribute("rollno");

	
	try{
	ps2=cn.prepareStatement("Select count(*) from db where roll_no=?"); 
	
	 ps2.setInt(1,rollno);
	 rs=ps2.executeQuery();
	 rs.next();
	 int count1=rs.getInt(1);
	 if(count1==1)
	 {
		 RequestDispatcher rd=request.getRequestDispatcher("fornt1.html");
			o.println("<script>");
			o.println("alert('Account is Already Created')");
			o.println("</script>");		
			rd.include(request, response);
	 }
	 else{
	if(enterotp==generatedotp)
	{
	RequestDispatcher rd=request.getRequestDispatcher("SignUp.jsp");
	request.setAttribute("rollno", rollno);
	rd.include(request, response);

	//	System.out.println("You Entered Correct info");
	}
	else
	{
		RequestDispatcher rd=request.getRequestDispatcher("fornt1.html");
		o.println("<script>");
		o.println("alert('Please enter Correct OTP')");
		o.println("</script>");		
		rd.include(request, response);

		//System.out.println("please enter Correct info");
	}}
	 cn.close(); 
	}catch(Exception e)
	{
		e.printStackTrace();
	}
	
	
	}}
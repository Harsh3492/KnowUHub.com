package com.shub.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.PasswordAuthentication;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
public class Feedback extends HttpServlet {
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
			e.printStackTrace();
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
	PrintWriter o=response.getWriter();
	int rollno=Integer.parseInt(request.getParameter("rollno"));
	String useremail=request.getParameter("email");
    String feedback=request.getParameter("feedback");
   String to ="knowuhub.com@gmail.com";
    String subject = "Feedback";
    String msg =  "Feedback from "+rollno+"::>>"+useremail+"::>>"+feedback+"";
    String id="knowuhub.com@gmail.com";
    String pwd="9838602164";
   SendMailSSL.send(to,subject,msg,id,pwd);
   RequestDispatcher rd=request.getRequestDispatcher("fornt1.html");
	o.println("<script>");
	o.println("alert('Your Query is Send.Thank you For the Query ')");
    o.println("</script>");		
	rd.include(request, response);
   }
    
    
	}
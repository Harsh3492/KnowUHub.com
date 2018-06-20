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
public class Forgetpwd extends HttpServlet {
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
	String userpwd=null;
	PreparedStatement ps2=null;
	ResultSet rs2=null;
	int rollno=Integer.parseInt(request.getParameter("rollno"));
    try{
    	ps2=cn.prepareStatement("Select count(*) from db where roll_no=?");
    	ps2.setInt(1, rollno);
    	rs2=ps2.executeQuery();
    	rs2.next();
    	int c2=rs2.getInt(1);
    			if(c2==0){
    				RequestDispatcher rd=request.getRequestDispatcher("fornt1.html");
    				o.println("<script>");
    				o.println("alert('Sorry Account Does not Created')");
    				o.println("</script>");		
    				rd.include(request, response);
    	    	}	
    			else{
    	///////////////////////////////////////Searching Password /////////////////////////////////////////////////////
    	PreparedStatement ps1=cn.prepareStatement("Select PASSWARD from db where roll_no=?");
    	ps1.setInt(1, rollno);
    	ResultSet rs1=ps1.executeQuery();
    	boolean c1=rs1.next();
    	if(c1==true)
    	{
    		 userpwd=rs1.getString(1);
    	}
    	else
    	{
    		RequestDispatcher rd=request.getRequestDispatcher("fornt1.html");
			o.println("<script>");
			o.println("alert('Please Enter Correct Roll Number')");
			o.println("</script>");		
			rd.include(request, response);
    	}
    //////////////////////////////Start of find mail////////////////	
	PreparedStatement ps=cn.prepareStatement("Select emai from data where roll_no=?");
	ps.setInt(1, rollno);
	ResultSet rs=ps.executeQuery();
	boolean c=rs.next();
	if(c==true)
	{
   String to = rs.getString(1);
    String subject = "Password";
    String msg =  "<div style=\"box-sizing: border-box;margin: 0;font-family: -apple-system,BlinkMacSystemFont,&quot;Segoe UI&quot;,Roboto,&quot;Helvetica Neue&quot;,Arial,sans-serif,&quot;Apple Color Emoji&quot;,&quot;Segoe UI Emoji&quot;,&quot;Segoe UI Symbol&quot;;font-size: 1rem;font-weight: 400;line-height: 1.5;color: #212529;text-align: left;background-color: #fff;min-width: 992px!important;\">\r\n" + 
    		"    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" style=\"box-sizing: border-box;\">\r\n" + 
    		"    <link href=\"https://fonts.googleapis.com/css?family=Questrial\" rel=\"stylesheet\" style=\"box-sizing: border-box;\">\r\n" + 
    		"    <div class=\"container\" style=\"box-sizing: border-box;width: 100%;padding-right: 15px;padding-left: 15px;margin-right: auto;margin-left: auto;min-width: 992px!important;\">\r\n" + 
    		"      <div class=\"row text-center\" style=\"height: 85px;background-color: #20313D;box-sizing: border-box;display: flex;-ms-flex-wrap: wrap;flex-wrap: wrap;margin-right: -15px;margin-left: -15px;text-align: center!important;\">\r\n" + 
    		"          <img src=\"https://thumb.ibb.co/iTQLKc/favicon.png\" class=\"img-fluid d-block mx-auto\" alt=\"KnowUHub logo\" style=\"box-sizing: border-box;vertical-align: middle;border-style: none;page-break-inside: avoid;max-width: 100%;height: auto;display: block!important;margin-right: auto!important;margin-left: auto!important;\">\r\n" + 
    		"      </div>\r\n" + 
    		"    </div><br style=\"box-sizing: border-box;\"><br style=\"box-sizing: border-box;\">\r\n" + 
    		"    <div class=\"container\" style=\"box-sizing: border-box;width: 100%;padding-right: 15px;padding-left: 15px;margin-right: auto;margin-left: auto;min-width: 992px!important;\">\r\n" + 
    		"      <div class=\"row \" style=\"box-sizing: border-box;display: flex;-ms-flex-wrap: wrap;flex-wrap: wrap;margin-right: -15px;margin-left: -15px;\">\r\n" + 
    		"       <div class=\"text-center\" style=\"box-sizing: border-box;text-align: center!important;\">\r\n" + 
    		"         <p style=\"font-family: 'Questrial', sans-serif;letter-spacing: 1px;font-size: 32px;box-sizing: border-box;margin-top: 0;margin-bottom: 1rem;orphans: 3;widows: 3;\"> Your Password is <span style=\"letter-spacing: 1px;color: #FF196A;box-sizing: border-box;\">"+userpwd+"</span> .Go and Login on <a href=\"http://www.knowuhub.com/\" style=\"box-sizing: border-box;color: #007bff;text-decoration: underline;background-color: transparent;-webkit-text-decoration-skip: objects;\">www.KnowUHub.com</a> .</p>\r\n" + 
    		"       </div>\r\n" + 
    		"      </div>\r\n" + 
    		"    </div>\r\n" + 
    		"    <div class=\"container\" style=\"box-sizing: border-box;width: 100%;padding-right: 15px;padding-left: 15px;margin-right: auto;margin-left: auto;min-width: 992px!important;\">\r\n" + 
    		"        <p style=\"font-family: 'Questrial', sans-serif;letter-spacing: 1px;font-size: 20px;box-sizing: border-box;margin-top: 0;margin-bottom: 1rem;orphans: 3;widows: 3;\">Thank You</p>\r\n" + 
    		"          <p style=\"font-family: 'Questrial', sans-serif;letter-spacing: 1px;font-size: 20px;color: #FF196A;box-sizing: border-box;margin-top: 0;margin-bottom: 1rem;orphans: 3;widows: 3;\">KnowUHub Team</p>\r\n" + 
    		"\r\n" + 
    		"    </div>\r\n" + 
    		"    <script src=\"https://code.jquery.com/jquery-3.2.1.slim.min.js\" style=\"box-sizing: border-box;\"></script>\r\n" + 
    		"    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js\" style=\"box-sizing: border-box;\"></script>\r\n" + 
    		"    <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js\" style=\"box-sizing: border-box;\"></script>\r\n" + 
    		"  </div>";
    String id="knowuhub.com@gmail.com";
    String pwd="9838602164";
   SendMail.send(to,subject,msg,id,pwd);
   RequestDispatcher rd=request.getRequestDispatcher("fornt1.html");
	o.println("<script>");
	o.println("alert('Password Send in "+to+"')");
	o.println("</script>");		
	rd.include(request, response);
   }
     else
     {
    	 RequestDispatcher rd=request.getRequestDispatcher("fornt1.html");
			o.println("<script>");
			o.println("alert('Please Contect Us')");
			o.println("</script>");		
			rd.include(request, response);
     }
    }
    			
    			cn.close();
    }catch(Exception e)
    {e.printStackTrace();}
    
    
	}}
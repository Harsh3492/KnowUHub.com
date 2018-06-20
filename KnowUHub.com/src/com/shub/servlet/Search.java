package com.shub.servlet;

import javax.servlet.*;
import javax.servlet.http.*;

import java.io.*;
import java.sql.*;


public class Search extends HttpServlet
{
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

	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{   
		Connection cn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		    cn=DriverManager.getConnection("jdbc:mysql://localhost/xyz","root","12345");
		} catch (Exception e1) {
			
			e1.printStackTrace();
		}
		PreparedStatement ps=null;
		PreparedStatement psemail=null;
		ResultSet rs=null;
		ResultSet rsemail=null;
		PrintWriter o=res.getWriter();
	    HttpSession session=req.getSession(false);
	    
	    session.getAttribute("rollno");
	    int no =0;
	    int rollno=Integer.parseInt(req.getParameter("rollno"));
	  

	if(rollno!=no )
	{
	
		try
		{
		ps=cn.prepareStatement("Select USER_NAME,ROLL_NO from db where ROLL_NO=? ");
		ps.setInt(1, rollno);
		
	   rs=ps.executeQuery();
	    boolean c=rs.next();
	    
		if(c==true)
		{
		String resultName=rs.getString(1);
		int resultrollno=rs.getInt(2);
	    RequestDispatcher rd=req.getRequestDispatcher("Result.jsp");
	    req.setAttribute("resultName",resultName );
	    req.setAttribute("resultrollno",resultrollno );
	    rd.forward(req,res);
		}
	    else
	    {
	    	
	    	psemail=cn.prepareStatement("Select name,emai from data where Roll_no=?");
			psemail.setInt(1,rollno);
			rsemail=psemail.executeQuery();
			boolean cemail=rsemail.next();
			if(cemail==true)
			{
			String Name=rsemail.getString(1);	
			String to=rsemail.getString(2);	
			String subject = "Message";
		    String msgRequest =  "<div style=\"box-sizing: border-box;margin: 0;font-family: -apple-system,BlinkMacSystemFont,&quot;Segoe UI&quot;,Roboto,&quot;Helvetica Neue&quot;,Arial,sans-serif,&quot;Apple Color Emoji&quot;,&quot;Segoe UI Emoji&quot;,&quot;Segoe UI Symbol&quot;;font-size: 1rem;font-weight: 400;line-height: 1.5;color: #212529;text-align: left;background-color: #fff;min-width: 992px!important;\">\r\n" + 
		    		"	<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" style=\"box-sizing: border-box;\">\r\n" + 
		    		"	<link href=\"https://fonts.googleapis.com/css?family=Questrial\" rel=\"stylesheet\" style=\"box-sizing: border-box;\">\r\n" + 
		    		"	<div class=\"container\" style=\"box-sizing: border-box;width: 100%;padding-right: 15px;padding-left: 15px;margin-right: auto;margin-left: auto;min-width: 992px!important;\">\r\n" + 
		    		"		<div class=\"row text-center\" style=\"height: 85px;background-color: #20313D;box-sizing: border-box;display: flex;-ms-flex-wrap: wrap;flex-wrap: wrap;margin-right: -15px;margin-left: -15px;text-align: center!important;\">\r\n" + 
		    		"				<img src=\"https://thumb.ibb.co/iTQLKc/favicon.png\" class=\"img-fluid d-block mx-auto\" alt=\"KnowUHub logo\" style=\"box-sizing: border-box;vertical-align: middle;border-style: none;page-break-inside: avoid;max-width: 100%;height: auto;display: block!important;margin-right: auto!important;margin-left: auto!important;\">\r\n" + 
		    		"		</div>\r\n" + 
		    		"	</div><br style=\"box-sizing: border-box;\"><br style=\"box-sizing: border-box;\">\r\n" + 
		    		"	<div class=\"container\" style=\"box-sizing: border-box;width: 100%;padding-right: 15px;padding-left: 15px;margin-right: auto;margin-left: auto;min-width: 992px!important;\">\r\n" + 
		    		"		<div class=\"row \" style=\"box-sizing: border-box;display: flex;-ms-flex-wrap: wrap;flex-wrap: wrap;margin-right: -15px;margin-left: -15px;\">\r\n" + 
		    		"		 <div class=\"text-center\" style=\"box-sizing: border-box;text-align: center!important;\">\r\n" + 
		    		"			 <p style=\"font-family: 'Questrial', sans-serif;letter-spacing: 1px;font-size: 32px;box-sizing: border-box;margin-top: 0;margin-bottom: 1rem;orphans: 3;widows: 3;\">Hey <span style=\"letter-spacing: 1px;color: #FF196A;box-sizing: border-box;\">"+Name+"</span> Someone Wants to Say Something to you on <a href=\"http://www.knowuhub.com/\" style=\"box-sizing: border-box;color: #007bff;text-decoration: underline;background-color: transparent;-webkit-text-decoration-skip: objects;\">www.KnowUHub.com</a> . So Please go and Make Account on KnowUHub.</p>\r\n" + 
		    		"		 </div>\r\n" + 
		    		"		</div>\r\n" + 
		    		"	</div>\r\n" + 
		    		"	<div class=\"container\" style=\"box-sizing: border-box;width: 100%;padding-right: 15px;padding-left: 15px;margin-right: auto;margin-left: auto;min-width: 992px!important;\">\r\n" + 
		    		"			<p style=\"font-family: 'Questrial', sans-serif;letter-spacing: 1px;font-size: 20px;box-sizing: border-box;margin-top: 0;margin-bottom: 1rem;orphans: 3;widows: 3;\">Thank You</p>\r\n" + 
		    		"				<p style=\"font-family: 'Questrial', sans-serif;letter-spacing: 1px;font-size: 20px;color: #FF196A;box-sizing: border-box;margin-top: 0;margin-bottom: 1rem;orphans: 3;widows: 3;\">KnowUHub Team</p>\r\n" + 
		    		"	\r\n" + 
		    		"	</div>\r\n" + 
		    		"	<script src=\"https://code.jquery.com/jquery-3.2.1.slim.min.js\" style=\"box-sizing: border-box;\"></script>\r\n" + 
		    		"	<script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js\" style=\"box-sizing: border-box;\"></script>\r\n" + 
		    		"	<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js\" style=\"box-sizing: border-box;\"></script>\r\n" + 
		    		"</div>";
		    String id="knowuhub.com@gmail.com";
		    String pwd="9838602164";
		    SendMail.send(to,subject,msgRequest,id,pwd);	
			RequestDispatcher rd1=req.getRequestDispatcher("View.jsp");
	    	o.println("<script>");
			o.println("alert('Person not on KnowUHub')");
			o.println("</script>");
	    	rd1.include(req, res);
	    	}
			
//	    	RequestDispatcher rd2=req.getRequestDispatcher("View.jsp");
//	    	
//	    	o.println("<script>");
//	    	
//			o.println("alert('Person not on KnowUHub')");
//		    o.println("</script>");
//	    	rd2.include(req,res);
	    }
		cn.close();
		}catch(Exception k1)
		{
			k1.printStackTrace();
		}
		
	}//end of all select 
	
	}// end of doPost
	}//end of class

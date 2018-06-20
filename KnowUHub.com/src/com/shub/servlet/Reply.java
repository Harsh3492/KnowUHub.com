package com.shub.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
public class Reply extends HttpServlet {
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
		PreparedStatement ps=null;
		PreparedStatement psCount=null;
		PreparedStatement psemail=null;
		PreparedStatement ps1=null;
		ResultSet rsCount=null;
		ResultSet rs=null;
		ResultSet rsemail=null;
		
		HttpSession session=request.getSession(false);
		int rollno=(int)session.getAttribute("rollno");
		PrintWriter o=response.getWriter();
	
        int resultrollno=(int)session.getAttribute("replyrollno");
        System.out.println(resultrollno);
         String msg=request.getParameter("msg");
         String replymsg=rollno+":"+msg;
       
	  String reply=request.getParameter("reply");
	  System.out.println(reply);
	  SimpleDateFormat sdf=new SimpleDateFormat("dd-MMM-yyyy");
	  SimpleDateFormat sdf2=new SimpleDateFormat("hh:mm:ss a");
	  Date date=new Date();
	  String cmtDate=sdf.format(date);
	  String cmttime=sdf2.format(date);
	 
	try{//SELECT table_name FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA='xyz' ;
		ps=cn.prepareStatement("select count(table_name) from information_schema.tables  where  table_name='H"+resultrollno+"' and table_schema='xyz'");
		rs=ps.executeQuery();
		rs.next();
        int c =rs.getInt(1);
		if(c==1)
		{
			 ///////////////////////////Counting Msg/////////////////////////

			psCount=cn.prepareStatement("Select count(msg) from H"+rollno+" ");

			rsCount=psCount.executeQuery();
			rsCount.next();
			 int countmsg=rsCount.getInt(1);
			////////End Of Counton Msg/////////////////////////////////
			 ps1=cn.prepareStatement("insert into H"+resultrollno+" values(?,?,?,?,?)");
			ps1.setInt(1,rollno);
			ps1.setString(2, replymsg);
			ps1.setString(3, cmtDate);
			ps1.setString(4, cmttime);
			ps1.setInt(5,countmsg+1);
			int count=ps1.executeUpdate();
			
		    if(count==1)
		    {
		    	//RequestDispatcher rd=request.getRequestDispatcher("View.jsp");
		    	o.println("<script>");
				o.println("alert('Messege Send Succesfull')");
				o.println("</script>");
		    	//rd.include(request, response);
		    	response.sendRedirect("View.jsp");
		    	psemail=cn.prepareStatement("Select name,emai from data where Roll_no=?");
				psemail.setInt(1, resultrollno);
				rsemail=psemail.executeQuery();
				boolean cemail=rsemail.next();
				if(cemail==true)
				{
				String Name=rsemail.getString(1);	
				String to=rsemail.getString(2);	
				String subject = "KnowUHub Message";
			    String msgRequest =  "<div style=\"box-sizing: border-box;margin: 0;font-family: -apple-system,BlinkMacSystemFont,&quot;Segoe UI&quot;,Roboto,&quot;Helvetica Neue&quot;,Arial,sans-serif,&quot;Apple Color Emoji&quot;,&quot;Segoe UI Emoji&quot;,&quot;Segoe UI Symbol&quot;;font-size: 1rem;font-weight: 400;line-height: 1.5;color: #212529;text-align: left;background-color: #fff;min-width: 992px!important;\">\r\n" + 
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
			    		"         <p style=\"font-family: 'Questrial', sans-serif;letter-spacing: 1px;font-size: 32px;box-sizing: border-box;margin-top: 0;margin-bottom: 1rem;orphans: 3;widows: 3;\">Hey <span style=\"letter-spacing: 1px;color: #FF196A;box-sizing: border-box;\">"+Name+"</span> Someone Sends you a reply on KnowUHub.com. So Please go and reply him/her on <a href=\"http://www.knowuhub.com/\" style=\"box-sizing: border-box;color: #007bff;text-decoration: underline;background-color: transparent;-webkit-text-decoration-skip: objects;\">www.KnowUHub.com</a> .</p>\r\n" + 
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
			    		"  </div>\r\n" + 
			    		"";
			    String id="knowuhub.com@gmail.com";
			    String pwd="9838602164";
			    SendMail.send(to,subject,msgRequest,id,pwd);	
				}
		    	//System.out.println("Massege Send??");
		    	
		    }
		    else
		    {
		    	RequestDispatcher rd=request.getRequestDispatcher("View.jsp");
		    	o.println("<script>");
				o.println("alert('Person not on KnowUHub')");
				o.println("</script>");
		    	rd.include(request, response);
		    	//System.out.println("Send Failer");
		    }
		}
		else{
			RequestDispatcher rd1=request.getRequestDispatcher("View.jsp");
	    	o.println("<script>");
			o.println("alert('Person not on KnowUHub')");
			o.println("</script>");
	    	rd1.include(request, response);
	     
	}
		cn.close();	
	}catch(Exception k)
	{
		k.printStackTrace();
	}
	
	}}

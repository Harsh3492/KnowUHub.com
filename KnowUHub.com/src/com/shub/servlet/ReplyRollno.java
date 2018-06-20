package com.shub.servlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.nio.ByteBuffer;
import java.security.Security;
import java.sql.*;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Scanner;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class ReplyRollno extends HttpServlet {
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
		PreparedStatement ps=null;
		PreparedStatement ps1=null;
		try{
			
		HttpSession session=request.getSession(false);
        PrintWriter o=response.getWriter();
        String replyrollno=request.getParameter("value");
		int personrollno=(Integer)session.getAttribute("rollno");
		String msg=request.getParameter("msg");
		String action=request.getParameter("action");
	    //////////////////////////////////Decrypet///////////////////////////////////////
		String Newstr="";  
         ///Code For encryption 
        
		////////////////////////////////////////////////////////////////////////
	     if(action.equals("Reply"))
		 {
			
		 RequestDispatcher rd=request.getRequestDispatcher("Reply.jsp");
		 request.setAttribute("replyrollno",Integer.parseInt(Newstr));
		 rd.include(request, response);
		 }
		 if(action.equals("Report"))
		 {
			
			 
				 ps=cn.prepareStatement("insert into report_msg values(?,?,?)");
				ps.setInt(1, personrollno);
				ps.setInt(2,Integer.parseInt(Newstr));
                ps.setString(3,msg);
                int count =ps.executeUpdate();
                if(count==1)
                {
                	response.sendRedirect("View.jsp");
                }else
                {
                	 RequestDispatcher rd=request.getRequestDispatcher("View.jsp");
                	 o.println("<script>");
     				o.println("alert('Report Could not Send ')");
     				o.println("</script>");
                	 rd.include(request, response);		
                }
			
		 }
		 if(action.equals("Delete"))
		 {
			 
				 ps1=cn.prepareStatement("Delete from H"+personrollno+" where MSG=?");
				
                ps1.setString(1,msg);
                int count =ps1.executeUpdate();
                if(count==1)
                {
                	
                response.sendRedirect("View.jsp");
                }
                else{
                	 RequestDispatcher rd=request.getRequestDispatcher("View.jsp");
                	 o.println("<script>");
     				o.println("alert('Message Could not Deleled ')");
     				o.println("</script>");
                	 rd.include(request, response);	
                }
			 
		 }
		 cn.close(); 
		}
		 catch(Exception e)
		 {e.printStackTrace();}
		
}}

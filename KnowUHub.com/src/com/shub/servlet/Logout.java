package com.shub.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class Logout extends HttpServlet {
@SuppressWarnings("unused")
protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	Connection cn = null;
	try {
		Class.forName("com.mysql.jdbc.Driver");
	    cn=DriverManager.getConnection("jdbc:mysql://localhost/xyz","root","12345");
	} catch (Exception e1) {
		
		e1.printStackTrace();
	}        
	HttpSession session =req.getSession(false);
		     session.getAttribute("rollno");
            PrintWriter o=res.getWriter();
            if(session==null)
            {
                   	o.println("THe Session is closed");
            }
            else
            {
            	session.invalidate();
//            	RequestDispatcher rd=req.getRequestDispatcher("fornt1.html");
//            	rd.include(req, res);
            	res.sendRedirect("./");
            }
      
      
    		  
	}}

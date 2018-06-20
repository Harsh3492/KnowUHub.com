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
public class Changepwd extends HttpServlet {
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
		HttpSession session=request.getSession(false);
         PrintWriter o=response.getWriter();
		 int rollno=(Integer) session.getAttribute("rollno");
          //System.out.println(rollno);
	      String oldpwd=request.getParameter("oldpwd");
	     // System.out.println(oldpwd);
	      String newpwd=request.getParameter("newpwd");
	      //System.out.println(newpwd);
		 try
		 {
			 ps=cn.prepareStatement("Update db set PASSWARD=? where Roll_no=? and PASSWARD=?");
			 ps.setString(1, newpwd);
			 ps.setInt(2, rollno);
			 ps.setString(3,oldpwd);
		     int count=ps.executeUpdate();
			 if(count==1)
				 {
				 RequestDispatcher rd=request.getRequestDispatcher("View.jsp");
				 o.println("<script>");
					o.println("alert('Password is changed')");
					o.println("</script>");
				 rd.include(request, response);
				 }
			 else
			 {
				 RequestDispatcher rd=request.getRequestDispatcher("View.jsp");
				 o.println("<script>");
					o.println("alert('Incorrect Password ')");
					o.println("</script>");
				 rd.include(request, response);
			 
			 }
			 cn.close();
		 }catch(Exception k)
		 {
			 k.printStackTrace();
		 }
		
	}

}

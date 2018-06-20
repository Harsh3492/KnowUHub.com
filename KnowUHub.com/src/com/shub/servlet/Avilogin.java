package com.shub.servlet;
import javax.servlet.*;
import javax.servlet.http.*;

import java.io.*;
import java.sql.*;

public class Avilogin extends HttpServlet
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
//			
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
		PreparedStatement ps1= null;
		PreparedStatement ps= null;
		ResultSet rs1= null;
		ResultSet rs = null;
		PrintWriter out=res.getWriter();
		int rollno=Integer.parseInt(req.getParameter("t1"));
		String pwd=req.getParameter("t2");
		try
		{
		PrintWriter o=res.getWriter();
		ps1=cn.prepareStatement("Select count(*) from db where ROLL_NO=?");	
		ps1.setInt(1,rollno);
		rs1=ps1.executeQuery();
		rs1.next();
		int c1=rs1.getInt(1);
		if(c1==1)
		{
			ps=cn.prepareStatement("Select count(*) from db where ROLL_NO=? and PASSWARD=?");	
			ps.setInt(1,rollno);
			ps.setString(2,pwd);
			 rs=ps.executeQuery();
			rs.next();
			int c=rs.getInt(1);
		
			if(c==1)
			{
	          HttpSession session=req.getSession();
	          session.setAttribute("rollno", rollno);
	          RequestDispatcher rd=req.getRequestDispatcher("StartAvi.jsp");
	          rd.include(req, res);
	          if((Integer)session.getAttribute("rollno")==null)
              res.sendRedirect("fornt1.html");
	          //res.sendRedirect("View.jsp");
	          
			}
			else{
				RequestDispatcher rd2=req.getRequestDispatcher("fornt1.html");
				o.println("<script>");
				o.println("alert('Roll Number or Password is Not Correct')");
				o.println("</script>");
				rd2.include(req, res);
				
				
			}
		}else{//
		
			RequestDispatcher rd2=req.getRequestDispatcher("fornt1.html");
			o.println("<script>");
			o.println("alert('Account Does not Created Please Go to SignUp Option')");
			o.println("</script>");
			rd2.include(req, res);
			
		}
			
	
		cn.close();
		}catch(Exception k)
		{
			out.println("Sorry Server Busy...........");
           System.out.println(k);
          out.print("Please Reload it.......");
		
		}
	
		
	}
}
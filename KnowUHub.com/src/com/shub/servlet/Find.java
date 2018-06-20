package com.shub.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/find")
public class Find extends HttpServlet {
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
		ResultSet rs=null;
		ResultSet rs1=null;
		PrintWriter o=response.getWriter();
		String name=request.getParameter("name");
       Map<String,String[]>
       m=request.getParameterMap();
       boolean b=m.containsKey("branch");
       String branch=null;
       if(b==true)
	   {
		   branch =request.getParameter("branch");
	   }
       if(name!=null && branch!=null)
   	{
   	
   		try
   		{
   			ps=cn.prepareStatement("Select Count(*) from db where  USER_NAME=? and BRANCH=?");
   		    ps.setString(1, name);
    	    ps.setString(2, branch);
    	    rs=ps.executeQuery();
   			rs.next();
   			int count=rs.getInt(1);
   			if(count==0)
   			{
   				System.out.println("Result not found");
   			}
   			else{
   		   ps1=cn.prepareStatement("Select USER_NAME,ROLL_NO from db where  USER_NAME=? and BRANCH=?");
        ps1.setString(1, name);
   	    ps1.setString(2, branch);
   	    rs1=ps1.executeQuery();
         while(rs1.next())
   		{
   		int resultrollno=rs1.getInt(2);
   		String resultname=rs1.getString(1);
   		RequestDispatcher rd=request.getRequestDispatcher("ResultRollno.jsp");
   		request.setAttribute("rollno", resultrollno);
   		request.setAttribute("name", resultname);
   		rd.include(request, response);
   	  // System.out.println(resultrollno);
   	   //System.out.println(resultname);
        }}
   			
   			cn.close();
   		}
   	    
   		catch(Exception k1)
   		{
   			k1.printStackTrace();
   		}
   		

   	}//end of all select  
	}//End of doPost
	

}

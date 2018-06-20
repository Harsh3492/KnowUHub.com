package com.shub.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class Sign extends HttpServlet {
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
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Connection cn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		    cn=DriverManager.getConnection("jdbc:mysql://localhost/xyz","root","12345");
		} catch (Exception e1) {
			
			e1.printStackTrace();
		}
		PreparedStatement ps=null;
		PreparedStatement ps1=null;
		PreparedStatement ps2=null;
		ResultSet rs=null;
		HttpSession session=req.getSession(false);
		PrintWriter o=res.getWriter();
		String OLD_FORMAT = "dd/MM/yyyy";
		String NEW_FORMAT = "yyyy/MM/dd";
		String name=req.getParameter("username");
		String Uppername=name.toUpperCase();
        int rollno=(int)session.getAttribute("rollno"); 
       
        String oldDateString =req.getParameter("dob");
        System.out.println("old date"+oldDateString);
        
        System.out.println("date");
        
        String pwd=req.getParameter("pwd");
	    Map<String,String[]>
		m=req.getParameterMap();
	    boolean b=m.containsKey("b");
	    String branch=null;
		String sex=null;
	    
		if(b==true)
		 branch =req.getParameter("b");
        
		boolean c =m.containsKey("sex");
		if(c==true)
     	sex=req.getParameter("sex");
		
		try{
			 ps2=cn.prepareStatement("Select count(*) from db where roll_no=?"); 
			 ps2.setInt(1,rollno);
			  rs=ps2.executeQuery();
			 rs.next();
			 int count1=rs.getInt(1);
			 if(count1==1)
			 {
				
				 o.println("<script>");
					o.println("alert('Person is already Exist')");
					o.println("return false;");
					o.println("</script>");		
			 }
			 else{
			 ps=cn.prepareStatement("insert into db values(?,?,?,?,?,?)"); 
	        ps.setString(1,name);
			ps.setInt(2,rollno);
			ps.setString(3,oldDateString);
			ps.setString(4,pwd);
			ps.setString(5,branch);
			ps.setString(6,sex);
			int count=ps.executeUpdate();
			if(count==1)
			{
				//System.out.println("Account Created Succesfully");
				//o.println("<h2>Account Created Succesfully</h2>");
				ps1=cn.prepareStatement("create table H"+rollno+"(Rollno int,msg varchar(1000),SDate varchar(50),time varchar(50),SNO int)");
				ps1.executeUpdate();
				RequestDispatcher rd=req.getRequestDispatcher("fornt1.html");
				 o.println("<script>");
					o.println("alert('Account Created Succesfully')");
			    o.println("</script>");		
			    rd.include(req, res);
			}
			else{
				RequestDispatcher rd=req.getRequestDispatcher("fornt1.html");
				 o.println("<script>");
					o.println("alert('Account Does not Created')");
			    o.println("</script>");
				//o.println("<h2>Plz enter Correct Information</h2>");
			}			
 		} 
			 cn.close();	 
		}catch(Exception k)
		{
			System.out.println(k);
		}
		

	}
	 
} 
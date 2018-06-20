<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>
<%@ page autoFlush = "true" %>
<%if(session.getAttribute("rollno")==null)
	response.sendRedirect("fornt1.html");%>

<html lang="en">
<%int rollno=(int)session.getAttribute("rollno");%>
<%!
PreparedStatement ps=null;
Connection cn=null;
ResultSet rs=null;
String b="EC";
String m="M";
String f="F";

public void jspInit()
{
try{
	//Class.forName("com.mysql.jdbc.Driver");
	//cn=DriverManager.getConnection("jdbc:mysql://localhost/xyz?autoReconnect=true","root","12345");
}catch(Exception e)
{
e.printStackTrace();
}
}
%>
<head>
 <title>KnowUHub</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="EditAviStart/css/avistart.css" />
   <script src="EditQuizStart/js/quizstart.js"></script>
  <link rel="shortcut icon" href="favicon.ico" />
  </head>
<body>
  <div class="jumbotron bg">
  <% 
  try{
	  Class.forName("com.mysql.jdbc.Driver");
		cn=DriverManager.getConnection("jdbc:mysql://localhost/xyz?autoReconnect=true","root","12345");
	  ps=cn.prepareStatement("select branch,sex from db where Roll_NO=?");
	  ps.setInt(1,rollno);
	  rs=ps.executeQuery();
	  rs.next();
	
	  String branch=rs.getString(1);
	  String sex=rs.getString(2);
	
	  if(branch.equals(b) && sex.equals(m))
	  {
	  %>
	 <a   href="./AviBoy.jsp" class="btn btn-lg  button">Start <i class="glyphicon glyphicon-play"></i></a>
	  <%}else if(branch.equals(b) && sex.equals(f)){%>
	  <a   href="./AviGirl.jsp" class="btn btn-lg  button">Start <i class="glyphicon glyphicon-play"></i></a>
	 <%}else{ %>
     <button onclick="alert('Sorry This is Only for EC 3rd year');" class="btn btn-lg  button">Start <i class="glyphicon glyphicon-play"></i></button>
	  
	   
	 <%} %>
	<%  
	cn.close(); 
  }catch(Exception e)
  {e.printStackTrace();}

  %>
    
  </div>
</body>



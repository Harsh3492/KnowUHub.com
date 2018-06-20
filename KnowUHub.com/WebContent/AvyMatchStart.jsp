<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>
<%@ page autoFlush = "true" %>
<%if(session.getAttribute("rollno")==null)
	response.sendRedirect("fornt1.html");%>

<html lang="en">
<%int rollno=(int)session.getAttribute("rollno");%>
<%!
PreparedStatement ps=null;
PreparedStatement psBranch=null;
Connection cn=null;
ResultSet rs=null;
ResultSet rsBranch=null;
int count;
String b="CSE";
String branch;
public void jspInit()
{
try{
//	Class.forName("com.mysql.jdbc.Driver");
	//cn=DriverManager.getConnection("jdbc:mysql://localhost/xyz?autoReconnect=true","root","12345");
}catch(Exception e)
{
e.printStackTrace();
}
}
%>

<head>
   <meta charset="utf-8">
	<title>KnowUHub</title>
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css">
    <link href="https://fonts.googleapis.com/css?family=Cabin" rel="stylesheet">
	<script defer src="https://use.fontawesome.com/releases/v5.0.6/js/all.js"></script>
	<link rel="shortcut icon" href="favicon.ico" />
	<link rel="stylesheet" href="EditaviMatch/css.css" />
</head>
<body>
  <div class="container-fuild">
	 <div class="row justify-content-center text-center rowHeight">
	    <div class="col-sm-12 align-self-center" >
		    <button class="btn btn-outline-dark btn-lg" data-toggle="modal" data-target="#calculator" id="btnId">Avy Match</button>
		</div>
	 </div>
	</div>
	<!----------------------------------------------------Start of modal--------------------------------------------------------->
	<div class="modal fade" id="calculator">
       <div class="modal-dialog modal-lg">
	      <div class="modal-content " style="background-color:#2c3e50;">

   			<div class="modal-body" style="color:white;">
	                         <div class="text-center">
	                            <h3 style="color:#c0392b;" >Instructions</h3>
	                          </div>	
	                           <hr class="line">
	                       <div class="text-justify qtxt" style="margin-left:25px; color:#ff7675;">
	                         
	                          <div class="text-center ">You need to go through this before</div><br>
	                        1. This is a "friend match" not a "love match".<br>
                       2. It is an indirect expression and interaction within class and it doesn't mean to offend anyone.<br>
                       3. Though if anyone get offended by any means, please inform us. We will try to sort it out.<br>
                       4. This is an example how you can submit your match.
                          <img alt="example image" class="img-fluid d-block mx-auto" style="margin-left:20px;margin-top:20px;" src="img/ex.JPG"> <br> 
                         
                          <div class="text-center">Thank you<br>
                            Team       <br>                     
                          knowUHub.com </div>    
     
     
	                        
	                       </div>
	                        <hr class="line">
	                        	  <div class="text-center">
	                        	  
	                           <%
	                        	  try{
	                        		  Class.forName("com.mysql.jdbc.Driver");
	                        		  cn=DriverManager.getConnection("jdbc:mysql://localhost/xyz?autoReconnect=true","root","12345");
	                         		  ps=cn.prepareStatement("select count(*) from avymatch1 where rollno="+rollno+"");
	                        		  rs=ps.executeQuery();
	                        		  rs.next();
	                        		  count=rs.getInt(1);
	                        		  psBranch=cn.prepareStatement("select branch from db where Roll_NO="+rollno+" ");
	                        		  rsBranch=psBranch.executeQuery();
	                        		  rsBranch.next();
	                        		  branch=rsBranch.getString(1);
	                        		 
	                        		 if(branch.equals("EC"))
	                        		 {
	                        		 if(count>=1)
	                        		  {
	                        	  
	                        	  %>
	                             <a href="#" onclick="alert('Sorry you already caste your vote');" class="btn btn-lg btn-outline-secondary rounded-circle">Go</a>
	                              <%}else{ %>
	                        	
	                               <a href="aviMatch1.jsp" class="btn btn-lg btn-outline-secondary rounded-circle">Go</a>
	                              <%
	                        	  }
	                        		 }
	                        		 else{	 
	                        	  %>
	                        	    <a href="#" onclick="alert('Sorry this event only for ECE 3rd Year');" class="btn btn-lg btn-outline-secondary rounded-circle">Go</a>
	                        	  <%
	                        	  }
	                              cn.close(); 
	                              }catch(Exception e){
	                        	  e.printStackTrace();
	                        	  }
	                               %>
	                          </div>

			</div><!----------End modal body--------------->
		  </div>
	   </div></div>
	<!----------------------------------------------------------End of modal----------------------------------------------------------->
  
     
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/js/bootstrap.min.js"></script>
    <script src="EditaviMatch/js.js" type="text/javascript"></script>
</body>
</html>
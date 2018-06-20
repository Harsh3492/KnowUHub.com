<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>
<%@ page  buffer="1kb" autoFlush = "true" %>
<%if(session.getAttribute("rollno")==null)
	response.sendRedirect("fornt1.html");%>

<html lang="en">
<%int rollno=(int)session.getAttribute("rollno");%>
<%!
PreparedStatement ps=null;
Connection cn=null;
ResultSet rs=null;

public void jspInit()
{
try{
	//Class.forName("com.mysql.jdbc.Driver");
	//cn=DriverManager.getConnection("jdbc:mysql://localhost/xyz","root","12345");
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
  <link rel="stylesheet" href="EditAvi/css/avi.css" />
   <script src="EditAvi/js/avi.js"></script>
  <link rel="shortcut icon" href="favicon.ico" />
  </head>
<body>
<div class="jumbotron background">
  <div class="modal-dialog">
    <div class="modal-content modalbg">
      <div class="modal-body">
             <div class="container-fulid"><!-----Start Search----->
			     <div class="row">
			     <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                   <form action="./aviboy" method="post" name="Resultrollno" onsubmit="return Resultrollnovalid()">
                   <div class="form-group">
                   <lable for="tx" class="srchtitle" ><b>The Crush</b></lable>
                   <input id="tx" type="text" class="form-control text-uppercase tx " name="cutegirl" placeholder="Write name of your Crush" />
                   </div>
                    <div class="form-group">
                   <lable for="tx" class="srchtitle" ><b>Smartest Girl</b></lable>
                   <input id="tx" type="text" class="form-control text-uppercase tx " name="smartgirl" placeholder="Write name of Smartest Girl" />
                   </div>
                    <div class="form-group">
                   <lable for="tx" class="srchtitle" ><b>Muggu Girl</b></lable>
                   <input id="tx" type="text" class="form-control text-uppercase tx " name="muggugirl" placeholder="Write name of Muggu Girl" />
                   </div>
                    <div class="form-group">
                   <lable for="tx" class="srchtitle" ><b>Cutest Girl</b></lable>
                   <input id="tx" type="text" class="form-control text-uppercase tx " name="agirl" placeholder="Write name of Cutest Girl" />
                   </div>
                   <div class="form-group">
                   <lable for="tx" class="srchtitle" ><b>Chipku Girl</b></lable>
                   <input id="tx" type="text" class="form-control text-uppercase tx " name="bgirl" placeholder="Write name of Chipku Girl" />
                   </div>
                   <div class="form-group">
				   <input  type="submit" class="form-control btn-primary" value="Submit" />
				   </div>
                   <%
                   try{
                	   Class.forName("com.mysql.jdbc.Driver");
                		cn=DriverManager.getConnection("jdbc:mysql://localhost/xyz?autoReconnect=true","root","12345");
                	  ps=cn.prepareStatement("select count(rollno) from aviboy where rollno="+rollno+""); 
                	  rs=ps.executeQuery();
                	  rs.next();
                	  int count =rs.getInt(1);
                	%>
                	  
				  
                   <%cn.close(); 
                   }catch(Exception e)
                   {e.printStackTrace();}
                   %>
                   </form><!-----End of form----->
				   </div>
				   </div>
		 </div>
		
    </div><!-- -----End of modal-dialog------ -->
  </div><!-- -----End of modal-content------- -->
</div><!-- -----End of jombotron------- -->
</div>

</body>



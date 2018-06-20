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
  <link rel="stylesheet" href="EditResultRollno/css/resultrollno.css" />
  <link rel="shortcut icon" href="favicon.ico" />
  </head>
<body>
<div class="jumbotron background">
  <div class=modal-dialog>
    <div class=modal-content>
      <div class="modal-body">
             <div class="container-fulid"><!-----Start Search----->
			     <div class="row">
			     <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                  <div class="table-responsive">
                  <table class="table" >
                  <tr>
                  <td>NAME</td>
                  <td>ROLL NUMBER</td>
                  </tr>
<% 
String name=request.getParameter("name");
String Uppername=name.toUpperCase();
Map<String,String[]>
m=request.getParameterMap();
boolean b=m.containsKey("branch");
String branch=null;
if(b==true)
{
branch =request.getParameter("branch");
}try{
	Class.forName("com.mysql.jdbc.Driver");
	cn=DriverManager.getConnection("jdbc:mysql://localhost/xyz?autoReconnect=true","root","12345");
PreparedStatement ps1=cn.prepareStatement("Select USER_NAME,ROLL_NO from db where  USER_NAME=? and BRANCH=?");
ps1.setString(1, Uppername);
   ps1.setString(2, branch);
   ResultSet rs1=ps1.executeQuery();
   
 while(rs1.next())
	{
%>

                   <tr>
                  <td><%=rs1.getString(1)%></td>
                  <td><%=rs1.getInt(2)%></td>
                  </tr>
                  
				   <%
	}cn.close();
	}catch(Exception k)
	{k.printStackTrace();
		}

				 %>
				 </table>
				   </div>
				   </div>
				 
				   </div>
		 </div>
		</div><!-- -----END of Body----- -->
		<div class="modal-footer"> 
		<a href="./View.jsp">Back To Home</a>
		</div>
    </div><!-- -----End of modal-content------- -->
  </div><!-- -----End of modal-dialog------ -->
</div><!-- -----End of jombotron------- -->

</body>



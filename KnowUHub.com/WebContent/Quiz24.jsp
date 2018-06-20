<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>

<%if(session.getAttribute("rollno")==null)
	response.sendRedirect("fornt1.html");%>

<html lang="en">
<%int rollno=(int)session.getAttribute("rollno");%>
<%!
String bgcolor=null;
PreparedStatement ps=null;
PreparedStatement ps1=null;
Connection cn=null;
ResultSet rs=null;
ResultSet rs1=null;
public void jspInit()
{
try{
	//Class.forName("com.mysql.jdbc.Driver");
	//cn=DriverManager.getConnection("jdbc:mysql://localhost/Knowuquiz?autoReconnect=true","root","12345");
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
  <link rel="stylesheet" href="EditQuiz/css/quiz.css" />
   <script src="EditQuiz/js/quiz.js"></script>
  <link rel="shortcut icon" href="favicon.ico" />
  </head>
<body>
  <body>
  <div class="container-fulid"  >
  <div class="container-fulid"  >
    <div class="row">
	   <div class="title">KnowU..IQ</div>
	</div>
   </div><!-- -----End of Container ------- -->
   <!-------------------End Of Title------------------------>
   <div class="container"  >
    <div class="row">
	  
	  
	     <form action="#">
		    <p class="question">Two men are playing chess.They have already played 5 games.Each has already won 3 games.How is it possible ?</p>
		 </form>
	   </div>
	   
	</div>
   </div><!-- -----End of Question Container ------- -->
   <div class="container"  >
    <div class="row">
	   <div class="col-lg-12">
	    	<form action="./quizexam" method="post">
			   <input type="text" class="form-control answer" name="answer" placeholder="Write Your Answer............................................" />
	           <input type="hidden" value="24" name="question"> 
			<a href="./Quiz23.jsp" class="btn btn-info pull-left button"><i class="glyphicon glyphicon-chevron-left"></i>Previous</a>
<% 
		try{
			Class.forName("com.mysql.jdbc.Driver");
			cn=DriverManager.getConnection("jdbc:mysql://localhost/Knowuquiz?autoReconnect=true","root","12345");
			ps=cn.prepareStatement("Select count(QUESTION) from q"+rollno+" where QUESTION=24");
		    rs=ps.executeQuery();
		    rs.next();
		    int count=rs.getInt(1);
		    if(count==1)
		    {
		    %>
			<input type="submit" style="margin-left:35%;"class="btn btn-danger button" value="Submited" disabled /> 
			<%}else{
			 %>
			 <input type="submit" style="margin-left:35%;"class="btn btn-primary button" value="Submit & Next" /> 
			 <% 
			}cn.close();}catch(Exception e)
			{e.printStackTrace();}

			 %>			<a href="./Quiz25.jsp" class="btn btn-info pull-right button">Next<i class="glyphicon glyphicon-chevron-right"></i></a>
			</form> 
			<hr class="line">
			 <a href="./Quiz1.jsp" class="btn btn-warning  option " >1</a>  
		  <a href="./Quiz2.jsp" class="btn btn-warning option " >2</a>
          <a href="./Quiz3.jsp" class="btn btn-warning option ">3</a>	
		  <a href="./Quiz4.jsp" class="btn btn-warning option ">4</a>
          <a href="./Quiz5.jsp" class="btn btn-warning option">5</a>	
          <a href="./Quiz6.jsp" class="btn btn-warning option ">6</a>	
          <a href="./Quiz7.jsp" class="btn btn-warning option " >7</a>
          <a href="./Quiz8.jsp" class="btn btn-warning option ">8</a>	
		  <a href="./Quiz9.jsp" class="btn  btn-warning option ">9</a>
          <a href="./Quiz10.jsp" class="btn btn-warning down option ">10</a>	
          <a href="./Quiz11.jsp" class="btn btn-warning option ">11</a>	
          <a href="./Quiz12.jsp" class="btn btn-warning option " >12</a>
          <a href="./Quiz13.jsp" class="btn btn-warning option ">13</a>	
		  <a href="./Quiz14.jsp" class="btn btn-warning option ">14</a>
          <a href="./Quiz15.jsp" class="btn btn-warning option ">15</a></br>	
          <a href="./Quiz16.jsp" class="btn btn-warning option ">16</a>	
          <a href="./Quiz17.jsp" class="btn btn-warning option " >17</a>
          <a href="./Quiz18.jsp" class="btn btn-warning option ">18</a>	
		  <a href="./Quiz19.jsp" class="btn btn-warning option ">19</a>
          <a href="./Quiz20.jsp" class="btn btn-warning option ">20</a>	
          <a href="./Quiz21.jsp" class="btn btn-warning option ">21</a>	
          <a href="./Quiz22.jsp" class="btn btn-warning option " >22</a>
          <a href="./Quiz23.jsp" class="btn btn-warning option ">23</a>	
		  <a href="./Quiz24.jsp" class="btn btn-warning option ">24</a>
          <a href="./Quiz25.jsp" class="btn btn-warning option ">25</a>	
          <a href="./Quiz26.jsp" class="btn btn-warning option ">26</a>	
          <a href="./Quiz27.jsp" class="btn btn-warning option " >27</a>
          <a href="./Quiz28.jsp" class="btn btn-warning option ">28</a>	
		  <a href="./Quiz29.jsp" class="btn btn-warning option ">29</a>
          <a href="./Quiz30.jsp" class="btn btn-warning option ">30</a>
          	
               <hr />	
<a href="./logout" class="btn btn-danger btn-lg center-block"><i class="glyphicon glyphicon-thumbs-up"> </i>I done it</a>			   
	   </div>
	</div>
   </div><!-- -----End of Answer Container ------- -->
</body>




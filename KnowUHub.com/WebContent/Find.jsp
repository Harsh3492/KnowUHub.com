<%@ page  buffer="1kb" autoFlush = "true" %>
<%
if((Integer)session.getAttribute("rollno")==null)
{
	
	response.sendRedirect("http://www.knowuhub.com");
	
}
%>

<html lang="en">
<%int rollno=(int)session.getAttribute("rollno");%>

<head>
  <title>KnowUHub</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="EditFind/css/find.css" />
   <script src="EditFind/js/find.js"></script>
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
                   <form action="./ResultRollno.jsp" method="post" name="Resultrollno" onsubmit="return Resultrollnovalid()">
                   <div class="form-group">
                   <lable for="tx" class="srchtitle" ><b>Enter Name</b></lable>
                   <input id="tx" type="text" class="form-control text-uppercase tx " name="name" placeholder="Enter Name" />
                   </div>
                   
                   <div class="form-group">
                   <lable for="tx" class="srchtitle"><b>Select Branch</b></lable></br>
                   <select name="branch" class="form-control tx" id="">
                    
	               <option name="branch" class="form-control tx" value="AE">Aeronautical Engineering</option>
	               <option name="branch" class="form-control tx" value="ME">Mechanical Engineering</option>
	               <option name="branch" class="form-control tx" value="ECE">Electronics & Communication Engineering </option>
	               <option name="branch" class="form-control tx" value="MCA">Master in Computer Application</option>
	               <option name="branch" class="form-control tx" value="CSE">Computer Science & Engineering</option>
	               </select>
                   </div>
                   
				   <div class="form-group">
				   <input  type="submit" class="form-control btn-primary" value="Find" />
				   </div >
                   </form><!-----End of form----->
				   </div>
				   </div>
		 </div>
		
    </div><!-- -----End of modal-dialog------ -->
  </div><!-- -----End of modal-content------- -->
</div><!-- -----End of jombotron------- -->
</div>
</body>



<%@ page  buffer="1kb" autoFlush = "true" %>
<%if(session.getAttribute("rollno")==null)
	response.sendRedirect("fornt1.html");%>

<html lang="en">
<%int rollno=(int)session.getAttribute("rollno");%>
<head>
  <title>KnowUHub</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="EditResult/css/result.css" />
   <script src="EditResult/js/result.js"></script>
  <link rel="shortcut icon" href="favicon.ico" />
  </head>
<body>
<% 
String name=(String)request.getAttribute("resultName");
int resultrollno=(int)request.getAttribute("resultrollno");
%>
<div class="jumbotron background">
  <div class=modal-dialog>
    <div class=modal-content>
      <div class="modal-body">
             <h2 style="font-family: 'Montserrat', sans-serif;" class="text-center">
             <%=name %>
             </h2>
             <div class="container">    
               <div class="col-xs-12">
                 <form  action="./chatstore" method="post" name="result"  onsubmit="return resultvalid() ">  <!----Start of Massege----->
                      <div class="form-group">
					    
						<textarea id="tx1" style="font-family: 'Montserrat', sans-serif;" class="form-control tx" rows="4" name="msg" placeholder="Write Your Message......" ></textarea>
						<input type="hidden" name="rollno" value="<%=resultrollno %>">
					      </div>
					        
                         <div class="form-group">
						 <input id="sm1" style="font-family: 'Montserrat', sans-serif;" type="submit" class="form-control btn-info" value="Send" placeholder="Submit" />
                      </div>						 
				  </form>	
    		  </div>			 
		  </div>
		 </div>
		
    </div><!-- -----End of modal-dialog------ -->
  </div><!-- -----End of modal-content------- -->
</div><!-- -----End of jombotron------- -->
</body>



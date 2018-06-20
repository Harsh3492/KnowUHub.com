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
  <link rel="stylesheet" href="EditReply/css/reply.css" />
  <script src="EditReply/js/reply.js"></script>
  <link rel="shortcut icon" href="favicon.ico" />
  </head>
<body>
<% 

int replyrollno=(Integer)request.getAttribute("replyrollno");
session.setAttribute("replyrollno",replyrollno);

%>
<div class="jumbotron background">
  <div class="modal-dialog">
    <div class="modal-content modalbg">
      <div class="modal-body">
             
             <div class="container">    
               <div class="col-xs-12">
                 <form  action="./reply" method="post" name="result" onsubmit="return resultvalid()">  <!----Start of Message----->
                      <div class="form-group">
					    
						<textarea id="tx1" class="form-control tx" style="font-family: 'Montserrat', sans-serif;" name="msg" rows="4" placeholder="Write Your Message......" ></textarea>
						
						
					      </div>
					        
                         <div class="form-group">
						 <input id="sm1" type="submit" style="font-family: 'Montserrat', sans-serif;" class="form-control btn-info" value="Reply" placeholder="Submit" />
                      </div>
                       						 
				  </form>	
    		  </div>			 
		  </div>
		 </div>
		
    </div><!-- -----End of modal-dialog------ -->
  </div><!-- -----End of modal-content------- -->
</div><!-- -----End of jombotron------- -->
</body>



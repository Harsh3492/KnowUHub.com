<%@ page  buffer="1kb" autoFlush = "true" %>
<html lang="en">

<head>
  <title>KnowUHub</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="EditSignin/css/signin.css" />
  <link rel="shortcut icon" href="favicon.ico" />
  </head>
<body>
<%
String email=(String)request.getAttribute("email");
int generatedotp=Integer.parseInt((String)request.getAttribute("otp"));
System.out.print(generatedotp);
int rollno=(int)request.getAttribute("rollno");
session.setAttribute( "generatedotp", generatedotp );
session.setAttribute( "rollno", rollno );

%>

<div class="jumbotron background">
  <div class=modal-dialog>
    <div class=modal-content>
      <div class="modal-body">
     <form action="./otp" method="post">
     <div class="form-group">
     <p style="font-family: 'Montserrat', sans-serif;">OTP is send on <%=email %> </p>
               
                   <input id="tx" type="text" style="font-family: 'Montserrat', sans-serif;" class="form-control " name="enterotp" placeholder="Enter Otp" />
                   
                   </div>
                
                   <div class="form-group">
						 <input id="sm1" style="font-family: 'Montserrat', sans-serif;" type="submit" class="form-control btn-info" value="Send" placeholder="Submit" />
                      </div></form>
                    
                      
      </div>
      <div class="modal-footer">
        <a href="./fornt1.html" class="pull-right" style="font-size:14px; color:red; margin-right:10px;" onclick="alert('Write your email id on Help option')">That's not my Email id</a>
      </div>
      
     
    </div><!-- -----End of modal-dialog------ -->
  </div><!-- -----End of modal-content------- -->
</div><!-- -----End of jombotron------- -->
<script>
alert("Please wait for OTP it may take some time")
</script>
</body>
</html>



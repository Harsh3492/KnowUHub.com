<%@ page  buffer="1kb" autoFlush = "true" %>
<head>
  <title>KnowUHub</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="EditSignUp/css/signup.css" />
  <script type="text/javascript" src="EditSignUp/js/signup.js"></script>
  <link rel="shortcut icon" href="favicon.ico" />
  </head>
<body>
<%
int rollno=(int)request.getAttribute("rollno");
session.setAttribute("rollno",rollno);
%>
<div class="jumbotron background">
  <div class=modal-dialog>
    <div class=modal-content>
      <div class="modal-body">
     <form action="./sign" method="post" name="fname" onsubmit="return valid()">
     <div class="form-group">
                       
              <div class="form-group">
			   <lable for="tx1"id="nm" style="font-family: 'Montserrat', sans-serif;" class="srchtitle"><b>User Name</b></lable></br>
                 <input id="tx1" type="text" style="font-family: 'Montserrat', sans-serif;" class="form-control text-uppercase tx" placeholder="Enter User name" name="username" />
			      </div>
		           <div class="form-group">
                     <lable for="tx2" id="nm" style="font-family: 'Montserrat', sans-serif;" class="srchtitle"><b>Your Roll Number is <p style="color:red;"><%=rollno %></p></b></lable></br>
                      </div>	
              	         <div class="form-group">
                          <lable for="tx3" id="nm" style="font-family: 'Montserrat', sans-serif;" class="srchtitle"><b>D.O.B</b></lable></br>
                          <input id="tx3" type="date" style="font-family: 'Montserrat', sans-serif;" class="form-control tx"placeholder="e.g.DD-MM_YYYY" name="dob"/>
			               </div>				 
		                    <div class="form-group">
				               <lable for="tx4" id="nm" style="font-family: 'Montserrat', sans-serif;" class="srchtitle"><b>Create Password</b></lable></br>
                                <input id="tx4" type="password" style="font-family: 'Montserrat', sans-serif;" class="form-control tx" placeholder="Enter Password"  name="pwd"/>
				                    </div>
		                             <div class="form-group">
				                       <lable for="tx5"style="font-family: 'Montserrat', sans-serif;" id="nm" class="srchtitle"><b>Re-enter Password</b></lable></br>
                                             <input id="tx5"style="font-family: 'Montserrat', sans-serif;" type="password" class="form-control tx" placeholder="Re-enter password" name="repwd" />
				                             </div>
				      <label id="nm1" style="font-family: 'Montserrat', sans-serif;" class="srchtitle" ><b>Select Your Branch</label><br>
                      <select id="bc "class="form-control tx" name="b" >
                      <option value="CSE" style="font-family: 'Montserrat', sans-serif;" name="b">Computer Science & Engineering</option>
                      <option value="AE" style="font-family: 'Montserrat', sans-serif;" name="b">Aeronautical Engineering</option>
                      <option value="ME" style="font-family: 'Montserrat', sans-serif;" name="b">Mechanical Engineering</option>
	                  <option value="EC" style="font-family: 'Montserrat', sans-serif;" name="b">Electronics & Communication Engineering</option>
					  <option value="MCA" style="font-family: 'Montserrat', sans-serif;" name="b">Master in Computer Application</option>
                      </select><br>
				      <div class="form-group">
				     <lable for="m1" style="font-family: 'Montserrat', sans-serif;" id="nm" class="srchtitle"><b>Sex</b></lable></br>
		             <input id ="m1" style="font-family: 'Montserrat', sans-serif;"  type="radio" name="sex" value="M"><b id="m">Male</b>
				     <input id ="m1" style="font-family: 'Montserrat', sans-serif;"  type="radio" name="sex" value="F"><b id="m" >Female</b><br>
                      </div>                  	
					 <div class="form-group">	          
				   <input id="sm1"  class="form-control btn-info"  style="font-family: 'Montserrat', sans-serif;" type="submit" value="Submit" placeholder="Submit" />
                     
				  </div>         
                       
     </div></form>
                      
                      
      </div>
      
     
    </div><!-- -----End of modal-dialog------ -->
  </div><!-- -----End of modal-content------- -->
</div><!-- -----End of jombotron------- -->
<script type="text/javascript">
function valid()
{
var x=document.forms["fname"]["username"].value;
if(x=="")
{
alert("Name is not filled");
return false;
}
var z=document.forms["fname"]["pwd"].value;
if(z=="")
{
	  alert("The Password is not Filled");
	   return false;
}
var a=document.forms["fname"]["repwd"].value;
if(a=="")
{
	  alert("Please Re Enter Password");
     return false;
}
if(z!=a)
{
	  alert("Password does not match");
    
	   return false;
}
 if((z).length<8)
{
	  alert("Please enter password more then 8 Character");
	  return false;
}  
 var ck=document.forms["fname"]["sex"].value;
if(ck==false)
	{
	alert("Please Select Your Gender ");
    return false;
	}
var dob=document.forms["fname"]["dob"].value;
if(dob=="")
	{
	alert("Please Enter Date  ");
    return false;
	}	

}

</script>
</body>



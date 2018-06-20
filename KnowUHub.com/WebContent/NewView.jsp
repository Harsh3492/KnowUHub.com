<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>
<%@ page import = "javax.servlet.RequestDispatcher" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="javax.xml.bind.DatatypeConverter"%>
<%@ page import="java.security.*"%>
<%@ page  buffer="1kb" autoFlush = "true" %>
<%if((Integer)session.getAttribute("rollno")==null)

	response.sendRedirect("fornt1.html");
%>


<html lang="en">
<%int rollno=(int)session.getAttribute("rollno");
response.setIntHeader("Refresh",60);
%>
<%!
PreparedStatement ps=null;
PreparedStatement ps1=null;
Connection cn=null;
ResultSet rs=null;
ResultSet rs1=null;
String msg;
int replyrollno;
String Newstr="";
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
  <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet">
  <link rel="stylesheet" href="Editview/css/view.css" />
  <link rel="shortcut icon" href="favicon.ico" />
   <style>
body {
    font-family: "Lato", sans-serif;
}

.sidenav {
    height: 100%;
    width: 0;
    position: fixed;
    z-index: 1;
    top: 0;
    left: 0;
    background-color: #111;
    overflow-x: hidden;
    transition: 0.5s;
    padding-top: 60px;
}

.sidenav a {
    padding: 8px 8px 8px 32px;
    text-decoration: none;
    font-size: 25px;
    color: #818181;
    display: block;
    transition: 0.3s;
}

.sidenav a:hover {
    color: #f1f1f1;
}

.sidenav .closebtn {
    position: absolute;
    top: 0;
    right: 25px;
    font-size: 36px;
    margin-left: 50px;
}

@media screen and (max-height: 450px) {
  .sidenav {padding-top: 15px;}
  .sidenav a {font-size: 18px;}
}
</style>
   </head>
<body >
<%
try{
	Class.forName("com.mysql.jdbc.Driver");
	cn=DriverManager.getConnection("jdbc:mysql://localhost/xyz?autoReconnect=true","root","12345");

	ps1=cn.prepareStatement("Select count(msg) from H"+rollno+" ");

	 rs1=ps1.executeQuery();
	rs1.next();
	 int countmsg=rs1.getInt(1);
	 //System.out.println(countmsg);

%>

<div class="jumbotron background">
<!-- -------------------Start of Slider-------------------------- -->
<div id="mySidenav" class="sidenav">
  <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
    <a href="./logout" style="font-size:20px;"><i class="glyphicon glyphicon-off" style="font-family: 'Montserrat', sans-serif;"></i>&nbsp&nbspLogout</a>
	<a data-toggle="modal" data-target="#changepwd" style="font-size:20px;" style="font-family: 'Montserrat', sans-serif;">Change Password</a>

    <a href="#" onclick="swal('Avy Match', 'Sorry Event is closed.Result will be announced on 27/03/2018');"; style="font-size:20px;">Avy Match<p style="color:red">(Only for ECE 3rd-Y)</p></a>
	<a href="./theCalculater"  style="font-size:20px;font-family:'Montserrat', sans-serif;">the Calculator</a>
	<a onclick="alert('Coming Soon');" href="#" style="font-size:20px;">Quiz</a>
	<%if(rollno==1518710038){ %>
	<a href="./sendMail" style="font-size:20px;font-family: 'Montserrat', sans-serif;">Send</a>
	<%} %>
</div>
<span style=""class="btn-danger btn sidermenu"  onclick="openNav()"><i class="glyphicon glyphicon-tasks"></i></span>
<!-- -------------------End of Slider-------------------------- -->


<!-- ----------------------------------------Start of Change pAssword--------------------------------------------------------- -->
<div class="modal fade" id="changepwd"><!------Start of change modal----------->
 <div class="modal-dialog modal-lg modal-md modal-sm modal-xs">
   <div class="modal-content modalbg">
   <div class="modal-header">
    <p class="srchtxt serachname" >Change Password <button type="button" class="close" data-dismiss="modal">&times;</button></p>
   </div><!-- ----End of modal header------- -->
   <div class="modal-body">
   <div class="container-fulid"><!-----Start Change password BODY----->
			     <div class="row">
			     <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                   <form action="./changepwd" name="changepwd" onsubmit="return valid()" method="post">

                   <div class="form-group">
                   <lable for="tx" class="srchtitle text-center" style="font-family: 'Montserrat', sans-serif;"><b>OLD PASSWORD</b></lable></br>
                   <input id="tx" type="password" style="font-family: 'Montserrat', sans-serif;"class="form-control tx" name="oldpwd" placeholder="Enter old Password" />
                   </div>
                   <div class="form-group">
                   <lable for="tx2" class="srchtitle text-center"style="font-family: 'Montserrat', sans-serif;">New Password</lable>
                   <input id="tx2" type="password" style="font-family: 'Montserrat', sans-serif;"class="form-control tx" name="newpwd" placeholder="Enter New Password"/>
                   </div>
                   <div class="form-group">
                   <lable for="tx3" class="srchtitle text-center"style="font-family: 'Montserrat', sans-serif;">Confirm New Password</lable>
                   <input id="tx3" type="password" style="font-family: 'Montserrat', sans-serif;"class="form-control tx" name="cnfnewpwd" placeholder="Re-enter New Password"/>
                   </div>
				   <div class="form-group">
				   <input  type="submit" style="font-family: 'Montserrat', sans-serif;" class="form-control btn-primary" value="Change Password" />
				   </div >
                   </form><!-----End of form----->
				   </div>
				   </div>

                </div><!-----End Search----->
   </div><!-- ----End of modal body------- -->

   </div>
 </div>
</div><!-- -------End of change modal---------- -->
<div class="col-lg-4 col-md-4 col-sm-4 col-xs-4  center-block" >
 <div class="contaner-fulid">
 <div class="row">
 <div class="col-lg-6 col-md-12 col-sm-12 col-xs-12">
<button type="button"  class=" btn bt btn-info center-block btn-position " data-toggle="modal" data-target="#search" style="font-family: 'Montserrat', sans-serif;"><i class="glyphicon glyphicon-search" ></i>&nbspSearch&nbsp</button><!-----Search button----->
      <div class="modal fade" id="search">
	   <div class="modal-dialog modal-lg modal-md modal-sm modal-xs" >
	     <div class="modal-content modalbg">
		    <div class="modal-header">
			 <p class="srchtxt serachname">Search <button type="button" class="close" data-dismiss="modal">&times;</button></p>
			  </div><!-----End of header----->
			   <div class="modal-body">
               <div class="container-fulid"><!-----Start Search----->
			     <div class="row">
			     <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                   <form action="./search" name="search"  method="post" onsubmit="return searchvalid()">

                   <div class="form-group">
                   <lable for="tx" class="srchtitle text-center" style="font-family: 'Montserrat', sans-serif;"><b>Roll Number</b></lable></br>
                   <input id="tx" type="text" class="form-control tx"style="font-family: 'Montserrat', sans-serif;" name="rollno" placeholder="e.g. 0000000001" />
                   </div>

				   <div class="form-group">
				   <input  type="submit" style="font-family: 'Montserrat', sans-serif;" class="form-control btn-primary" value="Search" />
				   </div >
                   </form><!-----End of form----->
				   </div>
				   </div>

                </div><!-----End Search----->

			</div><!-----End of body----->
			<div class="modal-footer">
			  <a class="find" href="" onclick="alert('Sorry Working On it.......')" >Find the Roll Number?</a>
			</div><!----End of footer----->
		 </div>
	   </div>
	  </div><!----End of Search Modal----->
	</div>
    <div class="col-lg-6 col-md-12 col-sm-12 col-xs-12">
<button type="button"  class=" btn btn-info center-block msgbtn-position" style="font-family: 'Montserrat', sans-serif;"data-toggle="modal" data-target="#massege"><i class="glyphicon glyphicon-envelope"></i>Message<span class="badge countmsg"><%=countmsg %></span></button><!-----Massege button----->
	    <div class="modal fade" id="massege">
		  <div class="modal-dialog">
		   <div class="modal-content">
		     <div class="modal-header">
			   <p class="msgtxt">Messages <button type="button"  class="close" data-dismiss="modal">&times;</button></p> <!-- ----Start of Message----- -->
			 </div><!-----End of header----->
    			<div class="modal-body">


				   <div class="form-group">



			    <%
			      ps=cn.prepareStatement("Select msg,ROLLNO from H"+rollno+" order by SNO desc");
                  rs=ps.executeQuery();
                  while(rs.next())
                  {
                %>
				   <div class="contaner-fulid">
                   <div class="row">
                   <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
				   <form  action="./replyrollno" method="post">
				    <%
                      msg=rs.getString(1);
				      replyrollno=rs.getInt(2);

				 %>
			           <p style="font-family: 'Montserrat', sans-serif;"><%=msg%></p>

				       <input type="hidden"  name="msg" value="<%=msg%>">
				       <input type="hidden" name="value" value="<%
				    		//Code For decryption Massege

				       %>" >

				   <div class="col-lg-6 col-md-4 col-sm-4 col-xs-4">
				   <input style="font-family: 'Montserrat', sans-serif;" type="submit" class="pull-left btn btn-info" name="action" value="Reply" />
				   </div>
				   <div class="col-lg-6 col-md-8 col-sm-8 col-xs-8">
				   <div class="form-group">
				        <!-- ------------Alert Option------------------------------------ -->
				        <div id="deleteAlert" class="modal fade ">
				          <div class="modal-dialog modal-sm">
				            <div class="modal-content">

				              <div class="modal-body">
				              Are You Sure You want to Delete
				              </div>
				              <div class="modal-footer">
                                 <input id="sm1"  style="font-family: 'Montserrat', sans-serif;"type="button" data-dismiss="modal" class="pull-right btn btn-warning" value="Cancel"   />
				                 <input id="sm1" type="submit" class="pull-right btn btn-danger" value="Delete" name="action"  />
				              </div>
				            </div>
				          </div>
				        </div>
                        <!-- ----------------End Alert-------------------------------- -->
						 <input id="sm1" type="submit" style="font-family: 'Montserrat', sans-serif;" onclick="if (confirm('Are you sure you want to Report?')) { form.action='./replyrollno'; } else { return false; }" class="pull-right btn btn-warning" value="Report" name="action"  />
						 <input id="sm1" type="submit" style="font-family: 'Montserrat', sans-serif;" onclick="if (confirm('Are you sure you want to delete?')) { form.action='./replyrollno'; } else { return false; }" class="pull-right btn btn-danger" value="Delete" name="action"  />
                      </div> </div>

				   </form>


				      </div></div><hr class="line"></div>



                   <%

                    }
                  cn.close();
	                }catch(Exception k)
	                {
	                	k.printStackTrace();
	                	out.println("Sorry Server Busy...........");

	                	out.print("Please Reload it.......");

		            }


				   %>



				 </div>


				</div><!-----End of  Massege body----->
                <div class="modal-footer"></div> <!-----End of footer----->
			 </div>
		  </div>
		</div><!----End of Massege Modal----->
		</div>
	  </div><!-----End of row----->
 </div>
 </div><!-----End of cntmenu----->
</div><!-----End of Jumbotrom----->

<script type="text/javascript">

function reportCnmf()
{
var reportAgree=confirm("Are you sure you want to report that person?");
if(reportAgree)
	return true;
else
	return false;
}


function searchvalid()
{
    var rollno=document.forms["search"]["rollno"].value;
	if(rollno=="")
	{
		alert("Please Enter Rollno");
		return false;
	}


	if(isNaN(rollno))
	{
		alert("Please Enter Valid Roll Number");
		return false;
	}
}
////////////////////////////////////////////////////////
function openNav() {
    document.getElementById("mySidenav").style.width = "250px";
}

function closeNav() {
    document.getElementById("mySidenav").style.width = "0";
}
</script>
  <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script src="Editview/js/view.js"></script>
</body>

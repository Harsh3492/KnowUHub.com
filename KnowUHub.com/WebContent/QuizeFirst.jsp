<%@ page autoFlush = "true" %>
<%if(session.getAttribute("rollno")==null)
	response.sendRedirect("fornt1.html");%>
	

<html lang="en">
<%int rollno=(int)session.getAttribute("rollno");%>
<head>
 <title>KnowUHub</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="EditQuizStart/css/quizstart.css" />
   <script src="EditQuizStart/js/quizstart.js"></script>
  <link rel="shortcut icon" href="favicon.ico" />
  </head>
<body>
  <div class="jumbotron bg">
    <a   href="./quizstart" class="btn  center-block button">Start <i class="glyphicon glyphicon-play"></i></a>
  </div>
</body>




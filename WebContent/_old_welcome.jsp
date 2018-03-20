<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Guess Me::Welcome</title> 
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
    <!-- Optional Bootstrap theme -->
    <link rel="stylesheet" href="css/bootstrap-theme.min.css">
    <link rel="stylesheet" href="css/docorate.css" >
</head>
<body class="bg">

   <div class="navTop">
    <span class="navElements"><a href="#">Home</a></span>
    <span class="navElements"><a href="#">How To play</a></span>
    <span class="navElements"><a href="#">About Us</a></span>
   </div>  
    <span class="blink">Guess Me Game!!</span>

<h1>Hi, <span style="color:green">${gamer.fullName}</span> !</h1>
<table> 
	<tr>
		<th>Full Name</th><th>Gamer Name</th><th>Gender</th><th>Login At</th> <th>Status</th>
	</tr> 
	<c:forEach var="gamerLog" items="${onlineGamers}" > 
		<tr> 
			<td>${gamerLog.gamer.fullName}</td>
			<td>${gamerLog.gamer.gamerName}</td>
			<td>${gamerLog.gamer.gender}</td> 
			<td>${gamerLog.loginAt}</td> 
			<td>${gamerLog.activeStatus}</td> 
			
		</tr> 
	</c:forEach> 
</table>

    <script src="js/jquery-1.11.3.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</body>
</html>
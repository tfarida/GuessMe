<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Guess Me - Game</title>
</head>
<body>
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

</body>
</html>
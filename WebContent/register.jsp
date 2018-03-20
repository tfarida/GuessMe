<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Guess Me::Register</title> 
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
    <!-- Optional Bootstrap theme -->
    <link rel="stylesheet" href="css/bootstrap-theme.min.css">
    <link rel="stylesheet" href="css/docorate.css" >
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js" type="text/javascript"></script>	
    <script src="javascript/register.js"></script>
</head>
<body class="bg">
    <div class="navTop">
        <span class="navElements"><a href="#">Home</a></span>
        <span class="navElements"><a href="#">How To play</a></span>
        <span class="navElements"><a href="#">About Us</a></span>
       </div>
    <span class="blink">Guess Me Game!!</span>
<!--register form --> 

<form id="form" class="loginform" method="POST" action="register">
<!-- <form id="form" class="loginform" > -->
    <div class="container">
    <p style="color: yellow">${successMessage}</p>
	<p style="color: red">${errorMessage}</p>
      <label for="userName"><b>Username</b></label>
      <input type="text" placeholder="Enter username" name="userName" required>
      
       <label for="email"><b>Email</b></label>
      <input type="text" placeholder="Enter e-mail address" name="email" required>
      
      <label for="password"><b>Password</b></label>
      <input type="password" placeholder="Enter password" name="password" id="password" required>
      
      <label for="confirmPassword"><b>Confirm Password</b></label>
      <input type="password" placeholder="Re-enter password" name="confirmPassword" id="confirmPassword" required>
      <p><span id='passwordStatus'></span></p>
      
       <label for="fullName"><b>Full Name</b></label>
      <input type="text" placeholder="Enter full name" name="fullName" required>  
        
      <label for="gender"><b>Gender</b></label>
      <input type="radio"  name="gender" value="M" required><label for="gender"><b>male</b></label>
      <input type="radio"  name="gender" value="F" required><label for="gender"><b>female</b></label> 
               
      <button id="btnSubmit" type="submit">Register</button>      
    </div>    
  </form>
    <script src="js/jquery-1.11.3.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</body>
</html>
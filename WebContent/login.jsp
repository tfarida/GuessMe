<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Guess Me::Login</title> 
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
<!--login form --> 

<form class="loginform" method="POST" action="login">
    <div class="imgcontainer">
      <img src="images/img_avatar.jpg" alt="Avatar" class="avatar">
    </div>  
    <div class="container">
      <label for="emailOrGamerName"><b>E-mail or Username</b></label>
      <input type="text" placeholder="Enter e-mail address or username" name="emailOrGamerName" required>
  
      <label for="password"><b>Password</b></label>
      <input type="password" placeholder="Enter Password" name="password" required>
          
      <button class="btn btn-success" type="submit">Login</button>
      <label>
        <input type="checkbox" checked="checked" name="remember"> Remember me
      </label>
    </div>
  
    <div class="container" >
      <!-- <button type="button" class="btn btn-success" class="registor">Register</button> -->
      <a style="color: yellow" href="register.jsp">Sign Up</a>
    </div>
  </form>
    <script src="js/jquery-1.11.3.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</body>
</html>
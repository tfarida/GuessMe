<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Guess Me Game!!</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="docorate.css" >
</head>
<body class="bg">

<nav class="navbar navbar-inverse headerTop">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li><a class="navbar-brand" href="#">Logo</a></li>>
        <li class="active"><a href="#">Home</a></li>
        <li><a href="#">How To play</a></li>
        <li><a href="#">About US</a></li>
        
      </ul>
      
      
    </div>
  </div>
</nav>
  
<div class="blink">Guess Me Game!!</div>


<!--login form --> 

<form class="loginform" action="login">
    <div class="imgcontainer">
      <img src="images/img_avatar.jpg" alt="Avatar" class="avatar record">
    </div>
  
    <div class="container record">
      <div><label for="uname"><b>Username</b></label></div>
      <div><input type="text" placeholder="Enter Username" name="uname" required>
      </div>
      <div><label for="psw"><b>Password</b></label></div>
      <div><input type="password" placeholder="Enter Password" name="psw" required></div>
          
      <div ><button class="btn btn-success" type="submit">Login</button>
      
        <input type="checkbox" checked="checked" name="remember"> Remember me</div>
      
    </div>
  
    <div class="container signup" >
      
      <a  href="register.jsp" class="btn btn-default">Sign Up</a>
    </div>
  </form>

  <video class="fullscreen" autoplay loop>
  <source src="images/welcome.mp4" type="video/mp4">
</video>
    
    <script src="js/jquery-1.11.3.min.js"></script>
    <script src="js/bootstrap.min.js"></script>




</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="ct" %>
<html lang="en">
<head>
<title>Guess Me</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="docorate.css">
</head>
<body class="bg">

	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#myNavbar">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">Logo</a>
			</div>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav">
					<li class="active"><a href="#">Home</a></li>
					<li><a href="#">How To play</a></li>
					<li><a href="#">About US</a></li>
				</ul>


			</div>
		</div>
	</nav>

	<div class="container text-center">
		<div class="row">
			<div class="col-sm-2 well" id="leftside">
				<div class="well">
					<p>
						<a href="#">${gamer.fullName}</a>
					</p>
					
				</div>
				<div class="well">
					
					
				</div>

				<p>
					<a href="#">Game 1</a>
				</p>
				<p>
					<a href="#">Game 2</a>
				</p>
				<p>
					<a href="#">Game 3</a>
				</p>
			</div>
			<div class="col-sm-7" id="centerSide">

				<div class="row">
					<div class="col-sm-12">
						<div class="panel panel-default text-left">
							<div class="panel-body">
								<p contenteditable="true">Playing Game</p>

							</div>
						</div>
					</div>
				</div>

				<div class="row">
					<div class="col-sm-12">
						<div class="col-sm-3">
							<div class="well">
								
							</div>
						</div>
						<div class="col-sm-9">
							<div class="well">
								
							</div>
						</div>
					</div>

					<div class="col-sm-12">
						<div class="col-sm-3">
							<div class="well">
								
							</div>
						</div>
						<div class="col-sm-9">
							<div class="well">
								
							</div>
						</div>
					</div>
					<div class="col-sm-12">
						<div class="col-sm-3">
							<div class="well">
								
							</div>
						</div>
						<div class="col-sm-9">
							<div class="well">
								
							</div>
						</div>
					</div>
					<div class="col-sm-12">
						<div class="col-sm-3"></div>

					</div>

				</div>


			</div>
			<div class="col-sm-3 well" id="rightSide">
				<div class="thumbnail">
					<p>Online friends</p>	
					
					<ul> 
					
						<ct:forEach var="onlineGamer" items="${onlineGamers}" > 
						<!-- <p> -->
							<%-- <button class="onlineGamer" id="${onlineGamer.gamer.id}" value="${onlineGamer.gamer.gamerName}" > </button>	 --%>						
							<%-- <strong> <a class="onlineGamer" id="${onlineGamer.gamer.id}" href="gam" > ${onlineGamer.gamer.gamerName} </a> </strong> --%>
						<!-- </p> -->
						<li> <strong> <a class="onlineGamer" id="${onlineGamer.gamer.id}" href="http://localhost:8080/GuessMe/StartGame?opId=${onlineGamer.gamer.id}"> ${onlineGamer.gamer.gamerName} </a> </strong> </li>
						</ct:forEach> 
					</ul>
					

				</div>

			</div>
		</div>
	</div>



</body>
</html>
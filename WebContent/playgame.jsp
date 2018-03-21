<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
					<li><a href="#">logout</a></li>

				</ul>


			</div>
		</div>
	</nav>

	<div class="contai" align="center">



		
		<div class="col-sm-3 left">
			<div class="well">
				<p>
					<a href="#">My Profile</a>
				</p>

			</div>
			<div class="well"></div>



			<p>
				<a href="#">Game 3</a>
			</p>
		</div>

		<div class="col-sm-8 right">
			<div class="row">
				</div>
				<div class="col-sm-8rightofRight">
					<div class="well">
						<p>
							<h2 >Guess Me </h2><br>
 			
 			
 			<div id="winner"></div>
 		 	Start guessing your friend No.
		 	<div class="panel panel-primary">
		 	
					<input type="text" min="0" 
								step="1" 
								name="myGuess" 
								maxlength="4" 
								class="form-control" 
								id="myGuess"
								placeholder="Enter 4 digits" 
								pattern = "^([\d])((?!\1)[\d])(?!\2)((?!\1)[\d])(?!\3)(?!\2)((?!\1)[\d])$"
								required
				    /> 
				</div><br>
					<button
		                    type="submit"
		                    id="btnSubmit"
		                    class="btn btn-primary">
		                    Submit
		                </button>			
				 	 &nbsp;
					<button
		                    type="Reset"
		                    id="btnReset"
		                    class="btn btn-primary">
		                    Reset
		                </button>
		            <br><br>							
			
						</p>

					</div>
				</div>
			</div>
		</div>
	</div>
	</div>
	</div>
	
	
	
	<video class="fullscreen" autoplay loop>
		<source src="welcome.mp4" type="video/mp4">
	</video>

</body>
</html>
// Written by Romie(Yee Mon Zaw) on 19th March for Ajax calls

var counter = 0;

$(function() {
	console.log("I am here!");
	$("#btnSubmit").click(function() {
		var myGuess = $("#myGuess").val();
		var btnValue = $("#btnSubmit").val();
		//if(btnValue.match(/^([\d])((?!\1)[\d])(?!\2)((?!\1)[\d])(?!\3)(?!\2)((?!\1)[\d])$/)){
			$.ajax({
				url : "GameSolver",
				data : {
					'myGuess' : myGuess,
					 'action' : 'checker'
				},
				dataType : "json",
				type : "POST",
				success : winner,
				fail : looser
			})
		/*}
		else{
			$("<div class='alert alert-warning'>")
				.html("<strong>Please enter 4 different digits. </strong>")
				.appendTo("#winner");
			$("#btnSubmit").attr("disabled",false);
		}*/

	});

	function winner(response) {
		console.log(response);
		if (response != undefined) {
			// $("#displayTable").hide();
			counter++;
			console.log("counter " +counter);
			if (counter == 1) {
				$("<div>")
						.html(
								"<table class='table'>"
										+ "<tr class='danger'>"
										+ "<td><strong>#</strong></td>"
										+ "<td align='center'>&nbsp;&nbsp;<strong>Your guessing Number</strong></td>"
										+ "<td align='center'><strong>(Matching Digit , Matching Position)</td></tr></strong>")
						.appendTo("#dataDiv");
			}
		}
		
		if(counter%2 ==0){
			$("<div>")
				.html(
					"<table class='table'>" + "<tr class='success'>" + "<td>"
							+ counter + "</td>" + "<td>" + response.number
							+ "</td>" + "<td>(" + response.match[0] + ","
							+ response.match[1] + ")</td></td></tr>")
				.appendTo(
					"#dataDiv");
		}else{
			$("<div>")
				.html(
					"<table class='table'>" + "<tr class='info'>" + "<td>"
							+ counter + "</td>" + "<td>" + response.number
							+ "</td>" + "<td>(" + response.match[0] + ","
							+ response.match[1] + ")</td></td></tr>")
				.appendTo(
					"#dataDiv");
		}
		
		if((response.match[0] ==4) && (response.match[1] == 4)){
			$("<div class='alert alert-success'>")
				.html("<strong>Congratulations ! You Won!</strong>")
				.appendTo("#winner");
			 $("#btnSubmit").attr("disabled", true);
		}
		
		if(counter > 10){
			$("<div class='alert alert-danger'>")
				.html("<strong>Sorry, you have reached the maximum attempt. You Fail ! </strong>")
				.appendTo("#winner");
			$("#btnSubmit").attr("disabled", true);
		}	
	}

	function looser() {
		$("<div class='alert alert-warning'>")
			.html("<strong>Error ! Please try again later. </strong>")
			.appendTo("#winner");
		$("#btnSubmit").attr("disabled",false);
	}
	
	$("#btnReset").click(function(){
		  $("#dataDiv").empty();
		  $("#btnSubmit").attr("disabled",false);
		  $("#winner").empty();
		  $("#myGuess").empty();
		  counter = 0;
	});
	
// Retrieve Opponent's details
	//console.log("Ready to retrieve ");
	$("#btnRetrieve").click(function() {
		console.log("Ready to retrieve ");
		var opponentId = $("#opponentId").val();
		console.log("opponentId = " + opponentId);
		$.ajax({
				url : "GameSolver",
				data : { 'opponentId' : opponentId,
						 'action' : 'getMyOpponent'
						},
				dataType : 'text',
				type : "POST",
				success : retrieveOpponent,
				fail : DBError
		})
	});
	
	function retrieveOpponent(opponentDetails){
		var data = JSON.parse(opponentDetails);
		console.log(data);
		$("<div>")
		.html(
			"<table class='table'>" + "<tr class='info'>" + "<td>"
					+ data.players[1].gamer.gamerName + "</td>" + "<td>" + data.players[1].gamer.emailAddress
					+ "</td></td></tr>")
		.appendTo(
			"#p2");
	}
	
	function DBError(){
		console.log("Error");
	}
	
	
//Start play a game
	$("#btnPlay").click(function(){
		var secretNo = $("#secretNo").val();
		$.ajax({
				url : "GameSolver",
				data : {
						"secretNo" : secretNo,
						"action" : "keepMeSecret"
					},
				datatType : "text",
				success : startPlay,
				fail : gameError
		});
	})
	
	function startPlay(data){
		console.log(data);
		$("<div>")
			.html("Your secret No is : " + data)
			.appendTo("#p1space");
	}
	
	function gameError(){
		console.log("Error");
	}
	
});
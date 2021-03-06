package wap.guessme.controllers;

/**
 * @author romiezaw
 *
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import wap.guessme.models.DatabaseService;
import wap.guessme.models.Game;
import wap.guessme.models.GamePlayer;
import wap.guessme.models.GameService;
import wap.guessme.models.Gamer;
import wap.guessme.models.GamerLog;
import wap.guessme.utilities.GameUtility;

import java.sql.*;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Servlet implementation class Solver
 */
@WebServlet("/GameSolver")
public class GameSolver extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private GameService gameService;
	private DatabaseService dbService;
	/**
	 * Default constructor.
	 */
	public GameSolver() {
		// TODO Auto-generated constructor stub
		gameService = new GameService();
		try {
			dbService = new DatabaseService();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		RequestDispatcher rd = null;

		if (request.getParameter("action").equals("getMyOpponent")) {
			int userId = Integer.parseInt(request.getParameter("opponentId"));
			
			//player1 for game
			Gamer me = (Gamer) session.getAttribute("gamer");
			GamePlayer player1 = new GamePlayer();
			player1.setGamer(me);
			
			//Player2 for game
			GamerLog gamer2Log = dbService.getGamerLoginDetails(userId);
			Gamer gamer2 = gamer2Log.getGamer();
			GamePlayer player2  = dbService.getPlayerDetails(gamer2.getId());
			
			//Start a game 
			Game game = dbService.startAGame(player2,player2);

			LocalDateTime startTime = LocalDateTime.now();
			session.setAttribute("startTime", startTime);
			
			dbService.createNewGame(game , (LocalDateTime)session.getAttribute("startTime"));
			
			session.setAttribute("newgame", game);
			
			String jsonInString = dbService.toJson(game);
			System.out.println(game.getPlayers().get(0).getGamer().getFullName());
			
			PrintWriter out = response.getWriter();
			out.println(jsonInString);
			out.flush();
			
		} else if (request.getParameter("action").equals("checker")) {
			// Check the matching no
			
			LocalDateTime endTime = LocalDateTime.now();
			Duration duration = Duration.between((LocalDateTime)session.getAttribute("startTime"), endTime);
			long timeTaken = duration.getSeconds()%60;
			
			int myGuess = (Integer.parseInt(request.getParameter("myGuess")));
			
			//set player 2 secret no
			Game m = (Game) session.getAttribute("newgame");
			int guessMe = m.getPlayers().get(1).getPickedNumber();		//Player 2 secret no which player 1 needs to guess
			if( guessMe != 0) {
				//gameService.setNumberToGuess(guessMe);			
				
				gameService.setNumberToGuess(5678);		
			}
			
			dbService.insertGameHistory(m , myGuess , timeTaken);
			
			gameService.setMyGuess(myGuess);
			//Convert to JSONObject
			JSONObject results = gameService.solveIt();
			//Update session
			
			
			
			PrintWriter out = response.getWriter();
			out.print(results);
			out.flush();
			
		} else if (request.getParameter("action").equals("keepMeSecret")) {
			//Set secret No for player1
			int secretNo = Integer.parseInt(request.getParameter("secretNo"));
			gameService.setSecretNo(secretNo);
			
			//Update session
			Game m = (Game) session.getAttribute("newgame");
			m.getPlayers().get(0).setPickedNumber(secretNo);
			session.setAttribute("newgame", m);
			
			PrintWriter out = response.getWriter();
			out.print(secretNo);
			out.flush();
			
		}	

	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

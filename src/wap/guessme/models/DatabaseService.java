/**
 * 
 */
package wap.guessme.models;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.ws.rs.ApplicationPath;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import wap.guessme.utilities.AppHelper;

/**
 * @author romiezaw
 *
 */
@ApplicationPath("/api")
public class DatabaseService {

	private DatabaseConnection connection;
	private Connection conn = null;
	private PreparedStatement stmt;
	private Statement statement;
	private String QUERY;	
	

	public DatabaseService() throws SQLException{
		//try { //--> titin: we want to handlle it in ones who call this constructor, so we add throws SQLException, and so no need to put try catch here, although you can if you want :)
			connection = DatabaseConnection.getInstance();
			conn = connection.getConnection();
			System.out.println("Connection successful.");
		//} catch (SQLException e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
		//}
	}
	
	
	//tins
	public Gamer getGamer(String emailAddressorGamerName) {
		Gamer gamer = null;
		try {
			//System.out.println("before call conn.createStatement();");
			statement = conn.createStatement();
			//System.out.println("after call conn.createStatement();");
			QUERY = "select * from tb_user where emailAddress = '"+emailAddressorGamerName+"' OR gamerName = '"+emailAddressorGamerName+"'";			
			ResultSet rs = statement.executeQuery(QUERY);
			if(rs.next()){
				int id = rs.getInt("id");
				String gamerName = rs.getString("gamerName");
				String emailAddress = rs.getString("emailAddress");
				String password = rs.getString("password");
				String fullName = rs.getString("fullName");
				String gender = rs.getString("gender");
				Date createdAt = rs.getDate("createdAt");				
				gamer = new Gamer(gamerName, emailAddress, password, fullName, gender, createdAt);
				gamer.setId(id);				
				//System.out.println("Records found");				
			}
			else {
				//System.out.println("No records found");
			}
			statement.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return gamer;		
	}	
	
	public List<GamerLog> getOnlineGamers(Gamer gm) {
		List<GamerLog> onlineGamers = new ArrayList<GamerLog>();
		try {
			//System.out.println("before call conn.createStatement();");
			statement = conn.createStatement();
			//System.out.println("after call conn.createStatement();");
			/*QUERY = "SELECT L.id, L.sessionId, L.loginAt, L.logoutAt, L.activeStatus " + 
					", L.userId, U.gamerName, U.emailAddress, U.password, U.fullName, U.gender, U.createdAt " + 
					"FROM tb_user_login L " + 
					"left join tb_user U " + 
					"on L.userId = U.id " + 
					"where L.activeStatus = 1";*/
			
			QUERY = "SELECT L.id, L.sessionId, L.loginAt, L.logoutAt, L.activeStatus "+
					" , L.userId, U.gamerName, U.emailAddress, U.password, U.fullName, U.gender, U.createdAt   "+
					" FROM tb_user_login L "+
					" left join tb_user U on L.userId = U.id "+
					" where L.activeStatus = 1  AND L.userId != '"+gm.getId()+"'"+
					" group by L.userId ";
			System.out.println("QUERY: "+QUERY);
			
			ResultSet rs = statement.executeQuery(QUERY);
			
			while(rs.next()){
				Gamer gamer;
				GamerLog gamerLog;
				int id = rs.getInt("userId");
				String gamerName = rs.getString("gamerName");
				String emailAddress = rs.getString("emailAddress");
				//String password = rs.getString("password");
				String fullName = rs.getString("fullName");
				String gender = rs.getString("gender");
				Date createdAt = rs.getDate("createdAt");				
				gamer = new Gamer(gamerName, emailAddress, fullName, gender, createdAt);
				gamer.setId(id);
				
				id = rs.getInt("id");
				String sessionId = rs.getString("sessionId");
				Date loginAt = rs.getDate("loginAt");
				Date logoutAt = rs.getDate("logoutAt");
				int activeStatus = rs.getInt("activeStatus");
				
				gamerLog = new GamerLog();
				gamerLog.setGamer(gamer);
				gamerLog.setId(id);
				gamerLog.setSessionId(sessionId);
				gamerLog.setLoginAt(loginAt);
				gamerLog.setLogoutAt(logoutAt);
				gamerLog.setActiveStatus(activeStatus);		
				
				onlineGamers.add(gamerLog);
				//System.out.println("Record found "+gamerLog.getGamer().getFullName());
			}

			statement.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return onlineGamers;		
	}	
	
	
	public int insertGamerLog(Gamer gamer, String sessionId) {
		
		int retInt = 0;
		try {
			statement = conn.createStatement();
			QUERY = "INSERT INTO tb_user_login(userId, sessionId, loginAt, activeStatus)"
					+ "values ('"+gamer.getId()+"', '"+sessionId+"', '"+AppHelper.getDateNow()+"', '1') ";
			
			retInt = statement.executeUpdate(QUERY,  Statement.RETURN_GENERATED_KEYS);
			statement.close();
			
					
		} 
		catch (SQLException ex) {
			System.err.println("SQLQueryException: " + ex.getMessage());
		}
		
		return retInt;
	}
	
	public int insertNewGamer(String gamerName, String emailAddress, String password,String fullName,String gender ){
		int retInt = 0;
		try {
			statement = conn.createStatement();
			
			//SimpleDateFormat f = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			
			QUERY = "INSERT INTO tb_user (gamerName, emailAddress,password,fullName,gender,createdAt)"+
					"VALUES ('"+gamerName+"','"+emailAddress+"','"+password+"', '"+fullName+"',	'"+gender+"', '"+AppHelper.getDateNow()+"')" ;
			
			System.out.print(QUERY);
			retInt = statement.executeUpdate(QUERY,  Statement.RETURN_GENERATED_KEYS);
			statement.close();
			
					
		} 
		catch (SQLException ex) {
			System.err.println("SQLQueryException: " + ex.getMessage());
		}
		
		return retInt;
	}
	
	//end tins
	
	// retrieve opponent's details
	public GamerLog getGamerLoginDetails(int loginId) {

		GamerLog gamerLog = null;
		try {
			String gamerLgnSql = "select * from tb_user_login where userId=" + loginId;
			stmt = conn.prepareStatement(gamerLgnSql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// Retrieve by column name
				int gamerId = Integer.parseInt(rs.getString("userId"));
				int activeStatus = Integer.parseInt(rs.getString("activeStatus"));
				
				String sessionId = rs.getString("sessionId");
				Date loginTime = rs.getDate("loginAt");
				Date logoutTime = rs.getDate("logoutAt");

				gamerLog = new GamerLog();
				gamerLog.setGamer(getGamerDetails(gamerId));
				gamerLog.setActiveStatus(activeStatus);
				gamerLog.setSessionId(sessionId);
				gamerLog.setLoginAt(loginTime);
				gamerLog.setLogoutAt(logoutTime);
				stmt.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return gamerLog;
	}

	public Gamer getGamerDetails(int gamerId) {

		Gamer opponent = null;
		String gamerSql = "select * from tb_user where id=" + gamerId;
		try {
			stmt = conn.prepareStatement(gamerSql);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int id = Integer.parseInt(rs.getString("id"));
				String name = rs.getString("gamerName");
				String email = rs.getString("emailAddress");
				String password = rs.getString("password");
				String fullName = rs.getString("fullName");
				String gender = rs.getString("gender");
				Date joinedDate = rs.getDate("createdAt");

				opponent = new Gamer(id, name, email, password, fullName, gender, joinedDate);
				//stmt.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return opponent;
	}

	public GamePlayer getPlayerDetails(int gamerId) {

		GamePlayer player2 = null;
		String gamerSql = "select * from tb_user where id=" + gamerId;
		try {
			stmt = conn.prepareStatement(gamerSql);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int id = Integer.parseInt(rs.getString("id"));
				String name = rs.getString("gamerName");
				String email = rs.getString("emailAddress");
				String password = rs.getString("password");
				String fullName = rs.getString("fullName");
				String gender = rs.getString("gender");
				Date joinedDate = rs.getDate("createdAt");

				Gamer opponent = new Gamer(id, name, email, password, fullName, gender, joinedDate);
				player2 = new GamePlayer();
				player2.setGamer(opponent);
				//stmt.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return player2;
	}

	// Start a new game and track record
	public Game startAGame(GamePlayer player1, GamePlayer player2) {

		System.out.println("Let's start a game!");
		Game game = new Game();

		// game.setStartTime(CLocalDateTime.now());
		game.addPlayer(player2);
		game.addPlayer(player2);
		return game;
	}


	public int insertGameHistory(Game game, int guessedNo, long timeTaken) {
		int retInt = 0;
		try {
			Statement stmt = conn.createStatement();
			int gameId = game.getGameId();
			
			int gamerId = game.getPlayers().get(0).getGamer().getId();
			String insertGmHisQry = "insert into tb_game_history(gameId, gamerId, guessedNumber, timeSpent)"
										+ "values ('"+ gameId +"', '"+ gamerId +"', '"+ guessedNo +"', '" + timeTaken+ "') ";
			
			retInt = stmt.executeUpdate(insertGmHisQry,  Statement.RETURN_GENERATED_KEYS);
			//stmt.close();
			
		}catch(SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retInt;
	}
	
	public int createNewGame(Game game,LocalDateTime startTime) {
		int retInt = 0;
		try {
			Statement stmt = conn.createStatement();
			int gameId = game.getGameId();
			SimpleDateFormat f = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			
			String createGmQry = "insert into tb_game(id, startime, endTime) "
					+ "values ('"+ gameId +"', '"+ f.format(Date.valueOf(startTime.toLocalDate())) 
										+ "', '"+ f.format(Date.valueOf(startTime.toLocalDate())) + "') ";
			
			retInt = stmt.executeUpdate(createGmQry,  Statement.RETURN_GENERATED_KEYS);
			//stmt.close();
			
		}catch(SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return retInt;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static String toJson(Object obj) {

		ObjectMapper mapper = new ObjectMapper();

		String jsonInString = "";
		try {
			jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(jsonInString);
		return jsonInString;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static JSONArray toJson(List list) {
		JSONArray jsonArray = new JSONArray();
		for (Object obj : list) {
			if (obj instanceof List) {
				jsonArray.add(toJson((List) obj));
			} else {
				jsonArray.add(obj);
			}
		}
		return jsonArray;
	}

}

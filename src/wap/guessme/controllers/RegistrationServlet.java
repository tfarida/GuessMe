package wap.guessme.controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wap.guessme.models.DatabaseService;
import wap.guessme.utilities.AppHelper;

/**
 * Servlet implementation class Registration
 */
@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DatabaseService ds;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String gamerName = request.getParameter("userName");
		String emailAddress = request.getParameter("email");
		String password = request.getParameter("password");
		String fullName = request.getParameter("fullName");
		String gender = request.getParameter("gender");
		
		try {
			ds = new DatabaseService();			
			ds.insertNewGamer(gamerName, emailAddress, password,fullName, gender);
			request.setAttribute("successMessage", "Your registration is done successfully!");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("errorMessage", AppHelper.internalServerErrorMessage);
			
		}			
		
		RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
		rd.forward(request, response);	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

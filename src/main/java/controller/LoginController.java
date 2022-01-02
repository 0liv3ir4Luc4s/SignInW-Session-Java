package controller;

import javax.servlet.http.HttpServlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String page = request.getParameter("page").toString();
	    if (page.equals("login")) {
		request.getRequestDispatcher("login.jsp").forward(request, response);   
	    } else {
		request.getRequestDispatcher("404.jsp").forward(request, response);
	    }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String action = request.getParameter("action");
	    if (action.equals("login")) {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		User user = new User();
		user.setEmail(email);
		user.setPassword(password);
		if (new UserController().login(user)) {
		    HttpSession session = request.getSession(false);
		    session.setAttribute("email", email);
		    session.setAttribute("password", password);
		    request.getRequestDispatcher("success.jsp").forward(request, response);
		} else {
		    request.getRequestDispatcher("404.jsp").forward(request, response);
		}
	    } else {
		request.getRequestDispatcher("404.jsp").forward(request, response);
	    }
	}

}

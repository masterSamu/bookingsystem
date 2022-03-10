package app;

import java.io.IOException;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import appUtilities.UserAccountUtilities;

@WebServlet("/validateuser")
public class ValidateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("varausdb");

	public ValidateUser() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String errorMessage = "Virheellinen salasana tai käyttäjätunnus.";
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		RequestDispatcher rd = null;

		if (username != "") {
			if (UserAccountUtilities.checkIfUserExist(username)) {
				if (UserAccountUtilities.validateUser(username, password)) {
					HttpSession oldSession = request.getSession(true);
					oldSession.invalidate();

					HttpSession session = request.getSession(true);
					session.setAttribute("auth", true);
					rd = request.getRequestDispatcher("/ohjauspaneeli");
				} else {
					request.setAttribute("loginErrorMessage", errorMessage);
					rd = request.getRequestDispatcher("/login");
				}
			} else {
				request.setAttribute("loginErrorMessage", errorMessage);
				rd = request.getRequestDispatcher("/login");
			}
		} else {
			request.setAttribute("loginErrorMessage", errorMessage);
			rd = request.getRequestDispatcher("/login");
		}

		try {
			rd.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		doGet(request, response);

	}

}

package app;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import appUtilities.CustomerUtilities;

/**
 * Add new customer Servlet implementation class AddCustomer
 */
@WebServlet("/addnewcustomer")
public class AddCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddCustomer() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		if (email != "") {
			String firstname = request.getParameter("firstname");
			String lastname = request.getParameter("lastname");
			String phone = request.getParameter("phone");
			String additionalInformation = request.getParameter("additionalInformation");

			CustomerUtilities.AddCustomerToDatabase(firstname, lastname, email, phone, additionalInformation);
		}
		response.sendRedirect("/asiakkaat");
		doGet(request, response);
	}

}

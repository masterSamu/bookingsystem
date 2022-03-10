package app;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import appUtilities.CustomerUtilities;

@WebServlet("/editcustomer")
public class EditCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EditCustomer() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String customerId = request.getParameter("customer_id");
		if (!customerId.equals("")) {
			String firstname = request.getParameter("firstname");
			String lastname = request.getParameter("lastname");
			String email = request.getParameter("email");
			String phone = request.getParameter("phone");
			String additionalInformation = request.getParameter("additionalInformation");

			CustomerUtilities.editCustomer(customerId, firstname, lastname, email, phone, additionalInformation);
		}

		response.sendRedirect("/asiakkaat");
		doGet(request, response);
	}

}

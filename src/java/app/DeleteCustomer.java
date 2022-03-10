package app;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import appUtilities.CustomerUtilities;

@WebServlet("/deletecustomer")
public class DeleteCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteCustomer() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String customerId = request.getParameter("id");

		CustomerUtilities.deleteCustomer(customerId);

		response.sendRedirect("/asiakkaat");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

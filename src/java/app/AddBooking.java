package app;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import appUtilities.AddBookingUtilities;

@WebServlet("/addbooking")
public class AddBooking extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddBooking() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String[] products = request.getParameterValues("checkbox-products");
		String[] customers = request.getParameterValues("checkbox-customers");
		String[] amounts = request.getParameterValues("amount");
		String additionalInformation = request.getParameter("additionalInformation");

		AddBookingUtilities.addBookingDataIntoDatabase(products, customers, amounts, additionalInformation);

		response.sendRedirect("/varaukset");

		doGet(request, response);
	}

}

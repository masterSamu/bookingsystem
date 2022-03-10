package app;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.BookingsInformation;
import data.CustomersDecrypted;
import appUtilities.*;

@WebServlet("showbookingsforcustomer")
public class BookingsPagePerCustomersPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BookingsPagePerCustomersPage() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String customerId = request.getParameter("id");

		CustomersDecrypted customer = CustomerUtilities.getSingleCustomer(customerId);
		List<BookingsInformation> bookings = ReadBookingUtilities.getBookingsForCustomer(customerId);
		

		request.setAttribute("customer", customer);
		request.setAttribute("bookings", bookings);

		RequestDispatcher rd = request.getRequestDispatcher("/jsp/bookings-page-customers.jsp");
		try {
			rd.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

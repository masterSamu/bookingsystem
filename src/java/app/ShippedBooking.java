package app;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import appUtilities.BookingUtilities;

@WebServlet("/shippedbooking")
public class ShippedBooking extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ShippedBooking() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String bookingId = request.getParameter("id");

		BookingUtilities.setBookingToShipped(bookingId);

		response.sendRedirect("/varaukset");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

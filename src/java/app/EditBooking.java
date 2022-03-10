package app;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;
import data.Bookings;

@WebServlet("/editbooking")
public class EditBooking extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EditBooking() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int bookingId = Integer.parseInt(request.getParameter("bookingid"));
		boolean state = Boolean.parseBoolean(request.getParameter("informed"));
		if (bookingId > 0) {
			Dao dao = new Dao();
			Bookings booking = dao.readBooking(bookingId);
			booking.setAmount(Integer.parseInt(request.getParameter("amount")));
			booking.setInformed(state);
			booking.setAdditionalInformation(request.getParameter("additionalInformation"));

			dao.editBooking(booking);

			response.sendRedirect("/varaukset");

		}

		doGet(request, response);
	}

}

package app;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;
import data.Bookings;

@WebServlet("/setinformed")
public class SetBookingInformed extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SetBookingInformed() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int bookingId = Integer.parseInt(request.getParameter("id"));
		boolean state = Boolean.parseBoolean(request.getParameter("data"));

		if (bookingId != 0) {
			Dao dao = new Dao();
			Bookings booking = dao.readBooking(bookingId);
			if (state) {
				booking.setInformed(false);
			} else {
				booking.setInformed(true);
			}
			dao.editBooking(booking);
		}

		doGet(request, response);
	}

}

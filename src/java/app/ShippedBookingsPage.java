package app;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import appUtilities.BookingUtilities;
import data.ShippedBookingsInfo;

@WebServlet("/toimitetut-varaukset")
public class ShippedBookingsPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ShippedBookingsPage() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<ShippedBookingsInfo> bookingInfo = BookingUtilities.getAllShippedBookingsAsList();

		request.setAttribute("bookings", bookingInfo);

		RequestDispatcher rd = request.getRequestDispatcher("/jsp/show-shippedbookings-page.jsp");
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

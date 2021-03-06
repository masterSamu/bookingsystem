package app;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import data.BookingsInformation;
import appUtilities.*;

@WebServlet("/varaukset")
public class BookingsPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BookingsPage() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ArrayList<BookingsInformation> bookings = ReadBookingUtilities.getAllBookings();
		request.setAttribute("bookings", bookings);

		RequestDispatcher rd = request.getRequestDispatcher("/jsp/bookings-page.jsp");
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

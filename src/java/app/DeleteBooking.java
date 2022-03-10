package app;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;

@WebServlet("/deletebooking")
public class DeleteBooking extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteBooking() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int bookingId = Integer.parseInt(request.getParameter("id"));

		if (bookingId != 0) {
			Dao dao = new Dao();
			dao.deleteBooking(bookingId);
		}

		response.sendRedirect("/varaukset");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

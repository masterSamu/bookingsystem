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
import data.Suppliers;
import appUtilities.*;

@WebServlet("/showbookingsforsupplier")
public class BookingsPerSupplierPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BookingsPerSupplierPage() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String supplierId = request.getParameter("id");

		Suppliers supplier = SuppliersUtilities.getSingleSupplier(supplierId);

		List<BookingsInformation> bookings = ReadBookingUtilities.getBookingsForSupplier(supplierId);

		request.setAttribute("supplier", supplier);
		request.setAttribute("bookings", bookings);

		RequestDispatcher rd = request.getRequestDispatcher("/jsp/bookings-page-supplier.jsp");
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

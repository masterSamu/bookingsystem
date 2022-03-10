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
import data.Products;
import data.Products_suppliers_many;
import data.Suppliers;
import appUtilities.*;

@WebServlet("/showbookingsforproduct")
public class BookingsPagePerProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BookingsPagePerProduct() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String productid = request.getParameter("id");

		Products product = ProductUtilities.getSingleProduct(productid);

		List<BookingsInformation> bookings = ReadBookingUtilities.getBookingsForProduct(productid);

		request.setAttribute("bookings", bookings);
		request.setAttribute("product", product);

		RequestDispatcher rd = request.getRequestDispatcher("/jsp/bookings-page-products.jsp");
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

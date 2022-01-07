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
import data.Products_suppliers_many;
import data.Suppliers;
import appUtilities.*;

/**
 * 
 * Servlet implementation class BookingsPage
 */
@WebServlet("/varaukset")
public class BookingsPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookingsPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<BookingsInformation> bookingInfo = ReadBookingUtilities.getAllBookings();
		List<Suppliers> suppliers = SuppliersUtilities.getAllSuppliers();
		List<Products_suppliers_many> productSuppliers = ProductUtilities.getAllProductSuppliersFromDatabase();
		
		request.setAttribute("bookings", bookingInfo);
		request.setAttribute("suppliers", suppliers);
		request.setAttribute("productsuppliers", productSuppliers);
		
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/bookings-page.jsp");
		try {
			rd.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

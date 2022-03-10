package app;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.CustomersDecrypted;
import data.Products;
import appUtilities.CustomerUtilities;
import appUtilities.ProductUtilities;

/**
 * Show page for new booking from dashboard link. Servlet implementation class
 * AddNewBookingPage
 */
@WebServlet("/uusivaraus")
public class AddNewBookingPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddNewBookingPage() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<CustomersDecrypted> customers = CustomerUtilities.getCustomersDataAsListFromDatabase();
		List<Products> products = ProductUtilities.getAllProducts();

		request.setAttribute("products", products);
		request.setAttribute("customers", customers);

		RequestDispatcher rd = request.getRequestDispatcher("/jsp/addnewbooking-page.jsp");
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

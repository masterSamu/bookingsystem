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
 * Servlet implementation class AddBookingForCustomerPage Set data for page
 * 
 * @author Samu
 */
@WebServlet("/uusivaraus-asiakas")
public class AddBookingForCustomerPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddBookingForCustomerPage() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String customer_id = request.getParameter("id");

		CustomersDecrypted customer = CustomerUtilities.getSingleCustomer(customer_id);
		List<Products> products = ProductUtilities.getAllProducts();

		request.setAttribute("products", products);
		request.setAttribute("customer", customer);

		RequestDispatcher rd = request.getRequestDispatcher("/jsp/addbooking-customer-page.jsp");
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

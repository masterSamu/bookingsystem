package app;

import java.io.IOException;
import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.CustomersDecrypted;
import data.Products;
import appUtilities.ProductUtilities;
import appUtilities.CustomerUtilities;

@WebServlet("/uusivaraus-tuote")
public class AddBookingForProductPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddBookingForProductPage() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String productid = request.getParameter("id");

		Products product = ProductUtilities.getSingleProduct(productid);
		List<CustomersDecrypted> customers = CustomerUtilities.getCustomersDataAsListFromDatabase();

		request.setAttribute("product", product);
		request.setAttribute("customers", customers);

		RequestDispatcher rd = request.getRequestDispatcher("/jsp/addbooking-product-page.jsp");
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

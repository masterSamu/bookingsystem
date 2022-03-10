package app;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.CustomersDecrypted;
import appUtilities.CustomerUtilities;

@WebServlet("/editcustomerpage")
public class EditCustomerPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EditCustomerPage() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String customerId = request.getParameter("id");

		CustomersDecrypted customer = CustomerUtilities.getSingleCustomer(customerId);

		request.setAttribute("customer", customer);

		RequestDispatcher rd = request.getRequestDispatcher("/jsp/editcustomer-page.jsp");
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

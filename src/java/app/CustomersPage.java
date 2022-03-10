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
import appUtilities.CustomerUtilities;

@WebServlet("/asiakkaat")
public class CustomersPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CustomersPage() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<CustomersDecrypted> customers = CustomerUtilities.getCustomersDataAsListFromDatabase();

		request.setAttribute("customers", customers);

		RequestDispatcher rd = request.getRequestDispatcher("/jsp/customers-page.jsp");
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

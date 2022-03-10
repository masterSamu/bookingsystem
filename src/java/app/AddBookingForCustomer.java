package app;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import appUtilities.AddBookingUtilities;

@WebServlet("/addbooking-customer")
public class AddBookingForCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddBookingForCustomer() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String products[] = request.getParameterValues("checkbox-products");
		String amounts[] = request.getParameterValues("amount");
		String customer_id = request.getParameter("customer_id");
		String additionalInformation = request.getParameter("additionalInformation");

		AddBookingUtilities.addBookingDataToCustomerIntoDatabase(products, customer_id, amounts, additionalInformation);

		response.sendRedirect("/asiakkaat");
		doGet(request, response);
	}

}

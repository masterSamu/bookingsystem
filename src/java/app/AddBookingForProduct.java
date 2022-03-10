package app;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import appUtilities.AddBookingUtilities;

@WebServlet("/addbooking-product")
public class AddBookingForProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddBookingForProduct() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String product_id = request.getParameter("product_id");
		String customers[] = request.getParameterValues("checkbox-customers");
		String amounts[] = request.getParameterValues("amount");
		String additionalInformation = request.getParameter("additionalInformation");

		AddBookingUtilities.addBookingDataToProductIntoDatabase(product_id, customers, amounts, additionalInformation);

		response.sendRedirect("/tuotteet");
		doGet(request, response);
	}

}

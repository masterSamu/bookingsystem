package app;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import appUtilities.ProductUtilities;

/**
 * Deletes single product information from database
 * @author Samu
 */
@WebServlet("/deleteproduct")
public class DeleteProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteProduct() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String  productId = request.getParameter("id");
		
		// Alternative id, if delete command is coming from tuotesivu.jsp
		if (productId == null) {
			productId = request.getParameter("productid");
		}

		ProductUtilities.deleteSingleProduct(productId);

		response.sendRedirect("/tuotteet");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

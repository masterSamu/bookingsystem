package app;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import appUtilities.SuppliersUtilities;

@WebServlet("/deletesupplier")
public class DeleteSupplier extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteSupplier() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String supplierId = request.getParameter("id");

		SuppliersUtilities.deleteSingleSupplier(supplierId);

		response.sendRedirect("/toimittajat");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

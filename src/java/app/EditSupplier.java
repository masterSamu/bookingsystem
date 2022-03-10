package app;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import appUtilities.SuppliersUtilities;

@WebServlet("/editsupplier")
public class EditSupplier extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EditSupplier() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String supplierId = request.getParameter("id");
		String name = request.getParameter("nimi");
		String additionalInformation = request.getParameter("lisatiedot");

		SuppliersUtilities.editSingleSupplier(supplierId, name, additionalInformation);

		response.sendRedirect("/toimittajat");

		doGet(request, response);
	}

}

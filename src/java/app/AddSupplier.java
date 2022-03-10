package app;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import appUtilities.SuppliersUtilities;

@WebServlet("/lisaatoimittaja")
public class AddSupplier extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddSupplier() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("nimi");
		String additionalInformation = request.getParameter("lisatiedot");

		SuppliersUtilities.addSupplierIntoDatabase(name, additionalInformation);

		response.sendRedirect("/toimittajat");

	}

}

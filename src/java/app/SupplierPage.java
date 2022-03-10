package app;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import appUtilities.SuppliersUtilities;
import data.Suppliers;

@WebServlet("/toimittajasivu")
public class SupplierPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SupplierPage() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String supplierId = request.getParameter("id");

		Suppliers supplier = SuppliersUtilities.getSingleSupplier(supplierId);

		request.setAttribute("supplier", supplier);

		RequestDispatcher rd = request.getRequestDispatcher("/jsp/toimittajasivu.jsp");
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

package app;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.Suppliers;
import appUtilities.SuppliersUtilities;

@WebServlet("/toimittajat")
public class SuppliersPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SuppliersPage() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Suppliers> suppliers = SuppliersUtilities.getAllSuppliers();

		request.setAttribute("suppliers", suppliers);

		RequestDispatcher rd = request.getRequestDispatcher("/jsp/toimittajat.jsp");
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

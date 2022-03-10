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
import data.Products;
import data.Products_suppliers_many;
import appUtilities.*;

@WebServlet("/tuotesivu")
public class ProductPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ProductPage() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String productId = request.getParameter("productid");

		Products product = ProductUtilities.getSingleProduct(productId);
		List<Suppliers> suppliers = SuppliersUtilities.getAllSuppliers();
		List<Products_suppliers_many> selectedProductSuppliers = ProductUtilities
				.getProductsSuppliersForSingleProduct(productId);

		request.setAttribute("product", product);
		request.setAttribute("suppliers", suppliers);
		request.setAttribute("selectedProductSuppliers", selectedProductSuppliers);

		RequestDispatcher rd = request.getRequestDispatcher("/jsp/tuotesivu.jsp");
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

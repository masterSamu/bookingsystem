package app;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;
import data.Products;
import data.Products_suppliers_many;
import appUtilities.ProductUtilities;

@WebServlet("/editproduct")
public class EditProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EditProduct() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String productId = request.getParameter("productid");
		if (!productId.equals("")) {
			String barcode = request.getParameter("viivakoodi");
			String productCode = request.getParameter("tuotekoodi");
			String name = request.getParameter("tuotenimi");
			String image = request.getParameter("kuva-url");
			String link = request.getParameter("linkki");
			String additionalInformation = request.getParameter("lisatiedot");
			String[] suppliers = request.getParameterValues("toimittaja");

			ProductUtilities.editProduct(productId, barcode, productCode, name, image, link, additionalInformation,
					suppliers);
		}
		response.sendRedirect("/tuotteet");

		doGet(request, response);
	}

}

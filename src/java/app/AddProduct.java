package app;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;
import data.Products;
import data.Products_suppliers_many;
import appUtilities.ProductUtilities;

/**
 * Add new product into database. Servlet implementation class AddProduct
 */
@WebServlet("/lisaatuote")
public class AddProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddProduct() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String productCode = request.getParameter("tuotekoodi");
		if (!productCode.equals("")) {
			String barCode = request.getParameter("viivakoodi");
			String name = request.getParameter("tuotenimi");
			String image = request.getParameter("kuva-url");
			String link = request.getParameter("linkki");
			String additionalInformation = request.getParameter("lisatiedot");
			String shop_product_id = link.substring(link.lastIndexOf('/') + 1);
			String[] suppliers = request.getParameterValues("toimittaja");

			ProductUtilities.addProductIntoDatabase(barCode, productCode, shop_product_id, name, image, link,
					additionalInformation, suppliers);
		}
		response.sendRedirect("/tuotteet");

		doGet(request, response);
	}

}

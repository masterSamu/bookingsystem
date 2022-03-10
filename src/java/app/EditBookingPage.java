package app;

import java.io.IOException;
import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;
import data.Bookings;
import data.Customer_Keys;
import data.Customers;
import data.CustomersDecrypted;
import data.Products;
import data.Products_suppliers_many;
import data.Suppliers;
import encrypt.CryptingDataUtils;

@WebServlet("/editbooking-page")
public class EditBookingPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EditBookingPage() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int productId, customerId, bookingId;

		bookingId = Integer.parseInt(request.getParameter("id"));
		productId = Integer.parseInt(request.getParameter("p2"));
		customerId = Integer.parseInt(request.getParameter("p3"));

		if (bookingId > 0) {
			Dao dao = new Dao();
			Bookings booking = dao.readBooking(bookingId);
			Products product = dao.readProduct(productId);
			List<Products_suppliers_many> ps = dao.readOneProductSuppliersMany(productId);
			List<Suppliers> suppliers = dao.readProductSuppliers();
			Customers encryptedCustomer = dao.readCustomer(customerId);

			List<Customer_Keys> keys = dao.readCustomerKeys();
			PrivateKey priKey = keys.get(0).getPrivateKey();

			// Decrypt customer data
			CustomersDecrypted cd = new CustomersDecrypted();
			cd.setCustomer_id(customerId);
			cd.setFirstname(CryptingDataUtils.decryptData(encryptedCustomer.getFirstname(), priKey));
			cd.setLastname(CryptingDataUtils.decryptData(encryptedCustomer.getLastname(), priKey));
			cd.setEmail(CryptingDataUtils.decryptData(encryptedCustomer.getEmail(), priKey));
			cd.setPhone(CryptingDataUtils.decryptData(encryptedCustomer.getPhone(), priKey));
			cd.setAdditionalInformation(encryptedCustomer.getAdditionalInformation());

			// Set supplier data
			List<Suppliers> supplierList = new ArrayList<Suppliers>();
			for (int i = 0; i < suppliers.size(); i++) {
				if (ps.size() > 0) {
					for (int j = 0; j < ps.size(); j++) {
						if (suppliers.get(i).getSupplier_id() == ps.get(j).getSupplier_id()) {
							supplierList.add(suppliers.get(i));
						}
					}
				}
			}
			request.setAttribute("product", product);
			request.setAttribute("customer", cd);
			request.setAttribute("booking", booking);
			request.setAttribute("suppliers", supplierList);

			RequestDispatcher rd = request.getRequestDispatcher("/jsp/edit-booking-page.jsp");
			try {
				rd.forward(request, response);
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

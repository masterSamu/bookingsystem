package appUtilities;

import static java.util.Objects.isNull;

import java.util.ArrayList;
import java.util.List;

import data.CustomersDecrypted;
import dao.Dao;
import data.Bookings;
import data.BookingsInformation;
import data.Products;
import data.Products_suppliers_many;

public class ReadBookingUtilities {
	static Dao dao = new Dao();
	
	public static List<BookingsInformation> getAllBookings() {
		return setAllBookingsDataIntoOneListOfObjects();
	}
	
	public static List<BookingsInformation> getBookingsForOneSupplier(String supplierId) {
		int supplierIdInt = Integer.parseInt(supplierId);
		List<Products> products = ProductUtilities.getAllProducts();
		List<Bookings> bookings = getAllBookingsAsListFromDatabase();
		List<CustomersDecrypted> customers = CustomerUtilities.getAllCustomerDataWhoHasBooking(bookings);
		List<Products_suppliers_many> productSuppliers = dao.readProductSuppliersManyForSupplier(supplierIdInt);
		return setBookingsForOneSupplierIntoList(products, customers, bookings, productSuppliers, supplierIdInt);
	}
	
	public static List<BookingsInformation> getBookingsForOneProduct(String productId) {
		Products product = ProductUtilities.getSingleProduct(productId);
		List<Bookings> bookings = getBookingsForOneProductAsListFromDatabase(Integer.parseInt(productId));
		List<CustomersDecrypted> customers = CustomerUtilities.getAllCustomerDataWhoHasBooking(bookings);
		
		return setBookingsForOneProductIntoOneList(product, customers, bookings);
	}
	
	public static List<BookingsInformation> getBookingsForOneCustomer(String customerId) {
		CustomersDecrypted customer = CustomerUtilities.getSingleCustomer(customerId);
		List<Products> products = ProductUtilities.getAllProducts();
		List<Bookings> bookings = getBookingsForOneCustomerAsListFromDatabase(Integer.parseInt(customerId));
		
		return setBookingsForOneCustomerIntoOneList(customer, products, bookings);
	}
	
	private static List<BookingsInformation> setBookingsForOneProductIntoOneList(Products product, 
			List<CustomersDecrypted> customers, List<Bookings> bookings) {
		
		List<BookingsInformation> bookingInfoArrayList = new ArrayList<BookingsInformation>();
		
		// Set booking information into object
		for (int b = 0; b < bookings.size(); b++) {
			BookingsInformation bi = new BookingsInformation();
			
			// Set customer information into object
			for (int c = 0; c < customers.size(); c++) {
				int customerid = bookings.get(b).getCustomer_id();
				if (customerid == customers.get(c).getCustomer_id()) {
					bi.setCustomer_id(customers.get(c).getCustomer_id());
					bi.setFirstname(customers.get(c).getFirstname());
					bi.setLastname(customers.get(c).getLastname());
					bi.setEmail(customers.get(c).getEmail());
					bi.setPhone(customers.get(c).getPhone());
				}
			}
			
			// If object is not empty after setting product and customer information, set booking information and add object into arraylist.
			if (!isNull(bi)) {
				bi.setBooking_id(bookings.get(b).getBooking_id());
				bi.setAmount(bookings.get(b).getAmount());
				bi.setInformed(bookings.get(b).isInformed());
				bi.setAdditionalInformation(bookings.get(b).getAdditionalInformation());
				bookingInfoArrayList.add(bi);
			}
		}
		return bookingInfoArrayList;
	}
	
	private static List<BookingsInformation> setBookingsForOneCustomerIntoOneList(CustomersDecrypted customer, 
			List<Products> products, List<Bookings> bookings) {
		List<BookingsInformation> bookingInfoArrayList = new ArrayList<BookingsInformation>();
		int customerId = customer.getCustomer_id();
		
		for (int b = 0; b < bookings.size(); b++) {
			int productId = bookings.get(b).getProduct_id();
			
			if (bookings.get(b).getProduct_id() == productId && bookings.get(b).getCustomer_id() == customerId) {
				BookingsInformation bi = new BookingsInformation();
				
				// Set product data
				for (int p = 0; p < products.size(); p++) {
					productId = bookings.get(b).getProduct_id();
					
					if (productId == products.get(p).getProduct_id()) {
						bi.setProduct_id(productId);
						bi.setBarcode(products.get(p).getBarcode());
						bi.setProductcode(products.get(p).getProductcode());
						bi.setShop_product_id(products.get(p).getShop_product_id());
						bi.setProductname(products.get(p).getName());
						bi.setImage(products.get(p).getImage());
					}
				}
				// If object is not empty after setting product and customer information, set booking information and add object into arraylist.
				if (!isNull(bi)) {
					bi.setBooking_id(bookings.get(b).getBooking_id());
					bi.setAmount(bookings.get(b).getAmount());
					bi.setInformed(bookings.get(b).isInformed());
					bi.setAdditionalInformation(bookings.get(b).getAdditionalInformation());
					bookingInfoArrayList.add(bi);
				}
			}
		}
		return bookingInfoArrayList;
	}
	
	private static List<BookingsInformation> setAllBookingsDataIntoOneListOfObjects() {
		List<Bookings> bookings = getAllBookingsAsListFromDatabase();
		List<Products> products = ProductUtilities.getAllProducts();
		List<CustomersDecrypted> customers = CustomerUtilities.getAllCustomerDataWhoHasBooking(bookings);
		
		return setAllBookingDataIntoOneList(bookings, products, customers);
	}
	
	
	private static List<BookingsInformation> setAllBookingDataIntoOneList(List<Bookings> bookings, 
			List<Products> products, List<CustomersDecrypted> customers) {
		
		List<BookingsInformation> bookingsInfoArrayList = new ArrayList<BookingsInformation>();

		for (int b = 0; b < bookings.size(); b++) {
			BookingsInformation bi = new BookingsInformation();
			
			// Set product information into object
			for (int p = 0; p < products.size(); p++) {
				int productid = bookings.get(b).getProduct_id();
				
				if (productid == products.get(p).getProduct_id()) {
					bi.setProduct_id(productid);
					bi.setBarcode(products.get(p).getBarcode());
					bi.setProductcode(products.get(p).getProductcode());
					bi.setShop_product_id(products.get(p).getShop_product_id());
					bi.setProductname(products.get(p).getName());
					bi.setImage(products.get(p).getImage());
				}
			}
			// Set customer information into object
			for (int c = 0; c < customers.size(); c++) {
				int customerid = bookings.get(b).getCustomer_id();
				if (customerid == customers.get(c).getCustomer_id()) {
					bi.setCustomer_id(customers.get(c).getCustomer_id());
					bi.setFirstname(customers.get(c).getFirstname());
					bi.setLastname(customers.get(c).getLastname());
					bi.setEmail(customers.get(c).getEmail());
					bi.setPhone(customers.get(c).getPhone());
				}
			}
			// If object is not empty after setting product and customer information, set booking information and add object into arraylist.
			if (!isNull(bi)) {
				bi.setBooking_id(bookings.get(b).getBooking_id());
				bi.setAmount(bookings.get(b).getAmount());
				bi.setInformed(bookings.get(b).isInformed());
				bi.setAdditionalInformation(bookings.get(b).getAdditionalInformation());
				bookingsInfoArrayList.add(bi);
			}
		}
		
		return bookingsInfoArrayList;
	}
	
	private static List<BookingsInformation> setBookingsForOneSupplierIntoList(List<Products> products,
			List<CustomersDecrypted> customers, List<Bookings> bookings, 
			List<Products_suppliers_many> productSuppliers, int supplierId) {
		
		List<BookingsInformation> bookingInfoArrayList = new ArrayList<BookingsInformation>();
		for (int i = 0; i < productSuppliers.size(); i++) {
			for (int b = 0; b < bookings.size(); b++) {
				int productId = bookings.get(b).getProduct_id();
				int customerId = bookings.get(b).getCustomer_id();
				
				if (productSuppliers.get(i).getProduct_id() == productId && productSuppliers.get(i).getSupplier_id() == supplierId) {
					BookingsInformation bi = new BookingsInformation();
					
					// Set product data
					for (int p = 0; p < products.size(); p++) {
						productId = bookings.get(b).getProduct_id();
						
						if (productId == products.get(p).getProduct_id()) {
							bi.setProduct_id(productId);
							bi.setBarcode(products.get(p).getBarcode());
							bi.setProductcode(products.get(p).getProductcode());
							bi.setShop_product_id(products.get(p).getShop_product_id());
							bi.setProductname(products.get(p).getName());
							bi.setImage(products.get(p).getImage());
						}
					}
					
					// Set customer information into object
					for (int c = 0; c < customers.size(); c++) {
						customerId = bookings.get(b).getCustomer_id();
						if (customerId == customers.get(c).getCustomer_id()) {
							bi.setCustomer_id(customers.get(c).getCustomer_id());
							bi.setFirstname(customers.get(c).getFirstname());
							bi.setLastname(customers.get(c).getLastname());
							bi.setEmail(customers.get(c).getEmail());
							bi.setPhone(customers.get(c).getPhone());
						}
					}
					
					// If object is not empty after setting product and customer information, set booking information and add object into arraylist.
					if (!isNull(bi)) {
						bi.setBooking_id(bookings.get(b).getBooking_id());
						bi.setAmount(bookings.get(b).getAmount());
						bi.setInformed(bookings.get(b).isInformed());
						bi.setAdditionalInformation(bookings.get(b).getAdditionalInformation());
						bookingInfoArrayList.add(bi);
					}
				}
			}
		}
		return bookingInfoArrayList;
	}
	
	private static List<Bookings> getBookingsForOneProductAsListFromDatabase(int productId) {
		return dao.readBookingsForOneProduct(productId);
	}
	
	private static List<Bookings> getBookingsForOneCustomerAsListFromDatabase(int customerId) {
		return dao.readBookingsForOneCustomer(customerId);
	}
	
	private static List<Bookings> getAllBookingsAsListFromDatabase() {
		return dao.readBookings();
	}

}

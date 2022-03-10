package appUtilities;

import java.util.ArrayList;
import java.util.List;

import data.CustomersDecrypted;
import dao.Dao;
import data.Bookings;
import data.BookingsInformation;
import data.ProductsWithSuppliers;
import data.Suppliers;

public class ReadBookingUtilities {
	static Dao dao = new Dao();

	public static ArrayList<BookingsInformation> getAllBookings() {
		return combineAllBookings();
	}

	public static ArrayList<BookingsInformation> getBookingsForSupplier(String supplierId) {
		return combineBookingsForSupplier(supplierId);
	}

	public static ArrayList<BookingsInformation> getBookingsForProduct(String productId) {
		return combineBookingsForProduct(productId);
	}

	public static ArrayList<BookingsInformation> getBookingsForCustomer(String customerId) {
		return combineBookingsForCustomer(customerId);
	}

	private static ArrayList<BookingsInformation> combineAllBookings() {
		List<Bookings> bookingsListFromDb = getAllBookingsAsListFromDatabase();
		List<ProductsWithSuppliers> productsWithSuppliersListFromDb = ProductUtilities.getAllProductsWithSuppliers();
		List<CustomersDecrypted> customersWithBookingList = CustomerUtilities
				.getAllCustomerDataWhoHasBooking(bookingsListFromDb);

		ArrayList<BookingsInformation> bookingsList = new ArrayList<BookingsInformation>(5);
		for (Bookings booking : bookingsListFromDb) {
			BookingsInformation newBookingsInformation = new BookingsInformation();
			newBookingsInformation.setBooking(booking);
			for (ProductsWithSuppliers product : productsWithSuppliersListFromDb) {
				if (booking.getProduct_id() == product.getProduct().getProduct_id()) {
					newBookingsInformation.setProductWithSuppliers(product);
					for (CustomersDecrypted customer : customersWithBookingList) {
						if (booking.getCustomer_id() == customer.getCustomer_id()) {
							newBookingsInformation.setCustomer(customer);
						}
					}
				}
			}
			bookingsList.add(newBookingsInformation);
		}

		return bookingsList;
	}

	private static ArrayList<BookingsInformation> combineBookingsForSupplier(String supplierId) {
		int supplierIdInt = Integer.parseInt(supplierId);
		List<Bookings> bookingsListFromDb = getAllBookingsAsListFromDatabase();
		List<ProductsWithSuppliers> productsWithSuppliersListFromDb = ProductUtilities.getAllProductsWithSuppliers();
		List<CustomersDecrypted> customersWithBookingList = CustomerUtilities
				.getAllCustomerDataWhoHasBooking(bookingsListFromDb);

		ArrayList<BookingsInformation> bookingsList = new ArrayList<BookingsInformation>(5);
		for (Bookings booking : bookingsListFromDb) {
			BookingsInformation newBookingsInformation = new BookingsInformation();

			for (ProductsWithSuppliers product : productsWithSuppliersListFromDb) {

				if (booking.getProduct_id() == product.getProduct().getProduct_id()) {
					newBookingsInformation.setProductWithSuppliers(product);
					for (Suppliers supplier : product.getSuppliers()) {
						if (supplierIdInt == supplier.getSupplier_id()) {
							newBookingsInformation.setBooking(booking);
							for (CustomersDecrypted customer : customersWithBookingList) {
								if (booking.getCustomer_id() == customer.getCustomer_id()) {
									newBookingsInformation.setCustomer(customer);
								}
							}
							bookingsList.add(newBookingsInformation);
						}
					}
				}
			}
		}
		return bookingsList;
	}

	private static ArrayList<BookingsInformation> combineBookingsForProduct(String productId) {
		int productIdInt = Integer.parseInt(productId);
		List<Bookings> bookingsListFromDb = getBookingsForOneProductAsListFromDatabase(Integer.parseInt(productId));
		List<ProductsWithSuppliers> productsWithSuppliersListFromDb = ProductUtilities.getAllProductsWithSuppliers();
		List<CustomersDecrypted> customersWithBookingList = CustomerUtilities
				.getAllCustomerDataWhoHasBooking(bookingsListFromDb);
		ProductsWithSuppliers productWithSuppliers = ProductUtilities.getSingleProductWithSuppliers(productId);

		ArrayList<BookingsInformation> bookingsList = new ArrayList<BookingsInformation>(5);
		for (Bookings booking : bookingsListFromDb) {
			BookingsInformation newBookingsInformation = new BookingsInformation();
			if (productIdInt == productWithSuppliers.getProduct().getProduct_id()) {
				for (CustomersDecrypted customer : customersWithBookingList) {
					if (booking.getCustomer_id() == customer.getCustomer_id()) {
						newBookingsInformation.setProductWithSuppliers(productWithSuppliers);
						newBookingsInformation.setBooking(booking);
						newBookingsInformation.setCustomer(customer);
						bookingsList.add(newBookingsInformation);
					}
				}

			}
		}
		return bookingsList;
	}

	private static ArrayList<BookingsInformation> combineBookingsForCustomer(String customerId) {
		List<Bookings> bookingsListFromDb = getBookingsForOneCustomerAsListFromDatabase(Integer.parseInt(customerId));
		List<ProductsWithSuppliers> productsWithSuppliersListFromDb = ProductUtilities.getAllProductsWithSuppliers();
		List<CustomersDecrypted> customersWithBookingList = CustomerUtilities
				.getAllCustomerDataWhoHasBooking(bookingsListFromDb);

		ArrayList<BookingsInformation> bookingsList = new ArrayList<BookingsInformation>(5);
		for (Bookings booking : bookingsListFromDb) {
			BookingsInformation newBookingsInformation = new BookingsInformation();
			for (CustomersDecrypted customer : customersWithBookingList) {
				if (booking.getCustomer_id() == customer.getCustomer_id()) {
					newBookingsInformation.setCustomer(customer);

					for (ProductsWithSuppliers product : productsWithSuppliersListFromDb) {
						if (booking.getProduct_id() == product.getProduct().getProduct_id()) {
							newBookingsInformation.setProductWithSuppliers(product);
							newBookingsInformation.setBooking(booking);
							bookingsList.add(newBookingsInformation);
						}

					}
				}

			}
		}
		return bookingsList;
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

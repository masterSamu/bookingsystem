package appUtilities;

import static java.util.Objects.isNull;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dao.Dao;
import data.Bookings;
import data.BookingsInformation;
import data.CustomersDecrypted;
import data.Products;
import data.Products_suppliers_many;
import data.ShippedBookings;
import data.ShippedBookingsInfo;

public class BookingUtilities {
	static Dao dao = new Dao();
	
	public static List<ShippedBookingsInfo> getAllShippedBookingsAsList() {
		return getAllShippedBookingsInformationInOneListOfObjects();
	}
	
	public static void setBookingToShipped(String bookingId) {
		setBookingToShippedInDatabase(Integer.parseInt(bookingId));
	}
	
	public static void deleteSingleShippedBooking(String shippedBookingId) {
		dao.deleteShippedBooking(Integer.parseInt(shippedBookingId));
	}
	
	private static List<ShippedBookingsInfo> getAllShippedBookingsInformationInOneListOfObjects() {
		List<ShippedBookings> shipped = getAllShippedBookingsAsListFromDatabase();
		List<CustomersDecrypted> customers = CustomerUtilities.getCustomersDataAsListFromDatabase();
		List<Products> products = ProductUtilities.getAllProducts();
		
		return setShippedBookingsInformationIntoOneList(shipped, customers, products);
	}
	
	private static List<ShippedBookingsInfo> setShippedBookingsInformationIntoOneList(List<ShippedBookings> shipped, 
			List<CustomersDecrypted> customers, List<Products> products) {
		List<ShippedBookingsInfo> bookingInfo = new ArrayList<ShippedBookingsInfo>();
		int productid, customerid;
		
		for (int s = 0; s < shipped.size(); s++) {
			ShippedBookingsInfo sbi = new ShippedBookingsInfo();
			
			for (int p = 0; p < products.size(); p++) {
				productid = shipped.get(s).getProduct_id();
				if (productid == products.get(p).getProduct_id()) {
					sbi.setProduct_id(productid);
					sbi.setBarcode(products.get(p).getBarcode());
					sbi.setProductcode(products.get(p).getProductcode());
					sbi.setShop_product_id(products.get(p).getShop_product_id());
					sbi.setProductname(products.get(p).getName());
					sbi.setImage(products.get(p).getImage());
				}
			}
			
			for (int c = 0; c < customers.size(); c++) {
				customerid = shipped.get(s).getCustomer_id();
				if (customerid == customers.get(c).getCustomer_id()) {
					sbi.setCustomer_id(customers.get(c).getCustomer_id());
					sbi.setFirstname(customers.get(c).getFirstname());
					sbi.setLastname(customers.get(c).getLastname());
					sbi.setEmail(customers.get(c).getEmail());
					sbi.setPhone(customers.get(c).getPhone());
				}
			}
			
			if (!isNull(sbi)) {
				sbi.setBooking_id(shipped.get(s).getBooking_id());
				sbi.setAmount(shipped.get(s).getAmount());
				sbi.setShippingdate(shipped.get(s).getShippingdate());
				bookingInfo.add(sbi);
			}
		}
		
		return bookingInfo;
	}
	
	private static void setBookingToShippedInDatabase(int bookingId) {
		if (bookingId != 0) {
			Bookings booking = getSingleBookingFromDatabase(bookingId);
			if (booking != null) {
				ShippedBookings sb = new ShippedBookings();
					sb.setBooking_id(booking.getBooking_id());
					sb.setCustomer_id(booking.getCustomer_id());
					sb.setProduct_id(booking.getProduct_id());
					sb.setAmount(booking.getAmount());
					sb.setShippingdate(getCurrentDateAsString());
					
				addShippedBookingIntoDatabase(sb);
				deleteSingleBookingFromDatabase(bookingId);
			}
		}
	}
	
	private static void deleteSingleBookingFromDatabase(int bookingId) {
		dao.deleteBooking(bookingId);
	}
	
	private static Bookings getSingleBookingFromDatabase(int bookingId) {
		return dao.readBooking(bookingId);
	}
	
	private static List<ShippedBookings> getAllShippedBookingsAsListFromDatabase() {
		return dao.readShippedBookings();
	}
	
	private static void addShippedBookingIntoDatabase(ShippedBookings shippedBooking) {
		dao.addShippedBooking(shippedBooking);
	}
	
	private static String getCurrentDateAsString() {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyy");
		String currentDate = formatter.format(date);
		return currentDate;
	}
	
}

package appUtilities;

import javax.persistence.PersistenceException;

import dao.Dao;
import data.Bookings;

public class AddBookingUtilities {
	
	public static void addBookingDataToProductIntoDatabase(String product_id, String[] customers, String[] amounts,
			String additionalInformation) {
		try {
			Dao dao = new Dao();
			
			for (int i = 0; i < customers.length; i++ ) {
				int customerId = Integer.parseInt(customers[i]);
				if (customerId > 0) {
					Bookings booking = new Bookings();
					booking.setCustomer_id(Integer.parseInt(customers[i]));
					booking.setProduct_id(Integer.parseInt(product_id));
					booking.setAmount(Integer.parseInt(amounts[i]));
					booking.setAdditionalInformation(additionalInformation);
					dao.addBooking(booking);
				}
			}
		} catch (PersistenceException pe) {
			pe.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void addBookingDataToCustomerIntoDatabase(String[] products, String customer_id, String[] amounts, 
			String additionalInformation) {
		
		try {
			if (products.length == amounts.length) {
				Dao dao = new Dao();
			
				for (int i = 0; i < products.length; i++ ) {
					Bookings booking = new Bookings();
					booking.setProduct_id(Integer.parseInt(products[i]));
					booking.setCustomer_id(Integer.parseInt(customer_id));
					booking.setAmount(Integer.parseInt(amounts[i]));
					booking.setAdditionalInformation(additionalInformation);
					dao.addBooking(booking);
				}
			}
		} catch (PersistenceException pe) {
			pe.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void addBookingDataIntoDatabase(String[] products, String[] customers, String[] amounts, 
			String additionalInformation) {
		try {
			Dao dao = new Dao();
			for (int i = 0; i < products.length; i++) {
				for (int j = 0; j < customers.length; j++) {
					Bookings booking = new Bookings();
					booking.setCustomer_id(Integer.parseInt(customers[j]));
					booking.setProduct_id(Integer.parseInt(products[i]));
					if (!amounts[i].isEmpty()) {
						booking.setAmount(Integer.parseInt(amounts[i]));
					}
					booking.setInformed(false);
					booking.setAdditionalInformation(additionalInformation);
					dao.addBooking(booking);
				}
			}
		} catch (PersistenceException pe) {
			pe.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}

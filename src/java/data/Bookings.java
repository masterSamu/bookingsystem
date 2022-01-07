package data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Entity class for handeling Bookings for database.
 * @author Samu
 *
 */
@Entity
public class Bookings {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int booking_id;
	
	private int customer_id;
	private int product_id;
	private int amount;
	private boolean informed;
	private String additionalInformation;
	
	public Bookings() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Bookings(int booking_id, int customer_id, int product_id, int amount, boolean informed, String additionalInformation) {
		super();
		this.booking_id = booking_id;
		this.customer_id = customer_id;
		this.product_id = product_id;
		this.amount = amount;
		this.informed = informed;
	}

	public int getBooking_id() {
		return booking_id;
	}

	public void setBooking_id(int booking_id) {
		this.booking_id = booking_id;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public boolean isInformed() {
		return informed;
	}

	public void setInformed(boolean informed) {
		this.informed = informed;
	}

	public String getAdditionalInformation() {
		return additionalInformation;
	}

	public void setAdditionalInformation(String additionalInformation) {
		this.additionalInformation = additionalInformation;
	}

}

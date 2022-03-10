package data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ShippedBookings {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int shippedbooking_id;
	
	private int booking_id;
	private int customer_id;
	private int product_id;
	private int amount;
	private String shippingdate;
	
	
	
	public ShippedBookings() {
		super();
	}

	public ShippedBookings(int booking_id, int customer_id, int product_id, int amount, String shippingdate) {
		super();
		this.booking_id = booking_id;
		this.customer_id = customer_id;
		this.product_id = product_id;
		this.amount = amount;
		this.shippingdate = shippingdate;
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

	public String getShippingdate() {
		return shippingdate;
	}

	public void setShippingdate(String shippingdate) {
		this.shippingdate = shippingdate;
	}

	@Override
	public String toString() {
		return "ShippedBookings [booking_id=" + booking_id + ", customer_id=" + customer_id + ", product_id=" + product_id
				+ ", amount=" + amount + ", shippingdate=" + shippingdate + "]";
	}
	
	
	
	

}

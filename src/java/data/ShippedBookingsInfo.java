package data;

/**
 * This data class is used to set all ShippedBooking information required in 1 object.
 * @author Samu
 *
 */
public class ShippedBookingsInfo {
	private int shippedbooking_id, booking_id, customer_id, product_id, amount;
	private String firstname, lastname, email, phone, productname, shop_product_id, image, barcode, productcode, shippingdate;

	public ShippedBookingsInfo() {
		super();
	}

	public ShippedBookingsInfo(int shippedbooking_id, int booking_id, int customer_id, int product_id, String shop_product_id, int amount,
			String firstname, String lastname, String email, String phone, String productname, String image,
			String barcode, String productcode, String shippingdate) {
		super();
		this.booking_id = booking_id;
		this.customer_id = customer_id;
		this.product_id = product_id;
		this.shippedbooking_id = shippedbooking_id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.phone = phone;
		this.productname = productname;
		this.image = image;
		this.barcode = barcode;
		this.productcode = productcode;
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
	
	public String getShop_product_id() {
		return shop_product_id;
	}

	public void setShop_product_id(String shop_product_id) {
		this.shop_product_id = shop_product_id;
	}

	public int getShippedbooking_id() {
		return shippedbooking_id;
	}

	public void setShippedbooking_id(int shippedbooking_id) {
		this.shippedbooking_id = shippedbooking_id;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public String getProductcode() {
		return productcode;
	}

	public void setProductcode(String productcode) {
		this.productcode = productcode;
	}

	public String getShippingdate() {
		return shippingdate;
	}

	public void setShippingdate(String shippingdate) {
		this.shippingdate = shippingdate;
	}

}

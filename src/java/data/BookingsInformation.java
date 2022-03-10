package data;

/**
 * Data class for collect all bookinginformation into one object.
 * 
 * @author Samu
 *
 */
public class BookingsInformation {


	Bookings booking;
	ProductsWithSuppliers productWithSuppliers;
	CustomersDecrypted customer;

	public BookingsInformation(Bookings booking, ProductsWithSuppliers productWithSuppliers, CustomersDecrypted customer) {
		super();
		this.booking = booking;
		this.productWithSuppliers = productWithSuppliers;
		this.customer = customer;
	}

	public BookingsInformation() {
		super();
	}

	public Bookings getBooking() {
		return booking;
	}

	public void setBooking(Bookings booking) {
		this.booking = booking;
	}

	public ProductsWithSuppliers getProductWithSuppliers() {
		return productWithSuppliers;
	}

	public void setProductWithSuppliers(ProductsWithSuppliers productWithSuppliers) {
		this.productWithSuppliers = productWithSuppliers;
	}

	public CustomersDecrypted getCustomer() {
		return customer;
	}

	public void setCustomer(CustomersDecrypted customer) {
		this.customer = customer;
	}

	

}

package data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Entity class for Customers table
 * @author Samu
 *
 */
@Entity
public class Customers {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customer_id;

	private byte[] firstname;
	private byte[] lastname;
	private byte[] email;
	private byte[] phone;
	private String additionalInformation;

	public Customers() {
		super();
	}

	public Customers(byte[] firstname, byte[] lastname, byte[] email, byte[] phone, String additionalInformation) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.phone = phone;
		this.additionalInformation = additionalInformation;
	}

	public Customers(int customer_id, byte[] firstname, byte[] lastname, byte[] email, byte[] phone,
			String additionalInformation) {
		super();
		this.customer_id = customer_id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.phone = phone;
		this.additionalInformation = additionalInformation;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public byte[] getFirstname() {
		return firstname;
	}

	public void setFirstname(byte[] firstname) {
		this.firstname = firstname;
	}

	public byte[] getLastname() {
		return lastname;
	}

	public void setLastname(byte[] lastname) {
		this.lastname = lastname;
	}

	public byte[] getEmail() {
		return email;
	}

	public void setEmail(byte[] email) {
		this.email = email;
	}

	public byte[] getPhone() {
		return phone;
	}

	public void setPhone(byte[] phone) {
		this.phone = phone;
	}

	public String getAdditionalInformation() {
		return additionalInformation;
	}

	public void setAdditionalInformation(String additionalInformation) {
		this.additionalInformation = additionalInformation;
	}

}

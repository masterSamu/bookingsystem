package appUtilities;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import dao.Dao;
import data.Bookings;
import data.Customer_Keys;
import data.Customers;
import data.CustomersDecrypted;
import encrypt.CryptingDataUtils;
import jakarta.persistence.PersistenceException;

public class CustomerUtilities {
	static Dao dao = new Dao();
	
	public static List<String> getCustomerEmails() {
		List<String> emailList = new ArrayList<String>();
		List<CustomersDecrypted> customersList = getCustomersDataAsListFromDatabase();
		
		if (customersList.size() > 0) {
			for (int i = 0; i < customersList.size(); i++) {
				emailList.add(customersList.get(i).getEmail());
			}
		}
		return emailList;
	}
	
	public static void deleteCustomer(String customerId) {
		int customerIdInt = Integer.parseInt(customerId);
		if (customerIdInt != 0) {
			dao.deleteCustomer(customerIdInt);
		}
	}
	
	public static void editCustomer(String customerId, String firstname, String lastname,
			String email, String phone, String additionalInformation) {
		CustomersDecrypted customer = new CustomersDecrypted();
			customer.setCustomer_id(Integer.parseInt(customerId));
			customer.setFirstname(firstname);
			customer.setLastname(lastname);
			customer.setEmail(email);
			customer.setPhone(phone);
			customer.setAdditionalInformation(additionalInformation);
		
		PublicKey pubKey = getCustomerKeys().get(0).getPublicKey();
		Customers encryptedCustomer = encryptCustomerData(customer, pubKey);
		
		if (encryptedCustomer != null) {
			dao.editCustomer(encryptedCustomer);
		}
	}
	
	public static CustomersDecrypted getSingleCustomer(String customerId) {
		return getSingleCustomerDataFromDatabase(customerId);
	}
	
	public static void AddCustomerToDatabase(String firstname, String lastname, String email, String phone, 
			String additionalInformation) {
		CustomersDecrypted newCustomer = new CustomersDecrypted();
			newCustomer.setFirstname(firstname);
			newCustomer.setLastname(lastname);
			newCustomer.setEmail(email);
			newCustomer.setPhone(phone);
			newCustomer.setAdditionalInformation(additionalInformation);
			
		PublicKey pubKey = getCustomerKeys().get(0).getPublicKey();
		Customers encryptedCustomer = encryptCustomerData(newCustomer, pubKey);
		
		dao.addCustomer(encryptedCustomer);
	}
	
	private static Customers encryptCustomerData(CustomersDecrypted decryptedCustomer, PublicKey pubKey) {
		Customers encryptedCustomer = new Customers();
		encryptedCustomer.setFirstname(CryptingDataUtils.encryptData(decryptedCustomer.getFirstname(), pubKey));
		encryptedCustomer.setLastname(CryptingDataUtils.encryptData(decryptedCustomer.getLastname(), pubKey));
		encryptedCustomer.setEmail(CryptingDataUtils.encryptData(decryptedCustomer.getEmail(), pubKey));
		encryptedCustomer.setPhone(CryptingDataUtils.encryptData(decryptedCustomer.getPhone(), pubKey));
		encryptedCustomer.setAdditionalInformation(decryptedCustomer.getAdditionalInformation());
		return encryptedCustomer;
	}
	
	public static List<CustomersDecrypted> getCustomersDataAsListFromDatabase() {
		PrivateKey priKey = getCustomerKeys().get(0).getPrivateKey();
		List<CustomersDecrypted> decryptedCustomersData = getDecryptedCustomerDataAsList(
				getAllCustomerDataFromDatabase(), priKey);
		return decryptedCustomersData;
	}
	
	public static List<CustomersDecrypted> getAllCustomerDataWhoHasBooking(List<Bookings> bookings) {
		PrivateKey priKey = getCustomerKeys().get(0).getPrivateKey();
		List<CustomersDecrypted> decryptedCustomersData = getDecryptedCustomerDataAsList(
				extractCustomersWhoHasBooking(getAllCustomerDataFromDatabase(), bookings), priKey);
		return decryptedCustomersData;
	}
	
	private static List<Customers> extractCustomersWhoHasBooking(List<Customers> customers, List<Bookings> bookings) {
		List<Customers> extractedCustomers = new ArrayList<Customers>();
		for (int i = 0; i < bookings.size(); i++) {
			for (int j = 0; j < customers.size(); j++) {
				if (bookings.get(i).getCustomer_id() == customers.get(j).getCustomer_id()) {
					extractedCustomers.add(customers.get(j));
				}
			}
		}
		HashSet<Customers> uniqueValues = new HashSet<>(extractedCustomers);
		List<Customers> returnList = new ArrayList<Customers>(uniqueValues);
		return returnList;
	}
	

	private static CustomersDecrypted getSingleCustomerDataFromDatabase(String customer_id) {
		int customerId = Integer.parseInt(customer_id);
		CustomersDecrypted decryptedCustomerData = null;
		try {
			Customers cryptedCustomer = dao.readCustomer(customerId);
			PrivateKey priKey = getCustomerKeys().get(0).getPrivateKey();
			
			decryptedCustomerData = decryptCustomerData(customerId, cryptedCustomer, priKey);
			return decryptedCustomerData;
		} catch (PersistenceException pe) {
			pe.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return decryptedCustomerData;
	}
	
	private static CustomersDecrypted decryptCustomerData(int customerId, Customers cryptedCustomerObject, 
			PrivateKey customerKey) {
		CustomersDecrypted cd = new CustomersDecrypted();
		if (cryptedCustomerObject != null) {
			cd.setCustomer_id(customerId);
			cd.setFirstname(CryptingDataUtils.decryptData(cryptedCustomerObject.getFirstname(), customerKey));
			cd.setLastname(CryptingDataUtils.decryptData(cryptedCustomerObject.getLastname(), customerKey));
			cd.setEmail(CryptingDataUtils.decryptData(cryptedCustomerObject.getEmail(), customerKey));
			cd.setPhone(CryptingDataUtils.decryptData(cryptedCustomerObject.getPhone(), customerKey));
			cd.setAdditionalInformation(cryptedCustomerObject.getAdditionalInformation());
		}
		return cd;
	}
	
	private static List<Customers> getAllCustomerDataFromDatabase() {
		List<Customers> cryptedCustomers = null;
		try {
			cryptedCustomers = dao.readCustomers();
		} catch (PersistenceException pe) {
			pe.printStackTrace();
		}
		return cryptedCustomers;
	}
	
	private static List<CustomersDecrypted> getDecryptedCustomerDataAsList(List<Customers> cryptedCustomers, 
			PrivateKey priKey) {
		List<CustomersDecrypted> decryptedCustomersData = new ArrayList<CustomersDecrypted>();
		
		for (int i = 0; i < cryptedCustomers.size(); i++) {
			decryptedCustomersData.add(
					decryptCustomerData(cryptedCustomers.get(i).getCustomer_id(), 
						cryptedCustomers.get(i), priKey));
		}
		return decryptedCustomersData;
	}
	
	
	private static List<Customer_Keys> getCustomerKeys() {
		List<Customer_Keys> keys = null;
		try {
			keys = dao.readCustomerKeys();
		} catch (PersistenceException pe) {
			pe.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return keys;
	}
	
}

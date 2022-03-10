package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import data.Suppliers;
import data.Users;
import data.Bookings;
import data.Customers;
import data.Products;
import data.Products_suppliers_many;
import data.ShippedBookings;

/**
 * Database class
 * @author Samu
 *
 */
public class Dao {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("varausdb");
	
	/*
	 * Read methods
	 */
	
	
	/**
	 * Read user credentials from database
	 * @param String username
	 * @return list of user objects
	 */
	public List<Users> readUserCredentials(String username) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Query query = em.createQuery("SELECT u FROM Users u WHERE u.username = :username");
		query.setParameter("username", username);
		List<Users> list = query.getResultList();
		em.getTransaction().commit();
		em.close();
		
		return list;
	}
	
	/**
	 * Reads all products from database
	 * @return list of product objects
	 */
	public List<Products> readProducts() {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		List<Products> list = em.createQuery("SELECT a FROM Products a").getResultList();
		em.getTransaction().commit();
		em.close();
		
		return list;
	}
	
	/**
	 * Read all suppliers from database
	 * @return list of supplier objects
	 */
	public List<Suppliers> readProductSuppliers() {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		List<Suppliers> list = em.createQuery("SELECT a FROM Suppliers a ORDER BY a.name ASC").getResultList();
		em.getTransaction().commit();
		em.close();
		
		return list;
	}
	
	/**
	 * Read all suppliers for product
	 * @return list of objects
	 */
	public List<Products_suppliers_many> readProductSuppliersMany() {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Query query = em.createQuery("SELECT a FROM Products_suppliers_many a");
		List<Products_suppliers_many> list = query.getResultList();
		em.getTransaction().commit();
		em.close();
		
		return list;
	}
	
	/**
	 * Read all customers from database
	 * @return list of customer objects
	 */
	public List<Customers> readCustomers() {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Query query = em.createQuery("SELECT a FROM Customers a");
		List<Customers> list = query.getResultList();
		em.getTransaction().commit();
		em.close();
		
		return list;
	}
	
	public List<Bookings> readBookings() {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Query query = em.createQuery("SELECT a FROM Bookings a");
		List<Bookings> list = query.getResultList();
		em.getTransaction().commit();
		em.close();
		
		return list;
	}
	
	
	/**
	 * Read one product's suppliers from database.
	 * @param int productId
	 * @return list of objects
	 */
	public List<Products_suppliers_many> readOneProductSuppliersMany(int productId) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Query query = em.createQuery("SELECT a FROM Products_suppliers_many a WHERE a.product_id = :productId");
		query.setParameter("productId", productId);
		List<Products_suppliers_many> list = query.getResultList();
		em.getTransaction().commit();
		em.close();
		
		return list;
	}
	
	/**
	 * Read product's suppliers data for one supplier
	 * @param supplierId
	 * @return list of objects
	 */
	public List<Products_suppliers_many> readProductSuppliersManyForSupplier(int supplierId) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Query query = em.createQuery("SELECT a FROM Products_suppliers_many a WHERE a.supplier_id = :supplierId");
		query.setParameter("supplierId", supplierId);
		List<Products_suppliers_many> list = query.getResultList();
		em.getTransaction().commit();
		em.close();
		
		return list;
	}
	
	/**
	 * Read shipped bookings from database
	 * @return list of objects
	 */
	public List<ShippedBookings> readShippedBookings() {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Query query = em.createQuery("SELECT a FROM ShippedBookings a");
		List<ShippedBookings> list = query.getResultList();
		em.getTransaction().commit();
		em.close();
		
		return list;
	}
	
	
	/**
	 * Read single product
	 * @param int productId
	 * @return product object
	 */
	public Products readProduct(int productId) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Query query = em.createQuery("SELECT a FROM Products a WHERE a.product_id = :productId");
		query.setParameter("productId", productId);
		Products product = new Products();
		product = (Products) query.getSingleResult();
		em.getTransaction().commit();
		em.close();
		
		return product;
	}
	
	/**
	 * Read single supplier information
	 * @param int supplierId
	 * @return supplier object
	 */
	public Suppliers readSupplier(int supplierId) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Query query = em.createQuery("SELECT a FROM Suppliers a WHERE a.supplier_id = :supplierId");
		query.setParameter("supplierId", supplierId);
		Suppliers supplier = new Suppliers();
		supplier = (Suppliers) query.getSingleResult();
		em.getTransaction().commit();
		em.close();
		
		return supplier;
	}
	
	/**
	 * Read single customer information
	 * @param int customerId
	 * @return customer object
	 */
	public Customers readCustomer(int customerId) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Query query = em.createQuery("SELECT a FROM Customers a WHERE a.customer_id = :customerId");
		query.setParameter("customerId", customerId);
		Customers customer = new Customers();
		customer = (Customers) query.getSingleResult();
		em.getTransaction().commit();
		em.close();
		
		return customer;
	}
	
	/**
	 * Read single booking information
	 * @param int bookingId
	 * @return booking object
	 */
	public Bookings readBooking(int bookingId) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Query query = em.createQuery("SELECT a FROM Bookings a WHERE a.booking_id = :bookingId");
		query.setParameter("bookingId", bookingId);
		Bookings booking = (Bookings) query.getSingleResult();
		em.getTransaction().commit();
		em.close();
		
		return booking;
	}
	
	public List<Bookings> readBookingsForOneCustomer(int customerId) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Query query = em.createQuery("SELECT a FROM Bookings a WHERE a.customer_id = :customerId");
		query.setParameter("customerId", customerId);
		List<Bookings> list = query.getResultList();
		em.getTransaction().commit();
		em.close();
		
		return list;
	}
	
	public List<Bookings> readBookingsForOneProduct(int productId) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Query query = em.createQuery("SELECT a FROM Bookings a WHERE a.product_id = :productId");
		query.setParameter("productId", productId);
		List<Bookings> list = query.getResultList();
		em.getTransaction().commit();
		em.close();
		
		return list;
	}
	
	
	public List<ShippedBookings> readShippedBookingsByProduct(int productId) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Query query = em.createQuery("SELECT a FROM ShippedBookings a WHERE a.product_id = :productId");
		query.setParameter("productId", productId);
		List<ShippedBookings> sb = query.getResultList();
		em.getTransaction().commit();
		em.close();
		
		return sb;
	}
	
	

	/*
	 * Add methods
	 */
	
	
	/**
	 * Add single product into database
	 * @param product object of product information
	 */
	public void addProduct(Products product) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(product);
		em.getTransaction().commit();
		em.close();
	}
	
	/**
	 * Add product_id and supplier_id into join table
	 * @param Psm object contains product_id and supplier_id
	 */
	public void addProductSuppliers(Products_suppliers_many Psm) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(Psm);
		em.getTransaction().commit();
		em.close();
	}
	
	/**
	 * Add new supplier into database
	 * @param supplier object
	 */
	public void addSupplier(Suppliers supplier) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(supplier);
		em.getTransaction().commit();
		em.close();
	}
	
	/**
	 * Add new customer into database
	 * @param customer object
	 */
	public void addCustomer(Customers customer) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(customer);
		em.getTransaction().commit();
		em.close();
	}
	
	/**
	 * Ad new booking to database
	 * @param booking object
	 */
	public void addBooking(Bookings booking) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(booking);
		em.getTransaction().commit();
		em.close();
	}
	
	public void addShippedBooking(ShippedBookings sb) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(sb);
		em.getTransaction().commit();
		em.close();
	}
	
	
	/*
	 * Edit methods
	 */
	
	/**
	 * Edit user's password
	 * @param Users user
	 */
	public void editUserPassword(Users user) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.find(Users.class, user.getUser_id());
		em.merge(user);
		em.getTransaction().commit();
		em.close();
	}
	
	
	/**
	 * Edit one product
	 * @param product object
	 */
	public void editProduct(Products product) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.find(Products.class, product.getProduct_id());
		em.merge(product);
		em.getTransaction().commit();
		em.close();
	}
	
	/**
	 * Edit one supplier
	 * @param supplier object
	 */
	public void editSupplier(Suppliers supplier) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.find(Suppliers.class, supplier.getSupplier_id());
		em.merge(supplier);
		em.getTransaction().commit();
		em.close();
	}
	
	/**
	 * Edit one customer
	 * @param customer object
	 */
	public void editCustomer(Customers customer) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.find(Customers.class, customer.getCustomer_id());
		em.merge(customer);
		em.getTransaction().commit();
		em.close();
	}
	
	public void editBooking(Bookings booking) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.find(Bookings.class, booking.getBooking_id());
		em.merge(booking);
		em.getTransaction().commit();
		em.close();
	}
	
	
	/*
	 * Delete methods
	 */
	
	
	/**
	 * Delete product information completely
	 * @param int productId
	 */
	public void deleteProduct(int productId) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		Query query = em.createQuery("DELETE FROM Products_suppliers_many a WHERE a.product_id = :productId");
		query.setParameter("productId", productId);
		query.executeUpdate();
		
		Query query2 = em.createQuery("DELETE FROM Bookings a WHERE a.product_id = :productId");
		query2.setParameter("productId", productId);
		query2.executeUpdate();
		
		Query query3 = em.createQuery("DELETE FROM ShippedBookings a WHERE a.product_id = :productId");
		query3.setParameter("productId", productId);
		query3.executeUpdate();
		
		Products product = em.find(Products.class, productId);
		if (product != null) {
			em.remove(product);
		}
		em.getTransaction().commit();
		em.close();
	}
	
	/**
	 * Delete supplier information completely
	 * @param int supplierId
	 */
	public void deleteSupplier(int supplierId) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Suppliers supplier = em.find(Suppliers.class, supplierId);
		if (supplier != null) {
			em.remove(supplier);
		}
		em.getTransaction().commit();
		em.close();
	}
	
	/**
	 * Delete product and suppliers join table by productId
	 * @param int productId
	 */
	public void deleteProductSuppliersProduct(int productId) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Query query = em.createQuery("DELETE FROM Products_suppliers_many a WHERE a.product_id = :productId");
		query.setParameter("productId", productId);
		query.executeUpdate();
		em.getTransaction().commit();
		em.close();
	}
	
	/**
	 * Delete product and suppliers join table by supplierId
	 * @param int supplierId
	 */
	public void deleteProductSuppliersSupplier(int supplierId) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Query query = em.createQuery("DELETE FROM Products_suppliers_many a WHERE a.supplier_id = :supplierId");
		query.setParameter("supplierId", supplierId);
		query.executeUpdate();
		em.getTransaction().commit();
		em.close();
	}
	
	/**
	 * Delete single customer information completely from customer table and bookings table.
	 * @param int customerId
	 */
	public void deleteCustomer(int customerId) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Customers customer = em.find(Customers.class, customerId);
		if (customer != null) {
			Query query = em.createQuery("DELETE FROM Bookings a WHERE a.customer_id = :customerId");
			query.setParameter("customerId", customerId);
			query.executeUpdate();
			
			Query query2 = em.createQuery("DELETE FROM ShippedBookings a WHERE a.customer_id = :customerId");
			query2.setParameter("customerId", customerId);
			query2.executeUpdate();
			
			em.remove(customer);
		}
		em.getTransaction().commit();
		em.close();
	}
	
	/**
	 * Delete single booking information from bookings table
	 * @param int bookingId
	 */
	public void deleteBooking(int bookingId) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Bookings booking = em.find(Bookings.class, bookingId);
		if (booking != null) {
			em.remove(booking);;
		}
		em.getTransaction().commit();
		em.close();
	}
	
	/**
	 * Delete single shipped booking information from shipped bookings.
	 * @param int shippedBookingId
	 */
	public void deleteShippedBooking(int shippedBookingId) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		ShippedBookings sb = em.find(ShippedBookings.class, shippedBookingId);
		if (sb != null) {
			em.remove(sb);
		}
		em.getTransaction().commit();
		em.close();
	}
	
	
}

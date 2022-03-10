package data;

import java.util.ArrayList;
/**
 * Data class to store Product and involved suppliers information.
 * @author Samu
 *
 */
public class ProductsWithSuppliers {
	Products product;
	ArrayList<Suppliers> suppliers;
	
	public ProductsWithSuppliers() {
		super();
	}

	public ProductsWithSuppliers(Products product, ArrayList<Suppliers> suppliers) {
		super();
		this.product = product;
		this.suppliers = suppliers;
	}
	
	public Products getProduct() {
		return product;
	}
	public void setProduct(Products product) {
		this.product = product;
	}
	public ArrayList<Suppliers> getSuppliers() {
		return suppliers;
	}
	public void setSuppliers(ArrayList<Suppliers> suppliers) {
		this.suppliers = suppliers;
	}
	
	
}

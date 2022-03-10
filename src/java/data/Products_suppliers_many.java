package data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Entity class for products and suppliers join
 * @author Samu
 *
 */
@Entity
public class Products_suppliers_many {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private int supplier_id;
	private int product_id;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSupplier_id() {
		return supplier_id;
	}

	public void setSupplier_id(int supplier_id) {
		this.supplier_id = supplier_id;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public Products_suppliers_many() {
		super();
	}

	public Products_suppliers_many(int supplier_id, int product_id) {
		super();
		this.supplier_id = supplier_id;
		this.product_id = product_id;
	}
	
	
	
	
	
	

}

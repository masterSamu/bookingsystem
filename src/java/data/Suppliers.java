package data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;

/**
 * Entity class for Suppliers
 * 
 * @author Samu
 *
 */
@Entity
public class Suppliers {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int supplier_id;

	private String name;
	private String additionalInformation;

	public Suppliers() {
		super();
	}

	public Suppliers(int supplier_id, String name, String additionalInformation) {
		super();
		this.supplier_id = supplier_id;
		this.name = name;
		this.additionalInformation = additionalInformation;
	}

	public int getSupplier_id() {
		return supplier_id;
	}

	public void setSupplier_id(int supplier_id) {
		this.supplier_id = supplier_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdditionalInformation() {
		return additionalInformation;
	}

	public void setAdditionalInformation(String additionalInformation) {
		this.additionalInformation = additionalInformation;
	}

}

package data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Entity class for Products
 * 
 * @author Samu
 *
 */
@Entity
public class Products {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int product_id;

	private String barcode;
	private String productcode;
	private String shop_product_id;
	private String name;
	private String image;
	private String link;
	private String additionalInformation;

	public Products() {
		super();
	}

	public Products(int product_id, String barcode, String productcode, String shop_product_id, String name,
			String image, String link, String additionalInformation) {
		super();
		this.product_id = product_id;
		this.barcode = barcode;
		this.productcode = productcode;
		this.shop_product_id = shop_product_id;
		this.name = name;
		this.image = image;
		this.link = link;
		this.additionalInformation = additionalInformation;
	}

	public Products(String barcode, String productcode, String shop_product_id, String name, String image, String link,
			String additionalInformation) {
		super();
		this.barcode = barcode;
		this.productcode = productcode;
		this.shop_product_id = shop_product_id;
		this.name = name;
		this.image = image;
		this.link = link;
		this.additionalInformation = additionalInformation;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
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

	public String getShop_product_id() {
		return shop_product_id;
	}

	public void setShop_product_id(String shop_product_id) {
		this.shop_product_id = shop_product_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getAdditionalInformation() {
		return additionalInformation;
	}

	public void setAdditionalInformation(String additionalInformation) {
		this.additionalInformation = additionalInformation;
	}

	@Override
	public String toString() {
		return "Products [product_id=" + product_id + ", barcode=" + barcode + ", productcode=" + productcode
				+ ", shop_product_id=" + shop_product_id + ", name=" + name + ", image=" + image + ", link=" + link
				+ ", additionalInformation=" + additionalInformation + "]";
	}
	
	

}

package appUtilities;

import java.util.ArrayList;
import java.util.List;

import dao.Dao;
import data.Products;
import data.ProductsWithSuppliers;
import data.Products_suppliers_many;
import data.Suppliers;

public class ProductUtilities {
	static Dao dao = new Dao();

	public static ArrayList<ProductsWithSuppliers> getAllProductsWithSuppliers() {
		return combineAllProductsWithSuppliers();
	}

	public static ProductsWithSuppliers getSingleProductWithSuppliers(String productId) {
		return combineSingleProductWithSuppliers(productId);
	}

	private static ArrayList<ProductsWithSuppliers> combineAllProductsWithSuppliers() {
		List<Products> products = getProductsAsListFromDatabase();
		List<Suppliers> suppliers = SuppliersUtilities.getAllSuppliers();
		List<Products_suppliers_many> productSuppliers = ProductUtilities.getAllProductSuppliersFromDatabase();

		ArrayList<ProductsWithSuppliers> pwsList = new ArrayList<ProductsWithSuppliers>();

		for (Products product : products) {
			ArrayList<Suppliers> supplierListForProduct = getSuppliersForProduct(product, productSuppliers, suppliers);
			ProductsWithSuppliers pws = new ProductsWithSuppliers();
			pws.setProduct(product);
			pws.setSuppliers(supplierListForProduct);
			pwsList.add(pws);
		}
		return pwsList;
	}

	private static ProductsWithSuppliers combineSingleProductWithSuppliers(String productId) {
		Products product = getSingleProductDataFromDatabase(productId);
		List<Suppliers> suppliers = SuppliersUtilities.getAllSuppliers();
		List<Products_suppliers_many> productSuppliers = ProductUtilities.getAllProductSuppliersFromDatabase();

		ProductsWithSuppliers productWithSuppliers = new ProductsWithSuppliers();
		ArrayList<Suppliers> supplierListForProduct = getSuppliersForProduct(product, productSuppliers, suppliers);
		productWithSuppliers.setProduct(product);
		productWithSuppliers.setSuppliers(supplierListForProduct);

		return productWithSuppliers;
	}

	public static void editProduct(String productId, String barcode, String productCode, String name, String image,
			String link, String additionalInformation, String[] suppliers) {
		String shop_product_id = extractShopProductIdFromLink(link);
		Products product = new Products();
		product.setProduct_id(Integer.parseInt(productId));
		product.setBarcode(barcode);
		product.setProductcode(productCode);
		product.setShop_product_id(shop_product_id);
		product.setName(name);
		product.setImage(image);
		product.setLink(link);
		product.setAdditionalInformation(additionalInformation);

		dao.editProduct(product);
		if (getProductsSuppliersForSingleProduct(productId).size() > 0) {
			deleteSuppliersFromProduct(productId);
		}
		addSuppliersToProduct(product, suppliers);
	}

	public static void deleteSingleProduct(String productId) {
		int productIdInt = Integer.parseInt(productId);
		if (productIdInt != 0) {
			dao.deleteProduct(productIdInt);
		}
	}

	private static String extractShopProductIdFromLink(String link) {
		String shop_product_id = "";
		if (link.length() > 3) {
			String last3CharactersOfLink = link.substring(link.length() - 3);
			if (!last3CharactersOfLink.equalsIgnoreCase("png") || !last3CharactersOfLink.equalsIgnoreCase("jpg")) {
				shop_product_id = link.substring(link.lastIndexOf('/') + 1);
			}
		}
		return shop_product_id;
	}

	public static Products getSingleProduct(String product_id) {
		return getSingleProductDataFromDatabase(product_id);
	}

	public static List<Products> getAllProducts() {
		return getProductsAsListFromDatabase();
	}

	public static List<Products_suppliers_many> getProductsSuppliersForSingleProduct(String productId) {
		return dao.readOneProductSuppliersMany(Integer.parseInt(productId));
	}

	public static List<Products_suppliers_many> getAllProductSuppliersFromDatabase() {
		return dao.readProductSuppliersMany();
	}

	private static List<Products> getProductsAsListFromDatabase() {
		List<Products> products = dao.readProducts();
		return products;
	}

	public static void addProductIntoDatabase(String barcode, String productCode, String shop_product_id, String name,
			String image, String link, String additionalInformation, String[] suppliers) {
		Products product = new Products();
		product.setBarcode(barcode);
		product.setProductcode(productCode);
		product.setShop_product_id(shop_product_id);
		product.setName(name);
		product.setImage(image);
		product.setLink(link);
		product.setAdditionalInformation(additionalInformation);

		dao.addProduct(product);
		addSuppliersToProduct(product, suppliers);
	}

	private static Products getSingleProductDataFromDatabase(String product_id) {
		return dao.readProduct(Integer.parseInt(product_id));
	}

	private static void deleteSuppliersFromProduct(String productId) {
		if (getProductsSuppliersForSingleProduct(productId).size() > 0) {
			dao.deleteProductSuppliersProduct(Integer.parseInt(productId));
		}
	}

	private static void addSuppliersToProduct(Products product, String[] suppliers) {
		if (suppliers != null) {
			for (int i = 0; i < suppliers.length; i++) {
				Products_suppliers_many Psm = new Products_suppliers_many();
				Psm.setProduct_id(product.getProduct_id());
				Psm.setSupplier_id(Integer.parseInt(suppliers[i]));
				dao.addProductSuppliers(Psm);
			}
		}
	}

	private static ArrayList<Suppliers> getSuppliersForProduct(Products product,
			List<Products_suppliers_many> productSuppliers, List<Suppliers> suppliers) {
		ArrayList<Suppliers> supplierListForProduct = new ArrayList<Suppliers>(1);
		for (Products_suppliers_many psm : productSuppliers) {
			if (product.getProduct_id() == psm.getProduct_id()) {
				for (Suppliers supplier : suppliers) {
					if (psm.getSupplier_id() == supplier.getSupplier_id()) {
						supplierListForProduct.add(supplier);
					}
				}
			}
		}
		return supplierListForProduct;
	}
}

package appUtilities;

import java.util.List;

import dao.Dao;
import data.Suppliers;

public class SuppliersUtilities {

	static Dao dao = new Dao();
	
	public static List<Suppliers> getAllSuppliers() {
		return getAllSuppliersAsListFromDatabase();
	}
	
	public static Suppliers getSingleSupplier(String supplierId) {
		return dao.readSupplier(Integer.parseInt(supplierId));
	}
	
	public static void deleteSingleSupplier(String supplierId) {
		int supplierIdInt = Integer.parseInt(supplierId);
		if (supplierIdInt > 0) {
			dao.deleteProductSuppliersSupplier(supplierIdInt);
			dao.deleteSupplier(supplierIdInt);
		}
	}
	
	public static void editSingleSupplier(String supplierId, String name, String additionalInformation) {
		int supplierIdInt = Integer.parseInt(supplierId);
		if (supplierIdInt > 0) {
			Suppliers supplier = new Suppliers();
			supplier.setSupplier_id(supplierIdInt);
			supplier.setName(name);
			supplier.setAdditionalInformation(additionalInformation);
			
			dao.editSupplier(supplier);
		}
	}
	
	public static void addSupplierIntoDatabase(String name, String additionalInformation) {
		Suppliers supplier = new Suppliers();
			supplier.setName(name);
			supplier.setAdditionalInformation(additionalInformation);
		
		if (supplier.getName() != "") {
			dao.addSupplier(supplier);
		}
	}
	
	private static List<Suppliers> getAllSuppliersAsListFromDatabase() {
		List<Suppliers> suppliers = dao.readProductSuppliers();
		return suppliers;
	}

	
}

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class InventoryController {

	//private StoreGui gui;
	private Inventory inventory;

	public InventoryController(Store store) {
		this.inventory = store.getStoreInventory();
	}
	
	public String addProduct(String productID, String quantity, String productName, String price, String manufacturer, boolean isFood) {

		IDValidator checkID = new IDValidator();

		//check length
		if (checkID.isIdValidProduct(productID) == 1) {
			return "Make sure the ID is four digits.";
		}

		//check characters
		else if (checkID.isIdValidProduct(productID) == 2) {
			return "Make sure the ID only contains digits.";
		}

		else if (quantity.length() < 1){
			return "Make sure the quantity is filled out.";
		}

		else if (productName.length() < 1){
			return "Make sure the Product Name is filled out.";
		}

		else if (price.length() < 1){
			return "Make sure the Price is filled out.";
		}

		else if (manufacturer.length() < 1){
			return "Make sure the Manufacturer Name is filled out.";
		}

		else {
			if(inventory.containsProduct(productID)){
				return "Product already exists.";
			}

			else{
				try {
					double doublePrice = Double.parseDouble(price);
					if(doublePrice < 0.01){
						return "Price has to be greater than one cent!";
					}
				} catch (NumberFormatException nfe) {
					return "Price has to be a double!";
				}
				try {
					int intQuantity = Integer.parseInt(quantity);
					if(intQuantity < 1){
						return "Quantity has to be greater than zero!";
					}
				} catch (NumberFormatException nfe) {
					return "Quantity has to be an Integer!";
				}

				Product p = new Product(productID, Integer.parseInt(quantity), productName, Double.parseDouble(price), manufacturer, isFood);
				inventory.addProduct(p);
				return "Product has been added, please return to inventory menu or add more.";
			}
		}
	}

	public int displayNumberOfProducts(){
		return inventory.getSize();
	}

	public double displayTotalValue(){
		return inventory.getTotalInventoryValue();
	}

	public ArrayList<Product> displayProductReportName(){
		return inventory.productReportName();
	}

	public ArrayList<Product> displayProductReportID(){
		return inventory.productReportID();
	}

	public ArrayList<Product> displayProductReportManufacturer(){
		return inventory.productReportManufacturer();
	}

	public ArrayList<Product> displayProductReportIsFood(){
		return inventory.productReportIsFood();
	}

	public void removeQuantity(String productID, int quantity) {
		inventory.getProduct(productID).setQuantity(inventory.getProduct(productID).getQuantity() - quantity);
	}

	public void addQuantity(String productID, int quantity) {
		inventory.getProduct(productID).setQuantity(inventory.getProduct(productID).getQuantity() + quantity);
	}
	
	public void updatePrice(String productID, double price) {
		inventory.getProduct(productID).setPrice(price);
	}
	
	public void removeProduct(String productID) {
		inventory.removeProduct(inventory.getProduct(productID));
	}

	public void manufacturerProductReport(String manufacturer){
		
		ArrayList<Product> allProductsManufacturer = inventory.productReportManufacturer();
		
		System.out.println("All Products made by " + manufacturer + " :");
		for (Product product : allProductsManufacturer) {
			if (product.getManufacturer().equals(manufacturer)) {
				double totalInventoryValue = product.getTotalValue();
				System.out.println(product + " Total Value: " + totalInventoryValue);

			}
		}
	}

	public void batchAddUpdate(File file){
		inventory.batchAddOrUpdate(file);
	}

	public void saveProductReport() throws IOException {
		File productReport = new File("ProductReport.txt");
		FileWriter writer = new FileWriter(productReport);
		for(int i = 0; i < inventory.productReportName().size(); i++) {
			writer.write(inventory.productReportName().get(i).toString());
		}
		writer.close();
	}
}

import java.util.ArrayList;

public class InventoryController {

	//private StoreGui gui;
	private Inventory inventory;

	public InventoryController(Store store) {
		this.inventory = store.getStoreInventory();
	}
	
	public void addProduct(String productID, int quantity, String productName, double price, String manufacturer, boolean isFood) {
		
		IDValidator checkID = new IDValidator(); 
		if(checkID.isIdValidProduct(productID)) {
			if(!inventory.containsProduct(productID)) {
				Product p = new Product(productID, quantity, productName, price, manufacturer, isFood);
				inventory.addProduct(p);
			}
			//already exists
		}
		//invalid id
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
	public void updateQuantity(String productID, int quantity) {
		inventory.getProduct(productID).setQuantity(quantity);
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
}

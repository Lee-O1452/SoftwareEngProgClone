import java.util.ArrayList;

public class InventoryController {

	//private StoreGui gui;
	private Inventory inventory;

	public InventoryController(Store store) {
		this.inventory = store.getStoreInventory();
	}
	
	public void addProduct(int productID, int quantity, String productName, double price, String manufacturer, boolean isFood) {
		
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
	public void displayProductReportName(){
		ArrayList<Product> allProductsName = inventory.productReportName();

		for(int i = 0; i < allProductsName.size(); i++) {
			System.out.println(allProductsName.get(i));
		}
	}
	public void displayProductReportID(){
		ArrayList<Product> allProductsID = inventory.productReportID();

		for(int i = 0; i < allProductsID.size(); i++) {
			System.out.println(allProductsID.get(i));
		}
	}
	public void displayProductReportManufacturer(){
		ArrayList<Product> allProductsManufacturer = inventory.productReportManufacturer();

		for(int i = 0; i < allProductsManufacturer.size(); i++) {
			System.out.println(allProductsManufacturer.get(i));
		}
	}
	public void displayProductReportIsFood(){
		ArrayList<Product> allProductsIsFood = inventory.productReportIsFood();

		for(int i = 0; i < allProductsIsFood.size(); i++) {
			System.out.println(allProductsIsFood.get(i));
		}
	}
	public void updateQuantity(int productID, int quantity) {
		inventory.getProduct(productID).setQuantity(quantity);
	}
	
	public void updatePrice(int productID, double price) {
		inventory.getProduct(productID).setPrice(price);
	}
	
	public void removeProduct(int productID) {
		inventory.removeProduct(inventory.getProduct(productID));
	}

	public void manufacturerProductReport(String manufacturer){
		
		ArrayList<Product> allProductsManufacturer = inventory.productReportManufacturer();
		
		System.out.println("All Products made by " + manufacturer + " :");
		for(int i = 0; i < allProductsManufacturer.size(); i++){
			if (allProductsManufacturer.get(i).getManufacturer().equals(manufacturer)){
				double totalInventoryValue = allProductsManufacturer.get(i).getTotalValue();
				System.out.println(allProductsManufacturer.get(i).toString() + " Total Value: " + totalInventoryValue);

			}

		}

	}
}

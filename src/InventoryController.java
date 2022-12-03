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
	public ArrayList<Product> displayProductReportName(){
		ArrayList<Product> allProductsName = inventory.productReportName();
		return allProductsName;
	}
	public ArrayList<Product> displayProductReportID(){
		ArrayList<Product> allProductsID = inventory.productReportID();

		return allProductsID;
	}
	public ArrayList<Product> displayProductReportManufacturer(){
		ArrayList<Product> allProductsManufacturer = inventory.productReportManufacturer();

		return allProductsManufacturer;
	}
	public ArrayList<Product> displayProductReportIsFood(){
		ArrayList<Product> allProductsIsFood = inventory.productReportIsFood();

		return allProductsIsFood;
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

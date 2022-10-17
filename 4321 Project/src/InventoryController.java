import java.util.ArrayList;

public class InventoryController {

	//private StoreGui gui;
	private Inventory inventory;
	
//	public InventoryController(StoreGui gui) {
//		this.gui = gui;
//		this.inventory = MapPersistence.buildInventory();
//	}
	
	public void addProduct(int productID, int quantity, String productName, double price, String manufacturer, boolean isFood) {
		
		IDValidator checkID = new IDValidator(); 
		if(checkID.isIdValidProduct(productID)) {
			if(!inventory.containsProduct(productID)) {
				Product p = new Product(productID, quantity, productName, price, manufacturer, isFood);
				inventory.addProduct(p);
				//add confirmation here
			}
			//already exists
		}
		//invalid id
	}
	
	public void displayProductReport(){
		ArrayList<Product> allProductsName = inventory.productReportName();
		ArrayList<Product> allProductsID = inventory.productReportID();
		ArrayList<Product> allProductsManufacturer = inventory.productReportManufacturer();
		ArrayList<Product> allProductsIsFood = inventory.productReportIsFood();
		
		System.out.println("There are " + allProductsName.size() + " products in the system.\n");
		double totalInventoryValue = 0;
		for(int i = 0; i < allProductsName.size(); i++) {
			totalInventoryValue += allProductsName.get(i).getTotalValue();
		}
		System.out.println("The total value of all products combined is $" + totalInventoryValue + ".\n");
		
		//needs code for selecting which to display based off the gui button selected, default is name
		
		for(int i = 0; i < allProductsName.size(); i++) {
			System.out.println(allProductsName.get(i));
		}
		
		for(int i = 0; i < allProductsID.size(); i++) {
			System.out.println(allProductsID.get(i));
		}
		
		for(int i = 0; i < allProductsManufacturer.size(); i++) {
			System.out.println(allProductsManufacturer.get(i));
		}
		
		for(int i = 0; i < allProductsIsFood.size(); i++) {
			System.out.println(allProductsIsFood.get(i));
		}
	}
}

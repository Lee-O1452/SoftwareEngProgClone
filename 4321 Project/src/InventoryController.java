
public class InventoryController {

	//private StoreGui gui;
	private Inventory inventory;
	
//	public InventoryController(StoreGui gui) {
//		this.gui = gui;
//		this.inventory = MapPersistence.buildInventory();
//	}
	
	public void addProduct(int productID, String productName, double price, String manufacturer, boolean isFood, int quantity) {
		
		IDValidator checkID = new IDValidator(); 
		
		if(checkID.isIdValidProduct(productID)) {
			if(!inventory.containsProduct(productID)) {
				Product p = new Product(productName, price, manufacturer, productID, isFood, quantity);
				inventory.addProduct(p);
				//add confirmation here
			}
			//already exists
		}
		//invalid id
	}
	

}

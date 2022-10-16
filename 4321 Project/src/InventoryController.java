
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
	

}

import java.util.Date;


public class MapPersistence {

	public Inventory buildInventory() {
		return new Inventory();
	}
	
	public void buildOrder(String orderID, String customerID, Date date, boolean usingSnap, boolean isPaid, Store store) {
		Order o = new Order(orderID, customerID, date, usingSnap, isPaid, store);
		Main.getOrderList().put(orderID, o);
	}
	
	public void buildStore(String storeID, String storeName) {
		Store s = new Store(storeID, storeName);
		Main.getStoreList().put(storeID, s);
	}

//for saving the inventory to a text file
//	public void saveInventory(){
//		
//	}
	
//	public void saveOrder(){
//	
//}
	
//	public void saveStore(){
//	
//}
	
}

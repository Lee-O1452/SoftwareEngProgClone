import java.util.Date;

//CTWOOD WAS HERE

public class MapPersistence {

	public Inventory buildInventory() {
		return new Inventory();
	}
	
	public Order buildOrder(String orderID, String customerID, Date date, boolean usingSnap, boolean isPaid, Store store) {
		Order o = new Order(orderID, customerID, date, usingSnap, isPaid, store);
		return o;
	}
	
	public Store buildStore(String storeID, String storeName) {
		Store s = new Store(storeID, storeName);
		Main.getStoreList().put(storeID, s);
		return s;
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

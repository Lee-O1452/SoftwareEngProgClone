import java.util.Date;

public class MapPersistence {

	public Inventory buildInventory() {
		Inventory i = new Inventory();
		return i;
	}
	
	public Order buildOrder(int orderID, int customerID, Date date, boolean usingSnap, boolean isPaid) {
		Order o = new Order(orderID, customerID, date, usingSnap, isPaid);
		return o;
	}
	
	public Store buildStore(int storeID, String storeName) {
		Store s = new Store(storeID, storeName);
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

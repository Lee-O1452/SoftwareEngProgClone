import java.time.LocalDate;



public class MapPersistence {

	public Inventory buildInventory() {
		return new Inventory();
	}

	public void buildOrder(String orderID, String customerID, Store store) {
		//date, usingSnap, isPaid,
		LocalDate date = LocalDate.now();
		boolean usingSnap = false;
		boolean isPaid = false;
		Order o = new Order(orderID, customerID, date, usingSnap, isPaid, store);
		Main.getOrderList().put(orderID, o);
	}

	public void buildStore(String storeID, String storeName) {
		Store s = new Store(storeID, storeName);
		Main.getStoreList().put(storeID, s);
	}
}

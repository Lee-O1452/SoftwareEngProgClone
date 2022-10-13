import java.util.HashMap;
import java.util.Map;

public class Store {
	
	private Map<Integer, Customer> store;
	private int storeID;
	private String storeName;
	
	public Store(int storeID, String storeName) {
		store = new HashMap<Integer, Customer>();
		this.storeName = storeName;
	}
	
	public String getStoreName() {
		return storeName;
	}
	
	public int getStoreID() {
		return storeID;
	}
	
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	
	public void setStoreID(int storeID) {
		this.storeID = storeID;
	}
	
	public void addCustomer(Customer c) {
		store.put(c.getCustomerID(), c);
	}
}

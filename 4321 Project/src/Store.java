import java.util.LinkedHashMap;

public class Store {
	
	private LinkedHashMap<Integer, Customer> store;
	private int storeID;
	private String storeName;
	
	public Store(int storeID, String storeName) {
		store = new LinkedHashMap<Integer, Customer>();
		this.storeID = storeID;
		this.storeName = storeName;
	}
	
	public boolean containsCustomer(int customerID) {
		return store.containsKey(customerID);
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

import java.util.HashMap;
import java.util.Map;

public class Store {
	
	private Map<Integer, Customer> store;
	private String storeName;
	
	public Store(String storeName) {
		store = new HashMap<Integer, Customer>();
		this.storeName = storeName;
	}
	
	public String getStoreName() {
		return storeName;
	}
	
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	
	public void addCustomer(Customer c) {
		store.put(c.getCustomerID(), c);
	}
}

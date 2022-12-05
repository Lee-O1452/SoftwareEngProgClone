import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;

public class Store {
	
	private LinkedHashMap<String, Customer> store;
	private String storeID;
	private String storeName;
	private Inventory storeInventory;
	private double foodTax;
	private double nonFoodTax;
	
	public Store(String storeID, String storeName) {
		store = new LinkedHashMap<>();
		this.storeID = storeID;
		this.storeName = storeName;
		MapPersistence storeMaps = new MapPersistence();
		storeInventory = storeMaps.buildInventory();
		foodTax = 0.04;
		nonFoodTax = 0.08;
	}
	
	public boolean containsCustomer(String customerID) {
		return store.containsKey(customerID);
	}

	public Customer getCustomer(String customerID){
		return store.get(customerID);
	}
	
	public String getStoreName() {
		return storeName;
	}
	
	public String getStoreID() {
		return storeID;
	}
	
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	
	public void setStoreID(String storeID) {
		this.storeID = storeID;
	}
	
	public void addCustomer(Customer c) {
		store.put(c.getCustomerID(), c);
	}
	
	public int getStoreSize() {
		return store.size();
	}
	
	public Inventory getStoreInventory() {
		return storeInventory;
	}
	
	public ArrayList<Customer> displayCustomers() {
		ArrayList<Customer> allCustomers = new ArrayList<>(store.values());
		allCustomers.sort((c1, c2) -> {
			if (c1.getFirstName().compareToIgnoreCase(c2.getFirstName()) == 0) {
				if (c1.getLastName().compareToIgnoreCase(c2.getLastName()) == 0) {
					return c1.getCustomerID().compareTo(c2.getCustomerID());
				}
				return c1.getLastName().compareToIgnoreCase(c2.getLastName());
			}
			return c1.getFirstName().compareToIgnoreCase(c2.getFirstName());
		});
		return allCustomers;
	}
	
	public double getFoodTax() {
		return foodTax;
	}
	
	public void setFoodTax(double foodTax) {
		this.foodTax = foodTax;
	}
	
	public double getNonFoodTax() {
		return nonFoodTax;
	}
	
	public void setNonFoodTax(double nonFoodTax) {
		this.nonFoodTax = nonFoodTax;
	}

	@Override
	public String toString() {
		return String.format("Store ID - %s , Store Name - %s\n", storeID,  storeName);
	}
}

import java.util.ArrayList;

public class StoreController {

		public void createStore(String storeName) {
			IDValidator buildID = new IDValidator();
			MapPersistence storeBuilder = new MapPersistence();
			String storeID = buildID.generateStoreID();
			storeBuilder.buildStore(storeID, storeName);
		}
	
		public void registerCustomer(Store store, String firstName, String lastName) {
			IDValidator buildID = new IDValidator();
			String customerID = buildID.generateCustomerID(store);
			Customer c = new Customer(customerID, firstName, lastName);
			store.addCustomer(c);
		}

		public void printDisplayCustomers(Store store) {
			ArrayList<Customer> allCustomers = store.displayCustomers();
			System.out.println("There are " + allCustomers.size() + " customers in the system.\n");
			for (Customer allCustomer : allCustomers) {
				System.out.println(allCustomer);
			}
			//gui stuff here
		}
		
		public void updateTaxes(Store store, double foodTax, double nonFoodTax) {
			store.setFoodTax(foodTax);
			store.setNonFoodTax(nonFoodTax);
		}
		
		//legwork for this is not done
		public void displayPopularProducts(){
			

		}
		
}

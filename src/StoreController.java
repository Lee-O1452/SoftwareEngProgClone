import java.util.ArrayList;

public class StoreController {

		public String createStore(String storeID, String storeName) {

			IDValidator checkID = new IDValidator();

			MapPersistence storeBuilder = new MapPersistence();

			if (checkID.isIdValidStore(storeID) == 1) {
				return "Make sure the ID is two digits.";
			}

			else if (checkID.isIdValidProduct(storeID) == 2) {
				return "Make sure the ID only contains digits.";
			}

			else {
				if(Main.getStoreList().containsKey(storeID)){
					return "Store already exists.";
				}
				else{
					storeBuilder.buildStore(storeID, storeName);
					return "Store has been added, please return to store selection or add more.";
				}
			}
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

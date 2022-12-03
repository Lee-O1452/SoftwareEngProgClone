import java.util.ArrayList;

public class StoreController {
	private Store store;
		public void createStore(String storeID, String storeName) {
			IDValidator checkID = new IDValidator(); 
			MapPersistence storeBuilder = new MapPersistence();
			if(checkID.isIdValidStore(storeID)) {
				if(!Main.getStoreList().containsKey(storeID)){
					this.store = storeBuilder.buildStore(storeID, storeName);
				}
				//already exists
			}
			//invalid id
		}
	
		public void registerCustomer(String customerID, String firstName, String lastName) {


			IDValidator checkID = new IDValidator(); 
			
			if(checkID.isIdValidCustomer(customerID)) {
				if(!store.containsCustomer(customerID)) {
					Customer c = new Customer(customerID, firstName, lastName);
					store.addCustomer(c);
					//add confirmation here
				}
				//already exists
			}
			//invalid id
		}
		

		public void printDisplayCustomers() {
			ArrayList<Customer> allCustomers = store.displayCustomers();
			System.out.println("There are " + allCustomers.size() + " customers in the system.\n");
			for (Customer allCustomer : allCustomers) {
				System.out.println(allCustomer);
			}
			//gui stuff here
		}
		
		public void updateTaxes(double foodTax, double nonFoodTax) {
			store.setFoodTax(foodTax);
			store.setNonFoodTax(nonFoodTax);
		}
		
		//legwork for this is not done
		public void displayPopularProducts(){
			

		}
		
}

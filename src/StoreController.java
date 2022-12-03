import java.util.ArrayList;

public class StoreController {
	private Store store;
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
					this.store = storeBuilder.buildStore(storeID, storeName);
					return "Store has been added, please return to store selection or add more.";
				}
			}
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

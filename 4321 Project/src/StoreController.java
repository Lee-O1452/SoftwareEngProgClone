
public class StoreController {

	//private StoreGui gui;
	private Store store;
		
//		public StoreController(StoreGui gui) {
//			this.gui = gui;
//			this.store = MapPersistence.buildStore();
//		}
		
		public void registerCustomer(int customerID, String firstName, String lastName) {
			
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
}

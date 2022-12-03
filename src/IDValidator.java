
public class IDValidator {
	
	public int isIdValidProduct(String productID) {
		int length = productID.length();
		if(length != 4) {
			return 1;
		}
		if(!productID.matches("[0-9]+")){
			return 2;
		}
		else {
			return 3;
		}
	}

	public int isIdValidStore(String storeID) {
		int length = storeID.length();
		if(length != 2) {
			return 1;
		}
		if(!storeID.matches("[0-9]+")){
			return 2;
		}
		else {
			return 3;
		}
	}

	public boolean isIdValidCustomer(String customerID) {
		int length = String.valueOf(customerID).length();
		if(length == 4) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean isIdValidOrder(String orderID) {
		int length = String.valueOf(orderID).length();
		if(length == 6) {
			return true;
		}
		else {
			return false;
		}
	}
}

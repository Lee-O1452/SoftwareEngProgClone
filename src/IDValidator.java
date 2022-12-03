
public class IDValidator {
	
	public boolean isIdValidProduct(String productID) {
		int length = String.valueOf(productID).length();
		if(length == 4) {
			return true;
		}
		else {
			return false;
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
	
	public boolean isIdValidStore(String storeID) {
		int length = String.valueOf(storeID).length();
		if(length == 2) {
			return true;
		}
		else {
			return false;
		}
	}
}

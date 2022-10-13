
public class IDValidator {
	
	public boolean isIdValidProduct(int productID) {
		int length = String.valueOf(productID).length();
		if(length == 4) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean isIdValidCustomer(int customerID) {
		int length = String.valueOf(customerID).length();
		if(length == 4) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean isIdValidOrder(int storeID) {
		int length = String.valueOf(storeID).length();
		if(length == 4) {
			return true;
		}
		else {
			return false;
		}
	}
}

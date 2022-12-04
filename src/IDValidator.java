
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

	public String generateCustomerID(Store store) {
		String size = String.valueOf(store.getStoreSize());
		int length = size.length();
		String base = "0000";
		if(length == 4){
			return size;
		}
		else{
			return base.substring(0, 4-length) + size;
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

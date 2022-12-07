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

	public String generateStoreID() {
		String size = String.valueOf(Main.getStoreList().size() + 1);
		int length = size.length();
		String base = "00";
		if(length == 2){
			return size;
		}
		else{
			return base.substring(0, 2-length) + size;
		}
	}

	public String generateCustomerID(Store store) {
		String size = String.valueOf(store.getStoreSize() + 1);
		int length = size.length();
		String base = "0000";
		if(length == 4){
			return size;
		}
		else{
			return base.substring(0, 4-length) + size;
		}
	}

	public String generateOrderID() {
		String size = String.valueOf(Main.getOrderList().size() + 1);
		int length = size.length();
		String base = "000000";
		if(length == 6){
			return size;
		}
		else{
			return base.substring(0, 6-length) + size;
		}
	}
}

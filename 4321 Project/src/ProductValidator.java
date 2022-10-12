
public class ProductValidator {
	
	public boolean isIdValid(int productID) {
		int length = String.valueOf(productID).length();
		if(length == 4) {
			return true;
		}
		else {
			return false;
		}
	}
}

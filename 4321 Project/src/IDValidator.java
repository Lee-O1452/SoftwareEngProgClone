
public class IDValidator {

    public static boolean isIdValidProduct(int productID) {
        int length = String.valueOf(productID).length();
        if(length == 4) {
            return true;
        }
        else {
            return false;
        }
    }

    public static boolean isIdValidCustomer(int customerID) {
        int length = String.valueOf(customerID).length();
        if(length == 4) {
            return true;
        }
        else {
            return false;
        }
    }

    public static boolean isIdValidOrder(int orderID) {
        int length = String.valueOf(orderID).length();
        if(length == 6) {
            return true;
        }
        else {
            return false;
        }
    }

    public static boolean isIdValidStore(int storeID) {
        int length = String.valueOf(storeID).length();
        if(length == 2) {
            return true;
        }
        else {
            return false;
        }
    }
}
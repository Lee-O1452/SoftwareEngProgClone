import java.util.ArrayList;
import java.util.Date;

public class OrderController {
	
	public void createOrder(String customerID, Date date, boolean usingSnap, boolean isPaid, Store store) {

		IDValidator buildID = new IDValidator();
		MapPersistence orderBuilder = new MapPersistence();
		String orderID = buildID.generateOrderID();
		orderBuilder.buildOrder(orderID, customerID, date, usingSnap, isPaid, store);
	}
	
	public void addToOrder(Order order, String productID, int quantity, String productName, double price, String manufacturer, boolean isFood) {
		ArrayList<Product> allProductsName = order.getStore().getStoreInventory().productReportName();
		for (Product product : allProductsName) {
			System.out.println(product);
		}
		//need way to then select the product from gui
		//this may need to be split into two methods for the gui, the top part for just displaying which then calls the bottom part when a product is clicked on
		Product p = new Product(productID, quantity, productName, price, manufacturer, isFood);
		order.addProduct(p);
	}

	public void payOrder(Order order) {
		order.setIsPaid(true);
		order.orderReport();
		//need to figure out how to number each item and use Inventory
			// for(int i = 0; i < order.length; i++){
			// 	order.getStore().getStoreInventory().decreaseQuantity(0, 0);
			// }
			
	}

	public void returnItem(Order order, String productID, int quantity){

		order.getStore().getStoreInventory().increaseQuantity(productID, quantity);
		order.returnProduct(productID);
	}
}

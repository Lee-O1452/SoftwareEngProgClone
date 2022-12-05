import java.util.ArrayList;

public class OrderController {
	
	public String createOrder(Store store, Customer customer) {
		IDValidator buildID = new IDValidator();
		MapPersistence orderBuilder = new MapPersistence();
		String orderID = buildID.generateOrderID();
		orderBuilder.buildOrder(orderID, customer.getCustomerID(), store);
		return orderID;
	}
	
	public void addToOrder(Order order, Product p, int quantity) {
		Product op = p;
		op.setQuantity(quantity);
		order.addProduct(op);
	}

	public String displayOrderReport(Order order) {
		return order.orderReport();
	}

	public void setOrderPayed(Order order) {
		order.setIsPaid(true);
	}

	public void returnItem(Order order, String productID, int quantity){
		order.getStore().getStoreInventory().increaseQuantity(productID, quantity);
		order.returnProduct(productID);
	}
}

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
		InventoryController inventoryController = new InventoryController(order.getStore());
		ArrayList keySet = new ArrayList<>(order.getOrder().keySet());
		for(int i = 0; i < order.getOrder().size(); i++){
			Product p = order.getOrder().get(keySet.get(i));
			inventoryController.removeQuantity(p.getProductID(), p.getQuantity());
		}
	}

	public void returnItem(Order order, String productID, int quantity){
		InventoryController inventoryController = new InventoryController(order.getStore());
		inventoryController.removeQuantity(productID, quantity);
		order.returnProduct(productID);
	}
}

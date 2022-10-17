import java.util.Date;

public class OrderController {

//	private StoreGui gui;
	private Order order;
	
//	public OrderController(StoreGui gui) {
//		this.gui = gui;
//	}
	
	public void createOrder(int orderID, int customerID, Date date, boolean usingSnap, boolean isPaid, Store store) {
		IDValidator checkID = new IDValidator(); 
		MapPersistence orderBuilder = new MapPersistence();
		if(checkID.isIdValidOrder(orderID)) {
			this.order = orderBuilder.buildOrder(orderID, customerID, date, usingSnap, isPaid, store);
		}
		//invalid id
	}
	
	public void payOrder() {
		order.setisPaid(true);
	}
	
}

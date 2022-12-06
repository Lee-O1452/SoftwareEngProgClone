import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;

public class OrderController {

	private Store store;

	public String createOrder(Store store, Customer customer) {
		IDValidator buildID = new IDValidator();
		MapPersistence orderBuilder = new MapPersistence();
		String orderID = buildID.generateOrderID();
		orderBuilder.buildOrder(orderID, customer.getCustomerID(), store);
		return orderID;
	}
	
	public void addToOrder(Order order, Product p, int quantity) {
		Product op = new Product(p.getProductID(), quantity, p.getProductName(), p.getPrice(), p.getManufacturer(), p.getIsFood());
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
		inventoryController.addQuantity(productID, quantity);
		order.returnProduct(productID);
	}

	public String displayOrderStatistics(Store store) {
		ArrayList<Order> orders = new ArrayList<>(Main.getOrderList().values());
		ArrayList<Order> allOrders = new ArrayList<>();
		for (Order value : orders) {
			if (value.getStore() == store) {
				allOrders.add(value);
			}
		}
		ArrayList<Double> totals = new ArrayList<>();
		ArrayList<Double> deviations = new ArrayList<>();
		ArrayList<Double> squares = new ArrayList<>();
		double total = 0;
		double totalTax = 0;
		double numOrders = 0;
		double additionSqs = 0;
		for(Order order : allOrders){
			numOrders += 1;
			totalTax += order.getTotalTax();
			total += order.getGrandTotal();
			totals.add(order.getGrandTotal());
		}
		double average = total/numOrders;
		for(int i = 0; i < totals.size(); i++){
			deviations.add(totals.get(i) - average);
			squares.add(deviations.get(i) * deviations.get(i));
			additionSqs += squares.get(i);
		}
		double std = Math.sqrt(additionSqs/(totals.size()-1));
		return String.format("Total of Taxes: $%.2f\n Total of Orders: $%.2f\n Average Order Total: $%.2f\n Standard Deviation of Order Totals: $%.2f", totalTax, total, average, std);
	}

	public class popularProductHelperObject{
		private int quantity;
		private Product p;
		public popularProductHelperObject(int quantity, Product p){
			this.quantity = quantity;
			this.p = p;
		}
		public int getQuantity() {
			return quantity;
		}

		public Product getP() {
			return p;
		}
	}
	public String displayPopularProductsQuantity(Store store){
		ArrayList<Order> orders = new ArrayList<>(Main.getOrderList().values());
		ArrayList<Order> allOrders = new ArrayList<>();

		for (Order value : orders) {
			if (value.getStore() == store) {
				allOrders.add(value);
			}
		}

		LinkedHashMap<String, Integer> temp = new LinkedHashMap<>();
		for(int i = 0; i < allOrders.size(); i++){
			for(int j = 0; j < allOrders.get(i).getOrder().values().size(); j++){
				ArrayList<Product> orderProducts = new ArrayList<>(allOrders.get(j).getOrder().values());
				if(temp.containsKey(orderProducts.get(j).getProductID())){
					temp.replace(orderProducts.get(j).getProductID(), temp.get(orderProducts.get(j).getProductID()) + orderProducts.get(j).getQuantity());
				}
				else{
					temp.put(orderProducts.get(j).getProductID(), orderProducts.get(j).getQuantity());
				}
			}
		}

		ArrayList<String> keySet = new ArrayList<>(temp.keySet());
		ArrayList<popularProductHelperObject> helpGod = new ArrayList<>();

		for(int i = 0; i < temp.size(); i++){
			popularProductHelperObject p = new popularProductHelperObject(temp.get(keySet.get(i)),store.getStoreInventory().getProduct(keySet.get(i)));
			helpGod.add(p);
		}

		helpGod.sort(Comparator.comparingInt(popularProductHelperObject::getQuantity));

		StringBuilder s = new StringBuilder();

		for (OrderController.popularProductHelperObject popularProductHelperObject : helpGod) {
			s.append("Total Quantity Sold: ").append(popularProductHelperObject.getQuantity()).append(" ").append(popularProductHelperObject.getP());
		}

		return s.toString();
	}
}

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
			if (value.getStore().getStoreID().equals(store.getStoreID())) {
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


	public String displayPopularProductsQuantity(Store store){
		ArrayList<Order> orders = new ArrayList<>(Main.getOrderList().values());
		ArrayList<Order> allOrders = new ArrayList<>();

		for (Order value : orders) {
			if (value.getStore().getStoreID().equals(store.getStoreID())) {
				allOrders.add(value);
			}
		}

		LinkedHashMap<String, Integer> totalQuantity = new LinkedHashMap<>();

		for(int i = 0; i < allOrders.size(); i++){
			for(int j = 0; j < allOrders.get(i).getOrder().size(); j++){
				ArrayList<Product> orderProducts = new ArrayList<>(allOrders.get(i).getOrder().values());
				if(totalQuantity.containsKey(orderProducts.get(j).getProductID())){
					totalQuantity.replace(orderProducts.get(j).getProductID(), totalQuantity.get(orderProducts.get(j).getProductID()) + orderProducts.get(j).getQuantity());
				}
				else{
					totalQuantity.put(orderProducts.get(j).getProductID(), orderProducts.get(j).getQuantity());
				}
			}
		}

		ArrayList<String> popularID = new ArrayList<>(totalQuantity.keySet());
		ArrayList<popularProductHelper> sorter = new ArrayList<>();

		for(int i = 0; i < totalQuantity.size(); i++){
			popularProductHelper p = new popularProductHelper(totalQuantity.get(popularID.get(i)),store.getStoreInventory().getProduct(popularID.get(i)));
			sorter.add(p);
		}

		sorter.sort(Comparator.comparingInt(popularProductHelper::getQuantity));
		StringBuilder s = new StringBuilder();

		for (popularProductHelper p : sorter) {
			s.append("Total Quantity Sold: ").append(p.getQuantity()).append(" ").append(p.getP());
		}

		return s.toString();
	}
}

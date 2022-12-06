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
		int numOrders = 0;
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
		return String.format("Number of Orders: %d\nTotal of Taxes: $%.2f\nTotal of Orders: $%.2f\nAverage Order Total: $%.2f\nStandard Deviation of Order Totals: $%.2f\n", numOrders, totalTax, total, average, std);
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
		ArrayList<reportHelper> sorter = new ArrayList<>();

		for(int i = 0; i < totalQuantity.size(); i++){
			reportHelper r =  new reportHelper(totalQuantity.get(popularID.get(i)),store.getStoreInventory().getProduct(popularID.get(i)));
			sorter.add(r);
		}

		sorter.sort(Comparator.comparingInt(reportHelper::getQuantity));
		StringBuilder report = new StringBuilder();

		for (reportHelper r : sorter) {
			report.append("Total Quantity Sold: ").append(r.getQuantity()).append(" ").append(r.getP());
		}

		return report.toString();
	}

	public String displayPopularProductsRevenue(Store store){
		ArrayList<Order> orders = new ArrayList<>(Main.getOrderList().values());
		ArrayList<Order> allOrders = new ArrayList<>();

		for (Order value : orders) {
			if (value.getStore().getStoreID().equals(store.getStoreID())) {
				allOrders.add(value);
			}
		}

		LinkedHashMap<String, Double> totalRevenue = new LinkedHashMap<>();

		for(int i = 0; i < allOrders.size(); i++){
			for(int j = 0; j < allOrders.get(i).getOrder().size(); j++){
				ArrayList<Product> orderProducts = new ArrayList<>(allOrders.get(i).getOrder().values());
				if(totalRevenue.containsKey(orderProducts.get(j).getProductID())){
					totalRevenue.replace(orderProducts.get(j).getProductID(), totalRevenue.get(orderProducts.get(j).getProductID()) + orderProducts.get(j).getTotalValue());
				}
				else{
					totalRevenue.put(orderProducts.get(j).getProductID(), orderProducts.get(j).getTotalValue());
				}
			}
		}

		ArrayList<String> popularID = new ArrayList<>(totalRevenue.keySet());
		ArrayList<reportHelper> sorter = new ArrayList<>();

		for(int i = 0; i < totalRevenue.size(); i++){
			reportHelper r = new reportHelper(totalRevenue.get(popularID.get(i)),store.getStoreInventory().getProduct(popularID.get(i)));
			sorter.add(r);
		}

		sorter.sort(Comparator.comparingDouble(reportHelper::getTotalValue));
		StringBuilder report = new StringBuilder();

		for (reportHelper r : sorter) {
			report.append("Total Revenue From Product: $").append(r.getTotalValue()).append(" ").append(r.getP());
		}

		return report.toString();
	}

	public String displayCustomerOrderTotals(Store store){
		ArrayList<Order> orders = new ArrayList<>(Main.getOrderList().values());
		ArrayList<Order> allOrders = new ArrayList<>();

		for (Order value : orders) {
			if (value.getStore().getStoreID().equals(store.getStoreID())) {
				allOrders.add(value);
			}
		}

		LinkedHashMap<String, Integer> totalOrders = new LinkedHashMap<>();

		for (Order allOrder : allOrders) {
			if (totalOrders.containsKey(allOrder.getCustomerID())) {
				totalOrders.replace(allOrder.getCustomerID(), totalOrders.get(allOrder.getCustomerID()) + 1);
			} else {
				totalOrders.put(allOrder.getCustomerID(), 1);
			}
		}

		ArrayList<String> popularID = new ArrayList<>(totalOrders.keySet());
		ArrayList<reportHelper> sorter = new ArrayList<>();

		for(int i = 0; i < totalOrders.size(); i++){
			reportHelper r = new reportHelper(totalOrders.get(popularID.get(i)),store.getCustomer(popularID.get(i)));
			sorter.add(r);
		}

		sorter.sort(Comparator.comparingInt(reportHelper::getTotalOrders));
		StringBuilder report = new StringBuilder();

		for (reportHelper r : sorter) {
			report.append("Total Orders From Customer: ").append(r.getTotalOrders()).append(" ").append(r.getC());
		}

		return report.toString();
	}

	public String displayOrderStatisticsSNAP(Store store){
		ArrayList<Order> orders = new ArrayList<>(Main.getOrderList().values());
		ArrayList<Order> allOrders = new ArrayList<>();

		for (Order value : orders) {
			if (value.getStore().getStoreID().equals(store.getStoreID())) {
				allOrders.add(value);
			}
		}

		int allOrderAmt = 0;

		ArrayList<Order> snapOrders = new ArrayList<>();

		for (Order order : allOrders){
			allOrderAmt += 1;
			if(order.getUsingSnap()){
				snapOrders.add(order);
			}
		}



		ArrayList<Double> totals = new ArrayList<>();
		ArrayList<Double> deviations = new ArrayList<>();
		ArrayList<Double> squares = new ArrayList<>();

		double total = 0;
		int numOrders = 0;
		double additionSqs = 0;

		for(Order order : snapOrders){
			numOrders += 1;
			total += order.getGrandTotal();
			totals.add(order.getGrandTotal());
		}

		double average = total/numOrders;
		double percentSNAP = (numOrders/(double)allOrderAmt)*100;

		for(int i = 0; i < totals.size(); i++){
			deviations.add(totals.get(i) - average);
			squares.add(deviations.get(i) * deviations.get(i));
			additionSqs += squares.get(i);
		}

		double std = Math.sqrt(additionSqs/(totals.size()-1));
		return String.format("Percent of Orders SNAP: %.2f\nNumber of SNAP Orders: %d\nTotal of All SNAP Orders: $%.2f\nAverage Total of SNAP Order: $%.2f\nStandard Deviation of SNAP Order Totals: $%.2f\n", percentSNAP, numOrders, total, average, std);
	}

	public String displayOrderDateRange(Store store, String date1, String date2) {
		ArrayList<Order> orders = new ArrayList<>(Main.getOrderList().values());
		ArrayList<Order> allOrders = new ArrayList<>();

		for (Order value : orders) {
			if (value.getStore().getStoreID().equals(store.getStoreID())) {
				allOrders.add(value);
			}
		}

		ArrayList<Order> dateOrders = new ArrayList<>();

		for (Order order : allOrders) {
			if ((order.getDateString().compareTo(date1) > 0 || order.getDateString().compareTo(date1) == 0) && (order.getDateString().compareTo(date2) < 0 || order.getDateString().compareTo(date2) == 0)) {
				dateOrders.add(order);
			}
		}

		StringBuilder report = new StringBuilder();
		report.append("Orders between ").append(date1).append(" and ").append(date2).append("\n");
		for (Order order : dateOrders) {
			report.append(String.format("Date: %s, Order ID: %s, %s", order.getDateString(), order.getOrderID(), store.getCustomer(order.getCustomerID())));
		}

		return report.toString();
	}
}

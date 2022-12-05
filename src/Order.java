import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;

public class Order {

	private LinkedHashMap<String, Product> order;
	private String orderID;
	private String customerID;
	private LocalDate date;
	private boolean usingSnap;
	private boolean isPaid;
	private Store store;
	
	
	public Order(String orderID, String customerID, LocalDate date, boolean usingSnap, boolean isPaid, Store store) {
		order = new LinkedHashMap<>();
		this.orderID = orderID;
		this.customerID = customerID;
		this.date = date;
		this.usingSnap = usingSnap;
		this.isPaid = isPaid;
		this.store = store;
	}

		
	//getters
	public String getOrderID() {
		return orderID;
	}
	
	public String getCustomerID() {
		return customerID;
	}
	
	public LocalDate getDate() {
		return date;
	}
	
	public boolean getUsingSnap() {
		return usingSnap;
	}
	
	public boolean getIsPaid() {
		return isPaid;
	}
	
	
	//setters
	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}
	
	public void setCustomerID(String customerID) {
		this.customerID = orderID;
	}
	
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	public void setUsingSnap(boolean usingSnap) {
		this.usingSnap = usingSnap;
	}
	
	public void setIsPaid(boolean isPaid) {
		this.isPaid = isPaid;
	}
	
	public Store getStore() {
		return store;
	}
	
	public void addProduct(Product p) {
		order.put(p.getProductID(), p);
	}

	public void returnProduct(String productID){
		order.remove(productID);

	}
	
	public String getDateString() {
		return getDate().toString();
	}

	public String orderReport() {
		ArrayList<Product> productsOrdered = new ArrayList<>(order.values());
		ArrayList<Product> foodItems = new ArrayList<>();
		ArrayList<Product> nonFoodItems = new ArrayList<>();
		double totalPrice = 0;
		double foodTax = 0;
		double nonFoodTax = 0;
		double totalTax;
		double grandTotal;
		double foodTotal = 0;
		double nonFoodTotal = 0;

		for (Product product : productsOrdered) {
			double productCost = product.getPrice() * product.getQuantity();
			totalPrice += productCost;
			if (product.getIsFood()) {
				if (getUsingSnap()) {
					foodTotal += productCost;
					foodItems.add(product);
				} else {
					foodTax += productCost * store.getFoodTax();
				}
			} else {
				nonFoodTax += productCost * store.getNonFoodTax();
				if (getUsingSnap()) {
					nonFoodTotal += productCost;
					nonFoodItems.add(product);
				}
			}
		}

		totalTax = foodTax + nonFoodTax;
		grandTotal = totalPrice + totalTax;

		StringBuilder productInformation = new StringBuilder();
		productInformation.append(String.format("Store Name - %s , Store ID - %s , Date - %s\n", store.getStoreName(), store.getStoreID(), getDateString()));
		if(getUsingSnap()) {
			productInformation.append("Food Items:\n");
			for(int i = 0; i < productsOrdered.size(); i++) {
				productInformation.append(String.format("Item - %s , Price - $%.2f , Quantity - %d\n", foodItems.get(i).getProductName(), foodItems.get(i).getPrice(), foodItems.get(i).getQuantity()));
			}
			productInformation.append("Food Total: $").append(foodTotal).append("\n");
			productInformation.append("Non-food Items:\n");
			for(int i = 0; i < productsOrdered.size(); i++) {
				productInformation.append(String.format("Item - %s , Price - $%.2f , Quantity - %d\n", nonFoodItems.get(i).getProductName(), nonFoodItems.get(i).getPrice(), nonFoodItems.get(i).getQuantity()));
			}
			productInformation.append("Non-food Subtotal: $").append(nonFoodTotal).append("\n");
			productInformation.append(String.format("Taxes - $%.2f , Nonfood Total - $%.2f , Grand Total - $%.2f\n", totalTax, nonFoodTotal + totalTax, grandTotal));
		}
		else {
			for (Product product : productsOrdered) {
				productInformation.append(String.format("Item - %s , Price - $%.2f , Quantity - %d\n", product.getProductName(), product.getPrice(), product.getQuantity()));
			}
			productInformation.append(String.format("\nTotal Price - $%.2f , Taxes - $%.2f , Grand Total - $%.2f", totalPrice, totalTax, grandTotal));
		}
		return productInformation.toString();
	}
}

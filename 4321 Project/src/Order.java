import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;

public class Order {

	private LinkedHashMap<Integer, Product> order;
	private int orderID;
	private int customerID;
	private Date date;
	private boolean usingSnap;
	private boolean isPaid;
	private Store store;
	
	
	public Order(int orderID, int customerID, Date date, boolean usingSnap, boolean isPaid, Store store) {
		order = new LinkedHashMap<Integer, Product>();
		this.orderID = orderID;
		this.customerID = customerID;
		this.date = date;
		usingSnap = false;
		isPaid = false;
		this.store = store;
	}

		
	//getters
	public int getOrderID() {
		return orderID;
	}
	
	public int getCustomerID() {
		return customerID;
	}
	
	public Date getDate() {
		return date;
	}
	
	public boolean getUsingSnap() {
		return usingSnap;
	}
	
	public boolean getisPaid() {
		return isPaid;
	}
	
	
	//setters
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	
	public void setCustomerID(int customerID) {
		this.customerID = orderID;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public void setUsingSnap(boolean usingSnap) {
		this.usingSnap = usingSnap;
	}
	
	public void setisPaid(boolean isPaid) {
		this.isPaid = isPaid;
	}
	
	public Store getStore() {
		return store;
	}
	
	public void addProduct(Product p) {
		order.put(p.getProductID(), p);
	}

	public void returnProduct(int productID){
		order.remove(productID);

	}
	
	public String getDateString() {
		String dateString = getDate().toGMTString();
		return dateString;
	}
	
	public void orderReport() {
	    //holding variables for display
		ArrayList<Product> productsOrdered = new ArrayList<Product>(order.values());
		ArrayList<Product> foodItems = new ArrayList<Product>();
		ArrayList<Product> nonFoodItems = new ArrayList<Product>();
		double totalPrice = 0;
		double foodTax = 0;
		double nonFoodTax = 0;
		double totalTax = 0;
		double grandTotal = 0;
		double foodTotal = 0;
		double nonFoodTotal = 0;
		//gets the total cost for each product from their price and quantity
		for(int i = 0; i < productsOrdered.size(); i++) {
			double productCost = productsOrdered.get(i).getPrice() * productsOrdered.get(i).getQuantity();
			totalPrice += productCost;
			//if the product is food then checks if customer is using snap or not to add to correct variables
			if(productsOrdered.get(i).getIsFood()) {
				if(getUsingSnap()) {
					foodTotal += productCost;
					foodItems.add(productsOrdered.get(i));
				}
				else {
					foodTax += productCost * store.getFoodTax();
				}
			}
			//if the food is not food then checks if customer is using snap to add extra details
			else {
				nonFoodTax += productCost * store.getNonFoodTax();
				if(getUsingSnap()) {
					nonFoodTotal += productCost;
					nonFoodItems.add(productsOrdered.get(i));
				}
			}
		}
		totalTax = foodTax + nonFoodTax;
		grandTotal = totalPrice + totalTax;
		String storeInformation = String.format("Store Name - %s , Store ID - %s , Date - %s\n", store.getStoreName(), store.getStoreID(), getDateString());
		System.out.println(storeInformation);
		//different output for snap users, shows products seperated by if food or not along with the total of each section
		if(getUsingSnap()) {
			System.out.println("Food Items:");
			for(int i = 0; i < productsOrdered.size(); i++) {
				String productInformation = String.format("Item - %s , Price - $%d , Quantity - %d", foodItems.get(i).getProductName(), foodItems.get(i).getPrice(), foodItems.get(i).getQuantity());
				System.out.println(productInformation);
			}
			System.out.println("Food Total: $" + foodTotal);
			System.out.println("Non-food Items:");
			for(int i = 0; i < productsOrdered.size(); i++) {
				String productInformation = String.format("Item - %s , Price - $%d , Quantity - %d", nonFoodItems.get(i).getProductName(), nonFoodItems.get(i).getPrice(), nonFoodItems.get(i).getQuantity());
				System.out.println(productInformation);
			}
			System.out.println("Non-food Subtotal: $" + nonFoodTotal);
			String costInformation = String.format("\nTaxes - $%d , Nonfood Total - $%d , Grand Total - $%d", totalTax, nonFoodTotal + totalTax,grandTotal);
			System.out.println(costInformation);
		}
		//output for non-snap users just shows all products together with combined total price 
		else {
			for(int i = 0; i < productsOrdered.size(); i++) {
				String productInformation = String.format("Item - %s , Price - $%d , Quantity - %d", productsOrdered.get(i).getProductName(), productsOrdered.get(i).getPrice(), productsOrdered.get(i).getQuantity());
				System.out.println(productInformation);
			}
			String costInformation = String.format("\nTotal Price - $%d , Taxes - $%d , Grand Total - $%d", totalPrice, totalTax, grandTotal);
			System.out.println(costInformation);
		}
	}
}

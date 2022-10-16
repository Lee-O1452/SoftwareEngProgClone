import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Order {

	private LinkedHashMap<Integer, Product> order;
	private int orderID;
	private int customerID;
	private Date date;
	private boolean usingSnap;
	private boolean isPaid;
	
	
	public Order(int orderID, int customerID, Date date, boolean usingSnap, boolean isPaid) {
		order = new LinkedHashMap<Integer, Product>();
		this.orderID = orderID;
		this.customerID = customerID;
		this.date = date;
		usingSnap = false;
		isPaid = false;
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
	
	public void addProduct(Product p) {
		order.put(p.getProductID(), p);
	}
}

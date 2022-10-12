
public class Product {
	
	
	private String productName;
	private double price;
	private String manufacturer;
	private int productID;
	private boolean isFood;
	private int quantity;
	
	
	//Constructor of the Product which has the name, price, manufacturer, id, and specifies if product is food.
	public Product(String productName, double price, String manufacturer, int productID,  boolean isFood, int quantity) {
		this.productName = productName;
		this.price = price;
		this.manufacturer = manufacturer;
		this.productID = productID;
		this.isFood = isFood;
		this.quantity = quantity;
	}
	
	
	//Getters
	public String getProductName() {
		return productName;
	}
	public double getPrice() {
		return price;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public int getProductID() {
		return productID;
	}
	public boolean getIsFood() {
		return isFood;
	}
	public int getQuantity() {
		return quantity;
	}
	
	
	//Setters
	public void setProductName(String productName) {
		productName = productName;
	}
	public void setPrice(double price) {
		price = price;
	}
	public void setManufacturer(String manufacturer) {
		manufacturer = manufacturer;
	}
	public void setProductID(int productID) {
		productID = productID;
	}
	public void setIsFood(boolean isFood) {
		isFood = isFood;
	}
	public void setQuantity(int quantity) {
		quantity = quantity;
	}
	

	@Override
	public String toString() {
		String ts = String.format("%s - %s , $ %d , ID - %d , SNAP Eligibility: %b , %d\n", productName,
				manufacturer, price, productID, isFood, quantity);
		return ts;
	}

}
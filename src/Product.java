import java.io.Serializable;

public class Product implements Serializable {

	private String productName;
	private double price;
	private String manufacturer;
	private String productID;
	private boolean isFood;
	private int quantity;

	public Product(String productID, int quantity, String productName, double price, String manufacturer, boolean isFood) {
		this.productName = productName;
		this.price = price;
		this.manufacturer = manufacturer;
		this.productID = productID;
		this.isFood = isFood;
		this.quantity = quantity;
	}

	public String getProductName() {
		return productName;
	}

	public double getPrice() {
		return price;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public String getProductID() {
		return productID;
	}

	public boolean getIsFood() {
		return isFood;
	}

	public int getQuantity() {
		return quantity;
	}

	public double getTotalValue() {
		return price * quantity;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public void setProductID(String productID) {
		this.productID = productID;
	}

	public void setIsFood(boolean isFood) {
		this.isFood = isFood;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return String.format("Product ID - %s , Quantity - %d , Product Name - %s , Price - $%.2f , Manufacturer - %s , Food Item - %b\n", productID, quantity, productName, price, manufacturer, isFood);
	}
}
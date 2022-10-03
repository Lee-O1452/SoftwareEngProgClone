
public class Product {
	
	private String ProductName;
	private double Price;
	private String Manufacturer;
	private int ProductID;
	private boolean IsFood;
	
	
	//Constructor of the Product which has the name, price, manufacturer, id, and specifies if product is food.
	public Product(String ProductName, double Price, String Manufacturer, int ProductID,  boolean IsFood) {
		this.ProductName = ProductName;
		this.Price = Price;
		this.Manufacturer = Manufacturer;
		this.ProductID = ProductID;
		this.IsFood = IsFood;
			
	}
	
	//Getters
	public String getProductName() {
		return ProductName;
	}
	public double getPrice() {
		return Price;
	}
	public String getManufacturer() {
		return Manufacturer;
	}
	public int getProductID() {
		return ProductID;
	}

	public boolean isIsFood() {
		return IsFood;
	}

	
	
	//Setters
	public void setProductName(String productName) {
		ProductName = productName;
	}
	public void setPrice(double price) {
		Price = price;
	}
	public void setManufacturer(String manufacturer) {
		Manufacturer = manufacturer;
	}
	public void setProductID(int productID) {
		ProductID = productID;
	}
	
	public void setIsFood(boolean isFood) {
		IsFood = isFood;
	}
	

	@Override
	public String toString() {
		
		
		
		String ts = String.format("%s - %s , $ %d , ID - %d , SNAP Eligibility: %b \n", ProductName,
				Manufacturer, Price, ProductID, IsFood);
		return ts;
	}
	

}
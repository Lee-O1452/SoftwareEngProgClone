import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class Inventory implements Serializable {

	private LinkedHashMap<String, Product> inventory;
	
	public Inventory() {
		inventory = new LinkedHashMap<>();
	}
	
	public void addProduct(Product p) {
		inventory.put(p.getProductID(), p);
	}
	

	public void batchAddOrUpdate(File file) {
	 	try {
			
			Scanner fileScanner = new Scanner(file); 
			Scanner productMaker = new Scanner(file);

			while(fileScanner.hasNextLine()) {
				String checkId = fileScanner.next();

				if(inventory.containsKey(checkId)){
					int quantityNew = fileScanner.nextInt();
					int quantityOld = inventory.get(checkId).getQuantity();
					setQuantity(checkId, quantityOld + quantityNew);
				}

				else{ 
					Product p = new Product(
					productMaker.next(),
					productMaker.nextInt(),
					productMaker.next(),
					productMaker.nextDouble(),
					productMaker.next(),
					productMaker.nextBoolean()
					);
					addProduct(p);
				}
				fileScanner.nextLine();
				productMaker.nextLine();
			}
			fileScanner.close();
			productMaker.close();
	
		}
	 	catch(IOException e) {
			System.out.println("Error opening file.");
			System.exit(0);
	 	}
	}

	
	public void removeProduct(Product p) {
		inventory.remove(p.getProductID());
	}
	
	public void setQuantity(String productID, int quantity) {
		inventory.get(productID).setQuantity(quantity);
	}
	
	public boolean containsProduct(String productID){
		return inventory.containsKey(productID);
	}
	
	public Product getProduct(String productID) {
		return inventory.get(productID);
	}
	
	public ArrayList<Product> productReportName() {
		ArrayList<Product> allProducts = new ArrayList<>(inventory.values());
		allProducts.sort((p1, p2) -> p1.getProductName().compareToIgnoreCase(p2.getProductName()));
		return allProducts;
	}
	
	public ArrayList<Product> productReportID() {
		ArrayList<Product> allProducts = new ArrayList<>(inventory.values());
		allProducts.sort(Comparator.comparing(Product::getProductID));
		return allProducts;
	}
	
	public ArrayList<Product> productReportManufacturer() {
		ArrayList<Product> allProducts = new ArrayList<>(inventory.values());
		allProducts.sort((p1, p2) -> {
			if (p1.getManufacturer().compareToIgnoreCase(p2.getManufacturer()) == 0) {
				return p1.getProductName().compareToIgnoreCase(p2.getProductName());
			}
			return p1.getManufacturer().compareToIgnoreCase(p2.getManufacturer());
		});
		return allProducts;
	}
	
	public ArrayList<Product> productReportIsFood() {
		ArrayList<Product> allProducts = new ArrayList<>(inventory.values());
		allProducts.sort((p1, p2) -> {

			if (p1.getIsFood() && !p2.getIsFood()) {
				return 1;
			}
			if (!p1.getIsFood() && p2.getIsFood()) {
				return -1;
			}
			return p1.getProductName().compareToIgnoreCase(p2.getProductName());
		});
		return allProducts;
	}

	public int getSize(){
		return inventory.size();
	}

	public double getTotalInventoryValue() {
		ArrayList<Product> allProducts = new ArrayList<>(inventory.values());
		double totalInventoryValue = 0;
		for (Product allProduct : allProducts) {
			totalInventoryValue += allProduct.getTotalValue();
		}
		return totalInventoryValue;
	}
}

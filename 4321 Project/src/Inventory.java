import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class Inventory {

	private LinkedHashMap<Integer, Product> inventory;
	
	public Inventory() {
		inventory = new LinkedHashMap<Integer, Product>();
	}
	
	public void addProduct(Product p) {
		inventory.put(p.getProductID(), p);
	}
	
    //checks each line for if a product with the ID already exists in the map, if it does then quantity is updated, if it doesn't then it is added as a new product
	public void batchAddOrUpdate(File file) {
	 	try {
			
			Scanner fileScanner = new Scanner(file); 
			Scanner productMaker = new Scanner(file);

			while(fileScanner.hasNextLine()) {
				int checkId = fileScanner.nextInt();
				if(inventory.containsKey(checkId) ){
					int quantityNew = fileScanner.nextInt();
					int quantityOld = inventory.get(checkId).getQuantity();
					updateQuantity(checkId, quantityOld + quantityNew);

				}
				else{ 
					Product p = new Product(
					productMaker.nextInt(),
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
	
	public void updateQuantity(int productID, int quantity) {
		inventory.get(productID).setQuantity(quantity);
	}

	//for when an order has a product returned, adds the quantity back into the inventory
	public void increaseQuantity(int productID, int quantity){

		int currentQuantity = quantity + getProduct(productID).getQuantity();
		getProduct(productID).setQuantity(currentQuantity);
	}

	//for when an order is payed, removes the quantity of product purchased from inventory
	public void decreaseQuantity(int productID, int quantity){

		int currentQuantity = getProduct(productID).getQuantity() - quantity;
		getProduct(productID).setQuantity(currentQuantity);
	}
	
	
	public boolean containsProduct(int productID){
		return inventory.containsKey(productID);
	}
	
	public Product getProduct(int productID) {
		return inventory.get(productID);
	}
	
	//turns the map into an array, creates a comparator to sort based on product name (case in-sensitive), and returns the array
	public ArrayList<Product> productReportName() {
		ArrayList<Product> allProducts = new ArrayList<Product>(inventory.values());
		Collections.sort(allProducts, new Comparator<Product>() {
			@Override
			public int compare(Product p1, Product p2) {
				return p1.getProductName().compareToIgnoreCase(p2.getProductName());
		    }
		});
		return allProducts;
	}
	
    //turns the map into an array, creates a comparator to sort based on product id, and returns the array
	public ArrayList<Product> productReportID() {
		ArrayList<Product> allProducts = new ArrayList<Product>(inventory.values());
		Collections.sort(allProducts, new Comparator<Product>() {
			@Override
			public int compare(Product p1, Product p2) {
				if(p1.getProductID() > p2.getProductID()) {
					return 1;
				}
				return -1;
		    }
		});
		return allProducts;
	}
	
	//turns the map into an array, creates a comparator to sort based on manufacturer name (case in-sensitive), and returns the array
	public ArrayList<Product> productReportManufacturer() {
		ArrayList<Product> allProducts = new ArrayList<Product>(inventory.values());
		Collections.sort(allProducts, new Comparator<Product>() {
			@Override
			public int compare(Product p1, Product p2) {
				if(p1.getManufacturer().compareToIgnoreCase(p2.getManufacturer()) == 0) {
					return p1.getProductName().compareToIgnoreCase(p2.getProductName());
				}
				return p1.getManufacturer().compareToIgnoreCase(p2.getManufacturer());
		    }
		});
		return allProducts;
	}
	
	//turns the map into an array, creates a comparator to sort based on if its a food product, and returns the array
	public ArrayList<Product> productReportIsFood() {
		ArrayList<Product> allProducts = new ArrayList<Product>(inventory.values());
		Collections.sort(allProducts, new Comparator<Product>() {
			@Override
			public int compare(Product p1, Product p2) {
				
				if(p1.getIsFood() == true && p2.getIsFood() == false) {
					return 1;
				}
				if(p1.getIsFood() == false && p2.getIsFood() == true) {
					return -1;
				}
				return p1.getProductName().compareToIgnoreCase(p2.getProductName());
		    }
		});
		return allProducts;
	}
	
	
	
	
}

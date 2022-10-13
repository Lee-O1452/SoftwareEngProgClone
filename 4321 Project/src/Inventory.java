import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Inventory {

	private Map<Integer, Product> inventory;
	
	public Inventory() {
		inventory = new HashMap<Integer, Product>();
	}
	
	public void addProduct(Product p) {
		inventory.put(p.getProductID(), p);
	}
	
//	public void batchAddOrUpdate(File file) {
//	 	try {
//			
//			Scanner fileScanner = new Scanner(file); 
//
//			while(fileScanner.hasNextLine()) {
//				
//			}
//			
//			
//			fileScanner.close();
//	
//		}
//	 	catch(IOException e) {
//			System.out.println("Error opening file.");
//			System.exit(0);
//	 	}
//	}
	
	public void removeProduct(Product p) {
		inventory.remove(p.getProductID());
	}
	
	public void updateQuantity(int productID, int quantity) {
		inventory.get(productID).setQuantity(quantity);
	}
	
}

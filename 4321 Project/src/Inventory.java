import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Inventory {

	private Map<Integer, Object> inventory;
	
	public Inventory() {
		inventory = new HashMap<Integer, Object>();
	}
	
	public void addProduct(Product p) {
		inventory.put(p.getID, p);
	}
	
	public void removeProduct(Product p) {
		inventory.remove(p.getID);
	}
	
	public void updateQuantity(int productID, int quantity) {
		inventory.get(productID).setQuantity(quantity);
	}
	
	public void batchAddUpdate(File file) {
	 	try {
			
			Scanner fileScanner = new Scanner(file); 

			while(fileScanner.hasNextLine()) {
				
			}
			
			
			fileScanner.close();
	
		}
	 	catch(IOException e) {
			System.out.println("Error opening file.");
			System.exit(0);
	 	}
	}
	
	public static void main(String[] args) {
		
	}
	
}

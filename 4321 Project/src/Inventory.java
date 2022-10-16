import java.io.File;
import java.io.IOException;
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
	
	public boolean containsProduct(int productID){
		return inventory.containsKey(productID);
	} 
	
}

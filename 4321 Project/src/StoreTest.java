import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StoreTest {

	Store store = new Store(01, "Greg's Store");
	Customer c1 = new Customer(1255, "Doug", "Charles");
	Customer c2 = new Customer(1258, "Charlene", "Holes");
	Customer c3 = new Customer(1259, "Doug", "Holes");
	Customer c4 = new Customer(1254, "Zimby", "Lows");
	Customer c5 = new Customer(1257, "Zimby", "Holes");
	Customer c6 = new Customer(1256, "Doug", "Holes");
	
	@Test
	@DisplayName("test addCustomer()")
	void testAddCustomer() {
		store.addCustomer(c1);
		boolean expectedCustomer = true;
		boolean actualCustomer = store.containsCustomer(1255);
		assertEquals(expectedCustomer, actualCustomer);
	}
	
	@Test
	@DisplayName("test displayCustomers()")
	void testDisplayCustomers() {
		store.addCustomer(c1);
		store.addCustomer(c2);
		store.addCustomer(c3);
		store.addCustomer(c4);
		store.addCustomer(c5);
		store.addCustomer(c6);
		ArrayList<Customer> allCustomers = store.displayCustomers();
		System.out.println("There are " + store.getStoreSize() + " customers in the system.\n");
		for(int i = 0; i < allCustomers.size(); i++) {
			System.out.println(allCustomers.get(i));
		}
	}

}

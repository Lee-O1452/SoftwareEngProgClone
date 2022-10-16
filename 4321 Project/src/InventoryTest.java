import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InventoryTest {
	Inventory inventory = new Inventory();
	Product x = new Product("Apple", 0.50, "Davie's Apple Orchard", 1001, true, 10);
	Product y = new Product("Fish", 1.00, "phill's Fishery", 0001, true, 10);


	@Test
	@DisplayName("test addProduct()")
	void testAddProduct() {
		inventory.addProduct(x);
		boolean expectedProduct = true;
		boolean actualProduct = inventory.containsProduct(1001);
		assertEquals(expectedProduct, actualProduct);
		
	}

	@Test
	@DisplayName("test removeProduct()")
	void testRemoveProduct() {
		inventory.removeProduct(x);
		boolean expectedProduct = false;
		boolean actualProduct = inventory.containsProduct(1001);
		assertEquals(expectedProduct, actualProduct);
	}

	@Test
	@DisplayName("test updateQuantity()")
	void testUpdateQuantity() {
		inventory.addProduct(x);
		inventory.addProduct(y);
		int expectedQuantity = 11;
		inventory.updateQuantity(1001, 11);
		int actualQuantity = inventory.getProduct(1001).getQuantity();
		assertEquals(expectedQuantity, actualQuantity);
	}

//	@Test
//	void testBatchAddUpdate() {
//		fail("Not yet implemented");
//	}

}

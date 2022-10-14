import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ProductTest {
	Product x = new Product("Apple", 0.50, "Davie's Apple Orchard", 1001, true, 10);

	@Test
	@DisplayName("test getProductName()")
	void testGetProductName() {
		String expectedName = "Apple";
		String actualName = x.getProductName();
		assertEquals(expectedName, actualName);
	}

	@Test
	@DisplayName("test getPrice()")
	void testGetPrice() {
		double expectedPrice = 0.50;
		double actualPrice = x.getPrice();
		assertEquals(expectedPrice, actualPrice);
	}

	@Test
	@DisplayName("test getManufacturer()")
	void testGetManufacturer() {
		String expectedManufacturer = "Davie's Apple Orchard";
		String actualManufacturer = x.getManufacturer();
		assertEquals(expectedManufacturer, actualManufacturer);
	}

	@Test
	@DisplayName("test getProductID()")
	void testGetProductID() {
		int expectedProductID = 1001;
		int actualProductID = x.getProductID();
		assertEquals(expectedProductID, actualProductID);
	}

	@Test
	@DisplayName("test getIsFood()")
	void testIsFood() {
		boolean expectedIsFood = true;
		boolean actualIsFood = x.getIsFood();
		assertEquals(expectedIsFood, actualIsFood);
	}

	@Test
	@DisplayName("test setProductName()")
	void testSetProductName() {
		String expectedName = "Fish";
		x.setProductName("Fish");
		String actualName = x.getProductName();
		assertEquals(expectedName, actualName);
	}

	@Test
	@DisplayName("test setPrice()")
	void testSetPrice() {
		double expectedPrice = 1.00;
		x.setPrice(1);
		double actualPrice = x.getPrice();
		assertEquals(expectedPrice, actualPrice);
	}

	@Test
	@DisplayName("test setManufacturer()")
	void testSetManufacturer() {
		String expectedManufacturer = "Pete's Apple Farm";
		x.setManufacturer("Pete's Apple Farm");
		String actualManufacturer = x.getManufacturer();
		assertEquals(expectedManufacturer, actualManufacturer);
	}

	@Test
	@DisplayName("test setProductID()")
	void testSetProductID() {
		int expectedProductID = 0001;
		x.setProductID(0001);
		int actualProductID = x.getProductID();
		assertEquals(expectedProductID, actualProductID);
	}

	@Test
	@DisplayName("test setIsFood()")
	void testSetIsFood() {
		boolean expectedIsFood = false;
		x.setIsFood(false);
		boolean actualIsFood = x.getIsFood();
		assertEquals(expectedIsFood, actualIsFood);
	}

}

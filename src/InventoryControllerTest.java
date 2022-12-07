import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InventoryControllerTest {
    public Product product
            = new Product("1234", 1, "firstProd",
            11.11, "Brand1", false);
    public Store store;
    public InventoryController inventoryController;

    @BeforeEach
    public void setup() {
        store = new Store("01", "S001");
        inventoryController = new InventoryController(store);
    }

    @Test
    public void test_addProduct_not_four_digits() {
        product.setProductID("aaaaaa");
        String expectedMessage = "Make sure the ID is four digits.";
        String actualMessage = inventoryController.addProduct(
                product.getProductID(), String.valueOf(product.getQuantity()),
                product.getProductName(), String.valueOf(product.getPrice()),
                product.getManufacturer(), product.getIsFood());
        Assertions.assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void test_addProduct_contains_non_digits() {
        product.setProductID("1a1a");
        String expectedMessage = "Make sure the ID only contains digits.";
        String actualMessage = inventoryController.addProduct(
                product.getProductID(), String.valueOf(product.getQuantity()),
                product.getProductName(), String.valueOf(product.getPrice()),
                product.getManufacturer(), product.getIsFood());
        Assertions.assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void test_addProduct_productName_not_exists() {
        product.setProductName("");
        String expectedMessage = "Make sure the Product Name is filled out.";
        String actualMessage = inventoryController.addProduct(
                product.getProductID(), String.valueOf(product.getQuantity()),
                product.getProductName(), String.valueOf(product.getPrice()),
                product.getManufacturer(), product.getIsFood());
        Assertions.assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void test_addProduct_manufacturer_not_exists() {
        product.setManufacturer("");
        String expectedMessage = "Make sure the Manufacturer Name is filled out.";
        String actualMessage = inventoryController.addProduct(
                product.getProductID(), String.valueOf(product.getQuantity()),
                product.getProductName(), String.valueOf(product.getPrice()),
                product.getManufacturer(), product.getIsFood());
        Assertions.assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void test_addProduct_product_exists_already() {
        String expectedMessage = "Product already exists.";
        inventoryController.addProduct(
                product.getProductID(), String.valueOf(product.getQuantity()),
                product.getProductName(), String.valueOf(product.getPrice()),
                product.getManufacturer(), product.getIsFood());
        String actualMessage = inventoryController.addProduct(
                product.getProductID(), String.valueOf(product.getQuantity()),
                product.getProductName(), String.valueOf(product.getPrice()),
                product.getManufacturer(), product.getIsFood());
        Assertions.assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void test_addProduct_zero_price() {
        product.setPrice(0);
        String expectedMessage = "Price has to be greater than one cent!";
        String actualMessage = inventoryController.addProduct(
                product.getProductID(), String.valueOf(product.getQuantity()),
                product.getProductName(), String.valueOf(product.getPrice()),
                product.getManufacturer(), product.getIsFood());
        Assertions.assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void test_addProduct_zero_quantity() {
        product.setQuantity(0);
        String expectedMessage = "Quantity has to be greater than zero!";
        String actualMessage = inventoryController.addProduct(
                product.getProductID(), String.valueOf(product.getQuantity()),
                product.getProductName(), String.valueOf(product.getPrice()),
                product.getManufacturer(), product.getIsFood());
        Assertions.assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void test_addProduct_SUCCESSFUL() {
        String expectedMessage = "Product has been added, please return to inventory menu or add more.";
        String actualMessage = inventoryController.addProduct(
                product.getProductID(), String.valueOf(product.getQuantity()),
                product.getProductName(), String.valueOf(product.getPrice()),
                product.getManufacturer(), product.getIsFood());
        Assertions.assertEquals(expectedMessage, actualMessage);
        Assertions.assertNotNull(inventoryController.displayProductReportName());
        inventoryController.displayNumberOfProducts();
        inventoryController.displayTotalValue();
        Assertions.assertNotNull(inventoryController.displayProductReportID());
        Assertions.assertNotNull(inventoryController.displayProductReportName());
        Assertions.assertNotNull(inventoryController.displayProductReportManufacturer());
        Assertions.assertNotNull(inventoryController.displayProductReportIsFood());
    }

    @Test
    public void test_manufacturerReport() {
        String expected = """
                Total Products: 1 Total Value: $11.11
                Total Value: $11.11 Product ID - 1234 , Quantity - 1 , Product Name - firstProd , Price - $11.11 , Manufacturer - Brand1 , Food Item - false
                """;
        inventoryController.addProduct(
                product.getProductID(), String.valueOf(product.getQuantity()),
                product.getProductName(), String.valueOf(product.getPrice()),
                product.getManufacturer(), product.getIsFood());
        String actualMessage = inventoryController.manufacturerReport(product.getManufacturer());
        Assertions.assertEquals(expected, actualMessage);
    }
}
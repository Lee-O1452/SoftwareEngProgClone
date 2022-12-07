import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IDValidatorTest {
    IDValidator idValidator = new IDValidator();
    public String productId;
    public StoreController storeController;
    public OrderController orderController;
    public Store store;

    @Test
    void test_isIdValidProduct_return_1() {
        productId = "1";
        Assertions.assertEquals(1, idValidator.isIdValidProduct(productId));
    }

    @Test
    void test_isIdValidProduct_return_2() {
        productId = "*(^s";
        Assertions.assertEquals(2, idValidator.isIdValidProduct(productId));
    }

    @Test
    void test_isIdValidProduct_return_3() {
        productId = "1233";
        Assertions.assertEquals(3, idValidator.isIdValidProduct(productId));
    }

    @Test
    void test_generateStoreID() {
        storeController = new StoreController();
        storeController.createStore("S1-Store");
        String actual = idValidator.generateStoreID();
        Assertions.assertNotNull(actual);
    }

    @Test
    void test_generateStoreID_length_2() {
        storeController = new StoreController();
        String storeName;
        for(int i = 0; i < 10; i++) {
            storeName = String.format("S%d-Store", i);
            storeController.createStore(storeName);
        }

        String actual = idValidator.generateStoreID();
        Assertions.assertNotNull(actual);
    }

    @Test
    void test_generateCustomerID() {
        storeController = new StoreController();
        storeController.createStore("S1-Store");

        String actual = idValidator.generateCustomerID(Main.getStoreList().get("01"));
        Assertions.assertNotNull(actual);
    }

    @Test
    void test_generateOrderID() {
        orderController = new OrderController();
        String orderIdExpected = orderController.createOrder(
                new Store("123", "S1"),
                new Customer("01", "firstName", "lastName")
        );
        Assertions.assertNotNull(orderIdExpected);
    }
}

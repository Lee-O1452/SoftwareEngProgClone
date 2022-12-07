import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StoreControllerTest {
    StoreController storeController = new StoreController();

    @Test
    public void test_createStore() {
        String expected = "01";
        String actual = storeController.createStore("Store1");
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test_registerCustomer() {
        String expected = "0001";
        Store store = new Store("01", "Store1");
        String actual = storeController.registerCustomer(store, "firstName", "lastName");
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test_printDisplayCustomers() {
        String expected = """
                [Customer ID - 0001 , First Name - firstName , Last Name - lastName
                , Customer ID - 0002 , First Name - firstName , Last Name - lastName
                ]""";
        Store store = new Store("01", "Store1");
        store.addCustomer(new Customer("0001", "firstName", "lastName"));
        storeController.registerCustomer(store, "firstName", "lastName");
        String actual = storeController.printDisplayCustomers(store).toString();
        Assertions.assertEquals(expected, actual);
    }
}
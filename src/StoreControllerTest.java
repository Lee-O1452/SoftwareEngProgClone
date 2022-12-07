import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class StoreControllerTest {
    StoreController storeController = new StoreController();

    @Test
    public void test_createStore() {
        String expected = "01";
        String actual = storeController.createStore("Store1");
        assertNotNull(actual);
        assertEquals(expected, actual);
    }

    @Test
    public void test_registerCustomer() {
        String expected = "0001";
        Store store = new Store("01", "Store1");
        String actual = storeController.registerCustomer(store, "firstName", "lastName");
        assertNotNull(actual);
        assertEquals(expected, actual);
    }

    @Test
    public void test_printDisplayCustomers() {
        String expected = "[Customer ID - 0001 , First Name - firstName , Last Name - lastName\n" +
                ", Customer ID - 0002 , First Name - firstName , Last Name - lastName\n" +
                "]";
        Store store = new Store("01", "Store1");
        store.addCustomer(new Customer("0001", "firstName", "lastName"));
        storeController.registerCustomer(store, "firstName", "lastName");
        String actual = storeController.printDisplayCustomers(store).toString();
        assertEquals(expected, actual);
    }
}
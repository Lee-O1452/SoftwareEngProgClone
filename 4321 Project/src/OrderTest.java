import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.Date;

class OrderTest {
    @SuppressWarnings("deprecation")
    Order order
            = new Order(12, 1234, new Date(2022, 10, 21),
            true, false, new Store(11, "testStore"));

    @Test
    void test() {
        assertEquals(12, order.getOrderID());
        assertEquals(1234, order.getCustomerID());
        assertTrue(order.getUsingSnap());
        assertFalse(order.getisPaid());
        assertEquals(11, order.getStore().getStoreID());
        assertEquals("testStore", order.getStore().getStoreName());
    }

}
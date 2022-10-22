import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CustomerTest {
    Customer customer = new Customer(1234, "First", "Last");
    @Test
    void test() {
        assertEquals(1234, customer.getCustomerID());
        customer.setCustomerID(2345);
        assertEquals(2345, customer.getCustomerID());
        assertEquals("First", customer.getFirstName());
        customer.setFirstName("Second");
        assertEquals("Second", customer.getFirstName());
        assertEquals("Last", customer.getLastName());
        customer.setLastName("SecondLast");
        assertEquals("SecondLast", customer.getLastName());
    }

}
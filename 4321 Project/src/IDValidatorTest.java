import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class IDValidatorTest {
    
    IDValidator checkID = new IDValidator(); 
    
    @Test
    public void testIsIdValidProduct() {
        int expected = 4444;
        assertTrue(checkID.isIdValidProduct(expected));
        expected = 12;
        assertFalse(checkID.isIdValidProduct(expected));
    }

    @Test
    public void testIsIdValidCustomer() {
        int expected = 4444;
        assertTrue(checkID.isIdValidCustomer(expected));
        expected = 12;
        assertFalse(checkID.isIdValidCustomer(expected));
    }

    @Test
    public void testIsIdValidOrder() {
        int expected = 444444;
        assertTrue(checkID.isIdValidOrder(expected));
        expected = 12;
        assertFalse(checkID.isIdValidCustomer(expected));
    }

    @Test
    public void testIsIdValidStore() {
        int expected = 12;
        assertTrue(checkID.isIdValidStore(expected));
        expected = 132;
        assertFalse(checkID.isIdValidCustomer(expected));
    }
}



import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class IDValidatorTest {
    @Test
    public void testIsIdValidProduct() {
        int expected = 4444;
        assertTrue(IDValidator.isIdValidProduct(expected));
        expected = 12;
        assertFalse(IDValidator.isIdValidProduct(expected));
    }

    @Test
    public void testIsIdValidCustomer() {
        int expected = 4444;
        assertTrue(IDValidator.isIdValidCustomer(expected));
        expected = 12;
        assertFalse(IDValidator.isIdValidCustomer(expected));
    }

    @Test
    public void testIsIdValidOrder() {
        int expected = 444444;
        assertTrue(IDValidator.isIdValidOrder(expected));
        expected = 12;
        assertFalse(IDValidator.isIdValidCustomer(expected));
    }

    @Test
    public void testIsIdValidStore() {
        int expected = 12;
        assertTrue(IDValidator.isIdValidStore(expected));
        expected = 132;
        assertFalse(IDValidator.isIdValidCustomer(expected));
    }
}



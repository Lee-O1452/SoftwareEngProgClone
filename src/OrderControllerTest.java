import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class OrderControllerTest {
    public Product product;
    public OrderController orderController;
    public Store store;
    public Customer customer;
    public Order order;

    @BeforeEach
    public void setup() {
        product = new Product("1234", 1, "firstProd",
                11.11, "Brand1", false);
        store = new Store("01", "S001");
        customer = new Customer("0001", "firstName", "lastName");
        orderController = new OrderController();
        LocalDate localDate = LocalDate.of(2022, 12, 06);
        order = new Order("01", "000001", localDate,
                true, false, store);
    }

    @Test
    public void test_createOrder() {
        String actual = orderController.createOrder(store, customer);
        assertNotNull(actual);
    }

    @Test
    public void test_displayOrderReport() {
        String expected = "Store Name - S001 , Store ID - 01 , Date - 2022-12-06\n" +
                "Food Items:\n" +
                "No Food Items\n" +
                "Food Total: $0.0\n" +
                "Non-food Items:\n" +
                "No Non-food Items\n" +
                "Non-food Subtotal: $0.0\n" +
                "Taxes - $0.00 , Nonfood Total - $0.00 , Grand Total - $0.00\n";
        String actual = orderController.displayOrderReport(order);
        assertNotNull(actual);
        assertEquals(expected, actual);
    }

    @Test
    public void test_displayOrderStatistics() {
        String expected = "Total of Taxes: $0.00\n" +
                " Total of Orders: $0.00\n" +
                " Average Order Total: $NaN\n" +
                " Standard Deviation of Order Totals: $-0.00";
        String actual = orderController.displayOrderStatistics(store);
        assertNotNull(actual);
        assertEquals(expected, actual);
    }
}

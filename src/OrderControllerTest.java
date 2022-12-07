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

        String actual = orderController.displayOrderReport(order);
        assertNotNull(actual);

    }

    @Test
    public void test_displayOrderStatistics() {

        String actual = orderController.displayOrderStatistics(store);
        assertNotNull(actual);

    }
}

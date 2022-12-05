import javax.swing.*;
import java.util.Date;

public class AfterLoginRegistration_C_2_5 {
    private JButton backButton;
    private JButton createOrderButton;
    private JButton returnItemButton;
    private JButton orderHistoryButton;
    private JPanel panel1;
    private JLabel storeNameField;
    private JLabel storeIDField;
    private JLabel customerNameField;
    private JLabel customerIDField;
    JFrame frame = new JFrame();

    public AfterLoginRegistration_C_2_5(Store store, Customer customer){
        frame.setContentPane(panel1);
        frame.setTitle("Create a New Store");
        frame.setSize(900,600);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        storeNameField.setText("Store Name: " + store.getStoreName());
        storeIDField.setText("Store ID: " + store.getStoreID());
        customerNameField.setText("Customer Name: " + customer.getFirstName() + " " + customer.getLastName());
        customerIDField.setText("Customer ID: " + customer.getCustomerID());

        backButton.addActionListener(e -> {
            if(e.getSource()==backButton){
                frame.dispose();
                Login_C_2_B login = new Login_C_2_B(store);
            }
        });

        createOrderButton.addActionListener(e -> {
            if(e.getSource()==createOrderButton){
                OrderController orderController = new OrderController();
                String orderID = orderController.createOrder(store, customer);
                frame.dispose();
                CreateOrder_C_3_A createOrder = new CreateOrder_C_3_A(Main.getOrderList().get(orderID));
            }
        });

        returnItemButton.addActionListener(e -> {
            if(e.getSource()==returnItemButton){
                frame.dispose();
                ReturnItem_C_4_ returnItem = new ReturnItem_C_4_(store, customer);
            }
        });

        orderHistoryButton.addActionListener(e -> {
            if(e.getSource()==orderHistoryButton){
                frame.dispose();
                OrderHistory_C_5_A orderHistory = new OrderHistory_C_5_A(store, customer);
            }
        });

    }
}

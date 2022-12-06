import javax.swing.*;
import java.util.ArrayList;
import java.util.Vector;


public class CustomersReceipts_M_5_D {
    private JButton backButton;
    private JTextField customerIDField;
    private JPanel panel1;
    private JButton loadButton;
    private JTextArea receipts;
    JFrame frame = new JFrame();

    public CustomersReceipts_M_5_D(Store store){
        frame.setContentPane(panel1);
        frame.setTitle("Create a New Store");
        frame.setSize(900,600);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        backButton.addActionListener(e -> {
            if(e.getSource()==backButton){
                frame.dispose();
                CustomerSelections_M_5_A customerSelection = new CustomerSelections_M_5_A(store);
            }
        });

        loadButton.addActionListener(e -> {
            if(e.getSource()==loadButton){
                String customerID = customerIDField.getText();
                ArrayList<Order> allOrders = new ArrayList<>(Main.getOrderList().values());
                ArrayList<Order> customersOrders = new ArrayList<>();
                for (Order allOrder : allOrders) {
                    if (allOrder.getCustomerID().equals(customerID)) {
                        customersOrders.add(allOrder);
                    }
                }
                OrderController orderController = new OrderController();
                receipts.setText("");
                for(Order o : customersOrders){
                    receipts.append(orderController.displayOrderReport(o));
                }
            }
        });

    }
}

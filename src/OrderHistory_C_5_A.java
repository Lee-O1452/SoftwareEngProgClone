import javax.swing.*;
import java.util.ArrayList;
import java.util.Vector;


public class OrderHistory_C_5_A {
    private JButton backButton;
    private JTextField customerIDField;
    private JButton viewOrderButton;
    private JPanel panel1;
    private JList orderHistory;
    private JButton loadButton;
    JFrame frame = new JFrame();

    public OrderHistory_C_5_A(Store store, Customer customer){
        frame.setContentPane(panel1);
        frame.setTitle("Create a New Store");
        frame.setSize(900,600);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        backButton.addActionListener(e -> {
            if(e.getSource()==backButton){
                frame.dispose();
                AfterLoginRegistration_C_2_5 afterLogin = new AfterLoginRegistration_C_2_5(store, customer);
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
                orderHistory.setListData(new Vector<>(customersOrders));
            }
        });

        viewOrderButton.addActionListener(e -> {
            if(e.getSource()==viewOrderButton){
                Order o = (Order) orderHistory.getSelectedValue();
                frame.dispose();
                Receipt_C_5_B priorReceipt = new Receipt_C_5_B((Order) orderHistory.getSelectedValue());
            }
        });
    }
}

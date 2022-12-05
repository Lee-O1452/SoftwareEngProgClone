import javax.swing.*;

public class Receipt_C_3_B {
    private JPanel panel1;
    private JButton payButton;
    private JButton backButton;
    private JTextArea receiptField;
    JFrame frame = new JFrame();
    public Receipt_C_3_B(Order order){
        frame.setContentPane(panel1);
        frame.setTitle("Create a New Store");
        frame.setSize(900,600);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        OrderController orderController = new OrderController();
        receiptField.setText(orderController.displayOrderReport(order));

        payButton.addActionListener(e -> {
            if(e.getSource()==payButton){
                orderController.setOrderPayed(order);
                frame.dispose();
                AfterLoginRegistration_C_2_5 afterLogin = new AfterLoginRegistration_C_2_5(order.getStore(), order.getStore().getCustomer(order.getCustomerID()));
            }
        });

        backButton.addActionListener(e -> {
            if(e.getSource()==backButton){
                frame.dispose();
                CreateOrder_C_3_A createOrder = new CreateOrder_C_3_A(order);
            }
        });
    }
}

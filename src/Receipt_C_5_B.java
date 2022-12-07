import javax.swing.*;

public class Receipt_C_5_B {
    private JPanel panel1;
    private JButton backButton;
    private JTextArea receiptField;
    JFrame frame = new JFrame();
    public Receipt_C_5_B(Order order){
        frame.setContentPane(panel1);
        frame.setTitle("Create a New Store");
        frame.setSize(900,600);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        OrderController orderController = new OrderController();
        receiptField.setText(orderController.displayOrderReport(order));

        backButton.addActionListener(e -> {
            if(e.getSource()==backButton){
                frame.dispose();
                new OrderHistory_C_5_A(order.getStore(), order.getStore().getCustomer(order.getCustomerID()));
            }
        });
    }
}

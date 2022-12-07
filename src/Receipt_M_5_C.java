import javax.swing.*;

public class Receipt_M_5_C {
    private JPanel panel1;
    private JButton backButton;
    private JTextArea receiptField;
    JFrame frame = new JFrame();
    public Receipt_M_5_C(Order order){
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
                new CustomerReceipt_M_5_C(order.getStore());
            }
        });
    }
}

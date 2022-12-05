import javax.swing.*;


public class ReturnItem_C_4_ {
    private JButton backButton;
    private JButton returnItemButton;
    private JTextField orderIDField;
    private JTextField productIDField;
    private JTextField quantityField;
    private JPanel panel1;
    JFrame frame = new JFrame();

    public ReturnItem_C_4_(Store store, Customer customer){

        frame.setContentPane(panel1);
        frame.setTitle("Return an Item");
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

        returnItemButton.addActionListener(e -> {
            if(e.getSource()==returnItemButton){
                OrderController orderController = new OrderController();
                orderController.returnItem(Main.getOrderList().get(orderIDField.getText()), productIDField.getText(), Integer.parseInt(quantityField.getText()));
            }
        });

    }
}

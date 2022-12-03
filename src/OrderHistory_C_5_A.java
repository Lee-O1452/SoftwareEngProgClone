import javax.swing.*;


public class OrderHistory_C_5_A {
    private JButton backButton;
    private JTextField textField1;
    private JTable table1;
    private JButton viewOrderButton;
    private JPanel panel1;
    JFrame frame = new JFrame();

    public OrderHistory_C_5_A(Store store){


        backButton.addActionListener(e -> {
            if(e.getSource()==backButton){
                frame.dispose();
                AfterLoginRegistration_C_2_5 afterLogin = new AfterLoginRegistration_C_2_5(store);
            }
        });
        viewOrderButton.addActionListener(e -> {
            if(e.getSource()==viewOrderButton){
                frame.dispose();
                Receipt_C_5_B priorReceipt = new Receipt_C_5_B();
            }
        });
    }
}

import javax.swing.*;
import javax.swing.JFrame;

public class CustomerSelections_M_5_A extends JFrame{
    private JButton backButton;
    private JButton displayCustomersButton;
    private JButton displayCustomerReceiptButton;
    private JPanel panel1;
    private JButton displayCustomerSReceiptsButton;
    JFrame frame = new JFrame();

    public CustomerSelections_M_5_A(Store store){
        frame.setContentPane(panel1);
        frame.setTitle("Customer Selections");
        frame.setSize(900,600);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        backButton.addActionListener(e -> {
            if(e.getSource()==backButton){
                frame.dispose();
                new Selections_M_2_A(store);
            }
        });

        displayCustomerReceiptButton.addActionListener(e -> {
            if(e.getSource()==displayCustomerReceiptButton){
                frame.dispose();
                new CustomerReceipt_M_5_C(store);
            }
        });

        displayCustomerSReceiptsButton.addActionListener(e -> {
            if(e.getSource()==displayCustomerSReceiptsButton){
                frame.dispose();
                new CustomersReceipts_M_5_D(store);
            }
        });

        displayCustomersButton.addActionListener(e -> {
            if(e.getSource()==displayCustomersButton){
                frame.dispose();
                new DisplayCustomers_M_5_B(store);
            }
        });

    }
}

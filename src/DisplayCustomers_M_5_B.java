import javax.swing.*;
import javax.swing.JFrame;

public class DisplayCustomers_M_5_B extends JFrame{
    private JButton backButton;
    private JTextArea customerList;
    private JPanel panel1;
    JFrame frame = new JFrame();
    StoreController storeController = new StoreController();

    public DisplayCustomers_M_5_B(Store store){
        frame.setContentPane(panel1);
        frame.setTitle("Display Customers");
        frame.setSize(900,600);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        customerList.setText(
                "There are " + storeController.displayNumberOfCustomers(store) + " customers in the system.\n" +
                        storeController.printDisplayCustomers(store)
        );

        backButton.addActionListener(e -> {
            if(e.getSource()==backButton){
                frame.dispose();
                CustomerSelections_M_5_A customerSelections = new CustomerSelections_M_5_A(store);
            }
        });


    }
}

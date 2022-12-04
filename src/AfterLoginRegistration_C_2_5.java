import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AfterLoginRegistration_C_2_5 {
    private JButton backButton;
    private JButton createOrderButton;
    private JButton returnItemButton;
    private JButton orderHistoryButton;
    private JPanel panel1;
    private JLabel storeNameField;
    private JLabel storeIDField;
    JFrame frame = new JFrame();

    public AfterLoginRegistration_C_2_5(Store store){
        frame.setContentPane(panel1);
        frame.setTitle("Create a New Store");
        frame.setSize(900,600);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        storeNameField.setText("Store Name: " + store.getStoreName());
        storeIDField.setText("Store ID: " + store.getStoreID());

        backButton.addActionListener(e -> {
            if(e.getSource()==backButton){
                frame.dispose();
                Selections_C_1_5 selections = new Selections_C_1_5();
            }
        });

        createOrderButton.addActionListener(e -> {
            if(e.getSource()==createOrderButton){
                frame.dispose();
                CreateOrder_C_3_A createOrder = new CreateOrder_C_3_A(store);
            }
        });

        returnItemButton.addActionListener(e -> {
            if(e.getSource()==returnItemButton){
                frame.dispose();
                ReturnItem_C_4_ returnItem = new ReturnItem_C_4_(store);
            }
        });

        orderHistoryButton.addActionListener(e -> {
            if(e.getSource()==orderHistoryButton){
                frame.dispose();
                OrderHistory_C_5_A orderHistory = new OrderHistory_C_5_A(store);
            }
        });

    }
}

import javax.swing.*;
import javax.swing.JFrame;


public class Login_C_2_B extends JFrame {
    private JButton backButton;
    private JButton loginButton;
    private JLabel storeNameField;
    private JLabel storeIDField;
    private JPanel panel;
    private JTextField customerIDField;
    JFrame frame = new JFrame();


    public Login_C_2_B(Store store){
        frame.setContentPane(panel);
        frame.setTitle("Create a New Store");
        frame.setSize(900,600);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        storeNameField.setText("Store Name: " + store.getStoreName());
        storeIDField.setText("Store ID: " + store.getStoreID());

        loginButton.addActionListener(e -> {
            if(e.getSource() == loginButton){
                frame.dispose();
                store.getCustomer(customerIDField.getText());
                AfterLoginRegistration_C_2_5 afterRegistration = new AfterLoginRegistration_C_2_5(store, store.getCustomer(customerIDField.getText()));
            }
        });
        backButton.addActionListener(e -> {
            if(e.getSource() == backButton){
                frame.dispose();
                Selections_C_1_5 selections = new Selections_C_1_5();
            }
        });

    }
}
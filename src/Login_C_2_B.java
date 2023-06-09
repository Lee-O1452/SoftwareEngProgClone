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
                if(store.getCustomer(customerIDField.getText())!=null) {
                    frame.dispose();
                    store.getCustomer(customerIDField.getText());
                    new AfterLoginRegistration_C_2_5(store, store.getCustomer(customerIDField.getText()));
                }
                else{
                    JOptionPane.showMessageDialog(frame, "Login Failed.");
                }
            }
        });

        backButton.addActionListener(e -> {
            if(e.getSource() == backButton){
                frame.dispose();
                new Selections_C_1_5();
            }
        });
    }
}
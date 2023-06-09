import javax.swing.*;
import java.util.ArrayList;

public class Registration_C_2_A {
    private JButton backButton;
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JButton registerButton;
    private JPanel panel1;
    private JLabel storeNameField;
    private JLabel storeIDField;
    private JButton registerAllButton;
    JFrame frame = new JFrame();
    StoreController storeController = new StoreController();

    public Registration_C_2_A(Store store){
        frame.setContentPane(panel1);
        frame.setTitle("Selections");
        frame.setSize(900,600);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        storeNameField.setText("Store Name: " + store.getStoreName());
        storeIDField.setText("Store ID: " + store.getStoreID());

        backButton.addActionListener(e -> {
            if (e.getSource() == backButton) {
                frame.dispose();
                new Selections_C_1_5();
            }
        });

        registerButton.addActionListener(e -> {
            if (e.getSource() == registerButton) {
                String firstName = firstNameField.getText();
                String lastName = lastNameField.getText();
                if(firstName.length()< 1 || lastName.length()< 1){
                    JOptionPane.showMessageDialog(frame, "Please supply a first and last name.");
                }
                else{
                    String customerID = storeController.registerCustomer(store, firstName, lastName);
                    JOptionPane.showMessageDialog(frame, "You have been registered with ID: " + customerID + "\nPlease return to store selection to login or register to another store.");
                }
            }
        });

        registerAllButton.addActionListener(e -> {
            if (e.getSource() == registerAllButton) {
                String firstName = firstNameField.getText();
                String lastName = lastNameField.getText();
                if(firstName.length()< 1 || lastName.length()< 1){
                    JOptionPane.showMessageDialog(frame, "Please supply a first and last name.");
                }
                else{
                    ArrayList<Store> allStores = new ArrayList<>(Main.getStoreList().values());
                    for(int i = 0; i < Main.getStoreList().size(); i++){
                        String customerID = storeController.registerCustomer(allStores.get(i), firstName, lastName);
                        JOptionPane.showMessageDialog(frame, "At Store ID: " + allStores.get(i).getStoreID() + "\nYou have been registered with ID: " + customerID + "\nPlease return to store selection to login or register to another store.");
                    }
                }
            }
        });
    }
}

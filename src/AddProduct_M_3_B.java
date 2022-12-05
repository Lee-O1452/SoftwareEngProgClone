import javax.swing.*;
import javax.swing.JFrame;

public class AddProduct_M_3_B extends JFrame{
    private JButton backButton;
    private JTextField productIDField;
    private JTextField productNameField;
    private JTextField manufacturerField;
    private JTextField priceField;
    private JTextField quantityField;
    private JButton addButton;
    private JPanel panel1;
    private JCheckBox isFoodBox;
    JFrame frame = new JFrame();

    public AddProduct_M_3_B(Store store){
        frame.setContentPane(panel1);
        frame.setTitle("Add Product");
        frame.setSize(900, 600);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        InventoryController inventoryController = new InventoryController(store);

        addButton.addActionListener(e -> {
            if (e.getSource() == addButton) {
                String productName = productNameField.getText();
                String productID = productIDField.getText();
                String manufacturer = manufacturerField.getText();
                String price = priceField.getText();
                String quantity = quantityField.getText();
                boolean isFood = isFoodBox.isSelected();
                JOptionPane.showMessageDialog(frame, inventoryController.addProduct(productID, quantity, productName, price, manufacturer, isFood));
            }
        });

        backButton.addActionListener(e -> {
            if(e.getSource()==backButton){
                frame.dispose();
                Inventory_M_3_A selections = new Inventory_M_3_A(store);
            }
        });
    }
}

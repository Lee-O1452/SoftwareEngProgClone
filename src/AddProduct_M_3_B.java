import javax.swing.*;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    private JOptionPane productCreated;

    JFrame frame = new JFrame();
    InventoryController inventoryController = new InventoryController();
    public AddProduct_M_3_B(){
        frame.setContentPane(panel1);
        frame.setTitle("Add Product");
        frame.setSize(900, 600);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == addButton) {
                    String productName = productNameField.getText();
                    int productID = Integer.parseInt(productIDField.getText());
                    String manufacturer = manufacturerField.getText();
                    double price = Double.parseDouble(priceField.getText());
                    int quantity = Integer.parseInt(quantityField.getText());
                    boolean isFood = isFoodBox.isSelected();
                    inventoryController.addProduct(productID, quantity, productName, price, manufacturer, isFood);
                    productCreated.showMessageDialog(frame, "Product has been added.");
                }
            }
        });
    }
}

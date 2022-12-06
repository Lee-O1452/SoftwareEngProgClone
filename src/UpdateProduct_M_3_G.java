import javax.swing.*;
import javax.swing.JFrame;

public class UpdateProduct_M_3_G extends JFrame{
    private JButton backButton;
    private JTextField productIDField;
    private JTextField newPriceField;
    private JTextField newQuantityField;
    private JButton updatePriceButton;
    private JButton updateQuantityButton;
    private JPanel panel1;
    JFrame frame = new JFrame();

    public UpdateProduct_M_3_G(Store store){
        frame.setContentPane(panel1);
        frame.setTitle("Update Products");
        frame.setSize(900, 600);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        InventoryController inventoryController = new InventoryController(store);

        backButton.addActionListener(e -> {
            if(e.getSource()==backButton){
                frame.dispose();
                Inventory_M_3_A inventorySelect = new Inventory_M_3_A (store);
            }
        });

        updatePriceButton.addActionListener(e -> {
            if(e.getSource()==updatePriceButton){
                inventoryController.updatePrice(productIDField.getText(), Double.parseDouble(newPriceField.getText()));
                JOptionPane.showMessageDialog(frame, "Price has been updated.");
            }
        });

        updateQuantityButton.addActionListener(e -> {
            if(e.getSource()==updateQuantityButton){
                inventoryController.addQuantity(productIDField.getText(), Integer.parseInt(newQuantityField.getText()));
                JOptionPane.showMessageDialog(frame, "Quantity has been updated.");
            }
        });
    }
}

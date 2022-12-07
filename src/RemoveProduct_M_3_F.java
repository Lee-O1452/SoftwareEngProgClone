import javax.swing.*;
import javax.swing.JFrame;

public class RemoveProduct_M_3_F extends JFrame{
    private JButton backButton;
    private JTextField productIDField;
    private JButton removeProductButton;
    private JPanel panel1;
    JFrame frame = new JFrame();

    public  RemoveProduct_M_3_F(Store store){
        frame.setContentPane(panel1);
        frame.setTitle("Remove Products");
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

        removeProductButton.addActionListener(e -> {
            if(e.getSource()==removeProductButton){
                try {
                    inventoryController.removeProduct(productIDField.getText());
                    JOptionPane.showMessageDialog(frame, "Product has been removed from the store.");
                }
                catch(Exception a){
                    JOptionPane.showMessageDialog(frame, "Input real Product ID to remove Product.");
                }
            }
        });
    }
}

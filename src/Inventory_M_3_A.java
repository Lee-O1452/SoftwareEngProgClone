import javax.swing.*;
import javax.swing.JFrame;
import java.io.IOException;

public class Inventory_M_3_A extends JFrame {
    private JButton backButton;
    private JButton createDealButton;
    private JButton updateProductButton;
    private JButton batchAddUpdateButton;
    private JButton addProductButton;
    private JButton displayProductsButton;
    private JButton removeProductButton;
    private JPanel pane1;
    private JButton saveProductButton;
    JFrame frame = new JFrame();

    public Inventory_M_3_A(Store store) {
        frame.setContentPane(pane1);
        frame.setTitle("Inventories");
        frame.setSize(900, 600);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        backButton.addActionListener(e -> {
            if(e.getSource()==backButton){
                frame.dispose();
                new Selections_M_2_A(store);
            }
        });

        updateProductButton.addActionListener(e -> {
            if(e.getSource()==updateProductButton){
                frame.dispose();
                new UpdateProduct_M_3_G(store);
            }
        });

        batchAddUpdateButton.addActionListener(e -> {
            if(e.getSource()==batchAddUpdateButton){
                frame.dispose();
                new BatchAdd_Update_M_3_E(store);
            }
        });

        addProductButton.addActionListener(e -> {
            if(e.getSource()==addProductButton){
                frame.dispose();
                new AddProduct_M_3_B(store);
            }
        });

        displayProductsButton.addActionListener(e -> {
            if(e.getSource()==displayProductsButton){
                frame.dispose();
                new DisplayProducts_M_3_D(store);
            }
        });

        removeProductButton.addActionListener(e -> {
            if(e.getSource()==removeProductButton){
                frame.dispose();
                new RemoveProduct_M_3_F(store);
            }
        });

        createDealButton.addActionListener(e -> {
            if(e.getSource()==createDealButton){
                frame.dispose();
                new CreateDeal_M_3_H(store);
            }
        });

        saveProductButton.addActionListener(e -> {
            if(e.getSource()==saveProductButton){
                InventoryController inventoryController = new InventoryController(store);
                try {
                    inventoryController.saveProductReport();
                    JOptionPane.showMessageDialog(frame, "ProductReport.txt has been created.");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }
}

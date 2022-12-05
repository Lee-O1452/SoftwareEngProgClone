import javax.swing.*;
import javax.swing.JFrame;

public class Inventory_M_3_A extends JFrame {
    private JButton backButton;
    private JButton createDealButton;
    private JButton updateProductButton;
    private JButton batchAddUpdateButton;
    private JButton addProductButton;
    private JButton displayProductsButton;
    private JButton removeProductButton;
    private JPanel pane1;
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
                Selections_M_2_A selections = new Selections_M_2_A(store);
            }
        });

        updateProductButton.addActionListener(e -> {
            if(e.getSource()==updateProductButton){
                frame.dispose();
                UpdateProduct_M_3_G updateProduct = new UpdateProduct_M_3_G();
            }
        });

        batchAddUpdateButton.addActionListener(e -> {
            if(e.getSource()==batchAddUpdateButton){
                frame.dispose();
                BatchAdd_Update_M_3_E batchUpdate = new BatchAdd_Update_M_3_E(store);
            }
        });

        addProductButton.addActionListener(e -> {
            if(e.getSource()==addProductButton){
                frame.dispose();
                AddProduct_M_3_B addProduct = new AddProduct_M_3_B(store);
            }
        });
        displayProductsButton.addActionListener(e -> {
            if(e.getSource()==displayProductsButton){
                frame.dispose();
                DisplayProducts_M_3_D displayProducts = new DisplayProducts_M_3_D(store);
            }
        });
        removeProductButton.addActionListener(e -> {
            if(e.getSource()==removeProductButton){
                frame.dispose();
                RemoveProduct_M_3_F removeProduct = new RemoveProduct_M_3_F();
            }
        });
        createDealButton.addActionListener(e -> {
            if(e.getSource()==createDealButton){
                frame.dispose();
                CreateDeal_M_3_H createDeal = new CreateDeal_M_3_H();
            }
        });

    }
}

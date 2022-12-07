import javax.swing.*;
import javax.swing.JFrame;
import java.io.File;

public class BatchAdd_Update_M_3_E extends JFrame{
    private JButton backButton;
    private JButton selectFileButton;
    private JPanel panel1;

    JFrame frame = new JFrame();
    public BatchAdd_Update_M_3_E(Store store){
        frame.setContentPane(panel1);
        frame.setTitle("Batch Add and Update");
        frame.setSize(900,600);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        backButton.addActionListener(e -> {
            if(e.getSource()==backButton){
                frame.dispose();
                new Inventory_M_3_A (store);
            }
        });

        selectFileButton.addActionListener(e -> {
            if(e.getSource()==selectFileButton){
                JFileChooser chooser = new JFileChooser();
                int status = chooser.showOpenDialog(null);
                if (status == JFileChooser.APPROVE_OPTION) {
                    File file = chooser.getSelectedFile();
                    if (file != null) {
                        InventoryController inventoryController = new InventoryController(store);
                        inventoryController.batchAddUpdate(file);
                        JOptionPane.showMessageDialog(frame, "Products has been updated.");
                    }
                    else{
                        JOptionPane.showMessageDialog(frame, "Failed to get file.");
                    }
                }
            }
        });
    }
}

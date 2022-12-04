import javax.swing.*;
import javax.swing.JFrame;

public class CreateStore_M_1_B extends JFrame{
    private JButton backButton;
    private JButton createStoreButton;
    private JTextField nameField;
    private JPanel panel1;

    JFrame frame = new JFrame();
    StoreController storeController = new StoreController();
    public CreateStore_M_1_B(){

        frame.setContentPane(panel1);
        frame.setTitle("Create a New Store");
        frame.setSize(900,600);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        createStoreButton.addActionListener(e -> {
            if(e.getSource() == createStoreButton){
                String name = nameField.getText();
                storeController.createStore(name);
                JOptionPane.showMessageDialog(frame, "Store has been created, please return to store selection or add more.");
            }
        });

        backButton.addActionListener(e -> {
            if(e.getSource()==backButton){
                frame.dispose();
                Selections_M_1_A selections = new Selections_M_1_A();
            }
        });
    }
}

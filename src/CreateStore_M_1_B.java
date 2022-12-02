import javax.swing.*;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateStore_M_1_B extends JFrame{
    private JButton backButton;
    private JButton createStoreButton;
    private JTextField nameField;
    private JTextField idField;
    private JLabel idLabel;
    private JLabel nameLabel;
    private JPanel panel1;
    JFrame frame = new JFrame();
    private StoreController StoreController;

    public CreateStore_M_1_B(){

        frame.setContentPane(panel1);
        frame.setTitle("Create a New Store");
        frame.setSize(900,600);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        createStoreButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == createStoreButton){
                    String id2 = idField.getText();
                    int id = Integer.parseInt(id2);
                    String name = nameField.getText();
                    StoreController.createStore(id, name);
                }
            }
        });
        backButton.addActionListener(new ActionListener(){
            @Override
                    public void actionPerformed(ActionEvent e){
                if(e.getSource()==backButton){
                    frame.dispose();
                    Selections_M_1_A selections = new Selections_M_1_A();
                }
            }
        });
    }
}

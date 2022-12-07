import javax.swing.*;
import javax.swing.JFrame;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Vector;


public class Selections_M_1_A extends JFrame {
    private JButton backButton;
    private JList storeSelect;
    private JButton saveAllDataButton;
    private JButton createStoreButton;
    private JPanel panel1;
    private JButton selectStoreButton;

    JFrame frame = new JFrame();

    public Selections_M_1_A() {

        frame.setContentPane(panel1);
        frame.setTitle("Selections");
        frame.setSize(900, 600);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        storeSelect.setListData(new Vector<>(Main.getStoreList().values()));

        createStoreButton.addActionListener(e -> {
            if(e.getSource() == createStoreButton){
                frame.dispose();
                new CreateStore_M_1_B();
            }

        });

        saveAllDataButton.addActionListener(e -> {
            if(e.getSource() == saveAllDataButton){
                FileOutputStream storeFOS;
                FileOutputStream orderFOS;
                try {
                    storeFOS = new FileOutputStream("storeList.out");
                    orderFOS = new FileOutputStream("orderList.out");
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
                ObjectOutputStream storeOOS;
                ObjectOutputStream orderOOS;
                try {
                    storeOOS = new ObjectOutputStream(storeFOS);
                    orderOOS = new ObjectOutputStream(orderFOS);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                try {
                    storeOOS.writeObject(Main.getStoreList());
                    orderOOS.writeObject(Main.getOrderList());
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                JOptionPane.showMessageDialog(frame, "System has been saved.");
            }
        });

        backButton.addActionListener(e -> {
            if (e.getSource() == backButton) {
                frame.dispose();
                new MainMenu_1_();
            }
        });

        selectStoreButton.addActionListener(e -> {
            if(e.getSource()==selectStoreButton){
                if(storeSelect.getSelectedValue()!=null){
                    frame.dispose();
                    new Selections_M_2_A((Store) storeSelect.getSelectedValue());
                }
                else{
                    JOptionPane.showMessageDialog(frame, "Select a store from the list or create a new one to continue.");
                }
            }
        });
    }
}


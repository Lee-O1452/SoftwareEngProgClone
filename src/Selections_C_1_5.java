import javax.swing.*;
import javax.swing.JFrame;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Selections_C_1_5 {
    private JButton backButton;
    private JButton registerButton;
    private JButton loginButton;
    private JPanel panel1;
    private JList storeSelect;

    JFrame frame = new JFrame();

    public Selections_C_1_5(){
        frame.setContentPane(panel1);
        frame.setTitle("Selections");
        frame.setSize(900,600);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        storeSelect.setListData(new Vector<>(Main.getStoreList().values()));

        registerButton.addActionListener(e -> {
            if(e.getSource() == registerButton){
                if(storeSelect.getSelectedValue()!=null) {
                    frame.dispose();
                    Registration_C_2_A registration = new Registration_C_2_A((Store) storeSelect.getSelectedValue());
                }
                else{
                    JOptionPane.showMessageDialog(frame, "Select a store from the list to continue.");
                }
            }
        });

        loginButton.addActionListener(e -> {
            if(e.getSource() == loginButton){
                if(storeSelect.getSelectedValue()!=null) {
                    frame.dispose();
                    Login_C_2_B login = new Login_C_2_B((Store) storeSelect.getSelectedValue());
                }
                else{
                    JOptionPane.showMessageDialog(frame, "Select a store from the list to continue.");
                }
            }
        });

        backButton.addActionListener(e -> {
            if(e.getSource() == backButton){
                frame.dispose();
                MainMenu_1_ mainMenu = new MainMenu_1_();
            }
        });
    }
}

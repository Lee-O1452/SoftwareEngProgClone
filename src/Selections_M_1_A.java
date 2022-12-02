import javax.swing.*;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedHashMap;


public class Selections_M_1_A extends JFrame {
    private JButton backButton;
    private JList StoreSelect;
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

        createStoreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == createStoreButton){
                    frame.dispose();
                    CreateStore_M_1_B createStore = new CreateStore_M_1_B();
                }

            }
        });
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == backButton) {
                    frame.dispose();
                    MainMenu_1_ mainMenu = new MainMenu_1_();

                }
            }
        });
        selectStoreButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if(e.getSource()==selectStoreButton){
                    frame.dispose();
                    Selections_M_2_A afterLogin = new Selections_M_2_A();
                }
            }
        });;


    }
}


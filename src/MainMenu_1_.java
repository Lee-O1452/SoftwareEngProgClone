import javax.swing.*;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedHashMap;

public class MainMenu_1_ extends JFrame{
    private JButton customerButton;
    private JPanel panel1;
    private JButton managerButton;
    private JLabel welcomeToStore;
    JFrame frame = new JFrame();
    public MainMenu_1_() {

        frame.setContentPane(panel1);
        frame.setTitle("Hello! Welcome to Store!");
        frame.setSize(900, 600);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        customerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == customerButton) {
                    frame.dispose();
                    Selections_C_1_5 selections = new Selections_C_1_5();
                }
            }

        });
        managerButton.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e){
               if(e.getSource() == managerButton){
                   frame.dispose();
                   Selections_M_1_A selections = new Selections_M_1_A();
                }

            }
        });
    }
}

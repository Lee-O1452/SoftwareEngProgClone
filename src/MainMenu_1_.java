import javax.swing.*;
import javax.swing.JFrame;

public class MainMenu_1_ extends JFrame{
    private JButton customerButton;
    private JPanel panel1;
    private JButton managerButton;
    JFrame frame = new JFrame();
    public MainMenu_1_() {

        frame.setContentPane(panel1);
        frame.setTitle("Hello! Welcome to Store!");
        frame.setSize(900, 600);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        customerButton.addActionListener(e -> {
            if (e.getSource() == customerButton) {
                frame.dispose();
                new Selections_C_1_5();
            }
        });

        managerButton.addActionListener(e -> {
            if(e.getSource() == managerButton){
                frame.dispose();
                new Selections_M_1_A();
             }
         });
    }
}

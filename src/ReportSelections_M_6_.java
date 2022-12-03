import javax.swing.*;
import javax.swing.JFrame;


public class ReportSelections_M_6_ extends JFrame{
    private JButton backButton;
    private JTextField ReportName;
    private JPanel panel1;
    JFrame frame = new JFrame();

    public ReportSelections_M_6_(Store store){
        frame.setContentPane(panel1);
        frame.setTitle("Reports");
        frame.setSize(900, 600);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        backButton.addActionListener(e -> {
            if(e.getSource()==backButton){
                frame.dispose();
                Selections_M_2_A selections = new Selections_M_2_A(store);
            }
        });

    }
}

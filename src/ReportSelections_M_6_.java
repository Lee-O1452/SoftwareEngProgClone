import javax.swing.*;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReportSelections_M_6_ extends JFrame{
    private JButton backButton;
    private JTextField ReportName;
    private JPanel panel1;
    JFrame frame = new JFrame();

    public ReportSelections_M_6_(){
        frame.setContentPane(panel1);
        frame.setTitle("Reports");
        frame.setSize(900, 600);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        backButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if(e.getSource()==backButton){
                    frame.dispose();
                    Selections_M_2_A selections = new Selections_M_2_A();
                }
            }
        });

    }
}

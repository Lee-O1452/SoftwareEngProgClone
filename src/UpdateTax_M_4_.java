import javax.swing.*;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventObject;

public class UpdateTax_M_4_ extends JFrame {
    private JButton backButton;
    private JTextField textField1;
    private JButton updateButton;
    private JTextField textField2;
    private JButton updateButton1;
    private JPanel panel1;
    JFrame frame = new JFrame();

    public UpdateTax_M_4_(Store store){

        frame.setContentPane(panel1);
        frame.setTitle("Update Taxes");
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

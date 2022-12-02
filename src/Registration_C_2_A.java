import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Registration_C_2_A {
    private JButton backButton;
    private JComboBox comboBox1;
    private JButton allStoresButton;
    private JTextField textField1;
    private JTextField textField2;
    private JButton registerButton;
    private JPanel panel1;
    JFrame frame = new JFrame();

    public Registration_C_2_A(){
        frame.setContentPane(panel1);
        frame.setTitle("Selections");
        frame.setSize(900,600);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == backButton) {
                    frame.dispose();
                    Selections_C_1_5 selections = new Selections_C_1_5();
                }
            }

        });

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == registerButton) {
                    frame.dispose();
                    AfterLoginRegistration_C_2_5 afterRegistration = new AfterLoginRegistration_C_2_5();
                }
            }

        });
    }

}

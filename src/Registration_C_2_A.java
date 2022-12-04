import javax.swing.*;

public class Registration_C_2_A {
    private JButton backButton;
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JButton registerButton;
    private JPanel panel1;
    JFrame frame = new JFrame();

    public Registration_C_2_A(Store store){
        frame.setContentPane(panel1);
        frame.setTitle("Selections");
        frame.setSize(900,600);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        backButton.addActionListener(e -> {
            if (e.getSource() == backButton) {
                frame.dispose();
                Selections_C_1_5 selections = new Selections_C_1_5();
            }
        });

        registerButton.addActionListener(e -> {
            if (e.getSource() == registerButton) {
                frame.dispose();
                AfterLoginRegistration_C_2_5 afterRegistration = new AfterLoginRegistration_C_2_5(store);
            }
        });
    }

}

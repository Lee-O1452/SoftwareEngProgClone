import javax.swing.*;
import javax.swing.JFrame;


public class Login_C_2_B extends JFrame {
    private JButton backButton;
    private JTextField textField1;
    private JTextField textField2;
    private JList StoreListButton;
    private JButton loginButton;
    private JPanel panel;
    JFrame frame = new JFrame();


    public Login_C_2_B(Store store){
        frame.setContentPane(panel);
        frame.setTitle("Create a New Store");
        frame.setSize(900,600);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        loginButton.addActionListener(e -> {
            if(e.getSource() == loginButton){
                frame.dispose();
                AfterLoginRegistration_C_2_5 afterRegistration = new AfterLoginRegistration_C_2_5(store);
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
import javax.swing.*;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login_C_2_B extends JFrame {
    private JButton backButton;
    private JTextField textField1;
    private JTextField textField2;
    private JList StoreListButton;
    private JButton loginButton;
    private JPanel panel;
    JFrame frame = new JFrame();


    public Login_C_2_B(){
        frame.setContentPane(panel);
        frame.setTitle("Create a New Store");
        frame.setSize(900,600);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        loginButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e){
                if(e.getSource() == loginButton){
                    frame.dispose();
                    AfterLoginRegistration_C_2_5 afterRegistration = new AfterLoginRegistration_C_2_5();
                }
            }
        });
        backButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e){
                if(e.getSource() == backButton){
                    frame.dispose();
                    MainMenu_1_ mainMenu = new MainMenu_1_();
                }
            }
        });

    }
}
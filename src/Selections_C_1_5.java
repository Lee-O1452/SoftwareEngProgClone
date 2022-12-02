import javax.swing.*;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Selections_C_1_5 {
    private JButton backButton;
    private JButton registerButton;
    private JButton loginButton;
    private JPanel panel1;
    JFrame frame = new JFrame();

    public Selections_C_1_5(){
        frame.setContentPane(panel1);
        frame.setTitle("Selections");
        frame.setSize(900,600);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        registerButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e){
                if(e.getSource() == registerButton){
                    frame.dispose();
                    Registration_C_2_A registration = new Registration_C_2_A();
                }
            }
        });
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

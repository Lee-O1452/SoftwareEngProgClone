import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReturnItem_C_4_ {
    private JButton backButton;
    private JButton returnItemButton;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JPanel panel1;
    JFrame frame = new JFrame();

    public ReturnItem_C_4_(){

        frame.setContentPane(panel1);
        frame.setTitle("Return an Item");
        frame.setSize(900,600);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        backButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if(e.getSource()==backButton){
                    frame.dispose();
                    AfterLoginRegistration_C_2_5 afterLogin = new AfterLoginRegistration_C_2_5();
                }
            }
        });

        returnItemButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if(e.getSource()==returnItemButton){

                }
            }
        });
    }
}
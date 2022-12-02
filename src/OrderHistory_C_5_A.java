import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OrderHistory_C_5_A {
    private JButton backButton;
    private JTextField textField1;
    private JTable table1;
    private JButton viewOrderButton;
    private JPanel panel1;
    JFrame frame = new JFrame();

    public OrderHistory_C_5_A(){


        backButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if(e.getSource()==backButton){
                    frame.dispose();
                    AfterLoginRegistration_C_2_5 afterLogin = new AfterLoginRegistration_C_2_5();
                }
            }
        });
        viewOrderButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if(e.getSource()==viewOrderButton){
                    frame.dispose();
                    Receipt_C_5_B priorReceipt = new Receipt_C_5_B();
                }
            }
        });
    }
}

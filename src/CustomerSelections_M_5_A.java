import javax.swing.*;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerSelections_M_5_A extends JFrame{
    private JButton backButton;
    private JButton displayCustomersButton;
    private JButton displayCustomerReceiptButton;
    private JPanel panel1;
    JFrame frame = new JFrame();

    public CustomerSelections_M_5_A(Store store){
        frame.setContentPane(panel1);
        frame.setTitle("Customer Selections");
        frame.setSize(900,600);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        backButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if(e.getSource()==backButton){
                    frame.dispose();
                    Selections_M_2_A selections = new Selections_M_2_A(store);
                }
            }
        });

        displayCustomerReceiptButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if(e.getSource()==displayCustomerReceiptButton){
                    frame.dispose();

                }
            }
        });

        displayCustomersButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if(e.getSource()==displayCustomersButton){
                    frame.dispose();
                    DisplayCustomers_M_5_B customers = new DisplayCustomers_M_5_B();
                }
            }
        });

    }
}

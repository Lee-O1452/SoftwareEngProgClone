import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AfterLoginRegistration_C_2_5 {
    private JButton backButton;
    private JButton createOrderButton;
    private JButton returnItemButton;
    private JButton orderHistoryButton;
    private JPanel panel1;
    JFrame frame = new JFrame();

    public AfterLoginRegistration_C_2_5(Store store){
        frame.setContentPane(panel1);
        frame.setTitle("Create a New Store");
        frame.setSize(900,600);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        backButton.addActionListener(e -> {
            if(e.getSource()==backButton){
                frame.dispose();
                MainMenu_1_ mainMenu = new MainMenu_1_();
            }
        });

        createOrderButton.addActionListener(e -> {
            if(e.getSource()==createOrderButton){
                frame.dispose();
                CreateOrder_C_3_A createOrder = new CreateOrder_C_3_A(store);
            }
        });

        returnItemButton.addActionListener(e -> {
            if(e.getSource()==returnItemButton){
                frame.dispose();
                ReturnItem_C_4_ returnItem = new ReturnItem_C_4_(store);
            }
        });

        orderHistoryButton.addActionListener(e -> {
            if(e.getSource()==orderHistoryButton){
                frame.dispose();
                OrderHistory_C_5_A orderHistory = new OrderHistory_C_5_A(store);
            }
        });

    }
}

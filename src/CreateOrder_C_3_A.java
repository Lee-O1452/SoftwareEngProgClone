import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;


public class CreateOrder_C_3_A {
    private JButton backButton;
    private JButton createOrderButton;
    private JTextField searchField;
    private JTextField quantityField;
    private JButton addToOrderButton;
    private JPanel panel1;
    private JList productList;
    JFrame frame = new JFrame();

    public CreateOrder_C_3_A(Store store, Customer customer){
        frame.setContentPane(panel1);
        frame.setTitle("Create a New Store");
        frame.setSize(900,600);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        InventoryController inventoryController = new InventoryController(store);

        productList.setListData(new Vector<>(inventoryController.displayProductReportName()));

        backButton.addActionListener(e -> {
            if(e.getSource()==backButton){
                frame.dispose();
                AfterLoginRegistration_C_2_5 afterLogin = new AfterLoginRegistration_C_2_5(store, customer);
            }
        });

        createOrderButton.addActionListener(e -> {
            if(e.getSource()==createOrderButton){
                frame.dispose();
                Receipt_C_3_B receipt = new Receipt_C_3_B();
            }
        });
    }
}

import javax.swing.*;
import java.util.ArrayList;
import java.util.Vector;


public class CreateOrder_C_3_A {
    private JButton backButton;
    private JButton createOrderButton;
    private JTextField searchField;
    private JTextField quantityField;
    private JButton addToOrderButton;
    private JPanel panel1;
    private JList productList;
    private JLabel orderIDField;
    private JCheckBox usingSNAPBox;
    private JButton searchButton;
    JFrame frame = new JFrame();

    public CreateOrder_C_3_A(Order order){
        frame.setContentPane(panel1);
        frame.setTitle("Create a New Store");
        frame.setSize(900,600);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        orderIDField.setText("Order ID: " + order.getOrderID());
        InventoryController inventoryController = new InventoryController(order.getStore());
        OrderController orderController = new OrderController();
        productList.setListData(new Vector<>(inventoryController.displayProductReportName()));

        searchButton.addActionListener(e -> {
            if(e.getSource()==searchButton){
                ArrayList<Product> searchedProducts = new ArrayList<>();
                for(int i = 0; i < inventoryController.displayProductReportName().size(); i++){
                    if(inventoryController.displayProductReportName().get(i).getProductName().contains(searchField.getText())){
                        searchedProducts.add(inventoryController.displayProductReportName().get(i));
                    }
                }
                productList.setListData(new Vector<>(searchedProducts));
            }
        });

        backButton.addActionListener(e -> {
            if(e.getSource()==backButton){
                frame.dispose();
                AfterLoginRegistration_C_2_5 afterLogin = new AfterLoginRegistration_C_2_5(order.getStore(), order.getStore().getCustomer(order.getCustomerID()));
            }
        });

        addToOrderButton.addActionListener(e -> {
            if(e.getSource() == addToOrderButton) {
                Product a = (Product) productList.getSelectedValue();
                if(Integer.parseInt(quantityField.getText()) <= a.getQuantity()){
                    orderController.addToOrder(order, (Product) productList.getSelectedValue(), Integer.parseInt(quantityField.getText()));
                    JOptionPane.showMessageDialog(frame, "Product added to order.");
                }
                else{
                    JOptionPane.showMessageDialog(frame, "the store doesn't have that many products.");
                }
            }
        });

        createOrderButton.addActionListener(e -> {
            if(e.getSource()==createOrderButton){
                order.setUsingSnap(usingSNAPBox.isSelected());
                frame.dispose();
                Receipt_C_3_B receipt = new Receipt_C_3_B(order);
            }
        });
    }
}

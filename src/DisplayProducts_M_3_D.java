import javax.swing.*;
import javax.swing.JFrame;

public class DisplayProducts_M_3_D extends JFrame {
    private JButton backButton;
    private JTextArea productList;
    private JPanel panel1;
    private JButton nameSort;
    private JButton idSort;
    private JButton manufacturerSort;
    private JButton foodSort;
    JFrame frame = new JFrame();
    public DisplayProducts_M_3_D(Store store){
        frame.setContentPane(panel1);
        frame.setTitle("Display Products");
        frame.setSize(900,600);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        InventoryController inventoryController = new InventoryController(store);

        productList.setText(
                "There are " + inventoryController.displayNumberOfProducts() + " products in the system.\n" +
                        "The total value of all products combined is $" + inventoryController.displayTotalValue() + ".\n" +
                        inventoryController.displayProductReportName()
        );

        nameSort.addActionListener(e -> {
            if(e.getSource()==nameSort){
                productList.setText(
                        "There are " + inventoryController.displayNumberOfProducts() + " products in the system.\n" +
                                "The total value of all products combined is $" + inventoryController.displayTotalValue() + ".\n" +
                                inventoryController.displayProductReportName()
                );
            }
        });

        idSort.addActionListener(e -> {
            if(e.getSource()==idSort){
                productList.setText(
                        "There are " + inventoryController.displayNumberOfProducts() + " products in the system.\n" +
                                "The total value of all products combined is $" + inventoryController.displayTotalValue() + ".\n" +
                                inventoryController.displayProductReportID()
                );
            }
        });

        manufacturerSort.addActionListener(e -> {
            if(e.getSource()==manufacturerSort){
                productList.setText(
                        "There are " + inventoryController.displayNumberOfProducts() + " products in the system.\n" +
                                "The total value of all products combined is $" + inventoryController.displayTotalValue() + ".\n" +
                                inventoryController.displayProductReportManufacturer()
                );
            }
        });

        foodSort.addActionListener(e -> {
            if(e.getSource()==foodSort){
                productList.setText(
                        "There are " + inventoryController.displayNumberOfProducts() + " products in the system.\n" +
                                "The total value of all products combined is $" + inventoryController.displayTotalValue() + ".\n" +
                                inventoryController.displayProductReportIsFood()
                );
            }
        });

        backButton.addActionListener(e -> {
            if(e.getSource()==backButton){
                frame.dispose();
                new Inventory_M_3_A(store);
            }
        });
    }
}

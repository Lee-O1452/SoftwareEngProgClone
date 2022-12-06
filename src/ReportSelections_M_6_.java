import javax.swing.*;
import javax.swing.JFrame;


public class ReportSelections_M_6_ extends JFrame{
    private JButton backButton;
    private JTextField reportName;
    private JPanel panel1;
    private JTextArea reportArea;
    private JButton customerOrderTotalsButton;
    private JButton manufacturersButton;
    private JButton popularProductsQuantityButton;
    private JButton orderStatisticsSNAPButton;
    private JButton orderStatisticsButton;
    private JButton ordersInDateRangeButton;
    private JButton storesSalesButton;
    private JButton popularProductsRevenueButton;
    private JTextField manufacturerField;
    JFrame frame = new JFrame();

    public ReportSelections_M_6_(Store store){
        frame.setContentPane(panel1);
        frame.setTitle("Reports");
        frame.setSize(900, 600);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        InventoryController inventoryController = new InventoryController(store);
        StoreController storeController = new StoreController();
        OrderController orderController = new OrderController();

        backButton.addActionListener(e -> {
            if(e.getSource()==backButton){
                frame.dispose();
                Selections_M_2_A selections = new Selections_M_2_A(store);
            }
        });

        manufacturersButton.addActionListener(e -> {
            if(e.getSource()==manufacturersButton){
                reportArea.setText(inventoryController.manufacturerReport(manufacturerField.getText()));
            }
        });

        orderStatisticsButton.addActionListener(e -> {
            if(e.getSource()==orderStatisticsButton){
                reportArea.setText(orderController.displayOrderStatistics(store));
            }
        });

        popularProductsQuantityButton.addActionListener(e -> {
            if(e.getSource()==popularProductsQuantityButton){
                reportArea.setText(orderController.displayPopularProductsQuantity(store));
            }
        });
    }
}

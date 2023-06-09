import javax.swing.*;
import javax.swing.JFrame;

public class ReportSelections_M_6_ extends JFrame{
    private JButton backButton;
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
    private JTextField date1Field;
    private JTextField date2Field;
    JFrame frame = new JFrame();

    public ReportSelections_M_6_(Store store){
        frame.setContentPane(panel1);
        frame.setTitle("Reports");
        frame.setSize(900, 600);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        InventoryController inventoryController = new InventoryController(store);
        OrderController orderController = new OrderController();

        backButton.addActionListener(e -> {
            if(e.getSource()==backButton){
                frame.dispose();
                new Selections_M_2_A(store);
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

        popularProductsRevenueButton.addActionListener(e -> {
            if(e.getSource()==popularProductsRevenueButton){
                reportArea.setText(orderController.displayPopularProductsRevenue(store));
            }
        });

        customerOrderTotalsButton.addActionListener(e -> {
            if(e.getSource()==customerOrderTotalsButton){
                reportArea.setText(orderController.displayCustomerOrderTotals(store));
            }
        });

        orderStatisticsSNAPButton.addActionListener(e -> {
            if(e.getSource()==orderStatisticsSNAPButton){
                reportArea.setText(orderController.displayOrderStatisticsSNAP(store));
            }
        });

        ordersInDateRangeButton.addActionListener(e -> {
            if(e.getSource()==ordersInDateRangeButton){
                reportArea.setText(orderController.displayOrderDateRange(store, date1Field.getText(), date2Field.getText()));
            }
        });

        storesSalesButton.addActionListener(e -> {
            if(e.getSource()==storesSalesButton){
                reportArea.setText(orderController.displayAllStoresSales());
            }
        });
    }
}

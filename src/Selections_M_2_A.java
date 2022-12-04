import javax.swing.*;
import javax.swing.JFrame;

public class Selections_M_2_A extends JFrame{
    private JButton backButton;
    private JButton inventoryButton;
    private JButton updateTaxButton;
    private JButton customersButton;
    private JButton reportsButton;
    private JLabel storeNameField;
    private JLabel storeIDField;
    private JPanel pane1;
    JFrame frame = new JFrame();

    public Selections_M_2_A(Store store){

        frame.setContentPane(pane1);
        frame.setTitle("Selections");
        frame.setSize(900,600);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        storeNameField.setText("Store Name: " + store.getStoreName());
        storeIDField.setText("Store ID: " + store.getStoreID());

        backButton.addActionListener(e -> {
            if (e.getSource() == backButton) {
                frame.dispose();
                Selections_M_1_A selectionsM1 = new Selections_M_1_A();

            }
        });

        inventoryButton.addActionListener(e -> {
            if (e.getSource() == inventoryButton) {
                frame.dispose();
                Inventory_M_3_A inventory = new Inventory_M_3_A(store);

            }
        });

        updateTaxButton.addActionListener(e -> {
            if (e.getSource() == updateTaxButton) {
                frame.dispose();
                UpdateTax_M_4_ updateTax = new UpdateTax_M_4_(store);

            }
        });

        customersButton.addActionListener(e -> {
            if (e.getSource() == customersButton) {
                frame.dispose();
                CustomerSelections_M_5_A customerSelections = new CustomerSelections_M_5_A(store);

            }
        });

        reportsButton.addActionListener(e -> {
            if (e.getSource() == reportsButton) {
                frame.dispose();
                ReportSelections_M_6_ reports = new ReportSelections_M_6_(store);

            }
        });
    }
}

import javax.swing.*;
import javax.swing.JFrame;

public class UpdateTax_M_4_ extends JFrame {
    private JButton backButton;
    private JTextField foodField;
    private JButton updateFoodButton;
    private JTextField nonfoodField;
    private JButton updateNonfoodButton;
    private JPanel panel1;
    JFrame frame = new JFrame();

    public UpdateTax_M_4_(Store store){

        frame.setContentPane(panel1);
        frame.setTitle("Update Taxes");
        frame.setSize(900, 600);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        StoreController storeController = new StoreController();

        backButton.addActionListener(e -> {
            if(e.getSource()==backButton){
                frame.dispose();
                Selections_M_2_A selections = new Selections_M_2_A(store);
            }
        });

        updateFoodButton.addActionListener(e -> {
            if(e.getSource()==updateFoodButton){
                storeController.updateFoodTax(store, Double.parseDouble(foodField.getText()));
                JOptionPane.showMessageDialog(frame, "Food tax has been updated.");
            }
        });

        updateNonfoodButton.addActionListener(e -> {
            if(e.getSource()==updateNonfoodButton){
                storeController.updateNonfoodTax(store, Double.parseDouble(nonfoodField.getText()));
                JOptionPane.showMessageDialog(frame, "Non-food tax has been updated.");
            }
        });
    }
}

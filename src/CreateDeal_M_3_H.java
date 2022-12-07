import javax.swing.*;

public class CreateDeal_M_3_H {

    private JPanel panel1;
    private JButton backButton;
    JFrame frame = new JFrame();

    public CreateDeal_M_3_H(Store store) {
        frame.setContentPane(panel1);
        frame.setTitle("Inventories");
        frame.setSize(900, 600);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        backButton.addActionListener(e -> {
            if(e.getSource()==backButton){
                frame.dispose();
                new Inventory_M_3_A(store);
            }
        });
    }
}

import javax.swing.*;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddProduct_M_3_B extends JFrame{
    private JButton backButton;
    private JTextField productID;
    private JTextField productName;
    private JTextField manufacturer;
    private JTextField price;
    private JTextField quantity;
    private JButton addButton;
    private JPanel panel1;
    JFrame frame = new JFrame();
    public AddProduct_M_3_B(){
        frame.setContentPane(panel1);
        frame.setTitle("Add Product");
        frame.setSize(900, 600);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

import javax.swing.*;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddProduct_M_3_B extends JFrame{
    private JButton backButton;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JButton addButton;
    private JPanel panel1;

    public void AddProduct_M_3_B(){

    }
    public static void main(String[] args){
        AddProduct_M_3_B c = new AddProduct_M_3_B();
        c.setContentPane(c.panel1);
        c.setTitle("Add Product");
        c.setSize(900, 600);
        c.setVisible(true);
        c.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

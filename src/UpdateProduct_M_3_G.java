import javax.swing.*;
import javax.swing.JFrame;


public class UpdateProduct_M_3_G extends JFrame{
    private JButton backButton;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton updatePriceButton;
    private JButton updateQuantityButton;
    private JPanel panel1;

    public void UpdateProduct_M_3_G(){

    }

    public static void main(String[] args){
        UpdateProduct_M_3_G a = new UpdateProduct_M_3_G();
        a.setContentPane(a.panel1);
        a.setTitle("Update Products");
        a.setSize(900, 600);
        a.setVisible(true);
        a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}

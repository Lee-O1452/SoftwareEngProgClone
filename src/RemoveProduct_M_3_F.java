import javax.swing.*;
import javax.swing.JFrame;

public class RemoveProduct_M_3_F extends JFrame{
    private JButton backButton;
    private JTextField textField1;
    private JButton removeProductButton;
    private JPanel panel1;

    public void RemoveProduct_M_3_F(){

    }

    public static void main(String[] args){
        RemoveProduct_M_3_F a = new RemoveProduct_M_3_F();
        a.setContentPane(a.panel1);
        a.setTitle("Remove Products");
        a.setSize(900, 600);
        a.setVisible(true);
        a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

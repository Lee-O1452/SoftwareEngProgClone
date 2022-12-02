import javax.swing.*;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DisplayCustomers_M_5_B extends JFrame{
    private JButton backButton;
    private JTextArea textArea1;
    private JScrollBar scrollBar1;
    private JPanel panel1;

    public void DisplayCustomers_M_5_B(){

    }
    public static void main(String[] args){
        DisplayCustomers_M_5_B a = new DisplayCustomers_M_5_B();
        a.setContentPane(a.panel1);
        a.setTitle("Display Customers");
        a.setSize(900,600);
        a.setVisible(true);
        a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

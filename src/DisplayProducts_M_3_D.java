import javax.swing.*;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DisplayProducts_M_3_D extends JFrame {
    private JButton backButton;
    private JTextArea textArea1;
    private JPanel panel1;

    public void DisplayProducts_M_3_D(){

    }
    public static void main(String[] args){
        DisplayProducts_M_3_D a = new DisplayProducts_M_3_D();
        a.setContentPane(a.panel1);
        a.setTitle("Display Products");
        a.setSize(900,600);
        a.setVisible(true);
        a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

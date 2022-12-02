import javax.swing.*;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BatchAdd_Update_M_3_E extends JFrame{
    private JButton backButton;
    private JButton selectFileButton;
    private JButton addUpdateButton;
    private JPanel panel1;

    public void BatchAdd_Update_M_3_E(){

    }
    public static void main(String[] args){
        BatchAdd_Update_M_3_E d = new BatchAdd_Update_M_3_E();
        d.setContentPane(d.panel1);
        d.setTitle("Batch Add and Update");
        d.setSize(900,600);
        d.setVisible(true);
        d.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

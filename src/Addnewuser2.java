
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Addnewuser2 extends JFrame {

    public Addnewuser2(String cont) {
        setTitle("Add New User");
        setSize(500, 500);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        JLabel l1 = new JLabel("Enter Name");

        JLabel l2 = new JLabel("Enter Start Date(yyyy-mm-dd)");
        JLabel l3 = new JLabel("Chitti Lifted");
        JLabel l4 = new JLabel("Enter Taken Chitti Amount");
        JLabel l5 = new JLabel("Enter Ending Date(yyyy-mm-dd)");
        JTextField t1 = new JTextField(20);
        JTextField t2 = new JTextField(20);

        JRadioButton y = new JRadioButton("Yes");
        JRadioButton n = new JRadioButton("No");

        ButtonGroup t3 = new ButtonGroup();
        t3.add(y);
        t3.add(n);
        JPanel radiopanel = new JPanel();
        radiopanel.setLayout(new FlowLayout());
        radiopanel.add(y);
        radiopanel.add(n);

        JTextField t4 = new JTextField(20);
        JTextField t5 = new JTextField(20);

        JPanel jp = new JPanel();
        jp.setLayout(new GridLayout(6, 2, 20, 20));
        jp.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        jp.add(l1);
        setsize(t1, 200, 30);
        jp.add(wrapInPanel(t1));
        jp.add(l2);
        setsize(t2, 200, 30);
        jp.add(wrapInPanel(t2));
        jp.add(l3);
        jp.add(wrapInPanel(radiopanel));
        jp.add(l4);
        setsize(t4, 200, 30);
        jp.add(wrapInPanel(t4));
        jp.add(l5);
        setsize(t5, 200, 30);
        jp.add(wrapInPanel(t5));

        JButton submit = new JButton("Submit");
        setsize(submit, 200, 30);

        jp.add(new JPanel());
        jp.add(wrapInPanel(submit));

        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = t1.getText();
                String start = t2.getText();
                String chittilifted = y.isSelected() ? "Yes" : "No";
                String takenChittiAmount = "";
                takenChittiAmount = t4.getText();
                String end = t5.getText();

                todatabase dt = new todatabase();
                dt.insert(name, start, chittilifted, takenChittiAmount, end);

                JOptionPane.showMessageDialog(null, "Details Successfully Subitted.");

                t1.setText("");
                t2.setText("");
                t4.setText("");
                t5.setText("");
                t3.clearSelection();

            }
        });

        add(jp);
        //setVisible(true);

    }

    private JPanel wrapInPanel(JComponent comp) {
        JPanel pan = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pan.add(comp);
        return pan;
    }

    private void setsize(JComponent tf, int width, int height) {
        Dimension size = new Dimension(width, height);
        tf.setPreferredSize(size);
        tf.setMaximumSize(size);
        tf.setMinimumSize(size);
    }

    public static void main(String[] args) {
        new Addnewuser2("yes");
    }
}

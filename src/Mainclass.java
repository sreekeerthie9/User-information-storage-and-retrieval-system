
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

class Mainclass {

    //JFrame obj;
    //JButton b1,b2;
    //JPanel jp;
    Mainclass() {
        JFrame obj = new JFrame("User Information Storage and Retrieval System");
        JButton b1 = new JButton("add new user");
        JButton b2 = new JButton("retrieve user details");

        //b1.setPreferredSize(new Dimension(200,50));
        //b2.setPreferredSize(new Dimension(200,50));
        b1.setAlignmentX(Component.CENTER_ALIGNMENT);
        b2.setAlignmentX(Component.CENTER_ALIGNMENT);

        //b1.setMinimumSize(new Dimension(200, 50));
        b1.setMaximumSize(new Dimension(200, 50));
        //b2.setMinimumSize(new Dimension(200, 50));
        b2.setMaximumSize(new Dimension(200, 50));

        JPanel jp = new JPanel();
        jp.setLayout(new BoxLayout(jp, BoxLayout.Y_AXIS));

        jp.add(Box.createRigidArea(new Dimension(0, 150)));
        jp.add(b1);
        jp.add(Box.createRigidArea(new Dimension(0, 75)));
        jp.add(b2);

        obj.add(jp);

        obj.setSize(500, 500);
        obj.setTitle("User Information Storage and Retrieval System");

        //obj.setResizable(false);
        obj.setVisible(true);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Addnewuser2 ad = new Addnewuser2("yes");
                ad.setVisible(true);
                //obj.setSize(600,600);
                //obj.setVisible(true);
            }
        });
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                RetrieveUserDetails re = new RetrieveUserDetails();
                re.setVisible(true);
                //retrieveUser();
                //obj.setSize(500, 500);
                //obj.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        new Mainclass();
    }
}

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

public class RetrieveUserDetails extends JFrame {

    public RetrieveUserDetails() {
        setTitle("Retrieve User Details");
        setSize(500, 500);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JLabel l1 = new JLabel("Enter User Name");
        JTextField t1 = new JTextField(20);
        JButton retrieve = new JButton("Retrieve");

        JTextArea resultArea = new JTextArea(10, 40);
        resultArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultArea);

        JPanel jp = new JPanel();
        jp.setLayout(new GridLayout(3, 2, 20, 20));
        jp.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        jp.add(l1);
        setsize(t1, 200, 30);
        jp.add(wrapInPanel(t1));
        jp.add(new JPanel());
        jp.add(wrapInPanel(retrieve));
        jp.add(new JPanel());
        jp.add(wrapInPanel(scrollPane));

        retrieve.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String userName = t1.getText();
                resultArea.setText("");
                retrieveUserDetails(userName, resultArea);
            }
        });

        add(jp);
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

    private void retrieveUserDetails(String userName, JTextArea resultArea) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        PreparedStatement ps = null;

        try {
            String url = "jdbc:mysql://127.0.0.1:3306/mschitti";
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, "root", "");
            stmt = conn.createStatement();

            String query = "SELECT * FROM userdetails WHERE name=?";
            ps = conn.prepareStatement(query);
            ps.setString(1, userName);
            rs = ps.executeQuery();

            if (rs.next()) {
                String result = "Name: " + rs.getString("name") +
                        "\nStart Date: " + rs.getString("start_date") +
                        "\nTaken Chitti Amount: " + rs.getString("taken_chitti_amount") +
                        "\nEnding Date: " + rs.getString("ending_date");
                resultArea.setText(result);
            } else {
                resultArea.setText("No user found with the name " + userName);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new RetrieveUserDetails().setVisible(true);
            }
        });
    }
}


import java.sql.*;

public class todatabase {

    private void insertdetails(Statement stmt, String name, String start_date, String taken_chitti_amount, String ending_date) {

        try {
            int s = 0;

            if (taken_chitti_amount == "null") {

                String query = "insert into userdetails(name,start_date,ending_date) values(?,?,?)";
                PreparedStatement ps = stmt.getConnection().prepareStatement(query);

//ps.setString(1,sno);
                ps.setString(1, name);
                ps.setString(2, start_date);
                ps.setString(3, ending_date);

                ps.executeUpdate();
            } else {

                String query = "insert into userdetails(name,start_date,taken_chitti_amount,ending_date) values(?,?,?,?)";
                PreparedStatement ps = stmt.getConnection().prepareStatement(query);

//ps.setString(1,sno);
                ps.setString(1, name);
                ps.setString(2, start_date);
                ps.setString(3, taken_chitti_amount);
                ps.setString(4, ending_date);

                ps.executeUpdate();

            }

        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("vendor error: " + ex.getErrorCode());
        }
    }

    public void insert(String name, String start_date, String chittilifted, String taken_chitti_amount, String ending_date) {
        //String sno="31";
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        PreparedStatement ps = null;

        try {

            System.out.println("hii");
            String url = "jdbc:mysql://127.0.0.1:3306/mschitti";
            Class.forName("com.mysql.cj.jdbc.Driver");

            conn = DriverManager.getConnection(url, "root", "");
            System.out.println("database connection established");
            stmt = conn.createStatement();

            if ("No".equals(chittilifted)) {
                taken_chitti_amount = "null";
            }

            insertdetails(stmt, name, start_date, taken_chitti_amount, ending_date);

        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("vendor error: " + ex.getErrorCode());
        } catch (Exception e) {
            System.err.println("cannot connect to database server");
        } finally {

            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException sqlex) {
                }
                rs = null;
            }

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException sqlex) {
                }
                stmt = null;
            }

            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException sqlex) {
                }
                ps = null;
            }

            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("database connection terminated");
                } catch (Exception e) {
                }
            }
        }

    }

    public static void main(String args[]) {
        new todatabase();
        //d.insert("sree","2024-12-03","No","","2025-12-03");
    }
}

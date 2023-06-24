package Helper;

//import java.applet.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {

    private static Connection con;

    public static Connection getConnection() {
        try {

            if (con == null) {

                // Driver Class
                Class.forName("com.mysql.cj.jdbc.Driver");

                // Create a connection
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventorymanagementapplication", "root", "");

            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return con;
    }

}

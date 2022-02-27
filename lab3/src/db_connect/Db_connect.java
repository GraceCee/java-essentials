package db_connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Db_connect {
    final private static Logger logger = Logger.getLogger(Db_connect.class.getName());
    public static Connection connect(Connection con) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/SMS?useTimezone=true&serverTimezone=UTC", "root", "adminadmin");
            logger.info("Connected");
            return con;
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Not Connected", e);
            return null;
        }
    }

    public static boolean disconnect(Connection con) {
        try {
            if (con != null) {
                con.close();
                logger.info("Disconnected");
                return true;
            }
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Not Connected", e);
        }
        return false;
    }
}

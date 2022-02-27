package db_connect;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Db_connect2 {

    final private static Logger logger = Logger.getLogger(Db_connect2.class.getName());
    private static Connection con = null;



    public static void main (String args[]){
        Db_connect2.connect();
        ArrayList<String> data = Db_connect2.retrieveData();
       // Db_connect2.disconnect();
    }



    public static void connect() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample_db?useTimezone=true&serverTimezone=UTC", "root", "adminadmin");
            logger.info("Connected");
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Not Connected", e);
        }

    }

    public static void disconnect() {
        try {
            if (con != null) {
                con.close();
                logger.info("Disconnected");
            }
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Not Connected", e);
        }
    }

    public static void insertData(String data) {
        String insertQuery = "Insert into datatable (data) values ('" + data + "')";
        Statement statement = null;
        int result = 0;

        try {
            statement = con.createStatement();
            result = statement.executeUpdate(insertQuery);
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "SQLException", e);
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (Exception e) {
                logger.log(Level.SEVERE, "ERROR IN CLOSING", e);
            }
        }
        logger.log(Level.INFO, "Inserted : {0}", result);
    }

    public static ArrayList<String> retrieveData() {
        String selectQuery = "SELECT * FROM datatable";
        Statement statement = null;
        ResultSet resultSet = null;
        ArrayList<String> result = new ArrayList<>();

        try {
            statement = con.createStatement();
            resultSet = statement.executeQuery(selectQuery);

            while (resultSet.next()) {
                logger.log(Level.INFO, resultSet.getString(1) + " : " + resultSet.getString(2));
                result.add(resultSet.getInt(1) + " : " + resultSet.getString(2));
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "SQLException", e);
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (resultSet != null) {
                    statement.close();
                }
            } catch (Exception e) {
                logger.log(Level.SEVERE, "ERROR IN CLOSING", e);
            }

        }
        logger.log(Level.INFO, "Retrieved : {0}", result);
        return result;

    }
}

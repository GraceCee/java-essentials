import db_connect.Db_connect;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Promo {
    protected String promo_code;
    protected String promo_details;
    protected int short_code;
    protected LocalDate start_date;
    protected LocalDateTime end_date;

    private static Connection con;
    final private static Logger logger = Logger.getLogger(Promo.class.getName());

    public Promo() {

    }

    public Promo(String promo_code, String promo_details, int short_code, LocalDate start_date, LocalDateTime end_date) {
        this.promo_code = promo_code;
        this.promo_details = promo_details;
        this.short_code = short_code;
        this.start_date = start_date;
        this.end_date = end_date;

    }



    public void User_defined() {

        boolean promo_inserted = false;

        try{

            con = Db_connect.connect(con);

            if(!con.isClosed()){

                logger.log(Level.INFO, "Connected to database");

                //IF CONNECTED TO THE DATABASE, DO THIS.

                Scanner scanner = new Scanner(System.in);
                System.out.print("ENTER PROMO CODE: " );
                String promo_code = scanner.nextLine();

                System.out.print("ENTER START DATE: " );
                LocalDate start_date = LocalDate.parse(scanner.nextLine());

                System.out.print("ENTER END DATE: " );
                String end_date = scanner.nextLine();

                // LocalDateTime end_date = LocalDateTime.from(LocalDate.parse(scanner.nextLine()));

                System.out.print("ENTER PROMO DETAILS:");
                String promo_details = scanner.nextLine();

                System.out.print("ENTER SHORT CODE: ");
                String short_code = scanner.nextLine();



                PreparedStatement sql_insert = con.prepareStatement("INSERT INTO tbl_promo2 (Promo_code, Promo_details, Short_code, Start_date, End_date) VALUES (?,?,?,?,?)");
                sql_insert.setString(1, promo_code);
                sql_insert.setString(2, promo_details);
                sql_insert.setString(3, short_code);
                sql_insert.setString(4, String.valueOf(start_date));
                sql_insert.setString(5, end_date);

                // execute statement
                int row = sql_insert.executeUpdate();

                if (row > 0) {
                    logger.log(Level.INFO, "PROMO WAS SUCCESSFULLY INSERTED TO THE DATABASE");
                    promo_inserted = true;
                } else {
                    logger.log(Level.WARNING, "PROMO WAS NOT INSERTED");
                }


            }else {
                logger.log(Level.SEVERE, "FAILED TO CONNECT TO THE DATABASE");
            }
            // Disconnect from the database
            Db_connect.disconnect(con);
            if (con.isClosed()) {
                logger.log(Level.INFO, "Disconnected from the database");
            } else {
                logger.log(Level.WARNING, "Connection to database might still be open");
            }

        }
        catch (SQLException e){
            e.printStackTrace();
            logger.log(Level.INFO, "NOT CONNECTED TO THE DATABASE", e);

        }


    }

//    public static void insert_promo(String promo_code, String promo_details, int short_code, LocalDate start_date, LocalDateTime end_date){
//
//
//    }

//    public static ArrayList<Promo> retrievePromo(){
//        Statement statement = null;
//        ResultSet resultSet = null;
//        ArrayList<Promo> promoList = new ArrayList<>();
//
//        String selectQuery = "SELECT * FROM tbl_promo2";
//        PreparedStatement ps = null;
//        ResultSet rs = null;
//
//        try {
//            // query from database
//            con = Db_connect.connect(con);
//            ps = con.prepareStatement(selectQuery);
//            rs = ps.executeQuery();
//
//            // turn to object and put in arraylist
//            while (rs.next()) {
//
//                // convert string to LocalDateTime
//                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//                LocalDateTime sd = LocalDateTime.parse(rs.getString("start_date"), formatter);
//                LocalDateTime ed = LocalDateTime.parse(rs.getString("end_date"), formatter);
//
////                Promo promo = new Promo(rs.getString("promo_code"), rs.getString("details"),
////                        rs.getString("short_code"), sd, ed);
////                promoList.add(promo);
//
//
//                Promo promo = new Promo();
//            }
//
//            con.close();
//            logger.log(Level.INFO, "Retrieved : {0}", promoList);
//
//        } catch (SQLException e) {
//            logger.log(Level.SEVERE, "SQLException", e);
//        }
//
//        return promoList;
//    }




}

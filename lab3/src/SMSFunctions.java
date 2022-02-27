import db_connect.Db_connect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;

//These are the functions connected to the SMS interface
//as what is being asked of us from the slides

public class SMSFunctions implements SMSInterface {

    private SMS sms;
    private static Connection con;
    final private static Logger logger = Logger.getLogger(SMSFunctions.class.getName());


    @Override
    public boolean insertSms() {
        return false;
    }

    //This is to check if the registration is valid following the promo end_date

    public static boolean checkREGifValid(String msisdn, String promo_code){

        boolean valid = false;

        con = Db_connect.connect(con);

        try{

            if(!con.isClosed()){
                PreparedStatement query = con.prepareStatement(
                        "SELECT tbl_sms3.MSISDN, tbl_sms3.Promo_code  " +
                                "FROM tbl_sms3 " +
                                "INNER JOIN tbl_promo2 " +
                                "ON tbl_promo2.Promo_code = tbl_sms3.Promo_code " +
                                "LIMIT 1 ");
                query.setString(1, msisdn);
                query.setString(2, promo_code);

                ResultSet rs = query.executeQuery();
                System.out.println(query.toString());

                if (rs.isBeforeFirst()) {
                    System.out.println(rs);
                    valid = true;
                }

            }else {
                logger.log(Level.SEVERE, "Connection to the database FAILED");
            }
            // DISCONNECT FROM THE DATABASE
            Db_connect.disconnect(con);
            if (con.isClosed()) {
                logger.log(Level.INFO, "Disconnected from the database");
            } else {
                logger.log(Level.WARNING, "Connection to database might still be open");
            }

        }catch (Exception  e){
            e.printStackTrace();
            logger.log(Level.INFO, "Connected to database", e);

        }

        return valid;

    }

    @Override
    public String retrieveSmsByDate(LocalDateTime startDate, LocalDateTime endDate) {
        return null;
    }

    @Override
    public String retrieveSmsByPromoCode(String promo_code) {
        return null;
    }

    @Override
    public String retrieveSmsByMsisdn(String msisdn) {
        return null;
    }

    @Override
    public String retrieveSmsByShortCode(String short_code) {
        return null;
    }

    @Override
    public String retrieveSmsBySent() {
        return null;
    }

    @Override
    public String retrieveSmsByManyMsisdn(String[] msisdn) {
        return null;
    }
}

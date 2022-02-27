import db_connect.Db_connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SMS {


    protected String short_code;
    protected String msisdn;
    protected String recipient;
    protected String sender;
    protected String transaction_id; //(contains number and characters)
    protected LocalDate timestamp;
    private String promo_code;

    //Note: TRANSACTION ID is auto generate by another system and is not generated.

    private Connection con;
    final private static Logger logger = Logger.getLogger(SMS.class.getName());


    public SMS() {

    }

    public void SMS (String short_code, String msisdn, String recipient, String sender, String transaction_id, LocalDate timestamp) {
        this.short_code = short_code;
        this.msisdn = msisdn;
        this.recipient = recipient;
        this.sender = sender;
        this.transaction_id = transaction_id;
        this.timestamp = timestamp;
    }



    public String getShort_code() {
        return short_code;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public String getRecipient() {
        return recipient;
    }

    public String getSender() {
        return sender;
    }

    public String getTransaction_id() {
        return transaction_id;
    }

    public LocalDate getTimestamp() {
        return timestamp;
    }



    //SMS CHECKER
    //
    //Create a function that will accept a map with exactly 3 items.
    //The first item is the mobile number.
    //The second item is the sms
    //The third is the short code that will send the sms
    //
    //
    //Example:
    //Mobile number : +639563026795
    //Message : PROMO CODE ACCEPTED
    //Short Code : 1234



    public boolean sms_checker(HashMap<String, String> map1, HashMap<String, String> map2) {

        if (!map1.containsKey("Mobile number: ") || !map2.containsKey("Mobile number: ") ||
                !map1.containsKey("MESSAGE: ") || !map2.containsKey("MESSAGE: ") ||
                !map1.containsKey("Short Code: ") || !map2.containsKey("Short Code: ")) {
            return false;
        }

        return map1.equals(map2);
    }




    public void send_sms (){
        SMS sms = new SMS();



        try{

            //CHECKING THE CONNECTION

            con = Db_connect.connect(con);

            if(!con.isClosed()){
                logger.log(Level.INFO, "Connected to database");

                //IF CONNECTED TO THE DATABASE, DO THIS.


                Scanner scanner = new Scanner(System.in);
      //  sms.send_sms("23456789","234567", "PROMO");
                System.out.print("ENTER MSISDN: ");
                msisdn = scanner.nextLine();
                System.out.print("ENTER SHORT CODE: ");
                short_code = scanner.nextLine();
                System.out.print("ENTER PROMO CODE: ");
                promo_code = scanner.nextLine();



                PreparedStatement sql_insert = con.prepareStatement("INSERT INTO tbl_sms3 (MSISDN, Short_code, Promo_code) VALUES (?,?,?)");
                sql_insert.setString(1, msisdn);
                sql_insert.setString(2, short_code);
                sql_insert.setString(3, promo_code);

                // EXECUTE THE STATEMENT
                int row = sql_insert.executeUpdate();
                if (row > 0){
                    logger.log(Level.INFO, "SMS sent");
                }else{
                    logger.log(Level.WARNING, "SMS FAILED TO SEND");
                }

                // DISCONNECT FROM THE DATABASE
                Db_connect.disconnect(con);
                if(con.isClosed()){
                    logger.log(Level.INFO, "Disconnected from the database");
                }else{
                    logger.log(Level.WARNING, "Connection to database might still be open");
                }

            }

            //IF NOT CONNECTED, DO THIS.

            else{
                logger.log(Level.SEVERE, "Connection to the database FAILED");
            }


        }catch (Exception e){
            e.printStackTrace();
            logger.log(Level.INFO, "Connected to database", e);
        }

    }


}

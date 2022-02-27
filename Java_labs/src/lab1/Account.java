

package lab1;

import java.util.Date;

public class Account {
    public static int id;
    //Account's fields
    //private int id;
    protected String first_name;
    protected String last_name;
    protected Date date_created;
    protected boolean is_active;

    //Gawa ng method for account
    public void Account (int id, String first_name, String last_name) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.date_created = new Date();
        this.is_active = false;
    }
    //Setter for date created para matawag siya as object sa method na account
    public void setDate_created(Date date_created) {this.date_created = date_created;}
    //Setter for is_active for the is_active object with the account method.
    public void setIs_active(boolean is_active) {this.is_active = is_active;}



    public int getId() {return id;}

    public String getFirst_name() {return first_name;}

    public String getLast_name(String s) {return last_name;}

    public Date getDate_created() {return date_created;}

    public boolean isIs_active() {return is_active;}



}

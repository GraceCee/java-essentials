package lab1;

import lab1.transaction_types.*;

import java.util.Random;


public class Randomizer {



    public static Money_transfer randomMTObject() {
       // RandomGenerator generator = RandomGenerator.getDefault();
        Random r = new Random();
        int store_id = r.nextInt(200000);
        int transaction_id = r.nextInt(1000000);
        int account_id = r.nextInt(900000);
        double amount = r.nextDouble();

        int randNum1 = r.nextInt(499);
        int randNum2 = r.nextInt(499);
        String recipient = Names.getRandom_Full_name(randNum1, randNum2);

        Money_transfer obj = new Money_transfer(store_id, transaction_id, account_id, amount, recipient);
        return obj;
    }
    public static Bills randomBillObject() {
        Random r = new Random();
        int store_id = r.nextInt(200000);
        int transaction_id = r.nextInt(1000000);
        int account_id = r.nextInt(900000);
        double amount = r.nextDouble();
        int randNum = r.nextInt(499);
        String company_name = Names.getRandom_Company_name(randNum);
        double bills_charge = r.nextDouble();

        Bills obj = new Bills (store_id, transaction_id, account_id, amount, company_name, bills_charge);
        return obj;

    }
    public static Buy_loads randomBLObject() {
        Random r = new Random();
        int store_id = r.nextInt(1000000);
        int transaction_id = r.nextInt(1000000);
        int account_id = r.nextInt(1000000);
        double amount = r.nextDouble();

        long msisdn = r.nextLong();

        Buy_loads obj = new Buy_loads (store_id, transaction_id, account_id, amount, msisdn);
        return obj;

    }

    public static Add_account_credits randomAACObject() {
        Random r = new Random();
        int store_id = r.nextInt(200000);
        int transaction_id = r.nextInt(1000000);
        int account_id = r.nextInt(900000);
        double amount = r.nextDouble();

        int randNum = r.nextInt(499);
        String company_name = Names.getRandom_Company_name(randNum);

        Add_account_credits obj = new Add_account_credits(store_id, transaction_id, account_id, amount, company_name);
        return obj;

    }
    public static Add_game_credits randomAGCObject() {
        Random r = new Random();
        int store_id = r.nextInt(200000);
        int transaction_id = r.nextInt(1000000);
        int account_id = r.nextInt(900000);
        double amount = r.nextDouble();

        int randNum = r.nextInt(499);
        String company_name = Names.getRandom_Company_name(randNum);

        Add_game_credits obj = new Add_game_credits(store_id, transaction_id, account_id, amount, company_name);
        return obj;

    }






}

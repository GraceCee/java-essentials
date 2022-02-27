package lab1.transaction_types;

import lab1.Transaction;

public class Money_transfer extends Transaction {


    protected String recipient;


    public Money_transfer(int store_id, int transaction_id, int account_id, double amount, String recipient) {
        super(store_id, transaction_id, account_id, amount);
        this.recipient = recipient;
    }



    @Override
    public String toString(){

        String output =
                "\n[MONEY TRANSFER] " +
                        "\nTransaction ID: " + this.transaction_id +
                        "\nAccount ID: " + this.account_id +
                        "\nStore ID: " + this.store_id +
                        "\nAmount: " + this.amount +
                        "\nTimestamp: " + this.timestamp;

        return output;
    }
}

package lab1.transaction_types;

import lab1.Transaction;

public class Add_account_credits extends Transaction {
    protected Long msisdn;


    public Add_account_credits(int store_id, int transaction_id, int account_id, double amount, String company_name) {
        super(store_id, transaction_id, account_id, amount);
        this.msisdn = msisdn;
    }


    public Long getMsisdn() {
        return msisdn;
    }

    @Override
    public String toString() {

        String output =
                "\n[ADD ACCOUNT CREDIT] " +
                        "\nTransaction ID: " + this.transaction_id +
                        "\nAccount ID: " + this.account_id +
                        "\nStore ID: " + this.store_id +
                        "\nMSISDN: " + this.msisdn +
                        "\nAmount: " + this.amount +
                        "\nTimestamp: " + this.timestamp;

        return output;
    }
}

package lab1;

public class Bills extends Transaction{

    protected String company_name;
    protected double bills_charge;



    public Bills(int store_id, int transaction_id, int account_id, double amount, String company_name, double bills_charge) {
        super(store_id, transaction_id, account_id, amount);

        this.company_name = company_name;
        this.bills_charge = bills_charge;
    }


    public String getCompany_name() {
        return company_name;
    }

    public double getBills_charge() {
        return bills_charge;
    }

    @Override
    public String toString() {

        String output =
                "\n[BILL] " +
                        "\nTransaction ID: " + this.transaction_id +
                        "\nAccount ID: " + this.account_id +
                        "\nStore ID: " + this.store_id +
                        "\nCompany Name: " + this.company_name +
                        "\nAmount: " + this.amount +
                        "\nBill: " + this.bills_charge +
                        "\nTimestamp: " + this.timestamp;

        return output;
    }

    //Create a function to identify unique and duplicate bills (LAST PART OF THE SLIDE

    @Override
    public boolean equals(Object object) {
        Bills obj = (Bills) object;
        if (obj == this) {
            return true;
        }

        if (
                Integer.compare(this.store_id, obj.store_id) == 0 &&
                        Integer.compare(this.transaction_id, obj.transaction_id) == 0 &&
                        Integer.compare(this.account_id, obj.account_id) == 0 &&
                        Double.compare(this.amount, obj.amount) == 0 &&
                        Double.compare(this.bills_charge, obj.bills_charge) == 0 &&
                        this.company_name.equals(obj.company_name)

        ) {
            return true;
        }

        return false;
    }


}

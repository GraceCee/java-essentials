package lab1;

import lab1.transaction_types.*;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class TransactionProcessing {

    private ArrayList<Transaction> transactions = new ArrayList<Transaction>();
    //Use log to show the details of the Transaction ArrayList
    final private static Logger logger = Logger.getLogger(TransactionProcessing.class.getName());


    public static void main(String[] args) {
        TransactionProcessing tp = TransactionProcessing.init();
        TransactionProcessing.listTransactionObjects(tp);
        TransactionProcessing.listTransactionsByType(tp, EnumClass.ADD_ACCOUNT_CREDITS);
    }

    public static TransactionProcessing init() {
        TransactionProcessing tp = new TransactionProcessing();

        //Money Transfer - generating 5 random objects
        int countdown = 5;
        while (countdown > 0) {
            tp.transactions.add(Randomizer.randomMTObject());
            countdown--;
        }

        //Bill - generating 3 random objects
        countdown = 3;
        while (countdown > 0) {
            tp.transactions.add(Randomizer.randomBillObject());
            countdown--;
        }

        //Buy Load - generating 5 random objects
        countdown = 5;
        while (countdown > 0) {
            tp.transactions.add(Randomizer.randomBLObject());
            countdown--;
        }

        //Add Account Credit - generating 2 random objects
        countdown = 2;
        while (countdown > 0) {
            tp.transactions.add(Randomizer.randomAACObject());
            countdown--;
        }

        //Add Game Credit - generating 5 random objects
        countdown = 5;
        while (countdown > 0) {
            tp.transactions.add(Randomizer.randomAGCObject());
            countdown--;
        }

        return tp;

    }


    //Create a show Transaction function
    //Use log to show the details of the Transaction ArrayList

    public static void listTransactionObjects(TransactionProcessing tp) {
        String transactionsList = "";
        for (Transaction i : tp.transactions) {
            transactionsList += "\n" + i;
        }
        logger.log(Level.INFO, transactionsList);
    }

    //Create a another show transactions
    //
    //The function will accept Transaction Types as a parameter
    //
    //The function will print the Transactions based on the type passed
    //
    //Use log to display the content

    public static void listTransactionsByType(TransactionProcessing tp, EnumClass type) {
        switch (type) {
            case MONEY_TRANSFER: {
                String infoList = "";
                for (Transaction i : tp.transactions) {
                    if (i instanceof Money_transfer) {
                        infoList += "\n" + i.toString();

                    }
                }
                logger.log(Level.INFO, infoList);
                break;
            }
            case BILLS_PAYMENT: {
                String infoList = "";
                for (Transaction i : tp.transactions) {
                    if (i instanceof Bills) {
                        infoList += "\n" + i.toString();

                    }
                }
                logger.log(Level.INFO, infoList);
                break;
            }
            case BUY_LOAD: {
                String infoList = "";
                for (Transaction i : tp.transactions) {
                    if (i instanceof Buy_loads) {
                        infoList += "\n" + i.toString();

                    }
                }
                logger.log(Level.INFO, infoList);
                break;
            }
            case ADD_ACCOUNT_CREDITS: {
                String infoList = "";
                for (Transaction i : tp.transactions) {
                    if (i instanceof Add_account_credits) {
                        infoList += "\n" + i.toString();

                    }
                }
                logger.log(Level.INFO, infoList);
                break;
            }
            case ADD_GAME_CREDITS: {
                String infoList = "";
                for (Transaction i : tp.transactions) {
                    if (i instanceof Add_game_credits) {
                        infoList += "\n" + i.toString();

                    }
                }
                logger.log(Level.INFO, infoList);
                break;
            }
            default: {
                throw new IllegalArgumentException("Can't yet handle " + type);

            }
        }
    }

}

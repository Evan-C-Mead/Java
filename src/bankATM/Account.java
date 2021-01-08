package bankATM;

import java.util.ArrayList;

public class Account {

    private String accountType;
    private String uuID;
    private Customer holder;
    private ArrayList<Transaction> transactions;

    public Account(String accountType, Customer holder, Bank theBank) {
        this.accountType = accountType;
        this.holder = holder;
        this.uuID = theBank.getNewAccountUUID();
        this.transactions = new ArrayList<Transaction>();
    }

    public String getUUID() {
        return this.uuID;
    }

    public String getSummaryLine() {
        double balance = this.getBalance();

        if (balance >= 0) {
            return String.format("%s : $%.02f : %s", this.uuID, balance, this.accountType);
        } else {
            return String.format("%s : $(%.02f) : %s", this.uuID, balance, this.accountType);
        }
    }

    public double getBalance() {
        double balance = 0;

        for (Transaction transaction : this.transactions) {
            balance += transaction.getAmount();
        }
        return balance;
    }

}

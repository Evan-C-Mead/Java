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
        holder.addAccount(this); // <-- adds to holder list
        theBank.addAccount(this); // <-- adds to bank list
    }

    public String getUUID() {
        return this.uuID;
    }

}

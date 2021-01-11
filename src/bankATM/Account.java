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
            return String.format("$%.02f | %s | Account #%s", balance, this.accountType, this.uuID);
        } else {
            return String.format("$(%.02f) | %s | Account #%s", balance, this.accountType, this.uuID);
        }
    }

    public double getBalance() {
        double balance = 0;

        for (Transaction transaction : this.transactions) {
            balance += transaction.getAmount();
        }
        return balance;
    }

    public void printTransactionHistory() {
        System.out.printf("\nTransaction history for account %s\n", this.uuID);
        for (int t = this.transactions.size() - 1; t >= 0; t--) {
            System.out.println(this.transactions.get(t).getSummaryLine());
        }
        System.out.println();
    }

    public void addTransaction(double amount, String memo) {
        Transaction newTransaction = new Transaction(amount, memo, this);
        this.transactions.add(newTransaction);
    }

}

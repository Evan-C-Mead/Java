package bankATM;

import java.util.ArrayList;
import java.util.Random;

public class Bank {

    private String name;
    private ArrayList<Customer> customers;
    private ArrayList<Account> accounts;

    public String getNewCustomerUUID() {
        String uuID;
        Random rng = new Random();
        int length = 6;
        boolean nonUnique;

        do {
            uuID = "";
            for (int i = 0; i < length; i++) {
                uuID += ((Integer)rng.nextInt(10)).toString();
            }
            nonUnique = false;
            for (Customer customer : this.customers) {
                if (uuID.compareTo(customer.getUUID()) == 0) {
                    nonUnique = true;
                    break;
                }
            }
        } while (nonUnique);
        return uuID;
    }

    public String getNewAccountUUID() {
        String uuID;
        Random rng = new Random();
        int length = 10;
        boolean nonUnique;

        do {
            uuID = "";
            for (int i = 0; i < length; i++) {
                uuID += ((Integer)rng.nextInt(10)).toString();
            }
            nonUnique = false;
            for (Account account : this.accounts) {
                if (uuID.compareTo(account.getUUID()) == 0) {
                    nonUnique = true;
                    break;
                }
            }
        } while (nonUnique);
        return uuID;
    }

    public void addAccount(Account account) {
        this.accounts.add(account);
    }

}

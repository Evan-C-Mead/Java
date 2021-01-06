package bankATM;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Random;

public class Bank {

    private String name;
    private ArrayList<Customer> customers;
    private ArrayList<Account> accounts;
    private byte[] pinHash;

    public Bank(String name) {
        this.name = name;
        this.customers = new ArrayList<Customer>();
        this.accounts = new ArrayList<Account>();
    }

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

    public Customer addCustomer(String firstName, String lastName, String pin) {
        Customer newCustomer = new Customer(firstName, lastName, pin, this);
        this.customers.add(newCustomer);

        Account newAccount = new Account("Savings", newCustomer, this); // <-- creates Customer Savings account
        newCustomer.addAccount(newAccount);
        this.addAccount(newAccount);

        return newCustomer;
    }

    public Customer customerLogin(String customerID, String pin) {
        for (Customer customer : this.customers) {
            if (customer.getUUID().compareTo(customerID) == 0 && customer.validatePin(pin)) {
                return customer;
            }
        }
        return null;
    }

}

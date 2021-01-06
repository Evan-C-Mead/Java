package bankATM;

import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.security.MessageDigest;

public class Customer {

    private String firstName;
    private String lastName;
    private String uuID; // <-- MD5 hash of customer pin
    private byte pinHash[];
    private ArrayList<Account> accounts;

    public Customer(String firstName, String lastName, String pin, Bank theBank) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.uuID = theBank.getNewCustomerUUID();

        // store the pin MD5 hash, rather than the original value for security
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            this.pinHash = md.digest(pin.getBytes());
        } catch (NoSuchAlgorithmException e) {
            System.out.println("error, caught NoSuchAlgorithmException");
            e.printStackTrace();
            System.exit(1);
        }

        this.accounts = new ArrayList<Account>();

        System.out.printf("New customer %s, %s with ID %s created.\n", firstName, lastName, this.uuID);
    }

    public void addAccount(Account account) {
        this.accounts.add(account);
    }

    public String getUUID() {
        return this.uuID;
    }

}

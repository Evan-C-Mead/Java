package bankATM;

import java.util.Scanner;

public class ATM {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Bank theBank = new Bank("Bank of (not) America");

        Customer newCustomer1 = theBank.addCustomer("Craig", "Baldwin", "1234");

        Account newAccount = new Account("Checking", newCustomer1, theBank);
        newCustomer1.addAccount(newAccount);
    }

}

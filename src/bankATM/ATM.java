package bankATM;

import java.util.Scanner;

public class ATM {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Bank theBank = new Bank("Bank of (not) America");

        Customer newCustomer1 = theBank.addCustomer("Craig", "Baldwin", "1234");

        Account newAccount = new Account("Checking", newCustomer1, theBank);
        newCustomer1.addAccount(newAccount);
        theBank.addAccount(newAccount);

        Customer currentCustomer;
        while (true) {
            currentCustomer = ATM.mainMenuPrompt(theBank, sc); // <-- stay in the login prompt until successful login
            ATM.printCustomerMenu(currentCustomer, sc); // <-- stay in main menu until customer/user quits
        }
    }

    public static Customer mainMenuPrompt(Bank theBank, Scanner sc) {
        String customerID;
        String pin;
        Customer authorizedCustomer;

        do {
            System.out.printf("\nWelcome to %s\n", theBank.getName());
            System.out.println("Enter your customer ID: ");
            customerID = sc.nextLine();
            System.out.println("Enter pin: ");
            pin = sc.nextLine();
            authorizedCustomer = theBank.customerLogin(customerID, pin);
            if (authorizedCustomer == null) {
                System.out.println("Incorrect ID/pin combination...Please try again.");
            }
        } while (authorizedCustomer == null);
        return authorizedCustomer;
    }

    public static void printCustomerMenu(Customer customer, Scanner sc) {
        customer.printAccountsSummary();
        int option;

        do {
            System.out.printf("Welcome %s! What would you like to to do?", customer.getFirstName());
            System.out.println("1 - View account history");
            System.out.println("2 - Withdraw");
            System.out.println("3 - Deposit");
            System.out.println("4 - Transfer money between accounts");
            System.out.println("5 - Quit");
            System.out.println();
            System.out.println("Enter an option [ 1, 2, 3, 4 or 5 ]");
            option = sc.nextInt();
            if (option < 1 || option > 5) {
                System.out.println("Enter a valid option [ 1, 2, 3, 4 or 5 ]");
            }
        } while (option < 1 || option > 5);
        switch (option) {
            case 1:
                ATM.showTransactionHistory(customer, sc);
                break;
            case 2:
                ATM.withdrawFunds(customer, sc);
                break;
            case 3:
                ATM.depositFunds(customer, sc);
                break;
            case 4:
                ATM.transferFunds(customer, sc);
                break;
        }
        if (option != 5) {
            ATM.printCustomerMenu(customer, sc);
        }
    }

}

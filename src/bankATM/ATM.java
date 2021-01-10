package bankATM;

import java.util.Scanner;

public class ATM {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Bank theBank = new Bank("Bank of (not) America");

        Customer newCustomer1 = theBank.addCustomer("Craig", "Baldwin", "1234");
        Account newAccount1 = new Account("Checking", newCustomer1, theBank);
        newCustomer1.addAccount(newAccount1);
        theBank.addAccount(newAccount1);

        Customer newCustomer2 = theBank.addCustomer("Jules", "Franklin", "1234");
        Account newAccount2 = new Account("Checking", newCustomer2, theBank);
        newCustomer2.addAccount(newAccount2);
        theBank.addAccount(newAccount2);

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
            System.out.printf("\nWelcome to %s\n\n", theBank.getName());
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
        int option;

        do {
            System.out.printf("\nWelcome %s! What would you like to to do?\n", customer.getFirstName());
            customer.printAccountsSummary();
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
            case 5:
                sc.nextLine();
                break;
        }
        if (option != 5) {
            ATM.printCustomerMenu(customer, sc);
        }
    }

    public static void showTransactionHistory(Customer customer, Scanner sc) {
        int theAccount;

        do {
            System.out.printf("Enter the number (1 - %d) of the account you want to see transactions for:\n", customer.numberAccounts());
            theAccount = sc.nextInt() - 1;
            if (theAccount < 0 || theAccount >= customer.numberAccounts()) {
                System.out.println("Invalid account. Please try again.");
            }
        } while (theAccount < 0 || theAccount >= customer.numberAccounts());
        customer.printAccountTransactionHistory(theAccount);
    }

    public static void withdrawFunds(Customer customer, Scanner sc) {
        int fromAccount;
        double amount;
        double accountBalance;
        String memo;

        do {
            System.out.printf("Enter the number (1 - %d) of the account you want to withdraw funds from:\n", customer.numberAccounts());
            fromAccount = sc.nextInt() - 1;
            if (fromAccount < 0 || fromAccount >= customer.numberAccounts()) {
                System.out.println("Invalid account. Please try again.");
            }
        } while (fromAccount < 0 || fromAccount >= customer.numberAccounts());
        accountBalance = customer.getAccountBalance(fromAccount);

        do {
            System.out.print("Enter the amount to withdraw:\n$");
            amount = sc.nextDouble();
            if (amount < 0) {
                System.out.println("Amount must be greater than $0.00");
            } else if (amount > accountBalance) {
                System.out.printf("Amount cannot be greater than balance of $%.02f\n", accountBalance);
            }
        } while (amount < 0 || amount > accountBalance);
        sc.nextLine();
        System.out.println("Enter a memo: ");
        memo = sc.nextLine();
        customer.addAccountTransaction(fromAccount, -1 * amount, memo);
    }

    public static void depositFunds(Customer customer, Scanner sc) {
        int toAccount;
        double amount;
        double accountBalance;
        String memo;

        do {
            System.out.printf("Enter the number (1 - %d) of the account you want to deposit funds into:\n", customer.numberAccounts());
            toAccount = sc.nextInt() - 1;
            if (toAccount < 0 || toAccount >= customer.numberAccounts()) {
                System.out.println("Invalid account. Please try again.");
            }
        } while (toAccount < 0 || toAccount >= customer.numberAccounts());
        accountBalance = customer.getAccountBalance(toAccount);

        do {
            System.out.print("Enter the amount to deposit:\n$");
            amount = sc.nextDouble();
            if (amount < 0) {
                System.out.println("Amount must be greater than $0.00");
            }
        } while (amount < 0);
        sc.nextLine();
        System.out.println("Enter a memo: ");
        memo = sc.nextLine();
        customer.addAccountTransaction(toAccount, amount, memo);
    }

    public static void transferFunds(Customer customer, Scanner sc) {
        int fromAccount;
        int toAccount;
        double amount;
        double accountBalance;

        do {
            System.out.printf("Enter the number (1 - %d) of the account you want to transfer funds from:\n", customer.numberAccounts());
            fromAccount = sc.nextInt() - 1;
            if (fromAccount < 0 || fromAccount >= customer.numberAccounts()) {
                System.out.println("Invalid account. Please try again.");
            }
        } while (fromAccount < 0 || fromAccount >= customer.numberAccounts());
        accountBalance = customer.getAccountBalance(fromAccount);

        do {
            System.out.printf("Enter the number (1 - %d) of the account you want to transfer funds to:\n", customer.numberAccounts());
            toAccount = sc.nextInt() - 1;
            if (toAccount < 0 || toAccount >= customer.numberAccounts()) {
                System.out.println("Invalid account. Please try again.");
            }
        } while (toAccount < 0 || toAccount >= customer.numberAccounts());

        do {
            System.out.print("Enter the amount to transfer:\n$");
            amount = sc.nextDouble();
            if (amount < 0) {
                System.out.println("Amount must be greater than $0.00");
            } else if (amount > accountBalance) {
                System.out.printf("Amount cannot be greater than balance of $%.02f\n", accountBalance);
            }
        } while (amount < 0 || amount > accountBalance);
        customer.addAccountTransaction(fromAccount, -1 * amount, String.format("Transfer to account %s", customer.getAccountUUID(toAccount)));
        customer.addAccountTransaction(toAccount, amount, String.format("Transfer to account %s", customer.getAccountUUID(fromAccount)));
    }

}

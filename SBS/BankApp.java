package SBS;

import java.util.ArrayList;
import java.util.Scanner;

public class BankApp {

    // Helper method to find account by account number
    public static Account findAccount(ArrayList<Account> accounts, String accountNo) {
        for (Account acc : accounts) {
            if (acc.getAccountNo().equals(accountNo)) {
                return acc;
            }
        }
        // Not found
        return null;
    }

    public static void main(String[] args) {

        // Scanner object for User Input
        Scanner scan = new Scanner(System.in);

        // All user account
        ArrayList<Account> accounts = new ArrayList<>();

        boolean exit = false;

        // Show Menu
        while (!exit) {
            System.out.println("Bank Menu");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5.Show All Accounts");
            System.out.println("6. Exit");
            System.out.println("Enter choice: ");

            int choice = scan.nextInt();
            scan.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Enter the account number");
                    String accountNo = scan.next();
                    scan.nextLine();
                    System.out.println("Enter the name");
                    String name = scan.nextLine();

                    if (findAccount(accounts, accountNo) != null) {
                        System.out.println("Account number already exists!");
                    } else {
                        Account newAccount = new Account(accountNo, name, 0);
                        accounts.add(newAccount);
                        System.out.println("Account created successfully");
                    }
                    break;

                case 2:
                    System.out.println("Enter account number");
                    accountNo = scan.nextLine();
                    Account depositAccount = findAccount(accounts, accountNo);

                    if (depositAccount == null) {
                        System.out.println("Account not found");
                    } else {
                        System.out.println("Enter amount to deposit: ");
                        double amount = scan.nextDouble();
                        scan.nextLine();
                        if (amount > 0) {
                            depositAccount.deposit(amount);
                        } else {
                            System.out.println("Amount must be positive!");
                        }
                    }
                    break;

                case 3:
                    System.out.println("Enter account number: ");
                    accountNo = scan.nextLine().trim();
                    Account withdrawAccount = findAccount(accounts, accountNo);

                    if (withdrawAccount == null) {
                        System.out.println("Account not found");
                    } else {
                        System.out.println("Enter amount to withdraw: ");
                        double amount = scan.nextDouble();
                        scan.nextLine();
                        if (amount > 0) {
                            withdrawAccount.withdraw(amount);
                        } else {
                            System.out.println("Amount must be positive!");
                        }
                    }
                    break;

                case 4:
                    System.out.println("Enter account number: ");
                    accountNo = scan.nextLine();
                    Account checkAccount = findAccount(accounts, accountNo);

                    if (checkAccount == null) {
                        System.out.println("Account not found!");
                    } else {
                        checkAccount.checkBalance();
                    }
                    break;
                case 5:
                    if (accounts.isEmpty()) {
                        System.out.println("No accounts available.");
                    } else {
                        System.out.println("All Accounts");
                        for (Account acc : accounts) {
                            System.out.println(acc);
                        }
                    }
                    break;
                case 6:
                    exit = true;
                    System.out.println("Thank you for using the bank!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        }
        scan.close();
    }
}

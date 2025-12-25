package SBS;

public class Account {
    // Fields
    private String accountNo;
    private String name;
    private double balance;

    // Constructor
    public Account(String accountNumber, String name, double balance) {
        this.accountNo = accountNumber;
        this.name = name;
        this.balance = balance;
    }

    // Getter and Setter methods

    // AccountNo
    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    // Name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Balance
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    // Methods

    // Deposite Method
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
    }

    // Withdraw Method
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient Balance!");
        }
    }

    // CheckBalance
    public void checkBalance() {
        System.out.println("Current Balance: " + balance);
    }

    // ToString Method
    @Override
    public String toString() {
        return "Account Number: " + accountNo +
                ", Name: " + name +
                ", Balance: " + balance;
    }
}

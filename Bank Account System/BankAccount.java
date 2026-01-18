

// File: BankAccount.java
import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    private String accountNumber;
    private String accountHolder;
    private double balance;
    private List<String> transactionHistory;

    // Constructor
    public BankAccount(String accountNumber, String accountHolder, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
        transactionHistory.add("Account created with balance: " + initialBalance);
    }

    // Deposit method
    public void deposit(double amount) {
        if(amount <= 0) throw new IllegalArgumentException("Deposit amount must be positive.");
        balance += amount;
        transactionHistory.add("Deposited: " + amount + ", New Balance: " + balance);
    }

    // Withdraw method
    public void withdraw(double amount) {
        if(amount <= 0) throw new IllegalArgumentException("Withdrawal amount must be positive.");
        if(amount > balance) throw new IllegalArgumentException("Insufficient balance.");
        balance -= amount;
        transactionHistory.add("Withdrawn: " + amount + ", New Balance: " + balance);
    }

    // Get current balance
    public double getBalance() {
        return balance;
    }

    // Get transaction history
    public List<String> getTransactionHistory() {
        return transactionHistory;
    }

    // Get account details
    public String getAccountDetails() {
        return "Account Number: " + accountNumber + ", Account Holder: " + accountHolder + ", Balance: " + balance;
    }
}


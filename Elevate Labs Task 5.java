import java.util.List;
import java.util.ArrayList;

// Interface for bank account operations
interface account {
    void deposit(double amount);

    void withdraw(double amount);

    double getBalance();
}

// Implementation of the bank account interface
class bank implements account {

    private String accountNumber;
    private double balance;
    private List<String> transactionHistory = new ArrayList<>();

    // Default constructor
    public bank() {
        this.accountNumber = "";
        this.balance = 0.0;
    }

    // Parameterized constructor
    public bank(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        transactionHistory.add("Deposited: " + amount);
    }

    @Override
    public void withdraw(double amount) {
        balance -= amount;
        transactionHistory.add("Withdrew: " + amount);
    }

    public void getTransactionHistory() {
        for (String t : transactionHistory) {
            System.out.println(t);
        }
    }

    @Override
    public double getBalance() {
        return balance;
    }

    // Main method to test the bank account functionality
    public static void main(String[] args) {
        bank myBank = new bank("123456789", 1000.0);
        System.out.println("Opening Balance: " + myBank.getBalance());
        myBank.deposit(500.0);
        myBank.withdraw(200.0);
        myBank.deposit(300.0);
        System.out.println("Transaction History:");
        myBank.getTransactionHistory();
        System.out.println("Current Balance: " + myBank.getBalance());
    }
}

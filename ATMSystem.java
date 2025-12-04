import java.util.Scanner;


class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Amount Deposited Successfully!");
    }

    public boolean withdraw(double amount) {
        if (amount > balance) {
            return false; 
        } else {
            balance -= amount;
            return true;
        }
    }

    public double getBalance() {
        return balance;
    }
}


class ATM {
    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account; 
    }

    public void showMenu() {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== ATM MACHINE =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Amount");
            System.out.println("3. Withdraw Amount");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    checkBalance();
                    break;

                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = sc.nextDouble();
                    deposit(depositAmount);
                    break;

                case 3:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = sc.nextDouble();
                    withdraw(withdrawAmount);
                    break;

                case 4:
                    System.out.println("Thank you for using ATM!");
                    break;

                default:
                    System.out.println("Invalid Choice! Try again.");
            }

        } while (choice != 4);
    }

    

    public void checkBalance() {
        System.out.println("Your Current Balance: " + account.getBalance());
    }

    public void deposit(double amount) {
        if (amount <= 0) { 
            System.out.println("Invalid Amount!");
        } else {
            account.deposit(amount);
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid Amount!");
        } else if (account.withdraw(amount)) {
            System.out.println("Withdrawal Successful!");
        } else {
            System.out.println("Insufficient Balance!");
        }
    }
}


public class ATMSystem {
    public static void main(String[] args) {

        // Create bank account with an initial balance
        BankAccount userAccount = new BankAccount(5000);

        // Create ATM and pass user's account
        ATM atm = new ATM(userAccount);

        // Start ATM menu
        atm.showMenu();
    }
}
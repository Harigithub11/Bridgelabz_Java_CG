package objectoriented.programmingfundamentals.level2;

import java.util.Scanner;

public class BankAccount {
    private String accountNumber;
    private String accountHolderName;
    private double balance;

    public BankAccount() {
    }

    public BankAccount(String accountNumber, String accountHolderName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = initialBalance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited: $" + amount);
            System.out.println("New Balance: $" + balance);
        } else {
            System.out.println("Invalid deposit amount. Amount must be positive.");
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount. Amount must be positive.");
        } else if (amount > balance) {
            System.out.println("Insufficient balance. Available balance: $" + balance);
        } else {
            balance -= amount;
            System.out.println("Successfully withdrawn: $" + amount);
            System.out.println("Remaining Balance: $" + balance);
        }
    }

    public void checkBalance() {
        System.out.println("Current Balance: $" + balance);
    }

    public void displayAccountInfo() {
        System.out.println("\n--- Account Information ---");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Balance: $" + balance);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Account Number: ");
        String accountNumber = scanner.nextLine();

        System.out.print("Enter Account Holder Name: ");
        String accountHolderName = scanner.nextLine();

        System.out.print("Enter Initial Balance: ");
        double initialBalance = scanner.nextDouble();

        BankAccount account = new BankAccount(accountNumber, accountHolderName, initialBalance);

        int choice;
        do {
            System.out.println("\n--- ATM Menu ---");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Display Account Info");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 3:
                    account.checkBalance();
                    break;
                case 4:
                    account.displayAccountInfo();
                    break;
                case 5:
                    System.out.println("Thank you for using ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }
}

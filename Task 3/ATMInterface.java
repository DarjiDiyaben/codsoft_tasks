import java.util.Scanner;

class BankAccount {
    private double balance;

    BankAccount(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance = balance + amount;
            System.out.println("Amount deposited successfully.");
        } else {
            System.out.println("Invalid amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount.");
        } else if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            balance = balance - amount;
            System.out.println("Please collect your cash.");
            System.out.println("Withdrawal successful.");
        }
    }

    public void checkBalance() {
        System.out.println("Current Balance = Rs. " + balance);
    }
}

class ATM {
    private BankAccount account;
    private Scanner sc = new Scanner(System.in);

    ATM(BankAccount account) {
        this.account = account;
    }

    public void startATM() {
        int choice;

        do {
            System.out.println("\n===== ATM INTERFACE =====");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = sc.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;

                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = sc.nextDouble();
                    account.deposit(depositAmount);
                    break;

                case 3:
                    account.checkBalance();
                    break;

                case 4:
                    System.out.println("Thank you for using ATM.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 4);
    }
}

public class ATMInterface {
    public static void main(String[] args) {

        // Create bank account with initial balance
        BankAccount account = new BankAccount(10000);

        // Connect ATM with bank account
        ATM atm = new ATM(account);

        // Start ATM
        atm.startATM();
    }
}

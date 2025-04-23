import java.util.Scanner;

public class ATM {
    private final BankAccount account;
    private final Scanner scanner;

    public ATM(BankAccount account) {
        this.account = account;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        int choice;
        do {
            displayMenu();
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> handleWithdrawal();
                case 2 -> handleDeposit();
                case 3 -> checkBalance();
                case 4 -> System.out.println("Thank you for using the ATM!");
                default -> System.out.println("Invalid option. Please try again.");
            }

        } while (choice != 4);
    }

    private void displayMenu() {
        System.out.println("\n===== ATM Menu =====");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    private void handleWithdrawal() {
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();
        if (account.withdraw(amount)) {
            System.out.println("Withdrawal successful! Amount: $" + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    private void handleDeposit() {
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();
        if (account.deposit(amount)) {
            System.out.println("Deposit successful! Amount: $" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    private void checkBalance() {
        System.out.println("Current balance: $" + account.getBalance());
    }
}

import java.util.*;

public class BankingInformationSystem {
    
    static class Account {
        private int accountNumber;
        private String holderName;
        private double balance;

        public Account(int accountNumber, String holderName, double balance) {
            this.accountNumber = accountNumber;
            this.holderName = holderName;
            this.balance = balance;
        }

        public int getAccountNumber() {
            return accountNumber;
        }

        public String getHolderName() {
            return holderName;
        }

        public double getBalance() {
            return balance;
        }

        public void deposit(double amount) {
            if (amount > 0) {
                balance += amount;
                System.out.println("Successfully deposited ₹" + amount);
            } else {
                System.out.println("Invalid deposit amount.");
            }
        }

        public void withdraw(double amount) {
            if (amount > 0 && amount <= balance) {
                balance -= amount;
                System.out.println("Successfully withdrawn ₹" + amount);
            } else {
                System.out.println("Insufficient balance or invalid amount.");
            }
        }

        public void displayDetails() {
            System.out.println("\nAccount Number: " + accountNumber);
            System.out.println("Holder Name: " + holderName);
            System.out.println("Balance: ₹" + balance);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<Integer, Account> accounts = new HashMap<>();
        int nextAccountNumber = 1001;
        boolean running = true;

        System.out.println("===========================================");
        System.out.println("     BANKING INFORMATION SYSTEM (NIVEDHA)  ");
        System.out.println("===========================================");

        while (running) {
            System.out.println("\n1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Display Account Details");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    sc.nextLine(); // consume newline
                    System.out.print("Enter Account Holder Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Initial Deposit: ");
                    double initialDeposit = sc.nextDouble();
                    Account acc = new Account(nextAccountNumber, name, initialDeposit);
                    accounts.put(nextAccountNumber, acc);
                    System.out.println("Account created successfully! Your Account Number is " + nextAccountNumber);
                    nextAccountNumber++;
                    break;

                case 2:
                    System.out.print("Enter Account Number: ");
                    int accNoDep = sc.nextInt();
                    if (accounts.containsKey(accNoDep)) {
                        System.out.print("Enter Deposit Amount: ");
                        double depAmt = sc.nextDouble();
                        accounts.get(accNoDep).deposit(depAmt);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter Account Number: ");
                    int accNoWith = sc.nextInt();
                    if (accounts.containsKey(accNoWith)) {
                        System.out.print("Enter Withdrawal Amount: ");
                        double withAmt = sc.nextDouble();
                        accounts.get(accNoWith).withdraw(withAmt);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter Account Number: ");
                    int accNoBal = sc.nextInt();
                    if (accounts.containsKey(accNoBal)) {
                        System.out.println("Current Balance: ₹" + accounts.get(accNoBal).getBalance());
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 5:
                    System.out.print("Enter Account Number: ");
                    int accNoDet = sc.nextInt();
                    if (accounts.containsKey(accNoDet)) {
                        accounts.get(accNoDet).displayDetails();
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 6:
                    running = false;
                    System.out.println("Thank you for using the Banking Information System!");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
        sc.close();
    }
}

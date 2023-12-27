package AnudipProject;

import java.util.Scanner;

public class BankAppicationWithExceptionHandling {
    public static void main(String[] args) {
        int balance, choice;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Your name: ");
        String name=sc.next();
        System.out.println("Enter balance to create account: ");
        balance = sc.nextInt();
        
        Account acc = new Account(balance);
        System.out.println("Enter\n1 to withdraw amount\n2 to deposit amount\n0 to exit");
        choice = sc.nextInt();
        while (choice == 1 || choice == 2) {
            if (choice == 1)
                acc.withdraw();
            else if (choice == 2)
                acc.deposit();
            System.out.println("Enter\n1 to withdraw amount\n2 to deposit amount\n0 to exit");
            choice = sc.nextInt();
        }
    }

}

class Account {
    int balance;
    Scanner sc = new Scanner(System.in);

    public Account(int balance) {
        this.balance = balance;
    }

    void withdraw() {
        int amount;
        System.out.println("Enter amount to be withdrawn");
        amount = sc.nextInt();
        try {
            if (amount < 1)
                throw new InvalidAmountExp();
            else if (amount > balance)
                throw new MinimumBalExp();
            else {
                balance = balance-amount;
                System.out.println("Amount is withdrawn, Now your Current Balance is= " + balance);
            }
        } catch (InvalidAmountExp i) {
            System.out.println(i.getMessage());
        } catch (MinimumBalExp m) {
            System.out.println(m.getMessage());
        } catch (Exception e) {
            System.out.println("Exception occured");
        }
    }

    void deposit() {
        int amount;
        System.out.println("Enter amount to be deposited");
        amount = sc.nextInt();
        try {
            if (amount < 1)
                throw new InvalidAmountExp();
            else {
                balance = balance +amount;
                System.out.println("Amount deposited, now your current balance is= " + balance);
            }
        } catch (InvalidAmountExp i) {
            System.out.println(i.getMessage());
        } catch (Exception e) {
            System.out.println("Exception occured");
        }
    }

}

class InvalidAmountExp extends Exception {
    public String getMessage() {
        return "Entered amount is invalid";
    }
}

class MinimumBalExp extends Exception {
    public String getMessage() {
        return "Entered amount is more than current balance, amount withdraw failed";
    }
}


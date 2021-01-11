package applications;

import model.entities.Account;
import model.exception.AccountException;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String args[]) {

        Locale.setDefault(Locale.US);
        Scanner input = new Scanner(System.in);


        System.out.println("Enter account data:");
        System.out.print("Number: ");
        Integer number = input.nextInt();
        System.out.print("Holder: ");
        input.nextLine();
        String holder = input.nextLine();
        System.out.print("Initial balance: ");
        double balance = input.nextDouble();
        System.out.print("Withdraw limit: ");
        double withdraw = input.nextDouble();
        Account acc = new Account(number, holder, balance, withdraw);

        System.out.println();
        System.out.print("Enter amount for withdraw: ");
        double amount = input.nextDouble();
        try {
            acc.withdraw(amount);
            System.out.println("New balance: " + String.format("%.2f", acc.getBalance()));
        } catch (AccountException e) {
            System.out.println("Withdraw error: " + e.getMessage());
        }
        input.close();
    }
}

package banking.app;

import com.sun.javafx.css.SizeUnits;
import java.util.Scanner;
import javax.sound.sampled.FloatControl;

public class BankingApp {

    public static void main(String[] args) {

        Customer[] c = new Customer[3];
        c[0] = new Customer("Bruce", "Wayne", "Brampton", "bWayne", 12345);
        c[1] = new Customer("Thanos", "Badman", "North York", "tBadman", 56789);
        c[2] = new Customer("Wonder", "Woman", "Oakville", "wWoman", 39087);

        Account[] a = new Account[4];
        a[0] = new SavingsAccount(1, c[0], 500, "Savings");
        a[1] = new SavingsAccount(2, c[1], 1000.00, "Savings");
        a[2] = new CheckingAccount(3, c[2], 500000.00, "Checking", 1500);
        a[3] = new CheckingAccount(4, c[0], 400000.00, "Checking", 10000);

        Scanner read = new Scanner(System.in);
        String usernm;
        int pwd;

        for (int i = 0; i < 5; i++) {//giving user five attempts to enter wrong username or password
            System.out.println("Please enter your username:");
            usernm = read.next();
            System.out.println("Please enter your password:");
            pwd = read.nextInt();
            int count = 0;
            for (int j = 0; j < c.length; j++) {
                if (c[j].getUserName().equals(usernm) && c[j].getPassword() == pwd) {
                    System.out.println("\nWelcome, " + c[j]);
                    System.out.println("Account Type:");
                    System.out.println("Enter ‘C’ or ‘c’ for Checkings Account\n"
                            + "Enter ‘S’ or ‘s’ for Savings Account");
                    char ch = read.next().charAt(0);
                    if (ch == 'S' || ch == 's') {
                        for (int k = 0; k < a.length; k++) {
                            if (a[k].getType().equals("Savings") && a[k].getCustomer().equals(c[j])) {
                                char op = 0;
                                while (op != 'x' && op != 'X') {
                                    System.out.println("Name: " + a[k].getCustomer());
                                    System.out.println("Balance: " + a[k].getBalance());
                                    System.out.println("Account type: " + a[k].getType());
                                    System.out.println("\nOperation:");

                                    System.out.println("Enter D or ‘d’  to deposit\n"
                                            + "Enter W or ‘w’  to withdraw\n"
                                            + "Enter x or ‘X’  to exit app");
                                    op = read.next().charAt(0);
                                    if (op == 'd' || op == 'D') {
                                        System.out.println("Enter amount to Deposit:");
                                        double dep = read.nextDouble();
                                        a[k].deposit(dep);
                                    } else if (op == 'w' || op == 'W') {
                                        System.out.println("Enter amount to Withdraw:");
                                        double wd = read.nextDouble();
                                        a[k].withdraw(wd);
                                    }
                                }
                                break;
                            }
                        }
                    } else if (ch == 'C' || ch == 'c') {
                        for (int k = 0; k < a.length; k++) {
                            if (a[k].getType().equals("Checking") && a[k].getCustomer().equals(c[j])) {
                                char op = 0;
                                while (op != 'x' && op != 'X') {
                                    System.out.println("Name: " + a[k].getCustomer());
                                    System.out.println("Balance: " + a[k].getBalance());
                                    System.out.println("Account type: " + a[k].getType());
                                    System.out.println("\nOperation:");

                                    System.out.println("Enter D or ‘d’  to deposit\n"
                                            + "Enter W or ‘w’  to withdraw\n"
                                            + "Enter x or ‘X’  to exit app");
                                    op = read.next().charAt(0);
                                    if (op == 'd' || op == 'D') {
                                        System.out.println("Enter amount to Deposit:");
                                        double dep = read.nextDouble();
                                        a[k].deposit(dep);
                                    } else if (op == 'w' || op == 'W') {
                                        System.out.println("Enter amount to Withdraw:");
                                        double wd = read.nextDouble();
                                        a[k].withdraw(wd);
                                    }
                                }
                                break;
                            }
                        }
                    }
                    count++;
                    break;
                }
            }
            if (count != 0) {
                return;
            }
        }
    }
}

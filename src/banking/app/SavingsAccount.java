package banking.app;

public class SavingsAccount extends Account {

    public SavingsAccount() {
    }

    public SavingsAccount(int accountNo, Customer customer, double balance, String type) {
        super(accountNo, customer, balance, type);
    }

    @Override
    public void withdraw(double amt) {
        if (amt > getBalance()) {
            System.out.println("The amount you are trying to withdraw exceeds your current balance");
        } else {
            setBalance(getBalance() - amt);
        }
    }
}

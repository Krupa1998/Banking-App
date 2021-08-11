package banking.app;

public class CheckingAccount extends Account {

    private double overdraft;

    public CheckingAccount() {
    }

    public CheckingAccount(int accountNo, Customer customer, double balance, String type, double overdraft) {
        super(accountNo, customer, balance, type);
        this.overdraft = overdraft;
    }

    public double getOverdraft() {
        return overdraft;
    }

    public void setOverdraft(double overdraft) {
        this.overdraft = overdraft;
    }

    @Override
    public void withdraw(double amt) {
        if (amt > (getBalance() + this.overdraft)) {
            System.out.println("The amount you are trying to withdraw exceeds your overdraft limit");
        } else {
            setBalance(getBalance() - amt);
        }
    }
}

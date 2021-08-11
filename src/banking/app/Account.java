package banking.app;

public abstract class Account {

    private int accountNo;
    private Customer customer;
    private double balance;
    private String type;

    public Account() {

    }
    
    public Account(int accountNo, Customer customer, double balance, String type) {
        this.accountNo = accountNo;
        this.customer = customer;
        this.balance = balance;
        this.type = type;
    }

    public int getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(int accountNo) {
        this.accountNo = accountNo;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void deposit(double amt) {
        this.balance += amt;
    }

    public abstract void withdraw(double amt);

}

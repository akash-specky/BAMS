package entity;


public class CheckingAccount extends Account {
    private static final double MIN_BALANCE = 1000;

    public CheckingAccount() {
    }

    public CheckingAccount(String accountId, String userId, double balance) {
        super(accountId, userId, balance);
    }

    @Override
    public void withdraw(double amount) {
        if (balance- amount < MIN_BALANCE){
            throw new IllegalArgumentException("Please enter the positive amount");
        }
        if (amount>balance){
            throw new IllegalArgumentException("Insufficient Balance");

        }
        balance -= amount;
    }
}

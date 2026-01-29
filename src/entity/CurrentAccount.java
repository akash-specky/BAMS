package entity;

public class CurrentAccount extends Account{

    public CurrentAccount() {
    }

    public CurrentAccount(String accountId, String userId, double balance) {
        super(accountId, userId, balance);
    }

    @Override
    public void withdraw(double amount) {
        if (amount<0){
            throw new IllegalArgumentException("Please enter the positive amount");
        }
        if (amount>balance){
            throw new IllegalArgumentException("Insufficient Balance");

        }
        balance -= amount;
    }
}

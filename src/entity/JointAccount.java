package entity;

public class JointAccount extends Account{

    public JointAccount(String accountId, String userId, double balance) {
        super(accountId, userId, balance);
    }

    public JointAccount() {
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

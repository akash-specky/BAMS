package entity;

public class SavingAccount extends Account{
    private static final double MIN_BALANCE = 1000;


    public SavingAccount(String accountId, String userId, double balance) {
        super(accountId, userId, balance);
    }

    public SavingAccount() {
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

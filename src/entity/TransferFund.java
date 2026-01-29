package entity;

public class TransferFund {
    private User user;
    private double amount;
    private String accountIdFrom;
    private String accountIdTo;

    public TransferFund(User user, double amount, String accountIdFrom, String accountIdTo) {
        this.user = user;
        this.amount = amount;
        this.accountIdFrom = accountIdFrom;
        this.accountIdTo = accountIdTo;
    }

    public TransferFund() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getAccountIdFrom() {
        return accountIdFrom;
    }

    public void setAccountIdFrom(String accountIdFrom) {
        this.accountIdFrom = accountIdFrom;
    }

    public String getAccountIdTo() {
        return accountIdTo;
    }

    public void setAccountIdTo(String accountIdTo) {
        this.accountIdTo = accountIdTo;
    }
}

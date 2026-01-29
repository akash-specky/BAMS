package entity;

import accounts.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public abstract class Account {
    protected String accountId;
    protected String userId;
    protected double balance;
    protected final List<Transaction> transactions = new ArrayList<>();
    protected AccountStatus status = AccountStatus.ACTIVE;

    public AccountStatus getStatus() {
        return status;
    }

    public Account() {
        this.accountId = UUID.randomUUID().toString();
    }

    public Account(String accountId, String userId, double balance) {
        this.accountId = accountId;
        this.userId = userId;
        this.balance = balance;
    }


    public String getAccountId() {
        return accountId;
    }

    public String getUserId() {
        return userId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount){
        validateAmount(amount);
        ensureActive();
        if (getBalance()<0){
            throw new IllegalArgumentException("Insufficient Balance");

        }
        balance += amount;
        transactions.add(new Transaction("Deposit", amount));
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
    private void validateAmount(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be greater than zero");
        }
    }
    public void close() {
        if (balance != 0) {
            throw new IllegalArgumentException(
                    "Account balance must be zero to close");
        }
        status = AccountStatus.CLOSED;
    }
    protected void ensureActive() {
        if (status != AccountStatus.ACTIVE) {
            throw new IllegalArgumentException(
                    "Account is not active: " + status);
        }
    }
    public void printStatement(Account account) {
        System.out.println("Current Balance for this Account Number: "+account.accountId+" is = " + balance);
    }

    public void freeze() {
        if (status == AccountStatus.CLOSED) {
            throw new IllegalArgumentException("Account already closed");
        }
        status = AccountStatus.FROZEN;
    }

    public abstract void withdraw(double amount);
}

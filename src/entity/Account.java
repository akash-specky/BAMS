package entity;

import accounts.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public abstract class Account {
    protected String accountId;
    protected String userId;
    protected double balance;
    protected boolean isActive = true;
    protected final List<Transaction> transactions = new ArrayList<>();

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

    public boolean isActive() {
        return isActive;
    }
    public List<Transaction> getTransactions() {
        return transactions;
    }
    private void validateAmount(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be greater than zero");
        }
    }

    private void ensureActive() {
        if (!isActive()) {
            throw new IllegalArgumentException("Account is closed");
        }
    }
    public void printStatement(Account account) {
        System.out.println("Current Balance for this Account Number: "+account.accountId+" is = " + balance);
    }
    public abstract void withdraw(double amount);
}

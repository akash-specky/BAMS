package accounts;

import entity.Account;

import javax.security.auth.login.AccountNotFoundException;
import java.util.HashMap;
import java.util.Map;

import java.util.*;

public class Bank {
    private String bankName;
    private Map<String, Account> accounts = new HashMap<>();

    public Bank(String bankName) {
        this.bankName = bankName;
    }

    public Account openAccount(Account account) {
        accounts.put(account.getAccountId(), account);
        return account;
    }

    public Account getAccount(String accountNumber) throws AccountNotFoundException {
        Account account = accounts.get(accountNumber);
        if (account == null) {
            throw new AccountNotFoundException("Account not found: " + accountNumber);
        }
        return account;
    }

    public String getBankName() {
        return bankName;
    }

    public void freezeAccount(String accountNumber) {
        try {
            getAccount(accountNumber).freeze();
        } catch (AccountNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void closeAccount(String accountNumber) {
        try {
            getAccount(accountNumber).close();
        } catch (AccountNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}


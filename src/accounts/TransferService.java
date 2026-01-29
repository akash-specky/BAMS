package accounts;

import entity.Account;

import javax.security.auth.login.AccountNotFoundException;

public interface TransferService {

    void transferWithinBank(
            Bank bank,
            String fromAcc,
            String toAcc,
            double amount) throws AccountNotFoundException;

    void transferToExternalBank(
            Account sender,
            double amount);
}

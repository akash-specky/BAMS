package accounts;

import entity.Account;

import javax.security.auth.login.AccountNotFoundException;


public class TransferServiceImpl implements TransferService {


    @Override
    public void transferWithinBank(Bank bank, String fromAcc, String toAcc, double amount) throws AccountNotFoundException {
        Account sender = bank.getAccount(fromAcc);
        Account receiver = bank.getAccount(toAcc);

        sender.withdraw(amount);
        receiver.deposit(amount);
    }

    @Override
    public void transferToExternalBank(Account sender, double amount) {

    }
}

import accounts.Bank;
import accounts.TransferService;
import accounts.TransferServiceImpl;
import entity.Account;
import entity.CheckingAccount;
import entity.SavingAccount;

import javax.security.auth.login.AccountNotFoundException;

public class BankApp {

    public static void main(String[] args) throws AccountNotFoundException {
        TransferService transferService = new TransferServiceImpl();
        Bank bank = new Bank("HDFC");


        Account a1 = bank.openAccount(new SavingAccount());
        Account a2 = bank.openAccount(new CheckingAccount());

        a1.deposit(5000);
        transferService.transferWithinBank(
                bank,
                a1.getAccountId(),
                a2.getAccountId(),
                2000
        );

        a1.printStatement(a1);
        a2.printStatement(a2);

        transferService.transferToExternalBank(a2, 500);
    }
}

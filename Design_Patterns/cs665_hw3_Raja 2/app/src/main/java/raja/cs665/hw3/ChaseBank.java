package raja.cs665.hw3;

import raja.cs665.hw3.enumTypes.AccountType;

import java.util.Date;

public class ChaseBank extends Bank{
    public ChaseBank() {
        super.getBankInstance();
    }

    @Override
    public synchronized StringBuilder createAccountStatement(AccountType accountType) {
        StringBuilder printStatement = super.createAccountStatement(accountType);
        printStatement.append("::Chase ");
        printStatement.append(accountType);
        printStatement.append((" Account"));
        return  printStatement;
    }

    public Account createAccount(String customerId, AccountType accountType,
                                 String accountId, Date openDate, int initialAmount){
        return super.createAccount(customerId, accountType, accountId, openDate, initialAmount);
    }
}

package raja.cs665.hw3;

import raja.cs665.hw3.enumTypes.AccountType;

import java.util.Date;

public class BOABank extends Bank {

    public BOABank() {
        super.getBankInstance();
    }

    @Override
    public synchronized StringBuilder createAccountStatement(AccountType accountType) {
        StringBuilder printStatement = super.createAccountStatement(accountType);
        printStatement.append("::BankOfAmerica ");
        printStatement.append(accountType);
        printStatement.append((" Account"));
        return  printStatement;
    }

    public Account createAccount(String customerId, AccountType accountType,
                                 String accountId, Date openDate, int initialAmount){
        return super.createAccount(customerId, accountType, accountId, openDate, initialAmount);
    }
}


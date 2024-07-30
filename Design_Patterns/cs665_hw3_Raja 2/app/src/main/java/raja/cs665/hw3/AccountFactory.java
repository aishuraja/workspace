package raja.cs665.hw3;

import raja.cs665.hw3.enumTypes.AccountType;
import raja.cs665.hw3.enumTypes.BankName;

import java.util.Date;

public class AccountFactory {
    private static Bank bankInstance;
    public AccountFactory(BankName bankName){
        switch (bankName){
            case Basic -> {
                bankInstance = new Bank();
                break;
            }
            case BOA -> {
                bankInstance = new BOABank();
                break;
            }
            case Chase -> {
                bankInstance = new ChaseBank();
                break;
            }
        }
    }

    public Customer createCustomer(String customerName, String customerId, Date registrationDate){
        return bankInstance.createCustomer(customerName, customerId, registrationDate);
    }

    public synchronized  Account createAccount(AccountType accountType, String customerId, String accountId, Date openDate, int initialAmount) {
        System.out.printf("Creating %s Account\n", accountType);
        System.out.println(bankInstance.createAccountStatement(accountType));
        return  bankInstance.createAccount(customerId, accountType, accountId, openDate, initialAmount);
    }
}

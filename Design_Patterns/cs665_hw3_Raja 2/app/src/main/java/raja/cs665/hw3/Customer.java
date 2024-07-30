package raja.cs665.hw3;

import raja.cs665.hw3.exceptions.BankException;

import java.text.DateFormat;
import java.util.*;

public class Customer {
    private final String name;
    private final String customerId;
    private final Date registrationDate;
    private final List<Account> accountList;
    private final Map<String, Customer> customerMap;

    public Customer(String name, String customerId, Date registrationDate) {
        this.name = name;
        this.customerId = customerId;
        this.registrationDate = registrationDate;
        this.accountList = new ArrayList<>();
        this.customerMap = new HashMap<>();
    }

    public String getName() {
        return this.name;
    }

    public String getCustomerId() {
        return this.customerId;
    }

    public Date getRegistrationDate() {
        return this.registrationDate;
    }

    public void addAccount(Account account) {
        accountList.add(account);
        /* Fill in the code to add the account to the customer's accountList */

    }

    public synchronized Customer createCustomer()
            throws BankException {

        /* Fill in the code and return the Customer. Exception if customerId already exists */
        customerMap.put(this.customerId, this);
        return this;
    }
    public void printStatement(Date toDate) {

        System.out.println("\nBEGIN ACCOUNT STATEMENT - " + this.getName() + " - " + DateFormat.getDateInstance().format(toDate));

        /* Fill in the code to iterate over the customer's accountList and invoke printStatement for each account */

        for(var account: accountList) {
            account.printStatement(toDate);
        }

        System.out.println("\nEND ACCOUNT STATEMENT\n");
    }

    @Override
    public String toString() {
        return "\n**Customer**::" + this.getClass().getSimpleName();
    }
}

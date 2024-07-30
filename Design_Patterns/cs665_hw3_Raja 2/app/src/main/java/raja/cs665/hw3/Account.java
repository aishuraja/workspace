package raja.cs665.hw3;

import raja.cs665.hw3.enumTypes.AccountStatus;
import raja.cs665.hw3.exceptions.BankException;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class Account {

    private final String accountId;
    private final Date openDate;
    private Date closeDate;

    private final Customer primaryOwner;
    private Customer jointOwner;

    private AccountStatus accountStatus;

    private Date jointOwnershipDate;

    private int currentBalance;

    private final List<Transaction> transactionList;

    public Account(Customer primaryOwner, String accountId, Date openDate) {
        this.accountId = accountId;
        this.openDate = openDate;
        this.accountStatus = AccountStatus.Open;
        this.currentBalance = 0;
        this.transactionList = new ArrayList<>();
        this.primaryOwner = primaryOwner;
        primaryOwner.addAccount(this);
    }

    public Customer getPrimaryOwner() {
        return this.primaryOwner;
    }

    public String getAccountId() {
        return this.accountId;
    }

    public Date getOpenDate() {
        return this.openDate;
    }

    public AccountStatus getAccountStatus() {
        return this.accountStatus;
    }

    public int getCurrentBalance() {
        return this.currentBalance;
    }

    public void setJointOwner(Customer jointOwner, Date jointOwnershipDate) {
        this.jointOwner = jointOwner;
        this.jointOwnershipDate = jointOwnershipDate;
        jointOwner.addAccount(this);
    }

    public Customer getJointOwner() {
        return this.jointOwner;
    }

    public Date getJointOwnershipDate() {
        return this.jointOwnershipDate;
    }

    protected synchronized void addTransaction(Transaction t) {

        if (this.accountStatus == AccountStatus.Close)
            throw new BankException("Account " + this.getAccountId() + "closed... Transaction not allowed");

        if (t instanceof DepositTransaction) {

            /* Fill in the code
            - invoke the deposit method with the transaction amount,
            - add the transaction to the transactionList
            - set the ending balance of the transaction as the account's current balance
            - invoke the transaction's print method
             */
            this.deposit(t.getTransactionAmount());
            transactionList.add(t);
            t.setEndingBalance(this.currentBalance);
            t.print(this);


        } else if (t instanceof WithdrawTransaction) {

            /* Fill in the code
            - invoke the withdraw method with the transaction amount if it is less than or equal to the current balance, otherwise change the description of the transaction
            - add the transaction to the transactionList
            - set the ending balance of the transaction as the account's current balance
            - invoke the transaction's print method
             */
            if(this.currentBalance >= t.getTransactionAmount()) {
                this.withdraw(t.getTransactionAmount());
            }
            else {
                t.setDescription("Not enough balance, withdrawal ignored ");
            }
            transactionList.add(t);
            t.setEndingBalance(this.currentBalance);
            t.print(this);


        } else if (t instanceof TransferTransaction) {

            TransferTransaction tr = (TransferTransaction) t;

            if (tr.getToAccount().accountStatus == AccountStatus.Close)
                throw new BankException("Account " + this.getAccountId() + " closed... Transaction not allowed");

            tr.setDescription("Transfer from " + this.getAccountId() + " to " + tr.getToAccount().getAccountId());
            this.transactionList.add(tr);
            tr.getToAccount().transactionList.add(tr);
            tr.print(this);
        }

    }

    private synchronized void deposit(int amount) {
        this.currentBalance += amount;
    }

    private synchronized void withdraw(int amount)  {
        this.currentBalance -= amount;
    }

    public synchronized void closeAccount(Date closeDate) {
        this.accountStatus = AccountStatus.Close;
        this.closeDate = closeDate;
    }

    public void printStatement(Date toDate) {

        System.out.println("\n\tTransactions for Account " + this.accountId + " Primary Owner: " + this.primaryOwner.getName() + "\n");

        /* Fill in the code to iterate over the transactionList and invoke the print method for each transaction */
        for(var tran : transactionList){
            tran.print(this);
        }

    }

}



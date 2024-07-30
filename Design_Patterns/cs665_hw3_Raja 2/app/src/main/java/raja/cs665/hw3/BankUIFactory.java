package raja.cs665.hw3;

import raja.cs665.hw3.enumTypes.BankName;

public class BankUIFactory {
    private static BankUI bankInstance;
    public  BankUIFactory(BankName bankName) {
        switch (bankName){
            case BOA -> {
                bankInstance = new BOABankUI();
                break;
            }
            case Chase -> {
                bankInstance = new ChaseBankUI();
                break;
            }
        }
    }

    public void createUI(){
        bankInstance.createUI();
    }
}

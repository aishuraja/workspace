package raja.cs665.hw3;

import raja.cs665.hw3.enumTypes.CustomerType;

import java.util.Date;

public class StandardFactoryCustomer {
    public synchronized Customer createCustomer(CustomerType customerType, String customerName, String customerId, Date registrationDate){
        System.out.printf("Creating %s Customer...", customerType);
        switch (customerType){
            case Standard -> {
                return new StandardCustomer(customerName, customerId, registrationDate).createCustomer();
            }

            case Preferred -> {
                return new PreferredCustomer(customerName, customerId, registrationDate).createCustomer();
            }

            case Business -> {
                return new BusinessCustomer(customerName, customerId, registrationDate).createCustomer();
            }
        }
        return null;
    }
}

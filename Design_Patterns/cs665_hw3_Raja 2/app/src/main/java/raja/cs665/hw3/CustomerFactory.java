package raja.cs665.hw3;

import raja.cs665.hw3.enumTypes.CustomerType;

import java.util.Date;

public class CustomerFactory {
    private static CustomerCreator customerInstance;
    private final CustomerType customerType;
    public  CustomerFactory(CustomerType customerType) {
        this.customerType = customerType;
        switch (customerType){
            case Standard -> {
                customerInstance = new StandardCustomerCreator();
                break;
            }
            case Preferred -> {
                customerInstance = new PreferredCustomerCreator();
                break;
            }
            case Business -> {
                customerInstance = new BusinessCustomerCreator();
                break;
            }
        }
    }

    public void createCustomer(String customerName, String customerId, Date registrationDate){
        System.out.printf("Creating %s Customer...", this.customerType );
        customerInstance.createCustomer(customerName, customerId, registrationDate);
    }
}

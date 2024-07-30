package raja.cs665.hw3;

import java.util.Date;

public class BusinessCustomer extends Customer{
    public BusinessCustomer(String name, String customerId, Date registrationDate) {
        super(name, customerId, registrationDate);
    }

    public Customer createCustomer(){
        System.out.println(super.toString());
        return super.createCustomer();
    }
}

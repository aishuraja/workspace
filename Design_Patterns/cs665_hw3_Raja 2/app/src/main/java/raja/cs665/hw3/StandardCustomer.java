package raja.cs665.hw3;

import java.util.Date;

public class StandardCustomer extends Customer{
    public StandardCustomer(String name, String customerId, Date registrationDate) {
        super(name, customerId, registrationDate);
    }

    public Customer createCustomer(){
        System.out.println(super.toString());
        return super.createCustomer();
    }
}


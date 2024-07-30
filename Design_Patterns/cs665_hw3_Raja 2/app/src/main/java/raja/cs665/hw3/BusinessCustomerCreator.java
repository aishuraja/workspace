package raja.cs665.hw3;

import java.util.Date;

public class BusinessCustomerCreator extends CustomerCreator{
    @Override
    public void createCustomer(String name, String customerId, Date registrationDate) {
        Customer StandardCustomer = new Customer(name, customerId, registrationDate);
        System.out.println(super.toString()+"BusinessCustomer");
        StandardCustomer.createCustomer();
    }
}

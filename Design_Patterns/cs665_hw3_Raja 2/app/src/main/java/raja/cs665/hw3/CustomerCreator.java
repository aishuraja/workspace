package raja.cs665.hw3;

import java.util.Date;

public abstract class CustomerCreator {
    public abstract void createCustomer(String name, String customerId, Date registrationDate);

    @Override
    public String toString() {
        return "\n**Customer**::";
    }
}

package service;

import model.Customer;

public interface CustomerService extends Service {
    void findCustomerByName();
    Customer getCustomer();
}

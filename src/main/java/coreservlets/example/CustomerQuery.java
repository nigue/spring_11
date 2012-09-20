package coreservlets.example;

import coreservlets.business.model.Customer;

public interface CustomerQuery {

    public Customer getCustomerByName(String name);
}

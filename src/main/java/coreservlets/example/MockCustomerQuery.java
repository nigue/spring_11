package coreservlets.example;

import coreservlets.business.model.Customer;
import java.util.ArrayList;
import java.util.List;

public class MockCustomerQuery implements CustomerQuery {

    private List<Customer> customers;

    public MockCustomerQuery(List<Customer> customers) {
        this.customers = customers != null ? customers : new ArrayList<Customer>();
    }

    @Override
    public Customer getCustomerByName(String name) {
        for (Customer c : customers) {
            if (c.getName().equals(name)) {
                return c;
            }
        }
        return null;
    }
}

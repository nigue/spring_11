package coreservlets.business.dao.jpa;

import coreservlets.business.dao.CustomerDAO;
import coreservlets.business.model.Customer;
import org.springframework.stereotype.Service;

@Service(value = "customerDAO")
public class JPACustomerDAO extends JPAGenericDAO<Customer> implements CustomerDAO {

    public JPACustomerDAO() {
        super(Customer.class);
    }
}

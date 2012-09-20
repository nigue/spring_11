package coreservlets.TestDAO;

import coreservlets.business.dao.CustomerDAO;
import coreservlets.business.model.Customer;
import java.util.List;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:testContext.xml", "classpath:modelContext.xml"})
public class TestCustomerDAO {

    private static final Logger LOGGER = Logger.getLogger(TestCustomerDAO.class);
    @Resource(name = "customerDAO")
    private CustomerDAO customerDAO;

    @Test
    public void custoemrTestDAO() {
        LOGGER.debug("/////////////Inicio de TEST");
        
        Customer customer = new Customer();
        customer.setName("comprador1");
        
        customerDAO.persist(customer);
        
        List<Customer> customers = customerDAO.findAll();
        Assert.assertFalse(customers.isEmpty());
        Assert.assertEquals(customers.size(), 1);
        Assert.assertEquals(customer, customers.get(0));
    }
}

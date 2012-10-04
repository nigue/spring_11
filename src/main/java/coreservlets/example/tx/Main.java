package coreservlets.example.tx;

import coreservlets.business.dao.CustomerDAO;
import coreservlets.business.model.Customer;
import java.util.List;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {

        BeanFactory beanFactory = new ClassPathXmlApplicationContext(new String[]{
                    "/coreservlets/example/tx/coreservletsTxContext.xml",
                    "/coreservlets/example/coreservletsContext.xml"});

        CustomerDAO customerDAO = (CustomerDAO) beanFactory.getBean("customerDAO");
        Customer customer = new coreservlets.business.model.Customer();
        List<Customer> customers = customerDAO.findAll();
        customer.setId(new Long(customers.size()));
        customer.setName("comprador" + customers.size());
        customerDAO.persist(customer);
    }
}
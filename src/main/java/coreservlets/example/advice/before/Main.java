package coreservlets.example.advice.before;

import coreservlets.business.dao.CustomerDAO;
import coreservlets.business.model.Customer;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    private static final Logger LOGGER = Logger.getLogger(Main.class);

    public static void main(String[] args) {

        BeanFactory beanFactory = new ClassPathXmlApplicationContext(new String[]{
                    "/coreservlets/example/advice/before/coreservletsAopContext.xml",
                    "/coreservlets/example/coreservletsContext.xml",
                    "classpath:modelContext.xml"});

        CustomerDAO customerDAO = (CustomerDAO) beanFactory.getBean("customerDAO");


        List<Customer> customers = customerDAO.findAll();

        for (Customer customer : customers) {
            LOGGER.debug("[" + customer.toString() + "]");
        }

    }
}

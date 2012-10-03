package coreservlets.example.advice.afterthrows;

import coreservlets.business.dao.CustomerDAO;
import coreservlets.business.model.Customer;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    private static final Logger LOGGER = Logger.getLogger(coreservlets.example.advice.afterreturn.Main.class);

    public static void main(String[] args) {

        BeanFactory beanFactory = new ClassPathXmlApplicationContext(new String[]{
                    "/coreservlets/example/advice/afterthrows/coreservletsAopContext.xml",
                    "/coreservlets/example/advice/afterthrows/coreservletsContext.xml",
                    "/coreservlets/example/coreservletsContext.xml",
                    "classpath:modelContext.xml"});

        CustomerDAO customerDAO = (CustomerDAO) beanFactory.getBean("customerDAO");


        List<Customer> customers = customerDAO.findAll();

        for (Customer customer : customers) {
            LOGGER.debug("[" + customer + "]");
        }

    }
}

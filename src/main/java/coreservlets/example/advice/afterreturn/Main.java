package coreservlets.example.advice.afterreturn;

import coreservlets.business.dao.CustomerDAO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    private static final Logger LOGGER = Logger.getLogger(Main.class);

    public static void main(String[] args) {

        BeanFactory beanFactory = new ClassPathXmlApplicationContext(new String[]{
                    "/coreservlets/example/advice/afterreturn/coreservletsAopContext.xml",
                    "/coreservlets/example/coreservletsContext.xml",
                    "classpath:modelContext.xml"});

//        CustomerQuery query = (CustomerQuery) beanFactory.getBean("customerQuery");
//
//        query.getCustomerByName("Java Joe");
        
        LOGGER.debug("/////////////inicio de main////////////");

        CustomerDAO customerDAO = (CustomerDAO) beanFactory.getBean("customerDAO");

        customerDAO.findByField("name", "comprador1");

    }
}

package coreservlets.example.advice.afterreturn;

import coreservlets.example.CustomerQuery;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {

        BeanFactory beanFactory = new ClassPathXmlApplicationContext(new String[]{
                    "/coreservlets/example/advice/afterreturn/coreservletsAopContext.xml",
                    "/coreservlets/example/coreservletsContext.xml"});

        CustomerQuery query = (CustomerQuery) beanFactory.getBean("customerQuery");

        query.getCustomerByName("Java Joe");

    }
}

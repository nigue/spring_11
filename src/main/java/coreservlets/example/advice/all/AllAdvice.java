package coreservlets.example.advice.all;

import java.lang.reflect.Method;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.log4j.Logger;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.ThrowsAdvice;

public class AllAdvice implements MethodInterceptor, MethodBeforeAdvice, AfterReturningAdvice, ThrowsAdvice {

    private static final Logger LOGGER = Logger.getLogger(Main.class);

    @Override
    public void before(Method mtd, Object[] args, Object target) throws Throwable {
        LOGGER.debug("******AOP****** Before");
    }

    @Override
    public void afterReturning(Object returnValue,
            Method method,
            Object[] args,
            Object target) throws Throwable {
        LOGGER.debug("******AOP****** After return");
    }

    public void afterThrowing(Method method,
            Object[] args,
            Object target,
            Exception ex) {
        LOGGER.debug("******AOP****** After throwing");
    }

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        try {
            LOGGER.debug("******AOP****** Around before");
            return invocation.proceed();
        } finally {
            LOGGER.debug("******AOP****** Around after");
        }
    }
}

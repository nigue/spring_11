package coreservlets.example.advice.around;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.log4j.Logger;

public class NamedAroundAdvice implements MethodInterceptor {

    private static final Logger log = Logger.getLogger(NamedAroundAdvice.class);
    private String name;

    public NamedAroundAdvice() {
    }

    public NamedAroundAdvice(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        try {
            log.debug("******AOP******");
            log.debug("before: " + this.name);
            Object returnValue = invocation.proceed();
            log.debug("after return: " + this.name);
            log.debug("******AOP******");
            return returnValue;
        } catch (Throwable t) {
            log.debug("******AOP******");
            log.debug("after throws: " + this.name);
            log.debug("******AOP******");
            throw t;
        } finally {
            log.debug("******AOP******");
            log.debug("after finally: " + this.name);
            log.debug("******AOP******");
        }
    }
}

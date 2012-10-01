package coreservlets.example.advice.afterreturn;

import java.lang.reflect.Method;
import java.util.Arrays;
import org.apache.log4j.Logger;
import org.springframework.aop.AfterReturningAdvice;

public class AfterReturningLoggingAdvice implements AfterReturningAdvice {
    
    private static final Logger LOGGER = Logger.getLogger(AfterReturningLoggingAdvice.class);

    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {

        LOGGER.debug("\n ---AOP--> " + 
                target.getClass().getSimpleName()
                + "#" + method.toGenericString()
                + ". args=" + Arrays.toString(args)
                + ". exit=return[" + returnValue + "]");
        
        Logger.getLogger(target.getClass()).debug(
                target.getClass().getSimpleName()
                + "#" + method.toGenericString()
                + ". args=" + Arrays.toString(args)
                + ". exit=return[" + returnValue + "]");

    }
}

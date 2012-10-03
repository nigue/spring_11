package coreservlets.example.advice.afterthrows;

import java.lang.reflect.Method;
import org.apache.log4j.Logger;
import org.springframework.aop.ThrowsAdvice;

public class ThrowsLoggingAdvice implements ThrowsAdvice {

    public void afterThrowing(Method method, Object[] arguments, Object target, IllegalArgumentException ex) throws Throwable {
        Logger.getLogger(target.getClass()).debug(
                "******AOP******\n" +
                "afterThrowing: IllegalArgumentException" +
                "\n******AOP******");
    }

    public void afterThrowing(Method method, Object[] arguments, Object target, IllegalStateException ex) throws Throwable {
        Logger.getLogger(target.getClass()).debug(
                "******AOP******\n" +
                "afterThrowing: IllegalArgumentException" +
                "\n******AOP******");
    }

    public void afterThrowing(Method method, Object[] arguments, Object target, RuntimeException ex) throws Throwable {
        Logger.getLogger(target.getClass()).debug(
                "******AOP******\n" +
                "afterThrowing: RuntimeException" +
                "\n******AOP******");
    }
}

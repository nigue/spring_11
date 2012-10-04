package coreservlets.example.aspectj.schema;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;

public class LoggingAroundAdvice {

    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        Logger log = Logger.getLogger(joinPoint.getTarget().getClass());
        try {
            log.debug("******AOP******");
            log.debug("before");
            log.debug("#" + joinPoint.getSignature().getName() + "()");
            Object returnValue = joinPoint.proceed();
            log.debug("after return");
            log.debug("******AOP******");
            return returnValue;
        } catch (Throwable t) {
            log.debug("after throws");
            throw t;
        }
    }
}

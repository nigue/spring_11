package coreservlets.example.aspectj.advice;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class LoggingAroundAdvice {

    @Around("coreservlets.example.aspectj.advice.CoreservletsPointcuts.queryLayer()"
    + "|| coreservlets.example.aspectj.advice.CoreservletsPointcuts.reportLayer()")
    public Object log(ProceedingJoinPoint jp) throws Throwable {
        Logger log = Logger.getLogger(jp.getTarget().getClass());
        try {
            log.debug("******AOP****** before");
            log.debug("******AOP****** #" + jp.getSignature().getName() + "()");
            Object returnValue = jp.proceed();
            log.debug("******AOP****** after return");
            return returnValue;
        } catch (Throwable t) {
            log.debug("******AOP****** after throws");
            throw t;
        }
    }
}

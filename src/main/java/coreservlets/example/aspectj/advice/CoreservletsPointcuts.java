package coreservlets.example.aspectj.advice;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class CoreservletsPointcuts {

    @Pointcut("target(coreservlets.business.dao.GenericDAO)")
    public void queryLayer() {
    }

    @Pointcut("target(coreservlets.business.dao.GenericDAO)")
    public void reportLayer() {
    }
}

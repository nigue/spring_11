package coreservlets.example.advice.ordering;

import java.lang.reflect.Method;
import org.apache.log4j.Logger;
import org.springframework.aop.MethodBeforeAdvice;

public class ErrorThrowingBeforeAdvice implements MethodBeforeAdvice {

    private static final Logger LOGGER = Logger.getLogger(ErrorThrowingBeforeAdvice.class);
    private Class<? extends Throwable> throwableType;

    public ErrorThrowingBeforeAdvice() {
    }

    public ErrorThrowingBeforeAdvice(Class<? extends Throwable> throwableType) {
        this.throwableType = throwableType;
    }

    public Class<? extends Throwable> getThrowableType() {
        return throwableType;
    }

    public void setThrowableType(Class<? extends Throwable> throwableType) {
        this.throwableType = throwableType;
    }

    @Override
    public void before(Method method, Object[] arguments, Object target) throws Throwable {
        try {
            throw throwableType.newInstance();
        } catch (InstantiationException e) {
            LOGGER.debug("Error: error generation. Failed to generate error: " + this.throwableType);
        } catch (IllegalAccessException e) {
            LOGGER.debug("Error: error generation. Failed to generate error: " + this.throwableType);
        }
    }
}

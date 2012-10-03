package coreservlets.example.advice.multiple;

import java.lang.reflect.Method;
import java.util.Arrays;
import org.apache.log4j.Logger;
import org.springframework.aop.MethodBeforeAdvice;

public class BeforeLoggingAdvice implements MethodBeforeAdvice {

    private static final Logger LOGGER = Logger.getLogger(BeforeLoggingAdvice.class);

    @Override
    public void before(Method method, Object[] arguments, Object target) throws Throwable {
        LOGGER.debug("******AOP******\n"
                + target.getClass().getSimpleName()
                + "\n# " + method.toGenericString()
                + "\n. args = " + Arrays.toString(arguments)
                + "\n******AOP******");
    }
}

package coreservlets.example.advice.before;

import java.lang.reflect.Method;
import java.util.Arrays;
import org.apache.log4j.Logger;
import org.springframework.aop.MethodBeforeAdvice;

public class BeforeLoggingAdvice implements MethodBeforeAdvice {

    private static final Logger LOGGER = Logger.getLogger(BeforeLoggingAdvice.class);

    @Override
    public void before(Method mtd, Object[] args, Object target) throws Throwable {

        LOGGER.debug("******AOP******\n"
                + target.getClass().getSimpleName()
                + "\n# " + mtd.toGenericString()
                + "\n. args = " + Arrays.toString(args)
                + "\n******AOP******");
    }
}

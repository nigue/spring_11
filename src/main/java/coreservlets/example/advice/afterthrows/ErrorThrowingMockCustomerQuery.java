package coreservlets.example.advice.afterthrows;

import coreservlets.business.dao.CustomerDAO;
import coreservlets.business.model.Customer;
import java.util.List;
import org.apache.log4j.Logger;

public class ErrorThrowingMockCustomerQuery implements CustomerDAO {

    private static final Logger log =
            Logger.getLogger(ErrorThrowingMockCustomerQuery.class);

    private Class<? extends RuntimeException> throwableType;

    public ErrorThrowingMockCustomerQuery(
            Class<? extends RuntimeException> throwableType) {
        if (throwableType == null) {
            throw new IllegalArgumentException("Required: throwable type.");
        }
        this.throwableType = throwableType;
    }

    @Override
    public Customer persist(Customer object) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete(Customer object) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Customer find(long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Customer> findAll() {
        try {
            throw throwableType.newInstance();
        } catch (InstantiationException e) {
            log.error("Error: error generation. Failed to generate error: "
                    + this.throwableType);
            return null;
        } catch (IllegalAccessException e) {
            log.error("Error: error generation. Failed to generate error: "
                    + this.throwableType);
            return null;
        }    }

    @Override
    public List<Customer> findByField(String field, String data) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Class getEntityClass() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}

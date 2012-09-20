package coreservlets.business.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer extends PersistentIdEntity {

    private String name;

    public Customer() {
        super();
    }

    public Customer(String id, String name) {
        super();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

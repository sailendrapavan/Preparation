package persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class DataBaseStore {

    private EntityManager entityManger;

    public DataBaseStore(EntityManager entityManger) {
        this.entityManger = entityManger;
    }

    public EntityManager getEntityManger() {

        return this.entityManger;
    }

}

package persistence;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import configuration.LoadProperties;

/*This class is mainly for creating an entitymanger factory 
 *when ever an new session(entity manager) is needed we use the above factory and create session through DataBaseStore
 * 
 */
public class DataBaseStoreZ {
    private static Logger log = LoggerFactory.getLogger(DataBaseStoreZ.class);

    private volatile static DataBaseStoreZ storez;
    private final EntityManagerFactory entityManagerFactory;
    private final static String DATABASE_NAME="PayslipGenerator";
    private static final String HIBERNATE_CONNECTION_URL_KEY = "hibernate.connection.url";
    private static final String HIBERNATE_CONNECTION_URL_VALUE = "jdbc:mysql://localhost:3306/" + DATABASE_NAME
            + "?createDatabaseIfNotExist=true&noAccessToProcedureBodies=true&amp;autoReconnect=true;";

    private static final String HIBERNATE_HBM2DDL_KEY = "hibernate.hbm2ddl.auto";
    private static final String HIBERNATE_HBM2DDL_VALUE = "update";

    private DataBaseStoreZ() {
        try {
            log.info("Creating an entity manager factory!!");
            LoadProperties loadPropertiesFromFile = new LoadProperties();
            //loadPropertiesFromFile.setProperty(HIBERNATE_CONNECTION_URL_KEY, HIBERNATE_CONNECTION_URL_VALUE);
            //loadPropertiesFromFile.setProperty(HIBERNATE_HBM2DDL_KEY, HIBERNATE_HBM2DDL_VALUE);
            entityManagerFactory = Persistence.createEntityManagerFactory("PaySlipGenerationPersistenceUnit",
                    loadPropertiesFromFile);
        } catch (Exception e) {
            throw e;
        }
    }

    public static DataBaseStoreZ get() {

        if (storez == null) {
            storez = new DataBaseStoreZ();
        }

        return storez;

    }
    
    public EntityManagerFactory getEntityMangerFactory() {
        return this.entityManagerFactory;
    }
    
    public DataBaseStore getEntityManger() {
        return new DataBaseStore(this.entityManagerFactory.createEntityManager());
    }
    
}

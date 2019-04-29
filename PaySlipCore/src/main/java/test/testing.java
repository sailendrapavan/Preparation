package test;

import javax.persistence.EntityManager;

import persistence.DataBaseStore;
import persistence.DataBaseStoreZ;

public class testing {

    public static void main(String args[]) {
        
     DataBaseStore dbstore= DataBaseStoreZ.get().getEntityManger();
     EntityManager em= dbstore.getEntityManger();
     em.getTransaction().begin();
     
     em.getTransaction().commit();
    }
}

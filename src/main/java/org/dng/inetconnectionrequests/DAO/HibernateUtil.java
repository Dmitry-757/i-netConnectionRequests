package org.dng.inetconnectionrequests.DAO;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class HibernateUtil {
    private static EntityManagerFactory entityManagerFactory = initEntityManagerFactory();

    private static EntityManagerFactory initEntityManagerFactory() {
        try{
            return Persistence.createEntityManagerFactory("inet_connection.dng.org");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }
}

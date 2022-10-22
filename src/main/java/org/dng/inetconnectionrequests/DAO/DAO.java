package org.dng.inetconnectionrequests.DAO;

import jakarta.persistence.*;
import org.dng.inetconnectionrequests.Models.ClientInfoEntity;
import org.hibernate.Session;


import java.util.LinkedList;
import java.util.List;

public class DAO implements IDAO{


    @Override
    public void createRecord(ClientInfoEntity item) {
        EntityManagerFactory entityManagerFactory = HibernateUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();

            entityManager.persist(item);
            transaction.commit();

        }catch (Exception e){
            System.out.println(e.getMessage());
        } finally{
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
        }
    }


    @Override
    public void updateRecordBySettingParams(int id, ClientInfoEntity updatedItem) {
        EntityManagerFactory entityManagerFactory = HibernateUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            ClientInfoEntity existItem = entityManager.find(ClientInfoEntity.class, id);
            if (existItem != null) {
                transaction.begin();
                //String clientFio, String email, String phoneNumber, String address
                existItem.setClientFio(updatedItem.getClientFio());
                existItem.setEmail(updatedItem.getEmail());
                existItem.setPhoneNumber(updatedItem.getPhoneNumber());
                existItem.setAddress(updatedItem.getAddress());

                transaction.commit();
            }
        }catch (Exception e) {
            System.out.println(e.getMessage());
        } finally{
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
        }
    }

    //@Override
    public void updateRecordByMergin(ClientInfoEntity item) {
        EntityManagerFactory entityManagerFactory = HibernateUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try{
            transaction.begin();
            entityManager.merge(item);
            transaction.commit();
        } finally{
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
        }
    }



    @Override
    public void deleteRecord(ClientInfoEntity item) {
        EntityManagerFactory entityManagerFactory = HibernateUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try{
            transaction.begin();

            ClientInfoEntity cie = entityManager.find(ClientInfoEntity.class, item.getId());
            entityManager.remove(cie);


            transaction.commit();
        }catch (Exception e){
            System.out.println(e.getMessage());
        } finally{
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
        }

    }

    public void deleteAllRecords() {
        EntityManagerFactory entityManagerFactory = HibernateUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();

            entityManager.createNativeQuery("TRUNCATE TABLE clientinfo_tbl")
                    .executeUpdate();
//            entityManager.createQuery("DELETE FROM ClientInfoEntity")
//                    .executeUpdate();

            transaction.commit();
        }catch (Exception e){
            System.out.println(e.getMessage());
        } finally{
//            if (transaction.isActive()) {
//                transaction.rollback();
//            }
            entityManager.close();
        }
    }


    @Override
    public ClientInfoEntity findById(int id) {
        EntityManagerFactory entityManagerFactory = HibernateUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try{

            return entityManager.find(ClientInfoEntity.class, id);

        } finally{
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
        }
    }


    @Override
    public List<ClientInfoEntity> findAllByHQL() {
        List<ClientInfoEntity> result = new LinkedList<>();
        EntityManagerFactory entityManagerFactory = HibernateUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try{
            transaction.begin();

            result = entityManager.createQuery("select e from ClientInfoEntity e").getResultList();
            transaction.commit();
        } finally{
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
        }

        return result;

    }

    public List<ClientInfoEntity> findAllByNativQuery() {
        List<ClientInfoEntity> result = new LinkedList<>();
        EntityManagerFactory entityManagerFactory = HibernateUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        Query myQuery;
        try{
            transaction.begin();

            myQuery = entityManager.createNativeQuery("select * from clientinfo_tbl", ClientInfoEntity.class);
            result = myQuery.getResultList();
            transaction.commit();
        } finally{
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
        }

        return result;
    }

}

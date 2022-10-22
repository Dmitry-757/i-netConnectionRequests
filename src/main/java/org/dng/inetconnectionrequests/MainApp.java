package org.dng.inetconnectionrequests;

import org.dng.inetconnectionrequests.Models.ClientInfoEntity;
import org.dng.inetconnectionrequests.DAO.DAO;
import org.dng.inetconnectionrequests.DAO.PrepareDB;


public class MainApp {
    public static void main(String[] args) {
        PrepareDB.prepareBase();
        PrepareDB.createTables();

        DAO dao = new DAO();
        ClientInfoEntity item = null;

        System.out.println("***************************");
        item = new ClientInfoEntity("fio", "email1@gmail.com", "+7912100200",
                "USSR");
        dao.createRecord(item);
        item = new ClientInfoEntity("fio2", "email2@gmail.com", "+7912100300",
                "RF");
        dao.createRecord(item);

        System.out.println("************ print all ***************");
        dao.findAllByHQL().forEach(System.out::println);


        System.out.println("************* update1 ************");
        dao.updateRecordBySettingParams(1, new ClientInfoEntity("fio", "email1@gmail.com", "+7912100200",
                "New Zealand"));

        System.out.println("************* update2 ************");
        item = dao.findById(2);
        item.setAddress("Australia");
        dao.updateRecordByMergin(item);

        System.out.println("***************************");
        dao.findAllByHQL().forEach(System.out::println);
        System.out.println("*** findAll by native query ************************");
        for (Object c:dao.findAllByNativQuery()) {
            int a = 1;
            System.out.println((ClientInfoEntity)c);
        }

    }
}

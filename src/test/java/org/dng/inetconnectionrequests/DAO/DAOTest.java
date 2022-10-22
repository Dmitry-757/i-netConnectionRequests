package org.dng.inetconnectionrequests.DAO;
import org.dng.inetconnectionrequests.Models.ClientInfoEntity;

import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class DAOTest {
    private DAO dao = new DAO();
    ClientInfoEntity item = null;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
            dao.deleteAllRecords();
            item = new ClientInfoEntity("fio", "email1@gmail.com", "+7912100200",
                    "Zimbabwe");
            dao.createRecord(item);
    }

    @org.junit.jupiter.api.Test
    void createRecord() {
        dao.deleteAllRecords();
        item = new ClientInfoEntity("fio", "email1@gmail.com", "+7912100200",
                "USSR");
        dao.createRecord(item);

        List<ClientInfoEntity> li = dao.findAllByHQL();
        if (li.size()>0) {
            ClientInfoEntity existItem = li.get(0);
            assertThat(dao.findById(existItem.getId())).isEqualTo(item);
        }
        else{
            fail("some ass happened ((");
        }

    }

    @org.junit.jupiter.api.Test
    void updateRecordBySettingParams() {
        List<ClientInfoEntity> li = dao.findAllByHQL();
        if (li.size()>0) {
            ClientInfoEntity existItem = li.get(0);
            item = new ClientInfoEntity(existItem.getId(), "fio", "email1@gmail.com", "+7912100200",
                    "Australia");
            dao.updateRecordBySettingParams(existItem.getId(), item);
            assertThat(dao.findById(existItem.getId())).isEqualTo(item);
        }
        else{
            fail("some ass happened ((");
        }
    }

    @org.junit.jupiter.api.Test
    void updateRecordByMergin() {
        List<ClientInfoEntity> li = dao.findAllByHQL();
        if (li.size()>0) {
            ClientInfoEntity existItem = li.get(0);
            item = new ClientInfoEntity(existItem.getId(), "fio", "email1@gmail.com", "+7912100200",
                    "Tanzania");
            dao.updateRecordByMergin(item);
            assertThat(dao.findById(existItem.getId())).isEqualTo(item);
        }
        else{
            fail("some ass happened ((");
        }
    }

    @org.junit.jupiter.api.Test
    void deleteRecord() {
        List<ClientInfoEntity> li = dao.findAllByHQL();
        if (li.size()>0) {
            ClientInfoEntity existItem = li.get(0);
            dao.deleteRecord(existItem);
            assertThat(dao.findById(existItem.getId())).isNull();
        }
        else{
            fail("some ass happened ((");
        }
    }

    @org.junit.jupiter.api.Test
    void findById() {
        List<ClientInfoEntity> li = dao.findAllByHQL();
        if (li.size()>0) {
            ClientInfoEntity existItem = li.get(0);
            assertThat(dao.findById(existItem.getId())).isEqualTo(item);
        }
        else{
            fail("some ass happened ((");
        }

    }

    @org.junit.jupiter.api.Test
    void findAllByHQL() {
        dao.deleteAllRecords();
        List<ClientInfoEntity> itemList = new LinkedList<>();
        itemList.add(new ClientInfoEntity("fio1", "email1@gmail.com", "+7912100201",
                "Zimbabwe"));
        itemList.add(new ClientInfoEntity("fio2", "email2@gmail.com", "+7912100202",
                "Burundi"));

        itemList.forEach(i -> dao.createRecord(i));

        assertThat(dao.findAllByHQL())
                .hasSize(itemList.size())
                .containsAll(itemList)
                .containsExactlyElementsOf(itemList);
    }

    @org.junit.jupiter.api.Test
    void findAllByNativQuery() {
        dao.deleteAllRecords();
        List<ClientInfoEntity> itemList = new LinkedList<>();
        itemList.add(new ClientInfoEntity("fio1", "email1@gmail.com", "+7912100201",
                "Zimbabwe"));
        itemList.add(new ClientInfoEntity("fio2", "email2@gmail.com", "+7912100202",
                "Burundi"));

        itemList.forEach(i -> dao.createRecord(i));

        assertThat(dao.findAllByNativQuery())
                .hasSize(itemList.size())
                .containsAll(itemList)
                .containsExactlyElementsOf(itemList);

    }
}
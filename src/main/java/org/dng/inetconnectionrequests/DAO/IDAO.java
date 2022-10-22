package org.dng.inetconnectionrequests.DAO;

import org.dng.inetconnectionrequests.Models.ClientInfoEntity;

import java.util.List;

public interface IDAO {
    ClientInfoEntity findById(int id);

    List<ClientInfoEntity> findAllByHQL();

    List<ClientInfoEntity> findAllByNativQuery();
    void createRecord(ClientInfoEntity item);
    void updateRecordBySettingParams(int id, ClientInfoEntity updatedItem);
    void deleteRecord(ClientInfoEntity item);

}

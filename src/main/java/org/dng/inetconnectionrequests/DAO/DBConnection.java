package org.dng.inetconnectionrequests.DAO;

import java.sql.Connection;

public class DBConnection {
    public static Connection getConnection(){
//        return MSSQLConnection.getConnection();
        return mySQLConnection.getConnection();
    }
}

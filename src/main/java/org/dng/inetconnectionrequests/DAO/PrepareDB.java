package org.dng.inetconnectionrequests.DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class PrepareDB {

    public static void prepareBase() {
        String PREPARE_QUERY =
                "DROP DATABASE IF EXISTS inet_connection_db;";
        try (Connection connection = DBConnection.getConnection();
             Statement statement = connection.createStatement()
        ) {

            statement.executeUpdate(PREPARE_QUERY);
        } catch (SQLException e) {
            e.printStackTrace();
        }


        PREPARE_QUERY =
                "CREATE DATABASE IF NOT EXISTS inet_connection_db;"
        ;
        try (Connection connection = DBConnection.getConnection();
             Statement statement = connection.createStatement()
        ) {

            statement.executeUpdate(PREPARE_QUERY);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public static void createTables() {
        String CREATE_TABLE_clientinfo_tbl =
                """
                        CREATE TABLE inet_connection_db.clientinfo_tbl (
                        id INT NOT NULL AUTO_INCREMENT,
                        clientFIO VARCHAR(100) NOT NULL,
                        email VARCHAR(50) NOT NULL,
                        phoneNumber VARCHAR(45) NOT NULL,
                        address VARCHAR(100) NOT NULL,
                        PRIMARY KEY (id),
                        UNIQUE INDEX id_UNIQUE (id ASC) VISIBLE);
                """;


        try (Connection connection = DBConnection.getConnection();
             Statement statement = connection.createStatement()
        ) {
            statement.addBatch(CREATE_TABLE_clientinfo_tbl);

            statement.executeBatch();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

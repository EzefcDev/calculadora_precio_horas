package com.schoolofliberation.config.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcUtil {

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String USER = "";
    private static final String PASS = "";
    private static final String URL = "";

    private static Connection connection = null;

    public static Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {

                Class.forName(DRIVER);
                connection = DriverManager.getConnection(URL, USER, PASS);  
            }
            return connection;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

}

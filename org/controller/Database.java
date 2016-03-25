package org.controller;

import java.sql.*;

/**
 * Created by dmytro on 25.03.16.
 */
public class Database {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/candy";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "ym.afu";

    protected Connection connection;

    Database() throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);
        connection = DriverManager.getConnection(DB_URL, USER, PASS);
    }

    protected void finalize() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

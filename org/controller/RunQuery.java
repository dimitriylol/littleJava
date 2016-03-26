package org.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by dmytro on 26.03.16.
 */
public class RunQuery extends Database {
    Statement statement;
    ResultSet rs;

    public RunQuery(String queryStr) throws SQLException, ClassNotFoundException {
        super();
        statement = connection.createStatement();
        rs = statement.executeQuery(queryStr);
    }

    public RunQuery() throws SQLException, ClassNotFoundException {
        super();
    }

    public ResultSet getTables() {
        try {
            return connection.getMetaData().getTables(null, null, "%" , null );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ResultSet getResult() {
        return rs;
//        while (rs.next()) {
//            //Retrieve by column name
//            int id = rs.getInt("id");
//            int age = rs.getInt("age");
//            String first = rs.getString("first");
//            String last = rs.getString("last");
//
//            //Display values
//            System.out.print("ID: " + id);
//            System.out.print(", Age: " + age);
//            System.out.print(", First: " + first);
//            System.out.println(", Last: " + last);
//        }
    }

    protected void finalize() {
        try {
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        super.finalize();
    }
}

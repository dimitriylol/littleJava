package org.controller;

import org.media.Candy;
import org.media.CandyBox;
import org.media.CandyInit;

import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by dmytro on 25.03.16.
 */
public class InputControl {
    public InputControl() { }

    public CandyBox createCandyBox(String[] tableNames, String[] candyNames) {
        try {
            return new CandyBox(getAllCandyInit(tableNames, candyNames));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private ArrayList<CandyInit> getAllCandyInit(String[] tableNames, String[] candyNames) throws SQLException {
        ArrayList<CandyInit> res = new ArrayList<>();
        for (String tableName : tableNames) {
            for (String name : candyNames) {
                ResultSet rs = safeGetResultSet("select * from " + tableName + " where name = " + name);
                while (rs.next()) {
                    res.add(new CandyInit(safeGetSting(rs, "name"), safeGetInt(rs, "sugarPercent"),
                            safeGetInt(rs, "weight"), safeGetSting(rs, "kind"), safeGetSting(rs, "additional")));
                }
            }
        }
        return res;
    }

    private ResultSet safeGetResultSet(String query) {
        try {
            return (new RunQuery(query)).getResult();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private int safeGetInt(ResultSet rs, String sugarPercent) {
        try {
            return rs.getInt(sugarPercent);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private String safeGetSting(ResultSet rs, String name) {
        try {
            return rs.getString(name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

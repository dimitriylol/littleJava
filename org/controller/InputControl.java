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
        for (String candyName : candyNames) {
            res.add(getCandyInit(tableNames, candyName));
        }
        return res;
    }

    public Candy createCandy(String[] tables, String name) {
        try {
            return getCandyInit(tables, name).getCandy();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
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

    private CandyInit getCandyInit(String[] tableNames, String candyName) throws SQLException {
        for (String tableName : tableNames) {
            ResultSet rs = safeGetResultSet("SELECT * FROM " + tableName + " WHERE name = '" + candyName + "'");
            if (rs.next()) {
                return new CandyInit(safeGetSting(rs, "name"), safeGetInt(rs, "sugarPercent"),
                                    safeGetInt(rs, "weight"), safeGetSting(rs, "kind"), safeGetSting(rs, "additional"));
            }
        }
        return null;
    }

    private ResultSet safeGetResultSet(String query) {
        try {
            return (new RunQuery(query)).getResult();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    private int safeGetInt(ResultSet rs, String sugarPercent) {
        try {
            return rs.getInt(sugarPercent);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    private String safeGetSting(ResultSet rs, String name) {
        try {
            return rs.getString(name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

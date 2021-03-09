package com.coinmanagement.loader.settings;

import com.coinmanagement.exception.DBConnectionException;
import com.coinmanagement.utils.Constants;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author sagar
 */
public class SettingsLoader extends BaseLoader {
    private static final Logger LOG = LogManager.getLogger(SettingsLoader.class.getSimpleName());
    private static SettingsLoader instance;
    private final ConcurrentHashMap<String, String> stringMap;
    private final ConcurrentHashMap<String, Integer> intMap;
    private final ConcurrentHashMap<String, Long> longMap;
    private final ConcurrentHashMap<String, Double> doubleMap;
    private final ConcurrentHashMap<String, Boolean> booleanMap;

    private SettingsLoader() {
        stringMap = new ConcurrentHashMap<>();
        intMap = new ConcurrentHashMap<>();
        longMap = new ConcurrentHashMap<>();
        doubleMap = new ConcurrentHashMap<>();
        booleanMap = new ConcurrentHashMap<>();
    }

    public static SettingsLoader getInstance() {
        if (instance == null) {
            instance = new SettingsLoader();
        }
        return instance;
    }

    public String getStringValue(String name) {
        try {
            checkForReload();
            if (stringMap.containsKey(name)) {
                return stringMap.get(name);
            }            
        } catch (Exception ex) {
            LOG.error("Exception in loading SettingsLoader value" +ex);
        } 
        return null;
    }

    public int getIntValue(String name) throws DBConnectionException, SQLException {
        checkForReload();
        if (intMap.containsKey(name)) {
            return intMap.get(name);
        }
        return 0;
    }

    public long getLongValue(String name) throws DBConnectionException, SQLException {
        checkForReload();
        if (longMap.containsKey(name)) {
            return longMap.get(name);
        }
        return 0;
    }

    public double getDoubleValue(String name) throws DBConnectionException, SQLException {
        checkForReload();
        if (doubleMap.containsKey(name)) {
            return doubleMap.get(name);
        }
        return 0;
    }

    public boolean getBoolValue(String name) throws DBConnectionException, SQLException {
        checkForReload();
        if (booleanMap.containsKey(name)) {
            return booleanMap.get(name);
        }
        return false;
    }

    @Override
    protected void clearPreviousData() {
        stringMap.clear();
        intMap.clear();
        longMap.clear();
        doubleMap.clear();
        booleanMap.clear();
    }

    @Override
    protected String makeSelectCommand() {
        String sql = "select settingName, settingValue, dataType from settings";
        return sql;
    }

    @Override
    protected void populateDataFromSql(ResultSet rs) throws DBConnectionException, SQLException {
        while (rs.next()) {
            switch (rs.getInt("dataType")) {
                case Constants.DATA_TYPE_INT:
                    intMap.put(rs.getString("settingName"), Integer.parseInt(rs.getString("settingValue")));
                    break;
                case Constants.DATA_TYPE_LONG:
                    longMap.put(rs.getString("settingName"), Long.parseLong(rs.getString("settingValue")));
                    break;
                case Constants.DATA_TYPE_DOUBLE:
                    doubleMap.put(rs.getString("settingName"), Double.parseDouble(rs.getString("settingValue")));
                    break;
                case Constants.DATA_TYPE_BOOLEAN:
                    booleanMap.put(rs.getString("settingName"), Boolean.parseBoolean(rs.getString("settingValue")));
                    break;
                default:
                    stringMap.put(rs.getString("settingName"), rs.getString("settingValue"));
                    break;
            }
        }
    }
}

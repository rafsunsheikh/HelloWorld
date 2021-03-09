/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coinmanagement.loader.settings;

import com.coinmanagement.exception.DBConnectionException;
import com.coinmanagement.utils.Constants;
import databaseconnector.DBConnection;
import databaseconnector.DBConnector;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author sagar
 */
public class IPLoader extends BaseLoader {

    private static final Logger LOG = LogManager.getLogger("IPLoader");

    private final int LOADING_INTERVAL = Constants.LOADING_INTERVAL_ONE_DAY;
    private long LOADING_TIME = 0;

    private static IPLoader instance;

    private final ConcurrentHashMap<Integer, String> intMap;

    private IPLoader() {
        intMap = new ConcurrentHashMap<>();
    }

    public static IPLoader getInstance() {
        if (instance == null) {
            instance = new IPLoader();
        }
        return instance;
    }

    public String getIntValue(Integer name) throws Exception {
        checkForReload();
        if (intMap.containsKey(name)) {
            return intMap.get(name);
        }
        return null;
    }
    
    public ConcurrentHashMap<Integer, String> getPermittedIPAddress(){
        checkForReload();
        return intMap;
    }

    protected void clearPreviousData() {
        intMap.clear();
    }

    protected void checkForReload() {     
        if (intMap.isEmpty()) {           
            reload();
        }
    }

    public  void forceReload() {
        reload();
    }

    private synchronized void  reload() {
        DBConnection db = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            clearPreviousData();
            db = createDBReadConnection();
            String sql = makeSelectCommand();
            ps = db.connection.prepareStatement(sql);
            rs = ps.executeQuery();
            populateDataFromSql(rs);
            LOADING_TIME = System.currentTimeMillis();
        } catch (DBConnectionException | SQLException ex) {
            LOG.error(ex);
        } finally {
            closeDBReadConnection(ps, db, rs);
        }
    }

    private void closeDBReadConnection(PreparedStatement stmt, DBConnection db, ResultSet rs) {
        if (stmt != null) {
            try {
                if (rs != null) {
                    rs.close();
                }
                stmt.close();
            } catch (SQLException e) {
                LOG.error("SQL Exception while closing statement", e);
            }
        }
        if (db != null) {
            try {
                DBConnector.getInstance().freeReadConnection(db);
            } catch (Exception e) {
                LOG.error("Exception while closing db connection", e);
            }
        }
    }

    @Override
    protected String makeSelectCommand() {
        return "SELECT * FROM permittedIPAddress WHERE active=1";
    }

    @Override
    protected void populateDataFromSql(ResultSet rs) throws DBConnectionException, SQLException {
        while (rs.next()) {
            intMap.put(rs.getInt("id"), rs.getString("ip"));
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coinmanagement.loader.settings;

import com.coinmanagement.dao.BaseDAO;
import com.coinmanagement.exception.DBConnectionException;
import databaseconnector.DBConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Kazi Nasir Uddin Oly
 */
public abstract class BaseLoader extends BaseDAO {

    protected long currentTime;
    protected long loadingTime;
    protected final long TIME_INTERVAL = 60 * 60 * 1000;

    protected void checkForReload() throws DBConnectionException, SQLException {
        currentTime = System.currentTimeMillis();
        if (currentTime - loadingTime > TIME_INTERVAL) {
            loadData(true);
        }
    }

    public void forceReload() throws DBConnectionException, SQLException {
        loadData(false);
    }

    private synchronized void loadData(boolean fromCheckForReload) throws DBConnectionException, SQLException {

        if (fromCheckForReload && !(currentTime - loadingTime > TIME_INTERVAL)) {
            return;
        }

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
            loadingTime = currentTime;
        } finally {
            closeAllReadConnection(rs, ps, db);
        }
    }

    protected abstract void clearPreviousData();

    protected abstract String makeSelectCommand();

    protected abstract void populateDataFromSql(ResultSet rs) throws DBConnectionException, SQLException;
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coinmanagement.dao;

import com.coinmanagement.exception.DBConnectionException;
import com.ringid.webserver.utils.Log;
import databaseconnector.DBConnection;
import databaseconnector.DBConnector;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Kazi Nasir Uddin Oly
 */
public class BaseDAO {

    private static final Log LOG = new Log("BaseDAO");

    protected DBConnection createDBReadConnection() throws DBConnectionException {
        DBConnection db = null;
        try {
            db = DBConnector.getInstance().makeReadConnection();
        } catch (Exception ex) {
            LOG.error("Exception while connecting db", ex);
            throw new DBConnectionException("Exception while connecting db", ex);
        }
        return db;
    }

    protected void freeDBReadConnection(DBConnection db) throws DBConnectionException {
        if (db != null) {
            try {
                DBConnector.getInstance().freeReadConnection(db);
            } catch (Exception ex) {
                LOG.error("Exception while closing db connection", ex);
                throw new DBConnectionException("Exception while closing db connection", ex);
            }
        }
    }
    
    protected DBConnection createDBWriteConnection() throws DBConnectionException {
        DBConnection db = null;
        try {
            db = DBConnector.getInstance().makeWriteConnection();
        } catch (Exception ex) {
            LOG.error("Exception while connecting db", ex);
            throw new DBConnectionException("Exception while connecting db", ex);
        }
        return db;
    }
    
    protected void freeDBWriteConnection(DBConnection db) throws DBConnectionException {
        if (db != null) {
            try {
                DBConnector.getInstance().freeWriteConnection(db);
            } catch (Exception ex) {
                LOG.error("Exception while closing db connection", ex);
                throw new DBConnectionException("Exception while closing db connection", ex);
            }
        }
    }

    protected void closePreparedStatement(PreparedStatement ps) throws SQLException {
        if (ps != null) {
            ps.close();
        }
    }

    protected void closeResultSet(ResultSet rs) throws SQLException {
        if (rs != null) {
            rs.close();
        }
    }

    protected void closeAllReadConnection(ResultSet rs, PreparedStatement ps, DBConnection db) throws SQLException, DBConnectionException{
        closeResultSet(rs);
        closePreparedStatement(ps);
        freeDBReadConnection(db);
    }
    
    protected void closeAllWriteConnection(ResultSet rs, PreparedStatement ps, DBConnection db) throws SQLException, DBConnectionException{
        closeResultSet(rs);
        closePreparedStatement(ps);
        freeDBWriteConnection(db);
    }
}

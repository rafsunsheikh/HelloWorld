package com.coinmanagement.dao;

import com.coinmanagement.dto.agent.AgentAccountDTO;
import com.coinmanagement.dto.agent.AgentAuthenticationDTO;
import com.coinmanagement.dto.agent.AgentDTO;
import com.coinmanagement.dto.agent.PasswordResetDTO;
import com.coinmanagement.utils.Constants;
import databaseconnector.DBConnection;
import databaseconnector.DBConnector;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author RingID Inc.
 */
public class AgentDAO {

    private static final Logger LOG = LogManager.getLogger(AgentDAO.class.getSimpleName());
    private static AgentDAO instance;

    private AgentDAO() {
    }

    public static AgentDAO getInstance() {
        if (instance == null) {
            instance = new AgentDAO();
        }

        return instance;
    }

    public int validateUserId(String userId) throws Exception {
        DBConnection db = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String selectQuery = "SELECT id FROM agent WHERE userId LIKE ?";
        int agentId = 0;
        try {
            db = DBConnector.getInstance().makeReadConnection();

            stmt = db.connection.prepareStatement(selectQuery);
            stmt.setString(1, userId.trim());
            stmt.execute();

            rs = stmt.getResultSet();

            if (rs.next()) {
                agentId = rs.getInt("id");
            }
        } catch (Exception e) {
            throw e;
        } finally {
            closeDBReadConnection(rs, stmt, db);
        }

        return agentId;
    }

    public boolean validateAgentLogUserId(String userId, int type, int parentId) throws Exception {
        DBConnection db = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            db = DBConnector.getInstance().makeReadConnection();

            String selectQuery = "SELECT id FROM agentRegistrationLog WHERE userId LIKE ? and verificationStatus = ?";
            stmt = db.connection.prepareStatement(selectQuery);
            stmt.setString(1, userId.trim().toLowerCase());
            stmt.setBoolean(2, true);
            stmt.execute();

            rs = stmt.getResultSet();

            if (rs.next()) {
                return true;
            }

        } catch (Exception e) {
            throw e;
        } finally {
            closeDBReadConnection(rs, stmt, db);
        }

        return false;
    }

    public boolean insertAgentInfo(AgentAuthenticationDTO agent, String token) throws Exception {
        DBConnection db = null;
        PreparedStatement stmt = null;
        Savepoint transactionBegin = null;
        ResultSet rs = null;

        int index = 0;
        Timestamp createdTime = new Timestamp(Calendar.getInstance().getTimeInMillis());
        String insertQuery = "INSERT INTO agentRegistrationLog ("
                + "  parentId,"
                + "  userId,"
                + "  name,"
                + "  password,"
                + "  mobileNo,"
                + "  pin,"
                + "  address,"
                + "  type,"
                + "  verificationToken,"
                + "  created,"
                + "  ringId,"
                + "  coinCommission,"
                + "  goldCommission"
                + ") VALUES (?, ?, ?, ?, ?,?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            db = DBConnector.getInstance().makeWriteConnection();
            db.connection.setAutoCommit(false);

            transactionBegin = db.connection.setSavepoint("TransactionBegin");

            stmt = db.connection.prepareStatement(insertQuery);
            stmt.setInt(++index, agent.getParentId());
            stmt.setString(++index, agent.getEmail());
            stmt.setString(++index, agent.getName());
            stmt.setString(++index, agent.getSHA256Password(agent.getPassword()));
            stmt.setString(++index, agent.getPhone());
            stmt.setString(++index, agent.getPin());
            stmt.setString(++index, agent.getAddress());
            stmt.setInt(++index, agent.getType());
            stmt.setString(++index, agent.getSHA256Password(token));
            stmt.setTimestamp(++index, createdTime);
            stmt.setLong(++index, agent.getRingId());
            stmt.setLong(++index, agent.getCoinCommission());
            stmt.setLong(++index, agent.getGoldCommission());
            stmt.executeUpdate();
            db.connection.commit();
        } catch (Exception e) {
            rollBackDBTransaction(db, transactionBegin);
            throw e;
        } finally {
            closeDBWriteConnectionWithAutoCommit(db, stmt, rs);
        }

        return true;
    }

    public AgentDTO autheticateAgentWithUserIdAndPassword(String userId, String password) throws Exception {
        DBConnection db = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        AgentDTO agentDTO = null;
        String selectQuery = "SELECT * FROM agent WHERE userId = ? AND password = ? ";

        try {
            db = DBConnector.getInstance().makeReadConnection();

            stmt = db.connection.prepareStatement(selectQuery);
            stmt.setString(1, userId);
            stmt.setString(2, password);
            stmt.execute();

            rs = stmt.getResultSet();
            LOG.info("Check userId: " + userId + " password: " + password);
            if (rs.next()) {
                agentDTO = new AgentDTO();
                agentDTO.setAgentId(rs.getInt("id"));
                agentDTO.setParentId(rs.getInt("parentId"));
                agentDTO.setAgentUserId(rs.getString("userId"));
                agentDTO.setName(rs.getString("name"));
                agentDTO.setActive(rs.getBoolean("active"));
                LOG.info("active: " + agentDTO.getActive());
                agentDTO.setMobileNo(rs.getString("mobileNo"));
                agentDTO.setAddress(rs.getString("address"));
                agentDTO.setType(rs.getInt("type"));
                agentDTO.setRingId(rs.getLong("ringId"));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            closeDBReadConnection(rs, stmt, db);
        }

        return agentDTO;
    }

    public AgentDTO authenticateAgentRegistrationLog(String userId, String password) throws Exception {
        DBConnection db = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        AgentDTO agentDTO = null;
        String selectQuery = "SELECT * FROM agentRegistrationLog WHERE userId = ? AND password = ? ";

        try {
            db = DBConnector.getInstance().makeReadConnection();

            stmt = db.connection.prepareStatement(selectQuery);
            stmt.setString(1, userId);
            stmt.setString(2, password);
            stmt.execute();

            rs = stmt.getResultSet();
            LOG.info("Check userId: " + userId + " password: " + password);
            if (rs.next()) {
                agentDTO = new AgentDTO();
                agentDTO.setParentId(rs.getInt("parentId"));
                agentDTO.setType(rs.getInt("type"));
                agentDTO.setVerificationToken(rs.getString("verificationToken"));
                agentDTO.setVerificationStatus(rs.getBoolean("verificationStatus"));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            closeDBReadConnection(rs, stmt, db);
        }
        return agentDTO;
    }
    
    public List<AgentAccountDTO> getAgentWalletStatus(int agentId) throws Exception {

        DBConnection db = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String selectQuery = "SELECT agentId, coinId, coinAmount FROM agentAccount WHERE agentId = ? ";
        List<AgentAccountDTO> agentWalletInfo = new ArrayList<>();
        try {
            db = DBConnector.getInstance().makeReadConnection();

            stmt = db.connection.prepareStatement(selectQuery);
            stmt.setInt(1, agentId);
            stmt.execute();

            rs = stmt.getResultSet();

            while (rs.next()) {
                AgentAccountDTO agentAccountDTO = new AgentAccountDTO();
                agentAccountDTO.setAgentId(rs.getInt("agentId"));
                agentAccountDTO.setCoinId(rs.getInt("coinId"));
                agentAccountDTO.setCoinAmount(rs.getLong("coinAmount"));
                agentWalletInfo.add(agentAccountDTO);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            closeDBReadConnection(rs, stmt, db);
        }

        return agentWalletInfo;

    }

    private void closeDBReadConnection(ResultSet rs, PreparedStatement stmt, DBConnection db) {
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
    
     private void closeDBWriteConnection(ResultSet rs, PreparedStatement stmt, DBConnection db) {
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
                DBConnector.getInstance().freeWriteConnection(db);
            } catch (Exception e) {
                LOG.error("Exception while closing db connection", e);
            }
        }
    }

    private void rollBackDBTransaction(DBConnection db, Savepoint transactionBegin) {
        try {
            if (db != null) {
                db.connection.rollback(transactionBegin);
            }
        } catch (Exception ex) {
            LOG.error("Exception while rolling back transaction", ex);
        }
    }

    private void closeDBWriteConnectionWithAutoCommit(DBConnection db, PreparedStatement stmt, ResultSet rs) {
        try {
            if (db != null) {
                db.connection.setAutoCommit(true);
            }

            closeDBWriteConnection(rs, stmt, db);
        } catch (Exception e) {
            LOG.error("Exception with db connection", e);
        }
    }
}

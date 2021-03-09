/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coinmanagement.sql;

import com.coinmanagement.utils.Constants;

/**
 *
 * @author Kazi Nasir Uddin Oly
 */
public class AgentSQL {

    private static AgentSQL instance = null;

    private AgentSQL() {

    }

    public static AgentSQL getInstance() {
        if (instance == null) {
            createInstance();
        }
        return instance;
    }

    private static synchronized void createInstance() {
        if (instance == null) {
            instance = new AgentSQL();
        }
    }

    public String makeCheckPinQuery(long agentId, String pin) {
        StringBuilder builder = new StringBuilder();
        builder.append("SELECT pin FROM agent where id = ").append(agentId)
                .append(" AND pin = ").append(pin).append(";");
        return builder.toString();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coinmanagement.dto.agent;

import java.sql.Timestamp;

/**
 *
 * @author sagar
 */
public class PasswordResetDTO {

    private int id;
    private String token;
    Timestamp created;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public boolean hasValidToken() {
        return !(token == null || token.isEmpty() || token.equalsIgnoreCase("Expired"));
    }
}

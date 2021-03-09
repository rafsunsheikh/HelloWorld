/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coinmanagement.dto.agent;

/**
 *
 * @author sagar
 */
public class AgentAccountDTO {

    private int agentId;
    private int coinId;
    private long coinAmount;

    public int getAgentId() {
        return agentId;
    }

    public void setAgentId(int agentId) {
        this.agentId = agentId;
    }

    public int getCoinId() {
        return coinId;
    }

    public void setCoinId(int coinId) {
        this.coinId = coinId;
    }

    public long getCoinAmount() {
        return coinAmount;
    }

    public void setCoinAmount(long coinAmount) {
        this.coinAmount = coinAmount;
    }
}

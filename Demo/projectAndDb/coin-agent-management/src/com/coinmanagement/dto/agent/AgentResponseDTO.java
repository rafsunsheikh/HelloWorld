/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coinmanagement.dto.agent;

import com.coinmanagement.dto.RingBit.PayloadDTO;
import com.coinmanagement.dto.RingBit.RingBitPreOrderDTO;
import java.util.List;

/**
 *
 * @author sagar
 */
public class AgentResponseDTO {

    private final Boolean sucs;
    private final String mg;
    private final Integer rc;

    private final AgentDTO agentDetails;
    private final List<AgentDTO> allAgents;
    private final List<AgentAccountDTO> agentWalletStatus;
    private final List<RingBitPreOrderDTO> preOrderList;
    private final String tokenHash;
    private final PayloadDTO payloadDTO;

    private AgentResponseDTO(Builder builder) {
        this.sucs = builder.sucs;
        this.mg = builder.mg;
        this.agentDetails = builder.agentDetails;
        this.allAgents = builder.allAgents;
        this.agentWalletStatus = builder.agentWalletStatus;
        this.tokenHash = builder.tokenHash;
        this.rc = builder.rc;
        this.preOrderList = builder.preOrderList;
        this.payloadDTO = builder.payloadDTO;
    }

    public Integer getRc() {
        return rc;
    }

    public String getMg() {
        return mg;
    }

    public Boolean getSucs() {
        return sucs;
    }

    public AgentDTO getAgentDetails() {
        return agentDetails;
    }

    public List<AgentDTO> getAllAgents() {
        return allAgents;
    }

    public List<AgentAccountDTO> getAgentWalletStatus() {
        return agentWalletStatus;
    }

    public String getTokenHash() {
        return tokenHash;
    }

    public List<RingBitPreOrderDTO> getPreOrderList() {
        return preOrderList;
    }

    public static class Builder {

        private Boolean sucs;
        private String mg;
        private AgentDTO agentDetails;
        private List<AgentDTO> allAgents;
        private List<AgentAccountDTO> agentWalletStatus;
        private String tokenHash;
        private Integer rc;
        private List<RingBitPreOrderDTO> preOrderList;
        private PayloadDTO payloadDTO;

        public Builder(Boolean sucs) {
            this.sucs = sucs;
        }

        public Builder mg(String mg) {
            this.mg = mg;
            return this;
        }

        public Builder agentDetails(AgentDTO agentDetails) {
            this.agentDetails = agentDetails;
            return this;
        }

        public Builder allAgents(List<AgentDTO> allAgents) {
            this.allAgents = allAgents;
            return this;
        }

        public Builder agentWalletStatus(List<AgentAccountDTO> agentWalletStatus) {
            this.agentWalletStatus = agentWalletStatus;
            return this;
        }

        public Builder token(String tokenHash) {
            this.tokenHash = tokenHash;
            return this;
        }

        public Builder rc(Integer rc) {
            this.rc = rc;
            return this;
        }

        public AgentResponseDTO build() {
            return new AgentResponseDTO(this);
        }
        
        public Builder payload(PayloadDTO payload){
            this.payloadDTO = payload;
            return this;
        }

        public Builder orderList(List<RingBitPreOrderDTO> preOrderList) {
            this.preOrderList = preOrderList;
            return this;
        }
    }
}

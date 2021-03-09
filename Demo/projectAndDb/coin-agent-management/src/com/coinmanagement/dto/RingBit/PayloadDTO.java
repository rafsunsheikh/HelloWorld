/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coinmanagement.dto.RingBit;

/**
 *
 * @author sagar
 */
public class PayloadDTO {
    
    private Integer sender = -1;
    private Long receiver;
    private Double amount;
    private String currency = "USD";
    private String transactionType = "RING_INVESTMENT_COIN_SELL_TO_RING_USER";
    private Long paymentReferenceId;
    private String agentId;
    
    public Integer getSender() {
        return sender;
    }

    public void setSender(Integer sender) {
        this.sender = sender;
    }

    public Long getReceiver() {
        return receiver;
    }

    public void setReceiver(Long receiver) {
        this.receiver = receiver;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public Long getPaymentReferenceId() {
        return paymentReferenceId;
    }

    public void setPaymentReferenceId(Long paymentReferenceId) {
        this.paymentReferenceId = paymentReferenceId;
    }            

    public String getAgentId() {
        return agentId;
    }

    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }
    
}
//{ 
//    "sender" : "-1", 
//    "receiver" : "123456789",
//    "amount": 0.01,
//    "currency" : "USD",
//    "transactionType" : "RING_INVESTMENT_COIN_SELL_TO_RING_USER",
//    "paymentReferenceId":"2c89ec66-d295-11e7-8941-cec278b6b50a" 
//}
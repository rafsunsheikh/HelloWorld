/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coinmanagement.dto.RingBit;

import com.coinmanagement.utils.Enums;
import java.sql.Timestamp;

/**
 *
 * @author sagar
 */
public class RingBitPreOrderDTO {

    private Long id;
    private String paymentMethodType;
    private Long userId;
    private Double RingBitAmount;
    private byte transactionStatus;
    private String status;
    private Timestamp transactionDate;
    private Integer agentId;
    private Long ringId;
    private String userName;
    private Double price;
    private Double discountPrice;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPaymentMethodType() {
        return paymentMethodType;
    }

    public void setPaymentMethodType(String paymentMethodType) {
        this.paymentMethodType = paymentMethodType;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Double getRingBitAmount() {
        return RingBitAmount;
    }

    public void setRingBitAmount(Double RingBitAmount) {
        this.RingBitAmount = RingBitAmount;
    }

    public byte getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(byte transactionStatus) {
        this.transactionStatus = transactionStatus;
        setStatus(Enums.TransactionType.typeById(transactionStatus).name());
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Timestamp transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Integer getAgentId() {
        return agentId;
    }

    public void setAgentId(Integer agentId) {
        this.agentId = agentId;
    }

    public Long getRingId() {
        return ringId;
    }

    public void setRingId(Long ringId) {
        this.ringId = ringId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(Double discountPrice) {
        this.discountPrice = discountPrice;
    }

    public enum AppType {
        RingID(Byte.valueOf("1")), RingIDLive(Byte.valueOf("3"));

        private byte value;

        private AppType(byte value) {
            this.value = value;
        }

        public byte AppTypeGetValue() {
            return value;
        }
    }

}
// `id` bigint(20) NOT NULL AUTO_INCREMENT,
//  `paymentMethodType` enum('AGENT','PAYPAL') DEFAULT NULL,
//  `userId` bigint(20) NOT NULL,
//  `ringBitAmount` int(11) NOT NULL,
//  `transactionStatus` tinyint(1) DEFAULT '1' COMMENT '1=PENDING, 2=ACCEPT, 3=DECLINED',
//  `transactionDate` datetime DEFAULT NULL,
//  `agentId` int(11) DEFAULT NULL,

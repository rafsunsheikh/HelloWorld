package com.coinmanagement.utils;

import java.util.HashMap;
import java.util.Map;

public class Enums {

    public enum UserType {
        IPvision(Byte.valueOf("1")), Storekeeper(Byte.valueOf("2")), General(Byte.valueOf("3"));

        private byte value;

        private UserType(byte value) {
            this.value = value;
        }

        public byte UserTypeGetValue() {
            return value;
        }
    }

    public enum PaymentMethodType {
        SSL_Wireless_BD(Byte.valueOf("1")), Android(Byte.valueOf("2")), Apple(Byte.valueOf("3")), Windows(Byte.valueOf("4")),
        Paypal(Byte.valueOf("5")), Cash(Byte.valueOf("6")), Bank(Byte.valueOf("7")), Bkash(Byte.valueOf("8"));

        private byte value;

        private PaymentMethodType(byte value) {
            this.value = value;
        }

        public byte PaymentMethodTypeGetValue() {
            return value;
        }

        public int getValue() {
            return value;
        }
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

    public enum CashOut {
        DAILY_CASHOUT_LIMIT_FOR_GOLD("dailyCashOutLimitForGold");

        private String value;

        private CashOut(String value) {
            this.value = value;
        }

        public String CashOutGetValue() {
            return value;
        }
    }

    public enum CashOutRequestStatus {
        APPROVED(1), PENDING(2), DENIED(3), IN_PROGRESS(4);

        private int value;

        private CashOutRequestStatus(int value) {
            this.value = value;
        }

        public int CashOutRequestStatusGetValue() {
            return value;
        }
    }

    public enum CashOutRequestType {
        BANK(1), COMMON(2);

        private int value;

        private CashOutRequestType(int value) {
            this.value = value;
        }

        public int CashOutRequestTypeGetValue() {
            return value;
        }
    }

    public enum CoinBundleType {
        USER_COIN_PURCHASE(1), USER_COIN_SELL(2), USER_COIN_CONVERSION(3);

        private int value;

        private CoinBundleType(int value) {
            this.value = value;
        }

        public int CoinBundleType() {
            return value;
        }
    }

    public enum TransactionStatus {
        REGULAR((byte) 1), REFUND_REQUEST((byte) 2), REFUND_CANCELED((byte) 3), PARTIALLY_REFUNDED((byte) 4), FULLY_REFUNDED((byte) 5);

        private byte value;

        private TransactionStatus(byte value) {
            this.value = value;
        }

        public byte getTransactionStatusValue() {
            return value;
        }
    }
    
    public enum TransactionType {
        
        PENDING((byte)1), ACCEPTED((byte)2), DECLINED((byte)3);

        private Byte value;

        private TransactionType(Byte value) {
            this.value = value;
        }

        public Byte DayConversionValue() {
            return value;
        }

        static Map<Byte,TransactionType> map = new HashMap<>();

        static {
            for (TransactionType type : TransactionType.values()) {
                map.put(type.value, type);
            }
        }

        public static TransactionType typeById(Byte id) {
            return map.get(id);
        }
    }
}

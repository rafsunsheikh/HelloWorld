package com.coinmanagement.utils;

import java.util.HashMap;
import java.util.Map;

public class Constants {
    public final static int API_TYPE_GOLD = 2;
    
    public final static String SESSION = "session";
    public final static String LOGIN_TOKEN_NAME = "static-jws-token";

    public final static int GLOBAL_SUCCESSFUL = 1;
    public final static int GLOBAL_SQL_EXCEPTION = 2;

    public final static int WALLET_INSUFFICIENT_BALANCE = 3;

    public final static int TRANSFER_AVAILABLE_BONUS_COIN_T0_WALLET_INSUFFICIENT_BALANCE = 3;

    public final static int TRANSFER_COIN_USER_TO_USER_INSUFFICIENT_BALANCE = 3;

    public final static int MAKE_BONUS_COIN_AVAILABLE_FOR_TRANSFER_INSUFFICIENT_BALANCE = 3;

    public final static int BUY_COIN_INSUFFICIENT_BALANCE = 3;

    public final static int BUY_COIN_INSUFFICIENT_AGENT_BALANCE = 3;

    public final static int IPVISION_ACCOUNT_INSUFFICIENT_BALANCE = 7;

    public final static int TRANSFER_COIN_INVALID_RESELLER = 5;

    public final static int AGENT_INVALID_PIN = 4;

    public final static int DUPLICATE_MEDIA_SHARED = 3;

    public final static int DUPLICATE_COIN_BUNDLE_WITH_EXTERNAL_PRODUCT_ID = 3;

    public final static int DAILY_CHECKIN_BONUS_NOT_APPLIED = 3;

    public final static int NO_ACTIVE_RULE = 4;

    public final static int BUY_COIN_TRANSACTION_TYPE_ID = 4;

    public final static int SELL_COIN_TRANSACTION_TYPE_ID = 5;

    public final static int DAILY_CHECKIN_ALREADY_CHECKEDIN = 5;

    public final static int NOT_ELIGIBLE_FOR_STAR_DAILY_CHECK_IN = 6;

    public final static int USER_PROFILE_COMPLETION_BONUS_NOT_APPLIED = 3;
    /* ---- hard coded db values ---- */

    public final static int NETWORK_ID = 1;

    public final static int GIFT_PRODUCT_CATEGORY_ID = 1;
    public final static int DONATION_PRODUCT_CATEGORY_ID = 2;

    public final static int USER_ID_IPVISION = -1;

    public final static int SEND_GIFT_TRANSFER_TO_COIN_ID = 1;

    public final static int GOLD_COIN_ID = 1;

    public final static int CONTRIBUTOR_COUNT = 10;

    public final static int TRANSACTION_COUNT = 10;
    
    public static final byte SIGNUP_PROFILE_ATTRIBUTE = 12;

    public final static String STAR_BASE_COIN = "userStarBaseCoin";
    public final static int LOADING_INTERVAL_ONE_HOUR = 60 * 1000 * 60;    
    public final static int LOADING_INTERVAL_ONE_DAY = 24 * 60 * 1000 * 60;

    /* ---------------------------------------------------------------- */
    public final static int PRODUCT_APPROVAL_PENDING = 1;
    public final static int PRODUCT_APPROVAL_APPROVED = 2;
    public final static int PRODUCT_APPROVAL_REJECTED = 3;
    

    /*----------------------------------ruleType-------------------------------- */
    public final static int RULE_TYPE_NORMAL = 1;
    public final static int RULE_TYPE_STAR = 2;

    /*------------------------------------------------------------------ */
    public final static int DAILY_CHECK_IN = 1;
    public final static int CONSECUTIVE = 2;
    public final static int DAY_OF_WEEK = 3;
    public final static int NON_CONSECUTIVE = 4;
    public final static int STAR_DAILY_CHECK_IN = 5;

    public final static int TRANSACTION_TYPE_USER_TO_SYSTEM = 4;
    public final static int TRANSACTION_TYPE_SYSTEM_TO_USER = 5;
    public final static int TRANSACTION_TYPE_SYSTEM_TO_RESELLER = 6;
    public final static int TRANSACTION_TYPE_RESELLER_TO_SYSTEM = 7;
    public final static int TRANSACTION_TYPE_RESELLER_TO_RESELLER_OR_AGENT = 8;
    public final static int TRANSACTION_TYPE_AGENT_TO_USER = 9;
    public final static int TRANSACTION_TYPE_USER_TO_AGENT = 10;
    public final static int TRANSACTION_TYPE_USER_TO_USER = 11;
    public final static int TRANSACTION_TYPE_RESELLER_TO_RESELLER_OR_AGENT_COMMISSION = 20;
    public final static int AGENT_REGISTRATION_APPROVAL_PENDING = 1;
    public final static int AGENT_REGISTRATION_APPROVAL_APPROVED = 2;
    public final static int AGENT_REGISTRATION_APPROVAL_REJECTED = 3;
    public final static int AGENT_INFO_INSERT_BY_USER = -1;
    public final static int RESELLER_TYPE = 1;
    public final static int AGENT_TYPE = 2;

    public final static int PASSWORD_RESET_TOKEN_EXPIRE_TIME = 6;

    /* ---------------------DB RECORD STATUS--------------------------- */
    public final static int RECORD_STATUS_INSERT = 1;
    public final static int RECORD_STATUS_UPDATE = 2;
    public final static int RECORD_STATUS_DELETE = 3;

    /*-----------------------SETTINGS-----------------------------------*/
    public final static String SETTINGS_GIFT_UPDATE_TIME = "giftProductUpdateTime";

    public final static int DATA_TYPE_BOOLEAN = 1;
    public final static int DATA_TYPE_INT = 2;
    public final static int DATA_TYPE_LONG = 3;
    public final static int DATA_TYPE_DOUBLE = 4;
    public final static int LOADING_INTERVAL_FIVE_MINUTES = 5 * 1000;
    public static Integer MIN_VERSION = 147;
    public final static String DIALING_CODE_ALL = "+0";

    /*-----------------------BUNDLE TYPE---------------------------------------*/
    public final static int BUNDLE_USER_PURCHASE_FROM_SYSTEM = 1;
    public final static int BUNDLE_USER_SELL_TO_SYSTEM = 2;
    public final static int BUNDLE_AGENT_PURCHASE_FROM_SYSTEM = 3;
    public final static int BUNDLE_AGENT_SELL_TO_SYSTEM = 4;
    public final static int BUNDLE_PAGE_DONATION = 5;

    /*----------------------AGENT APPROVAL STATUS ----------------------------*/
    public final static int AGENT_APPROVAL_PENDING = 1;
    public final static int AGENT_APPROVAL_APPROVED = 2;
    public final static int AGENT_APPROVAL_REJECTED = 3;

    public final static int CASHOUT_COIN_BUNDLE_ID = 35;
    public final static String RC = "rc";
    public final static int CASHOUT_PENDING_REQUEST = 1;
    public final static int FIVE_STAR = 5;

    public final static int OLD_VERSION = 152;

    public final static int CASH_CONVERSION_BUNDLE_ID = 1;
    
    public enum TransactionStatus {
        REGULAR((byte) 1), PARTIAL_REFUND((byte) 2), FULL_REFUND((byte) 3), PENDING((byte) 4);

        private byte value;

        private TransactionStatus(byte value) {
            this.value = value;
        }
        
        public byte getValue() {
            return value;
        }
    }
    
    public static class UserTypeId {

        public static byte IP_VISION = 1;
        public static byte STORE_KEEPER = 2;
        public static byte GENERAL = 3;
    }
    
    // RESELLER USER TYPE 
    public static final int SUPER_RESELLER = 1;
    public static final int NORMAL_RESELLER = 2;
    public static final int AGENT = 3;
    
    public enum CoinRefundStatus {
        
        REGULAR((byte)1), PARTIAL_REFUND((byte)2), FULL_REFUND((byte)3), PENDING((byte)4);

        private byte value;

        private CoinRefundStatus(byte value) {
            this.value = value;
        }

        public byte CoinRefundStatus() {
            return value;
        }

        static Map<Byte, CoinRefundStatus> map = new HashMap<>();

        static {
            for (CoinRefundStatus day : CoinRefundStatus.values()) {
                map.put(day.value, day);
            }
        }

        public static CoinRefundStatus typeById(byte id) {
            return map.get(id);
        }
    } 
    
    public static final int COIN_TYPE = 1;
    public static final int CASH_TYPE = 2;
    public static final int GOLD_COIN_TYPE = 3;

    public final static Integer THREAD_POOL_SIZE = 10;
    
}

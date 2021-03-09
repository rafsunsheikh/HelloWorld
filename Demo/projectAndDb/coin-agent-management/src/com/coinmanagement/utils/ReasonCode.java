/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coinmanagement.utils;

/**
 *
 * @author user
 */
public class ReasonCode {

    /* START Replica from AppConstants */
    /* IT'S USED IN CASSANDRA LOGIN */
    public static final int SUCCESSFULL = 1; 
    public static final int INSUFFICIENT_INFORMATION = 2;
    public static final int VERIFICATION_CODE_MIS_MATCHED = 3;
    public static final int DEVICE_MUST = 4;
    public static final int VERIFICATION_MUST = 5;
    /* END Replica from AppConstants */

    public static final int NONE = 0; //
    public static final int PERMISSION_DENIED = 1;
    public static final int PASSCODE_SENT_INTERVAL = 2;
    public static final int DONT_DISTURB_MODE = 3;
    public static final int ALREADY_SHARED = 4;
    public static final int NOT_TAG_MEMBER = 5;
    public static final int TAG_DOES_NOT_EXIST = 6;
    public static final int SMS_SENDING_FAILED = 7;
    public static final int EMAIL_SENDING_FAILED = 8;
    public static final int FRIEND_OFFLINE = 9;
    public static final int NOT_FRIEND = 10;
    public static final int USERID_FRIENDID_SAME = 11;
    public static final int ALREADY_FRIEND_REQUESTED = 12;
    public static final int EXCEPTION_OCCURED = 13;
    public static final int DATABASE_ROLL_BACKED = 14;
    public static final int CANT_SHARE_OWN_FEED = 15;
    public static final int FRIEND_DID_NOT_FOUND = 16;
    public static final int SMS_SEND_RETRY_LIMIT_OVER = 17;
    public static final int NO_MORE_DATA = 18;
    public static final int FRIEND_IS_USING_LIGHT_VERSION = 19;
    public static final int CONTACT_TYPE_MISSING = 20;
    public static final int LOGGED_IN_FROM_ANOTHER_DEVICE = 21;
    public static final int ANONYMOUS_CALL_IS_NOT_ALLOWED = 22;
    public static final int USER_DID_NOT_FOUND = 23;
    public static final int PASSWORD_DID_NOT_MATCHED = 24;
    public static final int INVALID_IMAGE_PROPERTY = 25;
    public static final int USER_EXISTS = 26;
    public static final int DUPLICATE_DATA = 27;
    public static final int QUERY_EXECUTION_SUCCESSFULL = 28;
    public static final int QUERY_GROUP_NOT_FOUND = 29;
    public static final int NOT_MATCHED = 30;
    public static final int FRIEND_USING_WEB_VERSION = 31;
    public static final int CELEBRITY_FOLLOW_FAILED = 32;
    public static final int THIS_IS_SPECIAL_FRIEND = 33;
    public static final int ALREADY_LIKED = 34;
    public static final int ALREADY_FRIEND = 35;
    public static final int CONTENT_NOT_FOUND = 36;
    public static final int ANONYMOUS_CHAT_BLOCKED = 37;
    public static final int DEVICE_ID_DID_NOT_MATCHED = 38;
    public static final int PHONE_NUMBER_IS_UNVERIFIED = 39;
    public static final int EMAIL_IS_UNVERIFIED = 40;
    public static final int FACEBOOK_IS_UNVERIFIED = 41;
    public static final int TWITTER_IS_UNVERIFIED = 42;
    public static final int FACEBOOK_ID_DID_NOT_MATCHED = 43;
    public static final int TWITTER_ID_DID_NOT_MATCHED = 44;
    public static final int INVALID_RINGID = 45;
    public static final int INVALID_PHONE_NUMBER = 46;
    public static final int INVALID_EMAIL = 47;
    public static final int DEVICE_UNIQUE_ID_MENDATORY = 48;
    public static final int PASSWORD_MENDATORY = 49;
    public static final int LOGIN_TYPE_MENDATORY = 50;
    public static final int DIALING_CODE_MENDATORY = 51;
    public static final int PHONE_NUMBER_MENDATORY = 52;
    public static final int RING_ID_MENDATORY = 53;
    public static final int EMAIL_MENDATORY = 54;
    public static final int VERSION_MENDATORY = 55;
    public static final int DEVICE_MENDATORY = 56;
    public static final int INVALID_INFORMATION = 57;
    public static final int NAME_MENDATORY = 58;
    public static final int FRIEND_LIMIT_OVER = 60;
    public static final int MEMBER_LIMIT_OVER = 61;
    public static final int USER_HAS_NO_SESSION = 62;
    public static final int NAME_CONTAINS_RINGID = 63;
    public static final int PENDING_FRIEND_LIMIT_OVER = 64;
    public static final int FRIENDS_PENDING_FRIEND_LIMIT_OVER = 65;
    public static final int FRIENDS_FRIEND_LIMIT_OVER = 66;
    public static final int INVALID_PASSWORD_LENGTH = 67;
    public static final int OPERATION_FAILED = 68;
    public static final int DEVICE_TOKEN_NOT_FOUND = 69;
    public static final int NOT_FOUND = 404;
    public static final int INVALID_NEWSPORTAL_PROPERTY = 69;
    public static final int FRIEND_AWAY = 70;
    public static final int ALREADY_SPAM_DECLARED = 71;
    public static final int SPAM_CONTENT_NOT_FOUND = 72;
    public static final int NEWS_PORTAL_CATEGORY_ID_NOT_FOUND = 73;
    public static final int NEWS_PORTAL_CATEGORY_ID_NOT_IN_RANGE = 74;
    public static final int NEWS_CATEGORY_ID_NOT_FOUND = 75;
    public static final int STATUS_MUST_NOT_BE_EMPTY = 76;
    public static final int COUNTRY_MANDATORY = 77;
    public static final int CATEGORY_LIST_NOT_FOUND = 78;
    public static final int UNWANTED_LOGIN = 79;
    public static final int INVALID_FEED_TYPE = 80;
    public static final int ALREADY_DELETED = 81;
    public static final int ALREADY_SUBSCRIBED = 82;
    public static final int UNKNOW_ERROR = 83;
    public static final int STREAM_SERVER_NOT_READY = 84;
    public static final int RE_INITIALIZE_STREAM = 85;
    public static final int UPDATE_FAILED = 86;
    public static final int YOU_CANT_UNFOLLOW_FRIEND = 87;
    public static final int NO_UPDATE_AVAILABLE = 88;
    public static final int CHANNEL_SERVER_NOT_READY = 89;
    public static final int INVALID_SESSION = 90;
    public static final int KEY_MISMATCHED = 91;
    public static final int FRIEND_USING_RINGID_LIVE = 92;
    public static final int SERVER_FAILURE = 93;
    public static final int FORCE_SIGN_OUT = 94;
    public static final int DUPLICATE_PHONE_NUMBER = 95;

    public static final int NO_DATA_FOUND = 304;
    public static final int IN_APP_PURCHASE_FAILED_USER_ERROR = 305;
    public static final int IN_APP_PURCHASE_FAILED_SYSTEM_ERROR = 306;
    public static final int VERIFIED_NUMBER_CAN_NOT_BE_CHANGED = 307;
    public static final int PSUH_SENDING_FAILED = 308;
    public static final int PSUH_NOTIFICATION_IS_DISABLED = 309;

    public static final int NOT_PUBLIC_FEED = 101;
    public static final int SHARED_FEED = 103;
    public static final int OWN_FEED = 105;
    public static final int WALL_POST_BY_FRIEND = 107;
    public static final int GROUP_FEED = 109;
    public static final int BLOCKED_BY_FEED_OWNER = 111;
    public static final int GROUP_FEED_CANT_BE_SHARED = 113;

    public static final int NOT_GROUP_MEMBER = 202;
    public static final int INVALID_PRIVACY = 203;
    public static final int USER_BLOCKED = 204;
    public static final int ID_NOT_PROVIDED = 502;    

    /**
     * 16.11.2015
     */
    public static final int INVALID_CONTACTTYPE = 503;
    public static final int ALREADY_ACCEPTED = 504;
    public static final int WRONG_REQUESTER = 505;

    /**
     * 10.12.2015
     */
    public static final int ALREADY_VERIFIED = 301;

    /**
     * 12.12.2015
     */
    public static final int INVALID_MOBILE = 302;

    /**
     * 27.12.2015
     */
    public static final int UNAUTHORIZED_USER = 420;

    /**
     * 17-04-2016
     */
    public static final int ALREADY_SPECIAL = 520;

    /**
     * 10-05-2016
     */
    public static final int INCOMING_REQUEST_ALLOWED = 1001;
    public static final int INCOMING_REQUEST_NOT_ALLOWED = 1002;
    public static final int AUTO_FRIEND_ALLOWED = 1003;
    public static final int AUTO_FRIEND_NOT_ALLOWED = 1004;
    public static final int INVALID_USER_TYPE = 1005;

    /**
     * 03-08-2016
     */
    public static final int FEED_NOT_FOUND = 1101;

    /**
     * author: abdullah
     */
    public static final int INVALID_CATEGORY = 1102;

    /*
     * 14-08-2016
     */
    public static final int CATEGORY_NOT_FOUND_IN_NEWS_PORTAL = 1201;
    public static final int NEWS_PORTAL_CATEGORIES_ALREADY_SUBSCRIBED = 1202;
    public static final int NEWS_PORTAL_SUBSCRIPTION_FAILED = 1203;
    public static final int CATEGORY_NOT_FOUND_IN_BUSINESS_PAGE = 1204;
    public static final int BUSINESS_PAGE_CATEGORIES_ALREADY_SUBSCRIBED = 1205;
    public static final int BUSINESS_PAGE_SUBSCRIPTION_FAILED = 1206;
    public static final int CATEGORY_NOT_FOUND_IN_MEDIA_PAGE = 1207;
    public static final int MEDIA_PAGE_CATEGORIES_ALREADY_SUBSCRIBED = 1208;
    public static final int MEDIA_PAGE_SUBSCRIPTION_FAILED = 1209;
    public static final int NEWS_PORTAL_ALREADY_UNSUBSCRIBED = 1210;
    public static final int BUSINESS_PAGE_ALREADY_UNSUBSCRIBED = 1211;
    public static final int MEDIA_PAGE_ALREADY_UNSUBSCRIBED = 1212;
    public static final int INVALID_PAGE_ID = 1213;
    public static final int PAGE_NOT_FOLLOWED = 1214;
    public static final int ALREADY_OWNS_A_PAGE = 1215;

    /**
     * album
     */
    public static final int ALBUM_DETAILS_NOT_FOUND = 5000;
    public static final int INVLID_ALBUM_PROPERTY = 5001;
    public static final int ALBUM_CREATE_FAILED = 5002;
    public static final int MEDIA_INSERT_FAILED = 5003;
    public static final int INVALID_MEDIA_PROPERTY = 5004;

    /**
     * media
     */
    public static final int INVALID_IMAGE_TYPE = 5005;
    public static final int INVALID_MEDIA_TYPE = 5006;

    public static final int ALREADY_SAVED = 5009;
    public static final int SAME_USERID_AND_WALLOWNERID = 5010;

    public static final int USER_NOT_SPECIAL = 5011;
    public static final int INVALID_LIMIT = 5012;

    public static final int INVALID_UUID_VERSION = 5013;
    public static final int INVALID_PAGE_TYPE = 5014;
    public static final int CANNOT_BE_DISCOVERABLE = 5015;

    public static final int CANT_SHARE_SHARED_FEED = 5030;
    public static final int WALL_OWNER_AND_GUEST_WRITER_CANT_BE_SAME = 5031;
    public static final int PAGE_CANT_HAVE_GUEST_WRITER = 5032;

    public static final int NOTHING_TO_UPDATE = 5033;
    public static final int CANT_SHARE_TRANSIENT_FEED = 5034;

    public static final int INVALID_COUNTRY_CODE = 5035;
    public static final int IMAGE_TYPE_MISMATCH = 5036;
    public static final int MEDIA_DELETE_FAILED = 5037;
    public static final int ALREADY_UPDATED = 5038;
    public static final int INVALID_REQUEST = 5039;
    public static final int INVALID_TIME_UUID = 5040;
    /**
     * Video call not allowed for special contacts
     */
    public static final int VIDEO_CALL_NOT_ALLOWED = 5041;

    public static final int CHANNEL_CREATION_LIMIT_OVER = 5042;
    public static final int CHANNEL_HAS_NO_PUBLISHED_MEDIA = 5043;

    /**
     * live streaming
     */
    public static final int AVAILABLE_IN_NEXT_VERSION = 2001;
    public static final int MAX_LIVE_CALL_TARIFF_EXCEEDED = 2002;
    public static final int INVALID_LIVE_TIME = 2003;

    /**
     * spam report
     */
    public static final int REPORT_NOT_FOUND = 2020;

    /**
     * Vote
     */
    public static final int ALREADY_VOTED = 5044;
    public static final int VOTE_LIMIT_EXCEEDED = 5045;
    public static final int OTP_SENT_LIMT_OVER = 5046;

    /**
     * wallet
     */
    public static final int MEDIA_SHARE_LIMIT_OVER = 6001;

    /*
    ***********
    | CAPTCHA | 
    ***********
     */
    public static final int REQUIRE_CAPTCHA = 6049;
    public static final int MISSING_CAPTCHA_TOKEN = 6050;
    public static final int CAPTCHA_REQUEST_TIMEOUT = 6051;
    public static final int CAPTCHA_VERIFICATION_FAILED = 6052;
    public static final int CAPTCHA_VERIFICATION_FAILED_WITH_ERROR = 6053;

    /**
     * user account de-active/close
     */
    public static final int CANNOT_DEACTIVATE_WITHIN_SEVEN_DAYS = 7000;
    public static final int ALREADY_NOT_ACTIVE = 7001;
    public static final int ACCOUNT_CLOSED = 7002;
    public static final int NOT_DEACTIVE = 7003;

    public static final int DEVICE_SMS_SEND_RETRY_LIMIT_OVER = 7005;
    public static final int USER_SPAMMED = 7006;

    /**
     * COIN MANAGEMENT 25 JULY 2017
     */
    public static final int INSUFFICIENT_BALANCE = 100000;
    public static final int NOT_STAR_USER = 100001;
    public static final int BONUS_NOT_APPLICABLE = 100002;
    public static final int ALREADY_CHECKED_IN = 100003;
    public static final int PENDING_CASHOUT_REQUEST = 100004;
    public static final int ALREDAY_GET_SIGN_UP_COIN = 100005;
    
    
    /**
     * RESELLER MANAGEMENT
     */
    public static final int PENDING_RESELLER_REGISTRATION_REQUEST = -100;
    public static final int DB_INSERTION_FAIL = -1000;
}

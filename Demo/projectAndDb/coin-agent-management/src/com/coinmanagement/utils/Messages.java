package com.coinmanagement.utils;

public class Messages {

    public final static String SAVE_SUCCESS = "%1s saved successfully";
    public final static String UPDATE_SUCCESS = "%1s updated successfully";
    public final static String DELETE_SUCCESS = "%1s deleted successfully";
    public final static String DUPLICATE_ENTRY = "Error occurred. A %1s with same %2s already exists.";
    public final static String FOREIGN_KEY_CONSTRAINT = "Related data exists. You cannot %1s, you can only %2s.";
    public final static String GENERIC_ERROR_MESSAGE = "Error occurred";
    public final static String GENERIC_INVALID_DATA_ERROR_MESSAGE = "Error occurred, valid data required";
    public final static String GENERIC_REQUIRED_MESSAGE = "%1s required";
    public final static String GENERIC_INVALID_VALUE_MESSAGE = "%1s have invalid value";
    public final static String DUPLICATE_REFERRAL_RULE_ERROR = "A rule under this referral rule and same connection level already exists.";
    public final static String DUPLICATE_SHARE_TO_SOCIAL_MEDIA_RULE_ERROR = "A rule for this social media already exists.";
    public final static String DUPLICATE_PROFILE_COMPLETION_RULE_ERROR = "A rule for this attribute title already exists.";
    public final static String DUPLICATE_DAILY_CHECK_IN_RULE_ERROR = "A rule having same daily check-in day type and day number already exists.";
    public final static String DUPLICATE_DWELL_TIME_RULE_ERROR = "A rule having same dwell time already exists.";
    public final static String DUPLICATE_COIN_BUNDLE_QTY_ERROR = "A coin bundle having same quantity, bundle type, network, currency, payment method type already exists.";
    public final static String DUPLICATE_COIN_BUNDLE_WITH_EXTERNAL_PRODUCTID_ERROR = "A coin bundle having same  payment method type and external product id already exists.";
    public final static String COIN_BUNDLE_INACTIVE_ERROR = "Coin bundle is inactive now.";
    public final static String INVALID_CASHOUT_REQUEST_STATUS = "Cashout request status is invalid";
    public final static String ALREADY_APPROVED_CASHOUT_REQUEST = "Cashout request is alreay approved.";
    public final static String INVALID_CASHOUT_PAYMENT_METHOD = "Cashout request payment method is invalid";
    public final static String INVALID_COIN_BUNDLE_ID = "Cashout request coin bundle is invalid";

    public final static String COIN_BUNDLE_NOT_APPLICABLE_FOR_SALE = "Coin bundle is not for sale";
    public final static String INVALID_PAYMENT_TYPE_ID = "Payment method type id is not valid";
    public final static String REQUESTED_COIN_AMOUNT_LIMIT_EXCEED = "Requested coin amount exceeds limit";
    public final static String REQUESTED_COIN_AMOUNT_BALANCE_LIMIT_EXCEED = "Requested cashout coin amount exceeds current user balance";
    public final static String PENDING_CASHOUT_REQUEST = "pending cashout request";

    public final static String COIN_TRANSFER_SUCCESS = "Coin transferred successfully";
    public final static String COIN_CONVERSION_SUCCESS = "Coin converted  successfully";
    public final static String INSUFFICIENT_BALANCE = "Insufficient balance";
    public final static String INSUFFICIENT_AGENT_BALANCE = "Insufficient agent balance";
    public final static String AGENT_INVALID_PIN = "Invalid pin";
    public final static String TRANSFER_BALANCE_SUCCESS = "%1s amount transferred successfully";
    public final static String STOREKEEPER_REGISTRATION_SUCCESS = "Storekeeper registered successfully";
    public final static String STOREKEEPER_REGISTRATION_FAILURE = "Error occurred while saving storekeeper information";
    public final static String COIN_BUY_SELL_SUCCESS = "%1s %2s successfully";
    public final static String VALID_API_HASHTOKEN = "API key is valid";
    public final static String INVALID_API_HASHTOKEN = "API key is invalid, permission denied";
    public final static String DAILY_CHECKIN_BONUS_NOT_APPLIED = "No bonus coin added for daily check-in rule";
    public final static String DAILY_CHECKIN_ALREADY_CHECKEDIN_TODAY = "You have already checked in today";
    public final static String USER_PROFILE_COMPLETION_BONUS_NOT_APPLIED = "No bonus coin added for this profile attribute rule";
    public final static String NO_ACTIVE_RULE_FOUND = "No active %1s rule found.";
    public final static String NO_ACTIVE_OR_VALID_PRODUCT_FOUND = "Product is no longer active or valid.";
    public final static String ONE_OR_MORE_PRODUCTS_INACTIVE_OR_INVALID = "One or more products are no longer active or valid.";
    public final static String GENERIC_SUCCESS = "%1s successfully";
    public final static String COIN_BUNDLE_NOT_FOUND = "Coin Bundle with ID: %1d not found";
    public final static String NOT_STAR_USER = "Not eligible for star daily check in";
    public final static String NOT_FOUND = "active %1s not found";
    public final static String ALREADY_GOT_SIGNUP_BONUS = "You have already received signup coin";

    public final static String AGENT_REGISTRATION_SUCCESS = "Agent registered successfully";
    public final static String AGENT_REGISTRATION_FAILURE = "Error occurred while saving Agent information";
    public final static String AGENT_INVALID_USERNAME_OR_PASSWORD = "Email or password does not match";
    public final static String AGENT_INACTIVE = "Agent not active yet";
    public final static String AGENT_LOGIN_SUCCESS = "Agent login successfully";
    public final static String AGENT_DUPLICATE_ENTRY = "Email already exists";
    public final static String AGENT_PARAMS_VALIDATION_ERROR = "Invalid data sent to agent api. Error occuered while reading data";
    public final static String AGENT_PASSWORD_RESET_SUCCESS = "Successfully token created for passsword reset";
    public final static String AGENT_PASSWPRD_RESET_FAILURE = "Password reset token generation failure";
    public final static String AGENT_PASSWORD_UPDATE_SUCCESS = "Password successfully updated";
    public final static String AGENT_EMAIL_VERIFICATION_SUCCESS = "Email verification successfull";
    public final static String AGENT_PASSWPRD_UPDATE_FAILURE = "Password update failure";
    public final static String AGENT_PIN_UPDATE_SUCCESS = "Pin successfully updated";
    public final static String AGENT_PIN_UPDATE_FAILURE = "Pin update failure";
    public final static String AGENT_ACCOUNT_PENDING = "Your account is waiting for admin approval. Contact an admin";
    public final static String EMAIL_VERIFICATION_PENDING = "Email is Unverified";

    public final static String IPVISION_ACCOUNT_INSUFFICIENT_BALANCE = "Not sufficient balance in main account";
    public final static String INVALID_INPUT_PARAMS = "Invalid input params";
    public final static String ACTIVE_DATA_NOT_FOUND = "No active data found for %1s Id";
    public final static String TRANSFER_COIN_INVALID_RESELLER = "INVALID RESELLER";
    public final static String BUY_COIN_INSUFFICIENT_BALANCE = "INSUFFICIENT BALANCE";
    public final static String AGENT_COIN_TRANSFER_SUCCESSFUL = "Successfully transfer coin to agent/reseller account";
    public final static String AGENT_COIN_TRANSFER_FAILURE = "Coin Transfer Failure";
    public final static String CASHOUT_REQUEST_PENDING_MAIL_CONTENT = "Your cashout request is pending for admin verification.";

    public final static String CASH_TO_COIN_CONVERSION_SUCCESSFULL = "Cash conversion successfull";
    public final static String TRANSACTION_NOT_FOUND_BY_ID = "No transaction found for id %1s";
    public final static String INVALID_REQUEST = "%1s request is invalid";
    public final static String ALREADY_IN_PENDING = "%1s request already pending";
    public final static String DUPLICATE_REQUEST_FOR_TRANSACTION = "Duplicate refund request for transactionId - %d";
    public final static String DB_INSERTION_FAIL = "DB insertion failed";
    public final static String DB_INSERTION_SUCCESS = "DB insertion success";

}

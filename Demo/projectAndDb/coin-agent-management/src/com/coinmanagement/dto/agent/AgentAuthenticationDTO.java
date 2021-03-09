package com.coinmanagement.dto.agent;

import com.coinmanagement.utils.HashGeneratorUtils;
import java.io.IOException;

/**
 *
 * @author RingID Inc.
 */
public class AgentAuthenticationDTO {

    private String email;
    private String name;
    private String password;
    private String newPassword;
    private String uId;
    private String phone;
    private String pin;
    private String address;
    private int agentId;
    private String agentUserId;
    private int parentId;
    private String parentUserId;
    private int coinAmount;
    private int type;
    private long tnxId;
    private Long ringId;
    private String tType;
    private int status;
    private int coinCommission;
    private int goldCommission;
    private int apiType;

    public String getName() {
        return name;
    }

    public void setName(String name) throws IOException {
        if (name == null || name.isEmpty()) {
            throw new IOException("Name is required");
        }
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) throws IOException {
        if (password == null || password.isEmpty()) {
            throw new IOException("Password is required");
        }
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws IOException {
        if (email == null || email.isEmpty()) {
            throw new IOException("Email is required");
        }
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) throws IOException {
        if (phone == null || phone.isEmpty()) {
            throw new IOException("Phone number must be valid");
        }
        this.phone = phone;
    }

    public boolean validate() throws IOException {
        setPin(this.pin);
        setEmail(this.email);
        setPhone(this.phone);
        setAddress(this.address);
        setName(this.name);
        setType(this.type);
        setParentId(this.parentId);
        if (this.parentId == -1) {
            setPassword(this.password);
        }
        return true;
    }

    public boolean validLoginCredintial() {
        return !(email == null || email.isEmpty() || password == null || password.isEmpty());
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) throws IOException {
        if (pin == null || pin.isEmpty()) {
            throw new IOException("pin must be present");
        }
        this.pin = pin;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if (address == null || address.isEmpty()) {
            this.address = "Not Set";
        } else {
            this.address = address;
        }
    }

    public int getType() {
        return type;
    }

    public void setType(int type) throws IOException {
        if (type < 1 && type > 2) {
            throw new IOException("Invalid type. Reseller=1 and Agent=2");
        }
        this.type = type;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) throws IOException {
        if (newPassword == null || newPassword.isEmpty()) {
            throw new IOException("Provide a valid reset password");
        }
        this.newPassword = newPassword;
    }

    public void setHashPassword(String hashPassword) {
        this.password = hashPassword;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) throws IOException {
        if (uId == null || uId.isEmpty()) {
            throw new IOException("uId must be present");
        }
        this.uId = uId;
    }

    public boolean validateResetParams() throws IOException {
        if (uId != null && !uId.isEmpty()) {
            validatePasswordResetParams();
        } else {
            validatePasswordChangeParams();
        }

        return true;
    }

    public boolean validatePasswordResetParams() throws IOException {
        setNewPassword(getNewPassword());
        setuId(uId);
        return true;
    }

    public boolean validateEmailVerificationParams() throws IOException {
        setuId(uId);
        return true;
    }

    public boolean validatePasswordChangeParams() throws IOException {
        setNewPassword(getNewPassword());
        setPassword(password);
        setEmail(email);
        return true;
    }

    public int getAgentId() {
        return agentId;
    }

    public void validateAgentId(int agentId) throws Exception {
        if (agentId < 1) {
            throw new IOException("agentId must be greater than 1");
        }
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) throws IOException {
        if (parentId < -1) {
            throw new IOException("Invalid Parent Id");
        }
        this.parentId = parentId;
    }

    public boolean validateEditParams() throws Exception {
        validateAgentId(agentId);
        return !((name == null || name.isEmpty()) && (address == null || address.isEmpty())
                && (phone == null || phone.isEmpty()) && (pin == null || pin.isEmpty()));
    }

    public boolean hasValidPassword() {
        return !(password == null || password.isEmpty());
    }

    public int getCoinAmount() {
        return coinAmount;
    }

    public void setCoinAmount(int coinAmount) throws IOException {
        if (coinAmount < 1) {
            throw new IOException("Coin Amount Must be Greated than 0");
        }
        this.coinAmount = coinAmount;
    }

    public boolean validateCoinTransferParams() throws IOException {
        setCoinAmount(coinAmount);
        setParentId(parentId);
        setAgentId(agentId);
        setPin(pin);
        return true;
    }

    public void setAgentId(int agentId) throws IOException {
        if (agentId < 1) {
            throw new IOException("agentId must be greated than 1");
        }
        this.agentId = agentId;
    }

    public String getSHA256Password(String password) throws Exception {
        return HashGeneratorUtils.generateSHA256(password);
    }

    public long getTnxId() {
        return tnxId;
    }

    public void setTnxId(long tnxId) throws IOException {
        if (tnxId < 1) {
            throw new IOException();
        }
        this.tnxId = tnxId;
    }

    public String gettType() {
        return tType;
    }

    public void settType(String tType) throws IOException {
        if ("ACCEPT".equals(tType) || "DECLINE".equals(tType)) {
            this.tType = tType;
            return;
        }
        throw new IOException();
    }

    public boolean validAgentRefundRequestParams() throws Exception {
        setTnxId(tnxId);
        setAgentId(agentId);
        return true;
    }

    public boolean validRefundRequestParams() throws Exception {
        setTnxId(tnxId);
        setAgentId(agentId);
        settType(tType);
        setStatus();
        return true;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus() {
        if (tType.equals("ACCEPT")) {
            this.status = 2;
        } else if (tType.equals("DECLINE")) {
            this.status = 3;
        }
    }

    public boolean validateAgentPreOrderHistoryParams() throws Exception {
        setAgentId(agentId);
        return true;
    }

    public Long getRingId() {
        return ringId;
    }

    public void setRingId(Long ringId) {
        this.ringId = ringId;
    }

    public int getCoinCommission() {
        return coinCommission;
    }

    public void setCoinCommission(int coinCommission) {
        this.coinCommission = coinCommission;
    }

    public int getGoldCommission() {
        return goldCommission;
    }

    public void setGoldCommission(int goldCommission) {
        this.goldCommission = goldCommission;
    }

    public boolean validateCommissionParams() throws Exception {
        validateAgentId(agentId);
        return !(coinCommission < 0 || goldCommission < 0);
    }

    public String getAgentUserId() {
        return agentUserId;
    }

    public void setAgentUserId(String agentUserId) {
        this.agentUserId = agentUserId;
    }

    public String getParentUserId() {
        return parentUserId;
    }

    public void setParentUserId(String parentUserId) {
        this.parentUserId = parentUserId;
    }

    public int getApiType() {
        return apiType;
    }

    public void setApiType(int apiType) {
        this.apiType = apiType;
    }

}

package com.coinmanagement.dto.agent;

import java.sql.Timestamp;

/**
 *
 * @author RingID Inc.
 */
public class AgentDTO {

    private Long logId;
    private Byte approvalStatus;
    private Boolean active;

    private Integer agentId;
    private Integer parentId;
    private String parentUserId;
    private Integer createdBy;
    private Integer lastModifiedBy;

    private String userId;
    private Long ringId;
    private String name;
    private String password;
    private String mobileNo;
    private String address;
    private String pin;
    private String externalRemarks;
    private String adminRemarks;
    private Integer type;

    private Timestamp created;
    private Timestamp lastModified;
    private Boolean verificationStatus;
    private String verificationToken;
    
    private Integer coinCommission;
    private Integer goldCommission;

    public Long getLogId() {
        return logId;
    }

    public void setLogId(Long logId) {
        this.logId = logId;
    }

    public Byte getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(Byte approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Integer getAgentId() {
        return agentId;
    }

    public void setAgentId(Integer agentId) {
        this.agentId = agentId;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }
    
    public String getParentUserId() {
        return parentUserId;
    }

    public void setParentUserId(String parentUserId) {
        this.parentUserId = parentUserId;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Integer getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(Integer lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public String getAgentUserId() {
        return userId;
    }

    public void setAgentUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getExternalRemarks() {
        return externalRemarks;
    }

    public void setExternalRemarks(String externalRemarks) {
        this.externalRemarks = externalRemarks;
    }

    public String getAdminRemarks() {
        return adminRemarks;
    }

    public void setAdminRemarks(String adminRemarks) {
        this.adminRemarks = adminRemarks;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public Timestamp getLastModified() {
        return lastModified;
    }

    public void setLastModified(Timestamp lastModified) {
        this.lastModified = lastModified;
    }

    public boolean hasValidToken() {
        return !(userId == null || userId.isEmpty());
    }

    public Boolean getVerificationStatus() {
        return verificationStatus;
    }

    public void setVerificationStatus(Boolean verificationStatus) {
        this.verificationStatus = verificationStatus;
    }

    public String getVerificationToken() {
        return verificationToken;
    }

    public void setVerificationToken(String verificationToken) {
        this.verificationToken = verificationToken;
    }

    public Long getRingId() {
        return ringId;
    }

    public void setRingId(Long ringId) {
        this.ringId = ringId;
    }
    
    public Integer getCoinCommission() {
        return coinCommission;
    }

    public void setCoinCommission(Integer coinCommission) {
        this.coinCommission = coinCommission;
    }
    
    public Integer getGoldCommission() {
        return goldCommission;
    }

    public void setGoldCommission(Integer goldCommission) {
        this.goldCommission = goldCommission;
    }

}

package com.mobu.jokar.bean;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class SignUpWithMobileResponse implements Serializable
{

    @SerializedName("userType")
    @Expose
    private String userType;

    @SerializedName("signupCompeted")
    @Expose
    private Boolean signupCompeted;
    @SerializedName("normalUserNotification")
    @Expose
    private Boolean normalUserNotification;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("createdAt")
    @Expose
    private String createdAt;
    @SerializedName("createdAt1")
    @Expose
    private String createdAt1;
    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("mobileNumber")
    @Expose
    private String mobileNumber;
    @SerializedName("countryCode")
    @Expose
    private String countryCode;
    @SerializedName("mobileOtp")
    @Expose
    private String mobileOtp;
    @SerializedName("addresses")
    @Expose
    private List<Object> addresses = null;
    @SerializedName("updatedAt")
    @Expose
    private String updatedAt;
    @SerializedName("__v")
    @Expose
    private Integer v;
    private final static long serialVersionUID = 8793510871510632501L;

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public Boolean getSignupCompeted() {
        return signupCompeted;
    }

    public void setSignupCompeted(Boolean signupCompeted) {
        this.signupCompeted = signupCompeted;
    }

    public Boolean getNormalUserNotification() {
        return normalUserNotification;
    }

    public void setNormalUserNotification(Boolean normalUserNotification) {
        this.normalUserNotification = normalUserNotification;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedAt1() {
        return createdAt1;
    }

    public void setCreatedAt1(String createdAt1) {
        this.createdAt1 = createdAt1;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getMobileOtp() {
        return mobileOtp;
    }

    public void setMobileOtp(String mobileOtp) {
        this.mobileOtp = mobileOtp;
    }

    public List<Object> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Object> addresses) {
        this.addresses = addresses;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getV() {
        return v;
    }

    public void setV(Integer v) {
        this.v = v;
    }

}

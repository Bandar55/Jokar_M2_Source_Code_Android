package com.mobu.jokar.bean;

import com.google.gson.annotations.SerializedName;

public class SignupInner {

    @SerializedName("name")
    private String name;

    @SerializedName("mobileNumber")
    private String mobileNumber;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
}

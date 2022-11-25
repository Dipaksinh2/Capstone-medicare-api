package com.medicare.entity;

import java.util.List;

public class OrderInput {
    private String userFullName;
    private String userFullAddress;
    private String userContactNumber;
    private String userAlternateContactNumber;
    private List<OrderProductQty> orderProductQties;


    public String getUserFullName() {
        return userFullName;
    }

    public void setUserFullName(String userFullName) {
        this.userFullName = userFullName;
    }

    public String getUserFullAddress() {
        return userFullAddress;
    }

    public void setUserFullAddress(String userFullAddress) {
        this.userFullAddress = userFullAddress;
    }

    public String getUserContactNumber() {
        return userContactNumber;
    }

    public void setUserContactNumber(String userContactNumber) {
        this.userContactNumber = userContactNumber;
    }

    public String getUserAlternateContactNumber() {
        return userAlternateContactNumber;
    }

    public void setUserAlternateContactNumber(String userAlternateContactNumber) {
        this.userAlternateContactNumber = userAlternateContactNumber;
    }

    public List<OrderProductQty> getOrderProductQties() {
        return orderProductQties;
    }

    public void setOrderProductQties(List<OrderProductQty> orderProductQties) {
        this.orderProductQties = orderProductQties;
    }
}

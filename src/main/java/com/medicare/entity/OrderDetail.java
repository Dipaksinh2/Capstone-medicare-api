package com.medicare.entity;

import javax.persistence.*;

@Entity
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;
    private String orderUserName;
    private String orderUserAddress;
    private String orderUserContact;
    private String orderUserAlternateContact;
    private String orderStatus;
    private Double orderAmount;
    @OneToOne
    private Product product;
    @OneToOne
    private User user;

    protected OrderDetail() {
    }

    public OrderDetail(String orderUserName, String orderUserAddress, String orderUserContact,
                       String orderUserAlternateContact, String orderStatus, Double orderAmount, Product product, User user) {
        this.orderUserName = orderUserName;
        this.orderUserAddress = orderUserAddress;
        this.orderUserContact = orderUserContact;
        this.orderUserAlternateContact = orderUserAlternateContact;
        this.orderStatus = orderStatus;
        this.orderAmount = orderAmount;
        this.product = product;
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public OrderDetail(String orderUserName, String orderUserAddress, String orderUserContact,
                       String orderUserAlternateContact, String orderStatus, Double orderAmount) {
        super();
        this.orderUserName = orderUserName;
        this.orderUserAddress = orderUserAddress;
        this.orderUserContact = orderUserContact;
        this.orderUserAlternateContact = orderUserAlternateContact;
        this.orderStatus = orderStatus;
        this.orderAmount = orderAmount;
    }

    public Long getOrderId() {
        return orderId;
    }
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
    public String getOrderUserName() {
        return orderUserName;
    }
    public void setOrderUserName(String orderUserName) {
        this.orderUserName = orderUserName;
    }
    public String getOrderUserAddress() {
        return orderUserAddress;
    }
    public void setOrderUserAddress(String orderUserAddress) {
        this.orderUserAddress = orderUserAddress;
    }
    public String getOrderUserContact() {
        return orderUserContact;
    }
    public void setOrderUserContact(String orderUserContact) {
        this.orderUserContact = orderUserContact;
    }
    public String getOrderUserAlternateContact() {
        return orderUserAlternateContact;
    }
    public void setOrderUserAlternateContact(String orderUserAlternateContact) {
        this.orderUserAlternateContact = orderUserAlternateContact;
    }

    public String getOrderStatus() {
        return orderStatus;
    }
    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
    public Double getOrderAmount() {
        return orderAmount;
    }
    public void setOrderAmount(Double orderAmount) {
        this.orderAmount = orderAmount;
    }

}

package com.medicare.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class User {

    @Id
    private String userEmail;
    private String userFirstName;
    private String userLastName;
    private String userPassword;
    private String userMobile;
    private String userAddress;
    private String userCity;
    private String userState;


    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "USER_ROLE",
            joinColumns = {
                    @JoinColumn(name = "USER_ID")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "ROLE_ID")
            }
    )

    private Set<Role> role;

    public User() {
    }

    public User(String userEmail, String userFirstName, String userLastName, String userPassword, String userMobile, String userAddress, String userCity, String userState, Set<Role> role) {
        this.userEmail = userEmail;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.userPassword = userPassword;
        this.userMobile = userMobile;
        this.userAddress = userAddress;
        this.userCity = userCity;
        this.userState = userState;
        this.role = role;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Set<Role> getRole() {
        return role;
    }

    public void setRole(Set<Role> role) {
        this.role = role;
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserCity() {
        return userCity;
    }

    public void setUserCity(String userCity) {
        this.userCity = userCity;
    }

    public String getUserState() {
        return userState;
    }

    public void setUserState(String userState) {
        this.userState = userState;
    }
}

package com.smart.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
public class UserEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;

    @Column(name = "name")
    private String name;

    @Column(name = "email_id", unique = true)
    private String emailId;

    @Column(name = "password")
    private String password;

    @Column(name = "user_role")
    private String userRole;

    @Column(name = "image_URL")
    private String imageUrl;

    @Column(name = "about", length = 500)
    private String about;

    @Column(name = "is_Enable")
    private boolean isEnabled;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,mappedBy = "userEntity")
    private List<ContactEntity> contactEntity = new ArrayList<>();

    public UserEntity() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    public List<ContactEntity> getContactEntity() {
        return contactEntity;
    }

    public void setContactEntity(List<ContactEntity> contactEntity) {
        this.contactEntity = contactEntity;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", emailId='" + emailId + '\'' +
                ", password='" + password + '\'' +
                ", userRole='" + userRole + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", about='" + about + '\'' +
                ", isEnabled=" + isEnabled +
                '}';
    }
}

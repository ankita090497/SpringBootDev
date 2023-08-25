package com.smart.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "contact")
public class ContactEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int contactId;

    @Column(name = "contact_name")
    private String contactName;

    @Column(name = "nick_name")
    private String nickName;

    @Column(name = "work")
    private String work;

    @Column(name = "email_id")
    private String emailId;

    @Column(name = "contact_image_URL")
    private String contactImageUrl;

    @Column(name = "description",length = 5000)
    private String description;

    @Column(name = "mobile_no")
    private long mobileNo;

    @ManyToOne
    private UserEntity userEntity;


    public ContactEntity() {
    }

    public int getContactId() {
        return contactId;
    }

    public void setContactId(int contactId) {
        this.contactId = contactId;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getContactImageUrl() {
        return contactImageUrl;
    }

    public void setContactImageUrl(String contactImageUrl) {
        this.contactImageUrl = contactImageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(long mobileNo) {
        this.mobileNo = mobileNo;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    @Override
    public String toString() {
        return "ContactEntity{" +
                "contactId=" + contactId +
                ", contactName='" + contactName + '\'' +
                ", nickName='" + nickName + '\'' +
                ", work='" + work + '\'' +
                ", emailId='" + emailId + '\'' +
                ", contactImageUrl='" + contactImageUrl + '\'' +
                ", description='" + description + '\'' +
                ", mobileNo=" + mobileNo +
                '}';
    }
}

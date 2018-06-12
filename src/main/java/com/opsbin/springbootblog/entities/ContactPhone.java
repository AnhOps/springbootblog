package com.opsbin.springbootblog.entities;

import javax.persistence.*;
import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "contact_phones")
public class ContactPhone implements Serializable {

    /** The Serial Version UID for Serializable classes. */
    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "contact_phone_id", nullable = false)
    private Long contactPhoneId;

    @Column(name = "phone_type", nullable = false)
    private String phoneType;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @ManyToOne
    @JoinColumn(name = "contact_id", referencedColumnName = "contact_id", nullable = false)
    private Contact contact;

    public Long getContactPhoneId() {
        return contactPhoneId;
    }

    public void setContactPhoneId(Long contactPhoneId) {
        this.contactPhoneId = contactPhoneId;
    }

    public String getPhoneType() {
        return phoneType;
    }

    public void setPhoneType(String phoneType) {
        this.phoneType = phoneType;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }
}

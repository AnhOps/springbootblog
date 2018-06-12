package com.opsbin.springbootblog.entities;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "contacts")
public class Contact implements Serializable {

    /** The Serial Version UID for Serializable classes. */
    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "contact_id")
    private Long contactId;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "birth_date", nullable = false)
    @Basic
    @Temporal(TemporalType.DATE)
    private Date birthDate;

    @ManyToMany
    @JoinTable(name = "contact_hobby_ids",
        joinColumns = @JoinColumn(name = "contact_id", referencedColumnName = "contact_id", nullable = false),
        inverseJoinColumns = @JoinColumn(name = "hobby_id", referencedColumnName = "hobby_id", nullable = false))
    private Set<Hobby> hobbies;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "contact")
    private Set<ContactPhone> contactPhones;

    public Long getContactId() {
        return contactId;
    }

    public void setContactId(Long contactId) {
        this.contactId = contactId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Hobby> getHobbies() {
        return hobbies;
    }

    public void setHobbies(Set<Hobby> hobbies) {
        this.hobbies = hobbies;
    }

    public Set<ContactPhone> getContactPhones() {
        return contactPhones;
    }

    public void setContactPhones(Set<ContactPhone> contactPhones) {
        this.contactPhones = contactPhones;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}

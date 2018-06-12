package com.opsbin.springbootblog.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "hobbies")
public class Hobby implements Serializable {

    /** The Serial Version UID for Serializable classes. */
    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "hobby_id", nullable = false)
    private Long hobbyId;

    @Column(name = "hobby_title", nullable = false)
    private String hobbyTitle;

    @ManyToMany(mappedBy = "hobbies")
    private Set<Contact> contacts;

    public Long getHobbyId() {
        return hobbyId;
    }

    public void setHobbyId(Long hobbyId) {
        this.hobbyId = hobbyId;
    }

    public String getHobbyTitle() {
        return hobbyTitle;
    }

    public void setHobbyTitle(String hobbyTitle) {
        this.hobbyTitle = hobbyTitle;
    }

    public Set<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(Set<Contact> contacts) {
        this.contacts = contacts;
    }
}

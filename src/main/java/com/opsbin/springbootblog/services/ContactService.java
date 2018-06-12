package com.opsbin.springbootblog.services;

import com.opsbin.springbootblog.entities.Contact;

import java.util.Collection;

public interface ContactService {

    Collection<Contact> findAll();
    Contact findOne(Long id);
}

package com.opsbin.springbootblog.services.impl;

import com.opsbin.springbootblog.entities.Contact;
import com.opsbin.springbootblog.repositories.ContactRepository;
import com.opsbin.springbootblog.services.ContactService;
import com.opsbin.springbootblog.utils.CollectionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Optional;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Override
    @Transactional(readOnly = true)
    public Collection<Contact> findAll() {
        return CollectionUtil.iterableToCollection(contactRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public Contact findOne(Long id) {
        Optional<Contact> contact = contactRepository.findById(id);
        return contact.isPresent() ? contact.get() : null;
    }
}

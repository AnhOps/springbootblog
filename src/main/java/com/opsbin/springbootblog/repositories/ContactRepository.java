package com.opsbin.springbootblog.repositories;

import com.opsbin.springbootblog.entities.Contact;
import org.springframework.data.repository.CrudRepository;

public interface ContactRepository extends CrudRepository<Contact, Long> {

}

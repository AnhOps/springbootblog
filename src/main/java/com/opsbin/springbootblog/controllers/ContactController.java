package com.opsbin.springbootblog.controllers;

import com.opsbin.springbootblog.constants.UrlConstant;
import com.opsbin.springbootblog.entities.Contact;
import com.opsbin.springbootblog.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;

@Controller
public class ContactController {

    protected static final String CONTACT_VIEW = "contacts/view";
    protected static final String CONTACT_LIST_VIEW = "contacts/list";

    protected static final String MODEL_ATTRIBUTE_CONTACT = "contact";
    protected static final String MODEL_ATTRIBUTE_CONTACTS = "contacts";

    @Autowired
    private ContactService contactService;

    @GetMapping(UrlConstant.CONTACTS)
    public ModelAndView contactsList() {
        ModelAndView mav = new ModelAndView(CONTACT_LIST_VIEW);
        Collection<Contact> contactsList = contactService.findAll();
        mav.addObject(MODEL_ATTRIBUTE_CONTACTS, contactsList);
        return mav;
    }

    @GetMapping(UrlConstant.CONTACT)
    public ModelAndView contact(@PathVariable("contactId") Long id) {
        ModelAndView mav = new ModelAndView(CONTACT_VIEW);
        Contact found = contactService.findOne(id);
        mav.addObject(MODEL_ATTRIBUTE_CONTACT, found);
        return mav;
    }
}

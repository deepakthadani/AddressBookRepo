package com.example.addressbook.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.addressbook.model.Addressbook;
import com.example.addressbook.model.Contact;
import com.example.addressbook.service.ContactRepository;

@Controller
public class ContactsController {
	
	@Autowired
	ContactRepository repository;

	@RequestMapping(value = "/list-uniquecontacts", method = RequestMethod.GET)
	public String showContacts(Model model) {
		List<String[]> list = repository.findUniqueContacts();
		ArrayList<Contact> contacts = new ArrayList<Contact>();
		Iterator<String[]> iterator = list.iterator();
		while (iterator.hasNext()) {
            Contact contact = new Contact();
            String[] columns = iterator.next();
            contact.setName(columns[0]);
            contact.setNumber(columns[1]);
            contacts.add(contact);
		}
		model.addAttribute("contacts", contacts);
		return "list-uniquecontacts";
	}
	
	@RequestMapping(value = "/delete-contact", method = RequestMethod.GET)
	public String deleteContact(@RequestParam int id, Model model) {
		Contact contactRetrieved = repository.findById(id).get();
		repository.deleteById(id);
		Addressbook addressbook = contactRetrieved.getAddressbook();
		model.addAttribute("addressbook", addressbook);
		return "list-addressbook";
	}

	@RequestMapping(value = "/update-contact", method = RequestMethod.GET)
	public String showUpdateContact(@RequestParam int id, Model model) {
		Contact contact = repository.findById(id).get();
		model.addAttribute("contact", contact);
		return "modify-contact";
	}

	@RequestMapping(value = "/update-contact", method = RequestMethod.POST)
	public String updateContact(@ModelAttribute("contact") Contact contact, Model model) {
		Contact contactRetrieved = repository.findById(contact.getId()).get();
		Addressbook addressbook = contactRetrieved.getAddressbook();
		contact.setAddressbook(addressbook);
		repository.save(contact);
		model.addAttribute("addressbook", addressbook);
		return "list-addressbook";
	}
	
}

package com.example.addressbook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.addressbook.model.Addressbook;
import com.example.addressbook.model.Contact;
import com.example.addressbook.service.AddressbookRepository;
import com.example.addressbook.service.ContactRepository;

@Controller
public class AddressbookController {
	
	@Autowired
	AddressbookRepository addressbookRepository;
	
	@Autowired
	ContactRepository contactRepository;

	@RequestMapping(value = "/list-addressbooks", method = RequestMethod.GET)
	public String showAddressbooks(Model model) {
		model.addAttribute("addressbooks", addressbookRepository.findAll());
		return "list-addressbooks";
	}

	@RequestMapping(value = "/add-addressbook", method = RequestMethod.GET)
	public String showAddAddressbook(Model model) {
		Addressbook addressbook = new Addressbook();     
    	model.addAttribute("addressbook", addressbook);  
    	return "add-addressbook";  
	}

	@RequestMapping(value = "/delete-addressbook", method = RequestMethod.GET)
	public String deleteAddressbook(@RequestParam int id) {
		addressbookRepository.deleteById(id);
		return "redirect:/list-addressbooks";
	}

	@RequestMapping(value = "/update-addressbook", method = RequestMethod.GET)
	public String showUpdateAddressbook(@RequestParam int id, Model model) {
		Addressbook addressbook = addressbookRepository.findById(id).get();
		model.addAttribute("addressbook", addressbook);
		return "modify-addressbook";
	}

	@RequestMapping(value = "/update-addressbook", method = RequestMethod.POST)
	public String updateAddressbook(@ModelAttribute("addressbook") Addressbook addressbook) {
		addressbookRepository.save(addressbook);
		return "redirect:/list-addressbooks";
	}

	@RequestMapping(value = "/add-addressbook", method = RequestMethod.POST)
	public String add(@ModelAttribute("addressbook") Addressbook addressbook, Model model) {
		addressbookRepository.save(addressbook);
		model.addAttribute("addressbooks", addressbookRepository.findAll());
		return "list-addressbooks";
	}
	
	@RequestMapping(value = "/addressbook/{id}", method = RequestMethod.GET)
	public String listContactsforAddressbook(@PathVariable int id, Model model) {
		Addressbook addressbook = addressbookRepository.getById(id);
		model.addAttribute("addressbook", addressbook);
		return "list-addressbook";

	}
	
	@RequestMapping(value = "/addressbook/{id}/add-contact", method = RequestMethod.POST)
	public String add(@ModelAttribute("contact") Contact contact, @PathVariable int id, Model model) {
		Addressbook addressbook = addressbookRepository.getById(id);
		contact.setAddressbook(addressbook);
		contactRepository.save(contact);
		addressbook = addressbookRepository.getById(id);
		model.addAttribute("addressbook", addressbook);
		return "list-addressbook";
	}
	
	@RequestMapping(value = "/addressbook/{id}/add-contact", method = RequestMethod.GET)
	public String add(@PathVariable int id, Model model) {
		Addressbook addressbook = addressbookRepository.getById(id);
		Contact contact = new Contact();    
		contact.setAddressbook(addressbook);
		model.addAttribute("addressbook", addressbook);
    	model.addAttribute("contact", contact);  
    	return "add-contact"; 
	}
	
}

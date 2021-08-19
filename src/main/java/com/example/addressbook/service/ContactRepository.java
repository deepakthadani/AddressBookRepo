package com.example.addressbook.service;

import com.example.addressbook.model.Contact;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ContactRepository extends JpaRepository<Contact, Integer> {
	
	@Query("SELECT DISTINCT name, number FROM Contact")
    List<String[]> findUniqueContacts();
}

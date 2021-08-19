package com.example.addressbook.service;

import com.example.addressbook.model.Addressbook;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressbookRepository extends JpaRepository<Addressbook, Integer> {
}

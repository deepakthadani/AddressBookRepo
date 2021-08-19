package com.example.addressbook.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Contact {
	
	public Contact(int id, String name, String number) {
		super();
		this.id = id;
		this.name = name;
		this.number = number;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id, name, number);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contact other = (Contact) obj;
		return id == other.id && Objects.equals(name, other.name) && Objects.equals(number, other.number);
	}

	@Override
	public String toString() {
		return "Contact [id=" + id + ", name=" + name + ", number=" + number + "]";
	}

	@Id
	@GeneratedValue
	private int id;
	
	private String name;
	private String number;
	
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Addressbook addressbook;

	public Addressbook getAddressbook() {
		return addressbook;
	}

	public void setAddressbook(Addressbook addressbook) {
		this.addressbook = addressbook;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public Contact() {
		super();
		// TODO Auto-generated constructor stub
	}

}

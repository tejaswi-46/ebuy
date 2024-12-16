package com.ebuy.ebuy_project.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Buy { 
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int bid;
	private String name,email,contact,address,city,state,pin,prod,pmethod;
	private LocalDate date= LocalDate.now();
	public Buy() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Buy(String name, String email, String contact, String address, String city, String state, String pin,
			String prod, String pmethod, LocalDate date) {
		super();
		this.name = name;
		this.email = email;
		this.contact = contact;
		this.address = address;
		this.city = city;
		this.state = state;
		this.pin = pin;
		this.prod = prod;
		this.pmethod = pmethod;
		this.date = date;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	public String getProd() {
		return prod;
	}
	public void setProd(String prod) {
		this.prod = prod;
	}
	public String getPmethod() {
		return pmethod;
	}
	public void setPmethod(String pmethod) {
		this.pmethod = pmethod;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Buy [bid=" + bid + ", name=" + name + ", email=" + email + ", contact=" + contact + ", address="
				+ address + ", city=" + city + ", state=" + state + ", pin=" + pin + ", prod=" + prod + ", pmethod="
				+ pmethod + ", date=" + date + "]";
	}
	
}

package com.ebuy.ebuy_project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Registration {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int regid;
private String name,contact,email,password,address,city;
public Registration() {
	super();
	// TODO Auto-generated constructor stub
}
public Registration(String name, String contact, String email, String password, String address, String city) {
	super();
	this.name = name;
	this.contact = contact;
	this.email = email;
	this.password = password;
	this.address = address;
	this.city = city;
}
public int getRegid() {
	return regid;
}
public void setRegid(int regid) {
	this.regid = regid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getContact() {
	return contact;
}
public void setContact(String contact) {
	this.contact = contact;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
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
@Override
public String toString() {
	return "Registration [regid=" + regid + ", name=" + name + ", contact=" + contact + ", email=" + email
			+ ", password=" + password + ", address=" + address + ", city=" + city + "]";
}

}
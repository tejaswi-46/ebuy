package com.ebuy.ebuy_project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class SaleCar {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int regid;
	private String brand,name,fuel,description,address,city,state;
	private int noofown/*no of owners*/,year,price;
	public SaleCar() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SaleCar(String brand, String name, String fuel, String description, String address, String city,
			String state, int noofown, int year, int price) {
		super();
		this.brand = brand;
		this.name = name;
		this.fuel = fuel;
		this.description = description;
		this.address = address;
		this.city = city;
		this.state = state;
		this.noofown = noofown;
		this.year = year;
		this.price = price;
	}
	public int getRegid() {
		return regid;
	}
	public void setRegid(int regid) {
		this.regid = regid;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFuel() {
		return fuel;
	}
	public void setFuel(String fuel) {
		this.fuel = fuel;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
	public int getNoofown() {
		return noofown;
	}
	public void setNoofown(int noofown) {
		this.noofown = noofown;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "SaleCar [regid=" + regid + ", brand=" + brand + ", name=" + name + ", fuel=" + fuel + ", description="
				+ description + ", address=" + address + ", city=" + city + ", state=" + state + ", noofown=" + noofown
				+ ", year=" + year + ", price=" + price + "]";
	}
	

}

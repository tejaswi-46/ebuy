package com.ebuy.ebuy_project.model;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Sale2w {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int s2wid;
	private String brand,name,fuel,description,address,city,state;
	private int noofown/*no of owners*/,year,price,kmdriven;
	
	
	@ManyToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name="sale2w_images",joinColumns= {
			@JoinColumn(name="sale2w_s2wid")
	},
	inverseJoinColumns= {
			@JoinColumn(name="image_id")
	}
	)
	private Set<ImageModel> saleImages;



	public Set<ImageModel> getSale2wImages() {
		return saleImages;
	}
	public void setSale2wImages(Set<ImageModel> saleImages) {
		this.saleImages = saleImages;
	}
	
	
	public Sale2w() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Sale2w(String brand, String name, String fuel, String description, String address, String city, String state,
			int noofown, int year, int price, int kmdriven) {
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
		this.kmdriven = kmdriven;
	}
	public int getS2wid() {
		return s2wid;
	}
	public void setSid(int s2wid) {
		this.s2wid = s2wid;
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
	public int getKmdriven() {
		return kmdriven;
	}
	public void setKmdriven(int kmdriven) {
		this.kmdriven = kmdriven;
	}
	@Override
	public String toString() {
		return "Sale2w [sid=" + s2wid + ", brand=" + brand + ", name=" + name + ", fuel=" + fuel + ", description="
				+ description + ", address=" + address + ", city=" + city + ", state=" + state + ", noofown=" + noofown
				+ ", year=" + year + ", price=" + price + ", kmdriven=" + kmdriven + "]";
	}
	
}

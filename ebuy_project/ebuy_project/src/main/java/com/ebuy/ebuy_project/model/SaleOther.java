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
public class SaleOther {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int soid;
	private String brand,name,description,address,city,state;
	private int noofown,year,price;

	@ManyToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name="saleOther_images",joinColumns= {
			@JoinColumn(name="saleOther_soid")
	},
	inverseJoinColumns= {
			@JoinColumn(name="image_id")
	}
	)
	private Set<ImageModel> saleImages;



	public Set<ImageModel> getSaleOtherImages() {
		return saleImages;
	}
	public void setSaleOtherImages(Set<ImageModel> saleImages) {
		this.saleImages = saleImages;
	}
	
	
	public SaleOther() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SaleOther(String brand, String name, String description, String address, String city, String state,
			int noofown, int year, int price) {
		super();
		this.brand = brand;
		this.name = name;
		this.description = description;
		this.address = address;
		this.city = city;
		this.state = state;
		this.noofown = noofown;
		this.year = year;
		this.price = price;
	}
	public int getSoid() {
		return soid;
	}
	public void setSoid(int soid) {
		this.soid = soid;
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
	
	public Set<ImageModel> getSaleImages() {
		return saleImages;
	}
	public void setSaleImages(Set<ImageModel> saleImages) {
		this.saleImages = saleImages;
	}
	@Override
	public String toString() {
		return "SaleOther [soid=" + soid + ", brand=" + brand + ", name=" + name + ", description=" + description
				+ ", address=" + address + ", city=" + city + ", state=" + state + ", noofown=" + noofown + ", year="
				+ year + ", price=" + price + "]";
	}
	
}

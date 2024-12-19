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
public class SaleDevice {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int sdid;
	private String brand,name,condition1,charger,description,address,city,state,network;
	private int noofown/*no of owners*/,year,storage,price;

	@ManyToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name="saleDevice_images",joinColumns= {
			@JoinColumn(name="saleDevice_sdid")
	},
	inverseJoinColumns= {
			@JoinColumn(name="image_id")
	}
	)
	private Set<ImageModel> saleImages;



	public Set<ImageModel> getSaleDeviceImages() {
		return saleImages;
	}
	public void setSaleDeviceImages(Set<ImageModel> saleImages) {
		this.saleImages = saleImages;
	}
	
	
	public SaleDevice() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public SaleDevice(String brand, String name, String condition1, String charger, String description, String address,
			String city, String state, String network, int noofown, int year, int storage, int price) {
		super();
		this.brand = brand;
		this.name = name;
		this.condition1 = condition1;
		this.charger = charger;
		this.description = description;
		this.address = address;
		this.city = city;
		this.state = state;
		this.network = network;
		this.noofown = noofown;
		this.year = year;
		this.storage = storage;
		this.price = price;
	}
	
	public int getSdid() {
		return sdid;
	}
	public void setSdid(int sdid) {
		this.sdid = sdid;
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
	public String getCondition1() {
		return condition1;
	}
	public void setCondition(String condition1) {
		this.condition1 = condition1;
	}
	public String getCharger() {
		return charger;
	}
	public void setCharger(String charger) {
		this.charger = charger;
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
	public String getNetwork() {
		return network;
	}
	public void setNetwork(String network) {
		this.network = network;
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
	public int getStorage() {
		return storage;
	}
	public void setStorage(int storage) {
		this.storage = storage;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "SaleDevice [sdid=" + sdid + ", brand=" + brand + ", name=" + name + ", condition=" + condition1
				+ ", charger=" + charger + ", description=" + description + ", address=" + address + ", city=" + city
				+ ", state=" + state + ", network=" + network + ", noofown=" + noofown + ", year=" + year + ", storage="
				+ storage + ", price=" + price + "]";
	}
	
	
}

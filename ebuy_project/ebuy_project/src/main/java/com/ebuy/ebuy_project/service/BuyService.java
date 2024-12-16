package com.ebuy.ebuy_project.service;

import java.util.List;

import com.ebuy.ebuy_project.model.Buy;

public interface BuyService {

	  //post
	Buy insertRecord(Buy r);
	//get
	List<Buy> getAll();
	//delete
	void delete(int id);
	//put
	Buy updateRecord(int i,Buy r);
}

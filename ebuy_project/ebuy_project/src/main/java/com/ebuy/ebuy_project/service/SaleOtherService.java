package com.ebuy.ebuy_project.service;

import java.util.List;

import com.ebuy.ebuy_project.model.SaleOther;

public interface SaleOtherService {

	//post
	SaleOther insertRecord(SaleOther r);
	//get
	List<SaleOther> getAll();
	//delete
	void delete(int id);
	//put
	SaleOther updateRecord(int i,SaleOther r);
}

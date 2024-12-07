package com.ebuy.ebuy_project.service;

import java.util.List;

import com.ebuy.ebuy_project.model.SaleCar;

public interface SaleCarService {
	//post
		SaleCar insertRecord(SaleCar r);
		//get
		List<SaleCar> getAll();
		//delete
		void delete(int id);
		//put
		SaleCar updateRecord(int i,SaleCar r);
}

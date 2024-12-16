package com.ebuy.ebuy_project.service;

import java.util.List;

import com.ebuy.ebuy_project.model.Sale2w;

public interface Sale2wService {

	        //post
			Sale2w insertRecord(Sale2w r);
			//get
			List<Sale2w> getAll();
			//delete
			void delete(int id);
			//put
			Sale2w updateRecord(int i,Sale2w r);
}

package com.ebuy.ebuy_project.service;

import java.util.List;

import com.ebuy.ebuy_project.model.SaleDevice;

public interface SaleDeviceService {
			//post
			SaleDevice insertRecord(SaleDevice r);
			//get
			List<SaleDevice> getAll();
			//delete
			void delete(int id);
			//put
			SaleDevice updateRecord(int i,SaleDevice r);
}

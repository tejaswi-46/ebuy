package com.ebuy.ebuy_project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ebuy.ebuy_project.model.SaleDevice;
import com.ebuy.ebuy_project.repository.SaleDeviceRepository;

@Service
public class SaleDeviceServiceImpl implements SaleDeviceService{

	@Autowired
	@Qualifier("saleDeviceRepo")
	public SaleDeviceRepository saleDeviceRepo;
	@Override
	public SaleDevice insertRecord(SaleDevice r) {
		// TODO Auto-generated method stub
		return saleDeviceRepo.save(r);
	}

	@Override
	public List<SaleDevice> getAll() {
		// TODO Auto-generated method stub
		return saleDeviceRepo.findAll();
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		saleDeviceRepo.deleteById(id);
	}

	@Override
	public SaleDevice updateRecord(int i, SaleDevice r) {
		Optional<SaleDevice> opt= saleDeviceRepo.findById(i);
		if(opt.isPresent())
		{
			//get old record in rold obj
			SaleDevice rold=opt.get();
			rold.setBrand(r.getBrand());
			rold.setName(r.getName());
			rold.setCondition(r.getCondition());
			rold.setDescription(r.getDescription());
			rold.setCharger(r.getCharger());
			rold.setAddress(r.getAddress());
			rold.setCity(r.getCity());
			rold.setState(r.getState());
			rold.setNoofown(r.getNoofown());
			rold.setYear(r.getYear());
			rold.setStorage(r.getStorage());
			rold.setPrice(r.getPrice());
			rold.setNetwork(r.getNetwork());
			return saleDeviceRepo.save(rold);
		}
		return null;
	
	}

}

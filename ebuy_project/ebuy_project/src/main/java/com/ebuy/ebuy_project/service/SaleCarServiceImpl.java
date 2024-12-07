package com.ebuy.ebuy_project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ebuy.ebuy_project.model.SaleCar;
import com.ebuy.ebuy_project.repository.SaleCarRepository;
@Service
public class SaleCarServiceImpl implements SaleCarService{

	@Autowired
	@Qualifier("saleCarRepo")
	public SaleCarRepository saleCarRepo;
	@Override
	public SaleCar insertRecord(SaleCar r) {
		// TODO Auto-generated method stub
		return saleCarRepo.save(r);
	}

	@Override
	public List<SaleCar> getAll() {
		// TODO Auto-generated method stub
		return saleCarRepo.findAll();
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		saleCarRepo.deleteById(id);
	}

	@Override
	public SaleCar updateRecord(int i, SaleCar r) {
		Optional<SaleCar> opt= saleCarRepo.findById(i);
		if(opt.isPresent())
		{
			//get old record in rold obj
			SaleCar rold=opt.get();
			rold.setBrand(r.getBrand());
			rold.setName(r.getName());
			rold.setFuel(r.getFuel());
			rold.setDescription(r.getDescription());
			rold.setAddress(r.getAddress());
			rold.setCity(r.getCity());
			rold.setState(r.getState());
			rold.setNoofown(r.getNoofown());
			rold.setYear(r.getYear());
			rold.setPrice(r.getPrice());
			return saleCarRepo.save(rold);
		}
		return null;
	
	}

}

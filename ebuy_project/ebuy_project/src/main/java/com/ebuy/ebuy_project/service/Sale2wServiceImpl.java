package com.ebuy.ebuy_project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ebuy.ebuy_project.model.Sale2w;
import com.ebuy.ebuy_project.repository.Sale2wRepository;
@Service
public class Sale2wServiceImpl implements Sale2wService{

	@Autowired
	@Qualifier("sale2wRepo")
	public Sale2wRepository sale2wRepo;

	@Override
	public Sale2w insertRecord(Sale2w r) {
		// TODO Auto-generated method stub
		return sale2wRepo.save(r);
	}

	@Override
	public List<Sale2w> getAll() {
		// TODO Auto-generated method stub
		return sale2wRepo.findAll();
	}

	@Override
	public void delete(int id) {
		sale2wRepo.deleteById(id);
	}

	@Override
	public Sale2w updateRecord(int i, Sale2w r) {
		Optional<Sale2w> opt= sale2wRepo.findById(i);
		if(opt.isPresent())
		{
			//get old record in rold obj
			Sale2w rold=opt.get();
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
			rold.setKmdriven(r.getKmdriven());
			return sale2wRepo.save(rold);
		}
		return null;
	
	}

}

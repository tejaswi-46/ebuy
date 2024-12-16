package com.ebuy.ebuy_project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ebuy.ebuy_project.model.Buy;
import com.ebuy.ebuy_project.repository.BuyRepository;

@Service
public class BuyServiceImpl implements BuyService{

	@Autowired
	@Qualifier("buyRepo")
	public BuyRepository buyRepo ;
	
	@Override
	public Buy insertRecord(Buy r) {
		// TODO Auto-generated method stub
		return buyRepo.save(r);
	}

	@Override
	public List<Buy> getAll() {
		// TODO Auto-generated method stub
		return buyRepo.findAll();
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		buyRepo.deleteById(id);
	}

	@Override
	public Buy updateRecord(int i, Buy r) {
		Optional<Buy> opt= buyRepo.findById(i);
		if(opt.isPresent())
		{
			//get old record in rold obj
			Buy rold=opt.get();
			rold.setName(r.getName());
			rold.setEmail(r.getEmail());
			rold.setContact(r.getContact());
			rold.setAddress(r.getAddress());
			rold.setCity(r.getCity());
			rold.setState(r.getState());
			rold.setPin(r.getPin());
			rold.setProd(r.getProd());
			rold.setPmethod(r.getPmethod());
			rold.setDate(r.getDate());
			return buyRepo.save(rold);
		}
		return null;
	
	}

}

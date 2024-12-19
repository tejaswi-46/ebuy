package com.ebuy.ebuy_project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ebuy.ebuy_project.model.Registration;
import com.ebuy.ebuy_project.repository.RegistrationRepository;

@Service
public class RegistrationServiceImpl implements RegistrationService{

	@Autowired
	@Qualifier("regRepo")
	private RegistrationRepository regRepo;
	
	@Override
	public Registration insertRecord(Registration r) {
		
		return regRepo.save(r);
	}

	@Override
	public List<Registration> getAll() {
		
		return regRepo.findAll();
	}

	@Override
	public void delete(int id) {
		regRepo.deleteById(id);
	}

	@Override
	public Registration updateRecord(int i,Registration r) {
		Optional<Registration> opt= regRepo.findById(i);
		if(opt.isPresent())
		{
			//get old record in rold obj
			Registration rold=opt.get();
			rold.setName(r.getName());
			rold.setContact(r.getContact());
			rold.setEmail(r.getEmail());
			rold.setPassword(r.getPassword());
			rold.setAddress(r.getAddress());
			rold.setCity(r.getCity());
			rold.setState(r.getState());
			return regRepo.save(rold);
		}
		return null;
	}

	@Override
	public List<Registration> login(String email, String password) {
		// TODO Auto-generated method stub
		return regRepo.findAllByEmailAndPassword(email, password);
	}
	

}

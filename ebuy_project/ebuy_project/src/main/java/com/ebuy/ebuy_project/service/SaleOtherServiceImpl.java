package com.ebuy.ebuy_project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ebuy.ebuy_project.model.SaleOther;
import com.ebuy.ebuy_project.repository.SaleOtherRepository;
@Service
public class SaleOtherServiceImpl implements SaleOtherService{

	@Autowired
	@Qualifier("saleOtherRepo")
	public SaleOtherRepository saleOtherRepo;
	
	@Override
	public SaleOther insertRecord(SaleOther r) {
		// TODO Auto-generated method stub
		return saleOtherRepo.save(r);
	}

	@Override
	public List<SaleOther> getAll() {
		// TODO Auto-generated method stub
		return saleOtherRepo.findAll();
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		saleOtherRepo.deleteById(id);
	}

	@Override
	public SaleOther updateRecord(int i, SaleOther r) {
		// TODO Auto-generated method stub
		Optional<SaleOther> opt= saleOtherRepo.findById(i);
		if(opt.isPresent())
		{
			//get old record in rold obj
			SaleOther rold=opt.get();
			rold.setBrand(r.getBrand());
			rold.setName(r.getName());
			rold.setDescription(r.getDescription());
			rold.setAddress(r.getAddress());
			rold.setCity(r.getCity());
			rold.setState(r.getState());
			rold.setNoofown(r.getNoofown());
			rold.setYear(r.getYear());
			rold.setPrice(r.getPrice());
		
			return saleOtherRepo.save(rold);
		}
		return null;
	
	}

}

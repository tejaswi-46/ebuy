package com.ebuy.ebuy_project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ebuy.ebuy_project.model.Feedback;
import com.ebuy.ebuy_project.repository.FeedbackRepository;

@Service
public class FeedbackServiceImpl implements FeedbackService{

	@Autowired
	@Qualifier("feedRepo")
	private  FeedbackRepository feedRepo;
	
	@Override
	public Feedback insertRecord(Feedback r) {
		
		return feedRepo.save(r);
	}

	@Override
	public List<Feedback> getAll() {
		
		return feedRepo.findAll();
	}

	@Override
	public void delete(int id) {
		feedRepo.deleteById(id);
	}

	@Override
	public Feedback updateRecord(int i,Feedback r) {
		Optional<Feedback> opt= feedRepo.findById(i);
		if(opt.isPresent())
		{
			//get old record in rold obj
			Feedback rold=opt.get();
			rold.setName(r.getName());
			rold.setEmail(r.getEmail());
			rold.setMessage(r.getMessage());
			return feedRepo.save(rold);
		}
		return null;
	}
}

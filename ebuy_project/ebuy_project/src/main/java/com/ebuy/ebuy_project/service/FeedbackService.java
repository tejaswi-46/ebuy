package com.ebuy.ebuy_project.service;

import java.util.List;

import com.ebuy.ebuy_project.model.Feedback;


public interface FeedbackService {
	//post
	Feedback insertRecord(Feedback r);
	//get
	List<Feedback> getAll();
	//delete
	void delete(int id);
	//put
	Feedback updateRecord(int i,Feedback r);
}

package com.ebuy.ebuy_project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ebuy.ebuy_project.model.Feedback;
import com.ebuy.ebuy_project.service.FeedbackService;

@RestController
public class FeedbackController {

	@Autowired
	private FeedbackService fs;

	@GetMapping("/feedbacks")
	public List<Feedback> handleGet()
	{
		return fs.getAll();
	}

	@PostMapping("/addfeed")
	public Feedback add(@RequestBody Feedback r)
	{
		return fs.insertRecord(r);
	}
	@DeleteMapping("/delfeed/{rid}")
	public void deleteFeed(@PathVariable("rid") int i)
	{
		fs.delete(i);
	}
	@PutMapping("/upfeed/{rid}")
	public Feedback update(@PathVariable("rid")int i,@RequestBody Feedback r)
	{
		return fs.updateRecord(i,r);
	}

}

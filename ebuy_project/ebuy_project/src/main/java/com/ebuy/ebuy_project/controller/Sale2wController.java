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

import com.ebuy.ebuy_project.model.Sale2w;
import com.ebuy.ebuy_project.service.Sale2wService;

@RestController
public class Sale2wController {

	@Autowired
	private Sale2wService stw;
	
	@GetMapping("/Sale2ws")
	public List<Sale2w> handleGet()
	{
		return stw.getAll();
	}

	@PostMapping("/addsale2w")
	public Sale2w add(@RequestBody Sale2w r)
	{
		return stw.insertRecord(r);
	}
	@DeleteMapping("/delsale2w/{rid}")
	public void delete(@PathVariable("rid") int i)
	{
		stw.delete(i);
	}
	@PutMapping("/upsale2w/{rid}")
	public Sale2w update(@PathVariable("rid")int i,@RequestBody Sale2w r)
	{
		return stw.updateRecord(i,r);
	}


}

package com.ebuy.ebuy_project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ebuy.ebuy_project.model.Buy;
import com.ebuy.ebuy_project.service.BuyService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/buy/")
public class BuyController {

	@Autowired
	private BuyService bs;
	
	@GetMapping("/buys")
	public List<Buy> handleGet()
	{
		return bs.getAll();
	}

	@PostMapping("/addbuy")
	public Buy add(@RequestBody Buy r)
	{
		return bs.insertRecord(r);
	}
	@DeleteMapping("/delbuy/{rid}")
	public void delete(@PathVariable("rid") int i)
	{
		bs.delete(i);
	}
	@PutMapping("/upbuy/{rid}")
	public Buy update(@PathVariable("rid")int i,@RequestBody Buy r)
	{
		return bs.updateRecord(i,r);
	}
	
}

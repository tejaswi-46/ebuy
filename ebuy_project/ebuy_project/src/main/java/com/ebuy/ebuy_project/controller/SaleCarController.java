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

import com.ebuy.ebuy_project.model.SaleCar;
import com.ebuy.ebuy_project.service.SaleCarService;

@RestController
public class SaleCarController {
	@Autowired
	private SaleCarService scs;
	
	@GetMapping("/SaleCars")
	public List<SaleCar> handleGet()
	{
		return scs.getAll();
	}

	@PostMapping("/addsalecar")
	public SaleCar add(@RequestBody SaleCar r)
	{
		return scs.insertRecord(r);
	}
	@DeleteMapping("/delsalecar/{rid}")
	public void delete(@PathVariable("rid") int i)
	{
		scs.delete(i);
	}
	@PutMapping("/upsalecar/{rid}")
	public SaleCar update(@PathVariable("rid")int i,@RequestBody SaleCar r)
	{
		return scs.updateRecord(i,r);
	}

}

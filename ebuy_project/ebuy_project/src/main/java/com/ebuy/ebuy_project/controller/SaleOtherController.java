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

import com.ebuy.ebuy_project.model.SaleOther;
import com.ebuy.ebuy_project.service.SaleOtherService;

@RestController
public class SaleOtherController {
	@Autowired
	private SaleOtherService sos;
	@GetMapping("/SaleOthers")
	public List<SaleOther> handleGet()
	{
		return sos.getAll();
	}

	@PostMapping("/addsaleother")
	public SaleOther add(@RequestBody SaleOther r)
	{
		return sos.insertRecord(r);
	}
	@DeleteMapping("/delsaleother/{rid}")
	public void delete(@PathVariable("rid") int i)
	{
		sos.delete(i);
	}
	@PutMapping("/upsaledevice/{rid}")
	public SaleOther update(@PathVariable("rid")int i,@RequestBody SaleOther r)
	{
		return sos.updateRecord(i,r);
	}


}

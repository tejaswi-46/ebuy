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

import com.ebuy.ebuy_project.model.SaleDevice;
import com.ebuy.ebuy_project.service.SaleDeviceService;

@RestController
public class SaleDeviceController {
	@Autowired
	private SaleDeviceService sds;
	@GetMapping("/SaleDevices")
	public List<SaleDevice> handleGet()
	{
		return sds.getAll();
	}

	@PostMapping("/addsaledevice")
	public SaleDevice add(@RequestBody SaleDevice r)
	{
		return sds.insertRecord(r);
	}
	@DeleteMapping("/delsaledevice/{rid}")
	public void delete(@PathVariable("rid") int i)
	{
		sds.delete(i);
	}
	@PutMapping("/upsaledevice/{rid}")
	public SaleDevice update(@PathVariable("rid")int i,@RequestBody SaleDevice r)
	{
		return sds.updateRecord(i,r);
	}

	

}

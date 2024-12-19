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

import com.ebuy.ebuy_project.model.Registration;
import com.ebuy.ebuy_project.service.RegistrationService;
@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/registration/")
public class RegistrationController {
	
@Autowired
private RegistrationService rs;

@GetMapping("/registrations")
public List<Registration> handleGet()
{
	return rs.getAll();
}

@PostMapping("/addreg")
public Registration add(@RequestBody Registration r)
{
	return rs.insertRecord(r);
}
@DeleteMapping("/delreg/{rid}")
public void deleteReg(@PathVariable("rid") int i)
{
	rs.delete(i);
}
@PutMapping("/upreg/{rid}")
public Registration update(@PathVariable("rid")int i,@RequestBody Registration r)
{
	return rs.updateRecord(i,r);
}
@GetMapping("/login/{email}/{password}")
public List<Registration> login(@PathVariable("email") String email, @PathVariable("password") String password)
{
	return rs.login(email, password);
}
}

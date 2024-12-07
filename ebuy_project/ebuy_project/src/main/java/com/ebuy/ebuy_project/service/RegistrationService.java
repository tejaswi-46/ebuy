package com.ebuy.ebuy_project.service;

import java.util.List;

import com.ebuy.ebuy_project.model.Registration;

public interface RegistrationService {
//post
Registration insertRecord(Registration r);
//get
List<Registration> getAll();
//delete
void delete(int id);
//put
Registration updateRecord(int i,Registration r);

List<Registration> login(String email, String password);
}

package com.ebuy.ebuy_project.service;

import java.util.List;

import com.ebuy.ebuy_project.model.AdminLogin;

public interface AdminLoginService {
List<AdminLogin> login(String email,String password);
}

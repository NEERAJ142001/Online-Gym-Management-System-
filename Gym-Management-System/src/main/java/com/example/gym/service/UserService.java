package com.example.gym.service;

import com.example.gym.entity.Userdetails;

public interface UserService {
public Userdetails saveUser(Userdetails user);
public boolean checkEmail(String email);
}

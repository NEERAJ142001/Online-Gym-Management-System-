package com.example.gym.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gym.entity.Userdetails;
import com.example.gym.repository.UserRepository;

@Service
public class UserSeviceImpl implements UserService {
	@Autowired
	private UserRepository userRepo;

	@Override
	public Userdetails saveUser(Userdetails user) {
		Userdetails newuser = userRepo.save(user);
		return newuser;
	}

	@Override
	public boolean checkEmail(String email) {

		return userRepo.existsByEmail(email);
	}

}

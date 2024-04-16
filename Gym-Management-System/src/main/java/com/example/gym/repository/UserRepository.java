package com.example.gym.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.gym.entity.Userdetails;

public interface UserRepository extends JpaRepository<Userdetails, Integer>{
	
	public boolean existsByEmail(String email);

}

package com.example.gym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.gym.entity.Userdetails;


@Repository
public interface UserRepository extends JpaRepository<Userdetails, Integer>{
	
	 boolean existsByEmail(String email);

}

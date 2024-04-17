package com.example.gym.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.condition.RequestConditionHolder;

import com.example.gym.entity.Userdetails;
import com.example.gym.repository.UserRepository;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

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

	@Override
	public void removeSession() {
		System.out.println("hello session removed");
		try {
			HttpSession session=((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest().getSession();
			session.removeAttribute("message");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}

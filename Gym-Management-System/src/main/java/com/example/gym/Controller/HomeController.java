package com.example.gym.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.gym.entity.Userdetails;
import com.example.gym.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {

	@Autowired
	private UserService userService;

	@GetMapping("/")
	public String index() {
		return "index";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/register")
	public String register() {
		return "register";
	}

	@GetMapping("/logout")
	public String logout() {
		return "logout";
	}

	@PostMapping("/newUser")
	public String saveuser(@ModelAttribute Userdetails user, HttpServletRequest request, HttpServletResponse response,
			HttpSession session, Model model) {

		// Check if email already exists
		boolean emailExists = userService.checkEmail(user.getEmail());
		if (emailExists) {
			System.out.println("Email already exists");
			session.setAttribute("message", "Email already exists");
//			userService.removesession();
			
			return "redirect:/register"; // Redirect back to registration page
		}

		// Check if password matches confirm password
		if (!user.getPassword().equals(user.getConfirmPassword())) {
			System.out.println("Password and confirm password do not match");
			session.setAttribute("message", "Password and confirm password do not match");
//			userService.removesession();
			
			return "redirect:/register"; // Redirect back to registration page
		}

		// If email is unique and password matches confirm password, save the user
		Userdetails entry = userService.saveUser(user);
		if (entry != null) {
			System.out.println("User saved successfully");
			session.setAttribute("message", "Registered Successfully");
//			session.removeAttribute("message");
			// Remove the session attribute after displaying the message
//			userService.removesession();
			

			return "redirect:/register"; // Redirect to login page after successful registration
		} else {
			session.setAttribute("message", "Something is wrong");
			System.out.println("Something is wrong");
			 
//			userService.removesession();
			return "redirect:/register"; // Redirect back to registration page on error
		}
	}
}

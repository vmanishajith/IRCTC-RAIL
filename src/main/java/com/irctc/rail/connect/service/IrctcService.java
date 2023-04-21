package com.irctc.rail.connect.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.irctc.rail.connect.User;
import com.irctc.rail.connect.repository.IrctcRepository;

@Service
public class IrctcService {

	@Autowired
	IrctcRepository irctcRepository;
	
	@Autowired
	private JavaMailSender javaMailSender;

	public String registerUser(User registerUser) {
		irctcRepository.save(registerUser);
		
		return "Login information of " + registerUser.getName() + " is saved.";
	}

	public User fetchUserDetails(int userId) {
		return irctcRepository.findById(userId).get();
	}
	
	public String loginUser(User user)  {
		String password;

		User existingUser = null;
		existingUser = irctcRepository.findByName(user.getName());

		if (existingUser != null) {
			password = existingUser.getPassword();

			if (password.equals(user.getPassword())) {
				return "Existing User. Logging you in ...";
			} else {
				return "Password is incorrect";
			}

		}
		return "Not Existing User. Please Register to IRCTC";

	}
	
	public String sendMail() {
		SimpleMailMessage mail= new SimpleMailMessage();
		mail.setFrom("manishajith157@gmail.com");
		mail.setTo("manishleo157@gmail.com");
		mail.setSubject("You are Successful!");
		mail.setText("Welcome to the real WORLD...");
		javaMailSender.send(mail);
		return "mail sent";
	}
	
}

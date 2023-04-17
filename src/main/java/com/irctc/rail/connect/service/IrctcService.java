package com.irctc.rail.connect.service;

import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.security.Security;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irctc.rail.connect.User;
import com.irctc.rail.connect.repository.IrctcRepository;

@Service
public class IrctcService {

	@Autowired
	IrctcRepository irctcRepository;


	public String saveUserLogin(User saveUser) throws Exception {
		
		
		irctcRepository.save(saveUser);
		
		return "Login information of " + saveUser.getName() + " is saved.";

	}
	

	public User irctfetchUserDetails(int userId) {
		return irctcRepository.findById(userId).get();

	}
	
	public String loginUser(User user) throws Exception  {
		String password;
		System.out.println("logged in name "+user.getName() +" and password "+user.getPassword());
		
		User existingUser=null;
		existingUser=irctcRepository.findByName(user.getName());
		
		System.out.println("existing user name  "+existingUser.getName() );
		//System.out.println("existing user pwd "+ existingUser.getPassword());
		
		if(existingUser != null ) {
			System.out.println("username is present in db");
			password= existingUser.getPassword();
		
			 if(password.equals(user.getPassword())) {
				 return "Existing User. Logging you in ...";
			 }else {
				 return "Password is incorrect";
			 }
			
			
		}
			return "Not Existing User. Please Register to IRCTC";
	
	}
	
	
}

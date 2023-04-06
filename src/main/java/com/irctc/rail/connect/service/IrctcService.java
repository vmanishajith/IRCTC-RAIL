package com.irctc.rail.connect.service;

import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.hash.Hashing;
import com.irctc.rail.connect.User;
import com.irctc.rail.connect.repository.IrctcRepository;

@Service
public class IrctcService {
	
	@Autowired
	IrctcRepository irctcRepository;
	
	public String saveUserLogin(User saveUser) {
		String sha256hex = Hashing.sha256()
				  .hashString(saveUser.getPassword(), StandardCharsets.UTF_8)
				  .toString();
		saveUser.setPassword(sha256hex);
		System.out.println("pass --> "+sha256hex);
		 irctcRepository.save(saveUser);
			return "Login information of "+ saveUser.getName() + " is saved.";

	}

}

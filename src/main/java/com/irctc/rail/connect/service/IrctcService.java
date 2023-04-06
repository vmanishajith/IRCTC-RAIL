package com.irctc.rail.connect.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irctc.rail.connect.User;
import com.irctc.rail.connect.repository.IrctcRepository;

@Service
public class IrctcService {
	
	@Autowired
	IrctcRepository irctcRepository;
	
	public String saveUserLogin(User saveUser) {
		 irctcRepository.save(saveUser);
			return "Login information of "+ saveUser.getName() + " is saved.";

	}

}

package com.irctc.rail.connect.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.irctc.rail.connect.User;
import com.irctc.rail.connect.repository.IrctcRepository;
import com.irctc.rail.connect.service.IrctcService;

@RestController
@RequestMapping("/irctc")
public class IrctcController {
	
	@Autowired
	IrctcService irctcService;
	
	@GetMapping("/fetchUserDetails")
	public User fetchUserDetails(@RequestParam int userId) {
		return	irctcService.irctfetchUserDetails(userId);
		
	}
	
	@PostMapping("/saveUserLogin")
	public String saveUserLogin(@RequestBody User saveUser) throws Exception {
		return irctcService.saveUserLogin(saveUser);
	}
	
	@PostMapping("/loginUser")
	public String loginUser(@RequestBody User user) throws Exception {
		return irctcService.loginUser(user);		
	}

}

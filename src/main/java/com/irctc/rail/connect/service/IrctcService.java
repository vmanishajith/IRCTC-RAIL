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

import org.bouncycastle.jce.provider.BouncyCastleProvider;
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
	
	//@SuppressWarnings("unused")
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
	
	/*
	 * private byte[] encrypt(String data) throws InvalidKeyException,
	 * IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException,
	 * NoSuchProviderException, NoSuchPaddingException {
	 * 
	 * Security.addProvider(new BouncyCastleProvider()); byte[] keyBytes = new
	 * byte[KEY_LENGTH_BYTE]; SecureRandom secureRandom = new SecureRandom();
	 * secureRandom.nextBytes(keyBytes); SecretKey key = new SecretKeySpec(keyBytes,
	 * "GCM"); Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding", "BC");
	 * cipher.init(Cipher.ENCRYPT_MODE, key); return
	 * cipher.doFinal(data.getBytes(StandardCharsets.UTF_8));
	 * 
	 * }
	 * 
	 * private String decrypt(String data) throws NoSuchAlgorithmException,
	 * NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException,
	 * BadPaddingException, NoSuchProviderException,
	 * InvalidAlgorithmParameterException { System.out.println("decrypt pwd ---   "+
	 * data); Security.addProvider(new BouncyCastleProvider()); byte[] keyBytes =
	 * new byte[KEY_LENGTH_BYTE]; SecureRandom secureRandom = new SecureRandom();
	 * secureRandom.nextBytes(keyBytes); SecretKey key = new SecretKeySpec(keyBytes,
	 * "GCM"); Cipher cipher=Cipher.getInstance("AES/GCM/NoPadding","BC");
	 * cipher.init(Cipher.DECRYPT_MODE,key);
	 * 
	 * byte[] plainText = cipher.doFinal(Base64.getDecoder().decode(data)); return
	 * new String(plainText); }
	 */

}

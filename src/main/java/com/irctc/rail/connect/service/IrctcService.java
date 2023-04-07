package com.irctc.rail.connect.service;

import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.security.Security;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
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

	int KEY_LENGTH_BYTE = 16;

	public String saveUserLogin(User saveUser) throws NoSuchAlgorithmException, NoSuchPaddingException,
			InvalidKeyException, IllegalBlockSizeException, BadPaddingException, NoSuchProviderException {
		Security.addProvider(new BouncyCastleProvider());
		byte[] keyBytes = new byte[KEY_LENGTH_BYTE];
		SecureRandom secureRandom = new SecureRandom();
		secureRandom.nextBytes(keyBytes);
		SecretKey key = new SecretKeySpec(keyBytes, "GCM");
		Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding", "BC");
		cipher.init(Cipher.ENCRYPT_MODE, key);
		saveUser.setPassword(Base64.getEncoder()
				.encodeToString(cipher.doFinal(saveUser.getPassword().getBytes(StandardCharsets.UTF_8))));
		irctcRepository.save(saveUser);
		return "Login information of " + saveUser.getName() + " is saved.";

	}

	public User irctfetchUserDetails(int userId) {
		return irctcRepository.findById(userId).get();

	}

}

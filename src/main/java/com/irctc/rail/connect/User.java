package com.irctc.rail.connect;

import org.springframework.context.annotation.Bean;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
@Table(name= "user_table")
public class User {
	
	
	
	public User(){
		
	}
	
	@Id
	@GeneratedValue
	private int id;
	
	@NotNull
	private String name;
	
	private String password;
	


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	

}

package com.irctc.rail.connect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.irctc.rail.connect.User;

@Repository
public interface IrctcRepository extends JpaRepository<User, Integer>{

	User findByName(String name);
}

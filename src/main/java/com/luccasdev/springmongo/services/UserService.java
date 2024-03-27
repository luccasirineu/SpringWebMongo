package com.luccasdev.springmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luccasdev.springmongo.domain.User;
import com.luccasdev.springmongo.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository repo;
	
	
	public List<User> findAll(){
		return repo.findAll();
	}

}

package com.luccasdev.springmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luccasdev.springmongo.domain.User;


@RestController
@RequestMapping(value="/users")
public class UserResource {
	
	@GetMapping
	public ResponseEntity<List<User>> findAll() { 
		User maria = new User("10", "Maria", "maria@gmail.com");
		User jose = new User("11", "Alex", "alex@gmail.com");
		List<User> list = new ArrayList<>();// na hora de instanciar precisamos colocar o ArrayList pois o List é apenas uma interface
		list.addAll(Arrays.asList(maria, jose));
		return ResponseEntity.ok().body(list);

	}
	

}

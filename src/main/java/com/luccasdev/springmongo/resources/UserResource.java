package com.luccasdev.springmongo.resources;


import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.luccasdev.springmongo.domain.User;
import com.luccasdev.springmongo.dto.UserDTO;
import com.luccasdev.springmongo.services.UserService;


@RestController
@RequestMapping(value="/users")
public class UserResource {
	
	@Autowired
	private UserService service;
	
	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll() { 
		List<User> list = service.findAll();
		List<UserDTO> listDTO = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());// convertendo os objetos da lista original para a listaDTO
		return ResponseEntity.ok().body(listDTO);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<UserDTO> findById(@PathVariable String id) { //Path variable serve para casar o id do argumento com o id da url		
		User obj = service.findById(id); 
		return ResponseEntity.ok().body(new UserDTO(obj));
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody UserDTO objDTO) { //RequestBody tem a msm funcao que o path variable mas é para o POST		
		User obj = service.fromDTO(objDTO); // convertendo objDTO para obj
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri(); 

		return ResponseEntity.created(uri).build();
	}
	

}

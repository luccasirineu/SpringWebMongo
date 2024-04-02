package com.luccasdev.springmongo.resources;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.luccasdev.springmongo.domain.Post;
import com.luccasdev.springmongo.resources.util.URL;
import com.luccasdev.springmongo.services.PostService;


@RestController
@RequestMapping(value="/posts")
public class PostResource {
	
	@Autowired
	private PostService service;
	

	
	@GetMapping(value="/{id}")
	public ResponseEntity<Post> findById(@PathVariable String id) { //Path variable serve para casar o id do argumento com o id da url		
		Post obj = service.findById(id); 
		return ResponseEntity.ok().body(obj);
	}
	
	
	@GetMapping(value="/titlesearch")
	public ResponseEntity<List<Post>> findByTitle(@RequestParam(value="text", defaultValue ="") String text) { 
		text = URL.decodeParam(text);
		List<Post> list = service.findByTitle(text);
		return ResponseEntity.ok().body(list);
	}
	


}

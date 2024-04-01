package com.luccasdev.springmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.luccasdev.springmongo.domain.Post;
import com.luccasdev.springmongo.domain.User;
import com.luccasdev.springmongo.dto.AuthorDTO;
import com.luccasdev.springmongo.repositories.PostRepository;
import com.luccasdev.springmongo.repositories.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		
		
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para sp, abs!", new AuthorDTO(maria));
		Post post2 = new Post(null, sdf.parse("27/03/2018"), "Voltando de  viagem", "Vou voltar para cs, abs!", new AuthorDTO(maria));
		postRepository.saveAll(Arrays.asList(post1, post2));
		
	}

}

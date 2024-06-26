package com.luccasdev.springmongo.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.luccasdev.springmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{ // string pois é o tipo do id

	List<Post> findByTitleContainingIgnoreCase(String text);
}

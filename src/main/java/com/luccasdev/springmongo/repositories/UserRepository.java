package com.luccasdev.springmongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.luccasdev.springmongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{ // string pois é o tipo do id

}

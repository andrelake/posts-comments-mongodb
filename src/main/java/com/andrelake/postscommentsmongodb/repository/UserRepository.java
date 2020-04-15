package com.andrelake.postscommentsmongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.andrelake.postscommentsmongodb.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{

}

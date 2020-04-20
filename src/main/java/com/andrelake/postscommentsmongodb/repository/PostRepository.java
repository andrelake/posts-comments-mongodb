package com.andrelake.postscommentsmongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.andrelake.postscommentsmongodb.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{

}

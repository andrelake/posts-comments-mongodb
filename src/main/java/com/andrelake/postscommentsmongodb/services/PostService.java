package com.andrelake.postscommentsmongodb.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andrelake.postscommentsmongodb.domain.Post;
import com.andrelake.postscommentsmongodb.repository.PostRepository;
import com.andrelake.postscommentsmongodb.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository postRepository;
	
	public Post findById(String id) {
	
		Post post = postRepository.findById(id)
				.orElseThrow(() -> new ObjectNotFoundException("Object not found"));

		return post;
	}
}

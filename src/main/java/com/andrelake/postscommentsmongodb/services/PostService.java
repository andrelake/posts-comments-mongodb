package com.andrelake.postscommentsmongodb.services;

import java.util.Date;
import java.util.List;

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
	
	public List<Post> findByTitle(String text) {
		
		return postRepository.findByTitleContainingIgnoreCase(text);
	}
	
	public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
		
		maxDate = new Date(maxDate.getTime() + 24*60*60*1000);
		return postRepository.fullSearch(text, minDate, maxDate);
	}
}

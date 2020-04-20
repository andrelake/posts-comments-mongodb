package com.andrelake.postscommentsmongodb.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andrelake.postscommentsmongodb.domain.Post;
import com.andrelake.postscommentsmongodb.services.PostService;

@RestController
@RequestMapping("/posts")
public class PostResource {

	@Autowired
	private PostService postService;
	
	@GetMapping("/{id}")
	public ResponseEntity<Post> findById(@PathVariable String id) {
		
		Post obj = postService.findById(id);
		
		return ResponseEntity.ok(obj);
	}
}
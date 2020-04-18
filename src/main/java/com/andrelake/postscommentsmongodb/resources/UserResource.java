package com.andrelake.postscommentsmongodb.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andrelake.postscommentsmongodb.domain.User;
import com.andrelake.postscommentsmongodb.dto.UserDTO;
import com.andrelake.postscommentsmongodb.services.UserService;

@RestController
@RequestMapping("/users")
public class UserResource {

	@Autowired
	private UserService userService;
	
	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll(){
		
		List<User> list = userService.findAll();
		List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());  //stream p/ list poder receber lambda
																									//map funcionando como um foreach
		return ResponseEntity.ok(listDto);															//Collectors.toList para voltar a ser list
	}
}

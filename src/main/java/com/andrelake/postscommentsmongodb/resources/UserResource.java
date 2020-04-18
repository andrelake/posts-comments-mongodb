package com.andrelake.postscommentsmongodb.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@GetMapping("/{id}")
	public ResponseEntity<UserDTO> findById(@PathVariable String id) {
		
		User obj = userService.findById(id);
		
		return ResponseEntity.ok(new UserDTO(obj));
	}
	
	@PostMapping
	public ResponseEntity<Void> add(@RequestBody UserDTO userDTO) {
		
		User user = userService.fromDTO(userDTO);
		userService.insert(user);
		
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> remove(@PathVariable String id) {
		
		userService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable String id, @RequestBody UserDTO userDTO) {
		
		User user = userService.fromDTO(userDTO);
		user.setId(id);
		user = userService.update(user);
		
		return ResponseEntity.ok(user);
	}
}

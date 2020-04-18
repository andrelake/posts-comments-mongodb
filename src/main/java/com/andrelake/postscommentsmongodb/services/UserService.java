package com.andrelake.postscommentsmongodb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andrelake.postscommentsmongodb.domain.User;
import com.andrelake.postscommentsmongodb.dto.UserDTO;
import com.andrelake.postscommentsmongodb.repository.UserRepository;
import com.andrelake.postscommentsmongodb.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll(){
		
		return userRepository.findAll();
	}
	
	public User findById(String id) {
	
		User user = userRepository.findById(id)
				.orElseThrow(() -> new ObjectNotFoundException("Object not found"));

		return user;
	}
	
	public User insert(User user) {
		
		return userRepository.insert(user);
	}
	
	public void delete(String id) {
		
		findById(id);
		userRepository.deleteById(id);
	}

	public User update(User user) {
	
		User newUser = userRepository.findById(user.getId())
				.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
		
		updateData(newUser, user);
		
		return userRepository.save(newUser);
	}
	
	private void updateData(User newUser, User user) {
		
		newUser.setName(user.getName());
		newUser.setEmail(user.getEmail());
	}

	public User fromDTO(UserDTO userDTO) {
		
		return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
	}
}

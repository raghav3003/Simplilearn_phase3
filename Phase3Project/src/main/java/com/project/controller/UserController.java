package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.model.UserEntity;
import com.project.repository.UserRepository;

@RestController
@RequestMapping(path = "/user")
public class UserController {
	
	@Autowired
    UserRepository userRepository;
	
	@RequestMapping(method=RequestMethod.GET, value="/all")
	public List<UserEntity> getAllUsers(){
		return userRepository.findAll();
    }
	
	@RequestMapping(method=RequestMethod.POST, value="/add")
	public void addUser(@RequestBody UserEntity ue){
		userRepository.save(ue);
    }
	
	@RequestMapping(method=RequestMethod.PUT, value="/update/{id}")
    public void updateUser(@PathVariable int id, @RequestBody UserEntity ue) {
		if(userRepository.findById(id).isPresent()) {
			UserEntity oldUserEntity=userRepository.findById(id).get();
			oldUserEntity.setEmail(ue.getEmail());
			oldUserEntity.setPassword(ue.getPassword());
			oldUserEntity.setPhone_number(ue.getPhone_number());
			oldUserEntity.setUsername(ue.getUsername());
            userRepository.save(oldUserEntity);
        }
    }
	
	@RequestMapping(method=RequestMethod.DELETE, value="/delete/{id}")
    public void deleteUser(@PathVariable int id)  {
		userRepository.deleteById(id);
    }
	
}

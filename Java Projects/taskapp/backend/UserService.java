package com.example.demo.Service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.LoginRequest;
import com.example.demo.Entity.Users;
import com.example.demo.Repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository usersRepository;

    


    public Users createUser(Users user) {
        return usersRepository.save(user);
    }

    public void deleteUser(Integer id) {
        usersRepository.deleteById(id);
    }

    public Map<String,Object> getUser(LoginRequest lr) {
    	Users user = usersRepository.findByUserName(lr.getUserName());
    	if(user != null) {
    		if(user.getPassword().equals(lr.getPassword())) {
    			return Map.of("Message","Welcome User","User",user) ;
    		} else {
    			return Map.of("Message","Invalid Credentials");
    		}
    	} else {
    		return Map.of("Message","Invalid User");
    	}
    }
}


package com.example.demo.Controller;

import com.example.demo.Entity.LoginRequest;
import com.example.demo.Entity.Users;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService usersService;


    @PostMapping("/register")
    public Users createUser(@RequestBody Users user) {
        return usersService.createUser(user);
    }
    
    
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequest lr) {
    	return ResponseEntity.ok(usersService.getUser(lr));
    }
    

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id) {
        usersService.deleteUser(id);
    }
}

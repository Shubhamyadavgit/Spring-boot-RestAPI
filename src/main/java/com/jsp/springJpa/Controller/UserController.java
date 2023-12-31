package com.jsp.springJpa.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.springJpa.Service.UserService;
import com.jsp.springJpa.Utility.ResponseStructure;
import com.jsp.springJpa.entity.User;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<ResponseStructure<User>> createUser(@RequestBody User user) {
        return userService.save(user);
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<ResponseStructure<User>> deleteUser(@PathVariable("userId") int userId) {
        return userService.delete(userId);
    }

    @GetMapping("/get")
    public ResponseEntity<ResponseStructure<List<User>>> getUsers() {
        return userService.getAllUsers();
    }

    @PutMapping("/update/{userId}")
    public ResponseEntity<ResponseStructure<User>> updateUser(@PathVariable("userId") int userId,
            @RequestBody User user) {
        return userService.update(userId, user);
    }

    @GetMapping("/getid/{userId}")
    public ResponseEntity<ResponseStructure<User>> getById(@PathVariable("userId") int userId){
        return userService.getById(userId);
    }
}

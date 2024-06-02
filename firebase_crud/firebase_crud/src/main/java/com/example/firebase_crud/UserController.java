package com.example.firebase_crud;

import com.example.firebase_crud.User;
import com.example.firebase_crud.UserService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public String createUser(@RequestBody User user) throws InterruptedException, ExecutionException {
        return userService.createUser(user);
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable String id) throws InterruptedException, ExecutionException {
        return userService.getUser(id);
    }

    @PutMapping("/user")
    public String updateUser(@RequestBody User user) throws InterruptedException, ExecutionException {
        return userService.updateUser(user);
    }

    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable String id) {
        return userService.deleteUser(id);
    }

@GetMapping("/test")
public ResponseEntity<String> testGetEndpoint(){
    return ResponseEntity.ok("Test GEt EndPoint");
}
}
package com.learn.student.userdetails.usersearchapi;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;



@RestController
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/{query}")
    public ResponseEntity<Object> searchUser(@PathVariable("query") String query) {
        User user = userService.searchUser(query);
        if (user != null) {
            // Return the user information
            Map<String, String> userDetails = new HashMap<>();
            userDetails.put("firstname", user.getFirstname());
            userDetails.put("username", user.getUsername());
            userDetails.put("email", user.getEmail());
            userDetails.put("status", user.getStatus());
            userDetails.put("details", user.getDetails());
            return ResponseEntity.ok(userDetails);
        } else {
            // No user found
            Map<String, String> response = new HashMap<>();
            response.put("message", "No user available");
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }
    }
}



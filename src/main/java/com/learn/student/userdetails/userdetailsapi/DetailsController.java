package com.learn.student.userdetails.userdetailsapi;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class DetailsController {
    private DetailsService detailsService;

    @Autowired
    public DetailsController(DetailsService detailsService) {
        this.detailsService = detailsService;
    }

    @GetMapping("/details")
    public ResponseEntity<Object> searchUser(@RequestParam Integer details) {
        UserDetails userDetails = detailsService.searchUser(details);
        if (userDetails != null) {
            // Return the user information
            Map<String, String> newDetails = new HashMap<>();
            newDetails.put("firstname", userDetails.getFirstname());
            newDetails.put("username", userDetails.getUsername());
            newDetails.put("password", userDetails.getPassword());
            newDetails.put("email", userDetails.getEmail());
            newDetails.put("status", userDetails.getStatus());
            newDetails.put("institution", userDetails.getInstitution());
            newDetails.put("role", userDetails.getRole());
            return ResponseEntity.ok(newDetails);
        } else {
            // No user found
            Map<String, String> response = new HashMap<>();
            response.put("message", "No user available");
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }
    }
}


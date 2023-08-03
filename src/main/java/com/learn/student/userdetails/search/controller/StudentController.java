package com.learn.student.userdetails.search.controller;

import com.learn.student.userdetails.search.pojo.StudentSearchResult;
import com.learn.student.userdetails.search.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RestController
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students/search")
    public ResponseEntity<?> searchStudents(
            @RequestParam String institutionName,
            @RequestParam(required = false) Integer studentId,
            @RequestParam(required = false) String username,
            @RequestParam(required = false) String email
    ) {
        if (studentId == null && username == null && email == null) {
            return ResponseEntity.badRequest().body("At least one of studentId, username, or email must be provided.");
        }

        // Check for individual errors and return bad request responses
        if (studentId != null && studentId <= 0) {
            return ResponseEntity.badRequest().body("Invalid studentId. Please provide a positive integer value.");
        }

        if (username != null && username.isEmpty()) {
            return ResponseEntity.badRequest().body("Username cannot be empty.");
        }

        if (email != null && !isValidEmail(email)) {
            return ResponseEntity.badRequest().body("Invalid email format. Please provide a valid email address.");
        }

        List<StudentSearchResult> searchResults = studentService.searchStudents(institutionName, studentId, username, email);

        if (searchResults.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body("No data found for the given inputs.");
        }

        return ResponseEntity.ok(searchResults);
    }

    // Helper method to validate email format
    private boolean isValidEmail(String email) {
        // Implement your email validation logic here, return true if it's valid
        // You can use regex or other methods to check the email format
        return true;
    }
}

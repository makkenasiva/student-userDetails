package com.learn.student.userdetails.search.controller;




import com.learn.student.userdetails.search.pojo.StudentSearchResult;
import com.learn.student.userdetails.search.service.StudentService;
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
    public List<StudentSearchResult> searchStudents(
            @RequestParam String institutionName,
            @RequestParam(required = false) Integer studentId,
            @RequestParam(required = false) String username,
            @RequestParam(required = false) String email
    ) {
        if(studentId == null && username == null && email == null){
            throw new IllegalArgumentException("At least one of studentId, username, or email must be provided.");
        }
        return studentService.searchStudents(institutionName, studentId, username, email);
    }
}
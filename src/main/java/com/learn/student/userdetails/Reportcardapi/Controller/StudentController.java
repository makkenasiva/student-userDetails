package com.learn.student.userdetails.Reportcardapi.Controller;

import com.learn.student.userdetails.Reportcardapi.Model.Student;
import com.learn.student.userdetails.Reportcardapi.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable Long id) {
        if (id <= 0) {
            return ResponseEntity.badRequest().body("Enter a valid ID");
        }

        Student student = studentService.getStudentById(id);

        if (student == null) {
            return ResponseEntity.status(HttpStatus.OK).body("{\"message\": \"Student not found\"}");
        }

        return ResponseEntity.ok(student);
    }
}


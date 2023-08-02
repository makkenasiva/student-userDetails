package com.learn.student.userdetails.scholarships;

import com.learn.student.userdetails.scholarships.ScholarshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/scholarships")
public class ScholarshipController {

    private final ScholarshipService scholarshipService;

    @Autowired
    public ScholarshipController(ScholarshipService scholarshipService) {
        this.scholarshipService = scholarshipService;
    }

    @GetMapping("/{student_id}")
    public <Scholarship> ResponseEntity<?> getEnrollmentsByStudentId(@PathVariable("student_id") int studentId) {
        List<Scholarship> scholarships = (List<Scholarship>) scholarshipService.getScholarships((long) studentId);

        if (!scholarships.isEmpty()) {
            return ResponseEntity.ok(scholarships);
        } else {
            String message = "No scholarships found for the student.";
            return ResponseEntity.status(HttpStatus.OK).body("{\"message\": \"" + message + "\"}");
        }
    }

    // Other methods and code for ScholarshipController...
}

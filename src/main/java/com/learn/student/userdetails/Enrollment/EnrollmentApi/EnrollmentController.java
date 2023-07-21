package com.learn.student.userdetails.Enrollment.EnrollmentApi;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/enrollment")
public class EnrollmentController {
    private final EnrollmentService enrollmentService;

    public EnrollmentController(EnrollmentService enrollmentService) {
        this.enrollmentService = enrollmentService;
    }

    @PostMapping("/enroll")
    public String enrollStudent(@RequestParam int studentId, @RequestParam int subjectId) {
        return enrollmentService.enrollStudent(studentId, subjectId);
    }

    @PostMapping("/drop")
    public String dropSubject(@RequestParam int studentId, @RequestParam int subjectId) {
        return enrollmentService.dropSubject(studentId, subjectId);
    }
}

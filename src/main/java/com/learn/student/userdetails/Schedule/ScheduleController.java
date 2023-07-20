package com.learn.student.userdetails.Schedule;
import org.springframework.http.HttpStatus;
import com.learn.student.userdetails.Enrollment.EnrollmentApi.Enrollment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/v3/schedule")
public class ScheduleController {
    private final ScheduleService scheduleService;

    @Autowired
    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @GetMapping("/{student_id}")
    public ResponseEntity<?> getEnrollmentsByStudentId(@PathVariable("student_id") int studentId) {
        List<Enrollment> enrollments = scheduleService.getEnrollmentsByStudentId(studentId);
        if (!enrollments.isEmpty()) {
            return ResponseEntity.ok(enrollments);
        } else {
            return ResponseEntity.status(HttpStatus.OK).body("No student found");
        }
    }

}

package com.learn.student.userdetails.Schedule;

import com.learn.student.userdetails.Enrollment.EnrollmentApi.Enrollment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


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
    public ResponseEntity<List<Enrollment>> getEnrollmentsByStudentId(@PathVariable("student_id") int studentId) {

        List<Enrollment> enrollments = scheduleService.getEnrollmentsByStudentId(studentId);
        if (!enrollments.isEmpty()) {
            return ResponseEntity.ok(enrollments);
        } else {
            return ResponseEntity.ok().build();
        }
    }
}

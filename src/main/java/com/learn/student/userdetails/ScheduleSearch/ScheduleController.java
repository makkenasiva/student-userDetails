package com.learn.student.userdetails.ScheduleSearch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/schedule")
public class ScheduleController {

    private final ScheduleService scheduleService;

    @Autowired
    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<?> getStudentEnrollments(
            @PathVariable Long studentId,
            @RequestParam(required = false) String academicYear
    ) {
        List<ScheduleDTO> enrollments = scheduleService.getStudentEnrollments(studentId, academicYear);

        if (enrollments.isEmpty()) {
            return ResponseEntity.ok("{ Student not registered }");
        }

        return ResponseEntity.ok(enrollments);
    }
}




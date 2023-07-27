package com.learn.student.userdetails.TotalFees;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/total-fees")
public class TotalFeesController {

    private final TotalFeesService totalFeesService;

    @Autowired
    public TotalFeesController(TotalFeesService totalFeesService) {
        this.totalFeesService = totalFeesService;
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<?> getTotalFees(@PathVariable Long studentId) {
        TotalFeesDTO totalFees = totalFeesService.getTotalFees(studentId);

        if (totalFees == null) {
            String message = "Student not found.";
            Map<String, String> response = new HashMap<>();
            response.put("message", message);
            return ResponseEntity.ok(response);
        }

        return ResponseEntity.ok(totalFees);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(Exception e) {
        String message = "Student not found.";
        Map<String, String> response = new HashMap<>();
        response.put("message", message);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }
}

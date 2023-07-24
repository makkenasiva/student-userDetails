package com.learn.student.userdetails.studentDetails.controller;

import com.learn.student.userdetails.studentDetails.studentinfo.Details;
import com.learn.student.userdetails.studentDetails.service.DetailService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DetailsController {
    private final DetailService detailService;

    public DetailsController(DetailService detailService) {
        this.detailService = detailService;
    }

    @GetMapping("/{studentId}")
    public Details getStudentDetails(@PathVariable Integer studentId) {
        return detailService.getStudentDetailsById(studentId);
    }
}

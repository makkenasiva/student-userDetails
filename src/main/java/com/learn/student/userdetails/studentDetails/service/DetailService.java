package com.learn.student.userdetails.studentDetails.service;

import com.learn.student.userdetails.studentDetails.studentinfo.Details;
import com.learn.student.userdetails.studentDetails.repository.DetailsRepository;
import org.springframework.stereotype.Service;
@Service
public class DetailService {
    private final DetailsRepository detailsRepository;

    public DetailService(DetailsRepository detailsRepository) {
        this.detailsRepository = detailsRepository;
    }

    public Details getStudentDetailsById(Integer studentId) {
        return detailsRepository.getStudentDetailsById(studentId);
    }
}
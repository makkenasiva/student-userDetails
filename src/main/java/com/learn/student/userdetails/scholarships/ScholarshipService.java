
package com.learn.student.userdetails.scholarships;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScholarshipService {

    private final ScholarshipRepository scholarshipRepository;

    @Autowired
    public ScholarshipService(ScholarshipRepository scholarshipRepository) {
        this.scholarshipRepository = scholarshipRepository;
    }

    public List<ScholarshipDTO> getScholarships(Long studentId) {
        return scholarshipRepository.getScholarships(studentId);
    }
}
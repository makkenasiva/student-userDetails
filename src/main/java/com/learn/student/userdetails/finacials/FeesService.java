package com.learn.student.userdetails.finacials;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeesService {

    private final FeesRepository feesRepository;
    @Autowired
    public FeesService(FeesRepository feesRepository) {
        this.feesRepository = feesRepository;
    }

    public List<FeesDTO> getEnrolledCoursesAndFees(Long studentId) {
        List<FeesDTO> enrolledCoursesAndFees = feesRepository.getFees(studentId);

        return enrolledCoursesAndFees;
    }


}

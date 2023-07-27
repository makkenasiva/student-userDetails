package com.learn.student.userdetails.TotalFees;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TotalFeesService {

    private final TotalFeesRepository totalFeesRepository;

    @Autowired
    public TotalFeesService(TotalFeesRepository totalFeesRepository) {
        this.totalFeesRepository = totalFeesRepository;
    }

    public TotalFeesDTO getTotalFees(Long studentId) {
        return totalFeesRepository.getTotalFees(studentId);
    }
}

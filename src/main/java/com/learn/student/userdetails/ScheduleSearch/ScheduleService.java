package com.learn.student.userdetails.ScheduleSearch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    @Autowired
    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    public List<ScheduleDTO> getStudentEnrollments(Long studentId, String academicYear) {
        return scheduleRepository.getStudentEnrollments(studentId, academicYear);
    }
}


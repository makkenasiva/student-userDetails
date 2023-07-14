package com.learn.student.userdetails.Schedule;

import com.learn.student.userdetails.Enrollment.EnrollmentApi.Enrollment;
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

    public List<Enrollment> getEnrollmentsByStudentId(int studentId) {
        return scheduleRepository.findByStudentId(studentId);
    }
}

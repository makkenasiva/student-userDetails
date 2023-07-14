package com.learn.student.userdetails.Schedule;

import com.learn.student.userdetails.Enrollment.EnrollmentApi.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Enrollment, Integer> {
    List<Enrollment> findByStudentId(int studentId);
}

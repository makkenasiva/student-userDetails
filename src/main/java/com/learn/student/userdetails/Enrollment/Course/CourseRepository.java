package com.learn.student.userdetails.Enrollment.Course;

import com.learn.student.userdetails.Enrollment.Course.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
    Optional<Course> findByGradeAndSubjectId(int grade, int subjectId);
}

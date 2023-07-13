package com.learn.student.userdetails.Enrollment.Course;

import com.learn.student.userdetails.Enrollment.Course.Course;
import com.learn.student.userdetails.Enrollment.Course.CourseDetails;
import com.learn.student.userdetails.Enrollment.Course.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CourseService {
    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public CourseDetails getCourseDetailsByGradeAndSubjectId(int grade, int subjectId) {
        Optional<Course> courseOptional = courseRepository.findByGradeAndSubjectId(grade, subjectId);
        if (courseOptional.isPresent()) {
            Course course = courseOptional.get();
            return new CourseDetails(course.getSubject().getSubjectName(), course.getCourseDescription(), course.getSeatsAvailable());
        } else {
            return new CourseDetails("Subject not available", "", 0);
        }
    }
}

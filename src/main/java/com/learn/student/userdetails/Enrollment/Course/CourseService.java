package com.learn.student.userdetails.Enrollment.Course;

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

    public String enrollStudent(int studentId, int subjectId) {
        Optional<Course> courseOptional = courseRepository.findById(subjectId);
        if (courseOptional.isPresent()) {
            Course course = courseOptional.get();

            if (course.hasAvailableSeats()) {
                // Perform student enrollment logic here
                // You can access the necessary student and course information to perform the enrollment process
                // Example: Create an Enrollment object and save it to the database
                // ...

                course.setSeatsAvailable(course.getSeatsAvailable() - 1);
                courseRepository.save(course);

                return "Enrollment successful.";
            } else {
                return "Subject has no available seats.";
            }
        } else {
            return "Course not found.";
        }
    }
}

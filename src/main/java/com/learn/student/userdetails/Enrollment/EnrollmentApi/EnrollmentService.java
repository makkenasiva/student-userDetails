package com.learn.student.userdetails.Enrollment.EnrollmentApi;

import com.learn.student.userdetails.Enrollment.Course.Course;
import com.learn.student.userdetails.Enrollment.Course.CourseRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Map;
import java.util.Optional;

@Service
public class EnrollmentService {
    private final EnrollmentRepository enrollmentRepository;
    private final CourseRepository courseRepository;
    private final JdbcTemplate jdbcTemplate;

    public EnrollmentService(EnrollmentRepository enrollmentRepository, CourseRepository courseRepository,
                             JdbcTemplate jdbcTemplate) {
        this.enrollmentRepository = enrollmentRepository;
        this.courseRepository = courseRepository;
        this.jdbcTemplate = jdbcTemplate;
    }

    public String enrollStudent(int studentId, int subjectId) {
        Optional<Enrollment> existingEnrollment = enrollmentRepository.findByStudentIdAndSubjectId(studentId, subjectId);
        if (existingEnrollment.isPresent()) {
            return "Student is already enrolled for the course.";
        }

        String studentQuery = "SELECT * FROM student WHERE id = ?";
        Map<String, Object> studentData = jdbcTemplate.queryForMap(studentQuery, studentId);

        if (!studentData.isEmpty()) {
            Integer studentGrade=Integer.parseInt(studentData.get("grade").toString());
            Optional<Course> course = courseRepository.findByGradeAndSubjectId(studentGrade,subjectId);
            Course course1 = course.get();

            if (course != null && Integer.parseInt(studentData.get("grade").toString()) == course1.getGrade() && course1.hasAvailableSeats()) {
                Enrollment enrollment = new Enrollment();
                enrollment.setStudentId(studentId);
                enrollment.setSubjectId(subjectId);
                enrollment.setAcademicYear(getAcademicYear());
                enrollment.setEnrollmentDate(LocalDate.now());

                enrollmentRepository.save(enrollment);

                course1.setSeatsAvailable(course1.getSeatsAvailable() - 1);
                courseRepository.save(course1);

                return "Enrollment successful.";
            } else {
                return "Subject not available or grade mismatch.";
            }
        } else {
            return "Student not found.";
        }
    }

    private String getAcademicYear() {
        int currentYear = LocalDate.now().getYear();
        int nextYear = currentYear + 1;
        return currentYear + "-" + nextYear;
    }

    public String dropSubject(int studentId, int subjectId) {
        Optional<Enrollment> enrollmentOptional = enrollmentRepository.findByStudentIdAndSubjectId(studentId, subjectId);
        if (enrollmentOptional.isPresent()) {
            Enrollment enrollment = enrollmentOptional.get();

            enrollmentRepository.delete(enrollment);

            Course course = courseRepository.findById(subjectId).orElse(null);
            if (course != null) {
                course.setSeatsAvailable(course.getSeatsAvailable() + 1);
                courseRepository.save(course);
            }

            return "Subject dropped successfully.";
        } else {
            return "Student is not enrolled in the subject.";
        }
    }
}

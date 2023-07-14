package com.learn.student.userdetails.Enrollment.EnrollmentApi;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "enrollments")
public class Enrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "student_id")
    private int studentId;

    @Column(name = "subject_id")
    private int subjectId;

    @Column(name = "academic_year")
    private String academicYear;

    @Column(name = "enrollment_date")
    private LocalDate enrollmentDate;

    // Other properties, getters, and setters

    public void setAcademicYear(String academicYear) {
        this.academicYear = academicYear;
    }

    public String getAcademicYear() {
        return academicYear;
    }
}

package com.learn.student.userdetails.Enrollment.Course;

import com.learn.student.userdetails.Enrollment.Subjectpojo.Subject;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int grade;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

    private String courseDescription;

    private int seatsAvailable;

    // Other properties, getters, and setters

    public String getSubjectName() {
        if (subject != null) {
            return subject.getSubjectName();
        }
        return null;
    }

    public boolean hasAvailableSeats() {
        return seatsAvailable > 0;
    }

    public void deductSeat() {
        seatsAvailable--;
    }
}

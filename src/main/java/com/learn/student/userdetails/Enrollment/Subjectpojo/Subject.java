package com.learn.student.userdetails.Enrollment.Subjectpojo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "subjects")
public class Subject {
    @Id
    private int id;

    @Column(name = "subject_name")
    private String subjectName;

    public String getSubjectName() {
        return subjectName;
    }

    // other properties, setters, and additional methods
}

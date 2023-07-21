package com.learn.student.userdetails.Reportcardapi.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name="students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int maths;
    private int science;
    private int social;
    private int arts;
    private int music;
    private int overallgrade;

    // Getters and setters
    // Constructors
}


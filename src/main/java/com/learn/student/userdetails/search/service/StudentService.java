package com.learn.student.userdetails.search.service;


import com.learn.student.userdetails.search.pojo.StudentSearchResult;
import com.learn.student.userdetails.search.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<StudentSearchResult> searchStudents(String institutionName, Integer studentId, String username, String email) {
        return studentRepository.searchStudents(institutionName, studentId, username, email);
    }
}
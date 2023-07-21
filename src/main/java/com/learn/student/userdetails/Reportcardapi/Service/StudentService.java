package com.learn.student.userdetails.Reportcardapi.Service;

import com.learn.student.userdetails.Reportcardapi.Model.Student;
import com.learn.student.userdetails.Reportcardapi.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElse(null);
    }
}


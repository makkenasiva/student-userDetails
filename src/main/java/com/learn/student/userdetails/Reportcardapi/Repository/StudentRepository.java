package com.learn.student.userdetails.Reportcardapi.Repository;

import com.learn.student.userdetails.Reportcardapi.Model.Student;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}



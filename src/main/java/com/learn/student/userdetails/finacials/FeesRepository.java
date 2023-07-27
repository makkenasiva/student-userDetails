package com.learn.student.userdetails.finacials;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
@Repository
public class FeesRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public FeesRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<FeesDTO> getFees(Long studentId) {
        String sqlQuery = "SELECT s.id AS student_id, s.first_name, s.last_name, e.subject_id, su.subject_name, c.grade, e.academic_year, c.fees " +
                "FROM student s " +
                "JOIN enrollments e ON s.id = e.student_id " +
                "JOIN subjects su ON e.subject_id = su.id " +
                "JOIN courses c ON su.id = c.subject_id AND s.grade = c.grade " +
                "WHERE s.id = ?";

        List<FeesDTO> enrolledCoursesAndFees = jdbcTemplate.query(sqlQuery, new Object[]{studentId}, (rs, rowNum) -> {
            FeesDTO feesDTO = new FeesDTO();
            feesDTO.setStudentId(rs.getLong("student_id"));
            feesDTO.setFirstName(rs.getString("first_name"));
            feesDTO.setLastName(rs.getString("last_name"));
            feesDTO.setSubjectId(rs.getLong("subject_id"));
            feesDTO.setSubjectName(rs.getString("subject_name"));
            feesDTO.setGrade(rs.getString("grade"));
            feesDTO.setAcademicYear(rs.getString("academic_year"));
            feesDTO.setFees(rs.getDouble("fees"));
            return feesDTO;
        });
        return enrolledCoursesAndFees;
    }
}

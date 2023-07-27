package com.learn.student.userdetails.scholarships;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ScholarshipRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ScholarshipRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<ScholarshipDTO> getScholarships(Long studentId) {
        String sqlQuery = "SELECT ss.student_id, ss.scholarship_id, sc.scholarship_amount " +
                "FROM Student_Scholarship ss " +
                "JOIN Scholarships sc ON ss.scholarship_id = sc.scholarship_id " +
                "WHERE ss.student_id = ?";

        return jdbcTemplate.query(sqlQuery, new Object[]{studentId}, (rs, rowNum) -> {
            ScholarshipDTO scholarshipDTO = new ScholarshipDTO();
            scholarshipDTO.setStudentId(rs.getLong("student_id"));
            scholarshipDTO.setScholarshipId(rs.getLong("scholarship_id"));
            scholarshipDTO.setScholarshipAmount(rs.getDouble("scholarship_amount"));
            return scholarshipDTO;
        });
    }
}

package com.learn.student.userdetails.TotalFees;

import com.learn.student.userdetails.TotalFees.TotalFeesDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TotalFeesRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public TotalFeesRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public TotalFeesDTO getTotalFees(Long studentId) {
        String sqlQueryScholarship = "SELECT ss.student_id, ss.scholarship_id, sc.scholarship_amount " +
                "FROM Student_Scholarship ss " +
                "JOIN Scholarships sc ON ss.scholarship_id = sc.scholarship_id " +
                "WHERE ss.student_id = ?";

        TotalFeesDTO totalFeesDTO = jdbcTemplate.queryForObject(sqlQueryScholarship, new Object[]{studentId}, (rs, rowNum) -> {
            TotalFeesDTO feesDTO = new TotalFeesDTO();
            feesDTO.setStudentId(rs.getLong("student_id"));
            feesDTO.setTotalFeesAfterScholarship(rs.getDouble("scholarship_amount"));
            return feesDTO;
        });

        String sqlQueryTotalFees = "SELECT s.id AS student_id, " +
                "s.first_name, " +
                "s.last_name, " +
                "SUM(c.fees) AS total_subject_fees " +
                "FROM student s " +
                "JOIN enrollments e ON s.id = e.student_id " +
                "JOIN subjects su ON e.subject_id = su.id " +
                "JOIN courses c ON su.id = c.subject_id AND s.grade = c.grade " +
                "WHERE s.id = ? " +
                "GROUP BY s.id, s.first_name, s.last_name";

        TotalFeesDTO totalFees = jdbcTemplate.queryForObject(sqlQueryTotalFees, new Object[]{studentId}, (rs, rowNum) -> {
            TotalFeesDTO feesDTO = new TotalFeesDTO();
            feesDTO.setStudentId(rs.getLong("student_id"));
            feesDTO.setFirstName(rs.getString("first_name"));
            feesDTO.setLastName(rs.getString("last_name"));
            feesDTO.setTotalSubjectFees(rs.getDouble("total_subject_fees"));
            return feesDTO;
        });

        // Calculate the total fees after scholarship
        double totalFeesAfterScholarship = totalFees.getTotalSubjectFees() - totalFeesDTO.getTotalFeesAfterScholarship();
        totalFees.setTotalFeesAfterScholarship(totalFeesAfterScholarship);
        return totalFees;
    }
}

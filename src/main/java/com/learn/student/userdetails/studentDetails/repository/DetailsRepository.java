package com.learn.student.userdetails.studentDetails.repository;

import com.learn.student.userdetails.studentDetails.studentinfo.Details;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
@Repository
public class DetailsRepository {
    private final JdbcTemplate jdbcTemplate;

    public DetailsRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Details getStudentDetailsById(Integer studentId) {
        String sql = "SELECT id, first_name, middle_name, last_name, preferred_name, date_of_birth, gender, email, address, mobile_number, institution_id " +
                "FROM Student " +
                "WHERE id = ?";

        return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
            Details studentDetails = new Details();
            studentDetails.setId(rs.getInt("id"));
            studentDetails.setFirstName(rs.getString("first_name"));
            studentDetails.setMiddleName(rs.getString("middle_name"));
            studentDetails.setLastName(rs.getString("last_name"));
            studentDetails.setPreferredName(rs.getString("preferred_name"));
            studentDetails.setDateOfBirth(rs.getString("date_of_birth"));
            studentDetails.setGender(rs.getString("gender"));
            studentDetails.setEmail(rs.getString("email"));
            studentDetails.setAddress(rs.getString("address"));
            studentDetails.setMobileNumber(rs.getLong("mobile_number"));
            studentDetails.setInstitutionId(rs.getInt("institution_id"));
            return studentDetails;
        }, studentId);
    }
}

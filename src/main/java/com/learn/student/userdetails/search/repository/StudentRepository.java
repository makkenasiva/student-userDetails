package com.learn.student.userdetails.search.repository;

import com.learn.student.userdetails.search.pojo.StudentSearchResult;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepository {
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public StudentRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public List<StudentSearchResult> searchStudents(
            String institutionName,
            Integer studentId,
            String username,
            String email
    ) {
        String sql = "SELECT i.name AS institutionName, CONCAT(s.first_name, ' ', s.last_name) AS studentName, s.grade, s.username " +
                "FROM Student s JOIN institutions i ON s.institution_id = i.id " +
                "WHERE i.name = :institutionName " +
                // "WHERE (:institutionName IS NULL OR i.name = :institutionName) " +
                "AND (:studentId IS NULL OR s.id = :studentId) " +
                "AND (:username IS NULL OR s.username = :username) " +
                "AND (:email IS NULL OR s.email = :email)";

        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("institutionName", institutionName);
        parameters.addValue("studentId", studentId);
        parameters.addValue("username", username);
        parameters.addValue("email", email);

        return namedParameterJdbcTemplate.query(sql, parameters, (rs, rowNum) -> {
            StudentSearchResult searchResult = new StudentSearchResult();
            searchResult.setInstitutionName(rs.getString("institutionName"));
            searchResult.setStudentName(rs.getString("studentName"));
            searchResult.setGrade(rs.getInt("grade"));
            searchResult.setUsername(rs.getString("username"));
            return searchResult;
        });
    }
}

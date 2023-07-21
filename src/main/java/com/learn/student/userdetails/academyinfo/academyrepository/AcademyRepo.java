package com.learn.student.userdetails.academyinfo.academyrepository;




import com.learn.student.userdetails.academyinfo.academyinformation.AcademyModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AcademyRepo {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public AcademyRepo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<AcademyModel> getAcademicInfoByStudentId(Integer studentId) {
        String sql = "SELECT * FROM academic_info WHERE student_id = ?";
        return jdbcTemplate.query(sql, new Object[]{studentId}, (resultSet, rowNum) -> {
            AcademyModel academy = new AcademyModel();
            academy.setId(resultSet.getInt("id"));
            academy.setSchool_name(resultSet.getString("school_name"));
            academy.setState_id(resultSet.getString("state_id"));
            academy.setDistrict_id(resultSet.getString("district_id"));
            academy.setCity_id(resultSet.getString("city_id"));
            academy.setStudent_id(resultSet.getInt("student_id"));
            academy.setEntryLevelOrTransfer(resultSet.getString("entryLevelOrTransfer"));

            return academy;
        });
    }
}

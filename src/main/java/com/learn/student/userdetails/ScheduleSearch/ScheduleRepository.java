package com.learn.student.userdetails.ScheduleSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ScheduleRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ScheduleRepository(JdbcTemplate jdbcTemplate) {

        this.jdbcTemplate = jdbcTemplate;
    }

    public List<ScheduleDTO> getStudentEnrollments(Long studentId, String academicYear) {
        String sqlQuery = "SELECT s.id AS student_id, s.first_name, s.last_name, e.subject_id, su.subject_name, c.grade, e.academic_year " +
                "FROM student s " +
                "JOIN enrollments e ON s.id = e.student_id " +
                "JOIN subjects su ON e.subject_id = su.id " +
                "JOIN courses c ON su.id = c.subject_id AND s.grade = c.grade " +
                "WHERE s.id = ? AND e.academic_year = ?";
        return jdbcTemplate.query(sqlQuery, new Object[]{studentId, academicYear}, new ScheduleDTOMapper());
    }

    private static class ScheduleDTOMapper implements RowMapper<ScheduleDTO> {
        @Override
        public ScheduleDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
            ScheduleDTO scheduleDTO = new ScheduleDTO();
            scheduleDTO.setStudentId(rs.getLong("student_id"));
            scheduleDTO.setFirstName(rs.getString("first_name"));
            scheduleDTO.setLastName(rs.getString("last_name"));
            scheduleDTO.setSubjectId(rs.getLong("subject_id"));
            scheduleDTO.setSubjectName(rs.getString("subject_name"));
            scheduleDTO.setGrade(rs.getString("grade"));
            scheduleDTO.setAcademicYear(rs.getString("academic_year"));

            return scheduleDTO;
        }
    }
}



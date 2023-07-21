package com.learn.student.userdetails.userrepository;


import com.learn.student.userdetails.newuserinfo.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
@Repository
public class UserRepo {
    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public UserRepo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void createUser(UserModel user) {
        if (isUsernameExists(user.getUsername())) {
            throw new IllegalArgumentException("Username already exists");
        }
        String sql = "INSERT INTO user (id, username, user_password, email, status, role_id, role_name,institution_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        // Retrieve role_id based on role_name
        String roleSql = "SELECT role_id FROM role WHERE role_name = ?";
        int roleId = jdbcTemplate.queryForObject(roleSql, Integer.class, user.getRole_name());
        jdbcTemplate.update(sql, user.getId(), user.getUsername(), user.getUser_password(), user.getEmail(), "Active", roleId, user.getRole_name(),user.getInstitution_id());
    }
    public boolean isUsernameExists(String username) {
        String sql = "SELECT COUNT(*) FROM user WHERE username = ?";
        int count = jdbcTemplate.queryForObject(sql, Integer.class, username);
        return count > 0;
    }


}



package com.learn.student.userdetails.usersearchapi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    User findByFirstname(String firstname);
    User findByUsername(String username);
    User findByEmail(String email);
}


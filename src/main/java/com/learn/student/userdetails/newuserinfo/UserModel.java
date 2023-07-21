package com.learn.student.userdetails.newuserinfo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserModel {
    @JsonIgnore
    private Integer id;
    private String username;
    private String user_password;
    private String email;
    @JsonIgnore
    private String status;
    private String role_name;
    @JsonIgnore
    private Integer role_id;
    private Integer institution_id;


}

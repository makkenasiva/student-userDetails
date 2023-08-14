package com.learn.student.userdetails.search.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class StudentSearchResult {
    private String institutionName;
    private String studentName;
    private Integer grade;
    private String username;
    private String email;
    private Integer studentId;
}


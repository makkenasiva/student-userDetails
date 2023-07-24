package com.learn.student.userdetails.studentDetails.studentinfo;


import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Details {
    @JsonIgnore
    private Integer id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String preferredName;
    private String dateOfBirth;
    private String gender;
    @JsonIgnore
    private String email;
    private String address;
    private Long mobileNumber;
    private Integer institutionId;

}
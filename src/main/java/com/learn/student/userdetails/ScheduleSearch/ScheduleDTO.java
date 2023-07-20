package com.learn.student.userdetails.ScheduleSearch;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ScheduleDTO {
    private Long studentId;
    private String firstName;
    private String lastName;
    private Long subjectId;
    private String subjectName;
    private String grade;
    private String academicYear;

}


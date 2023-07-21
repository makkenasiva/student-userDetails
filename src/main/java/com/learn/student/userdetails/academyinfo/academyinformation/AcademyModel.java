package com.learn.student.userdetails.academyinfo.academyinformation;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class AcademyModel {

    private Integer id;
    private String school_name;
    private String state_id;
    private String district_id;
    private String city_id;
    private Integer student_id;
    private String entryLevelOrTransfer;


}

package com.learn.student.userdetails.academyinfo.academyservice;


import com.learn.student.userdetails.academyinfo.academyinformation.AcademyModel;
import com.learn.student.userdetails.academyinfo.academyrepository.AcademyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AcademyService {

    private final AcademyRepo academicInfoRepository;

    @Autowired
    public AcademyService(AcademyRepo academicInfoRepository) {
        this.academicInfoRepository = academicInfoRepository;
    }

    public List<AcademyModel> getAcademicInfoByStudentId(Integer studentId) {
        return academicInfoRepository.getAcademicInfoByStudentId(studentId);
    }
}

